package com.chenhe;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chenhe
 * @Date 2018-07-31 14:58
 * @desc
 **/
public class CuratorUtil {

    private static final String address = "127.0.0.1:2181";

    public static void main(String[] args) {
        //重试策略, 初试时间为1s,重试3次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        //通过工厂创建连接
        CuratorFramework client = CuratorFrameworkFactory.newClient(address, retryPolicy);
        //开启连接
        client.start();
        final InterProcessMutex mutex = new InterProcessMutex(client,"/curator/lock");
        //读写锁
        InterProcessReadWriteLock readWriteLock = new InterProcessReadWriteLock(client,"/curator/readWriteLock");

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for( int i =0; i<5; i++){
            executorService.submit(() -> task(mutex));
        }
    }

    private static void task(InterProcessMutex mutex){
        boolean flag = false;

        try{
            flag = mutex.acquire(5, TimeUnit.SECONDS);
            Thread currentThread = Thread.currentThread();

            if (flag){
                System.out.println("线程:"+currentThread.getName()+"获取锁成功");
            }else{
                System.out.println("线程:"+currentThread.getName()+"获取锁失败");
            }
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (flag){
                try {
                    System.out.println("线程:"+Thread.currentThread().getName()+"释放锁");
                    mutex.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

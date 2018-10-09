package com.chenhe.task;

import com.chenhe.service.TaskService;
import com.chenhe.task.worker.StockInfoQueryWorker;
import com.chenhe.uitl.PropertiesRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenhe
 * @Date 2018-09-27 17:00
 * @desc
 **/
@Component
public class ThreadPool implements InitializingBean, DisposableBean {

    private Logger logger = LoggerFactory.getLogger(ThreadPool.class);
    private ThreadPoolExecutor threadPoolExecutor;
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    @Autowired
    TaskService taskService;
    private final int MAX_THREAD_COUNT = 10;
    @Autowired
    PropertiesRead  propertiesRead;

    @Override
    public void destroy() throws Exception {
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        threadPoolExecutor = new ThreadPoolExecutor(MAX_THREAD_COUNT, MAX_THREAD_COUNT, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

        for (int i = 0; i < MAX_THREAD_COUNT; i++) {
            threadPoolExecutor.submit(new StockInfoQueryWorker());
        }
        logger.info("线程初始化完毕,线程数量:{}", MAX_THREAD_COUNT);

    }


}

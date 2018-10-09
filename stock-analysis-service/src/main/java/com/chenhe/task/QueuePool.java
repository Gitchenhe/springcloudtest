package com.chenhe.task;

import com.chenhe.dao.entity.StockListEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chenhe
 * @Date 2018-09-27 16:43
 * @desc
 **/
public class QueuePool {
    private static Logger logger = LoggerFactory.getLogger(QueuePool.class);

    private static LinkedBlockingQueue<StockListEntity> stockInfoQueue = new LinkedBlockingQueue<>();

    public static void putStockInfoToQueue(List<StockListEntity> list) {
        list.parallelStream().forEach(stockInfo -> {
            try {
                stockInfoQueue.put(stockInfo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static StockListEntity pollStockInfo() {
        try {
            return stockInfoQueue.poll(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.info("队列中取证券信息异常", e);
        }
        return null;
    }

}

package com.chenhe.service;

import com.chenhe.dao.StockMapper;
import com.chenhe.dao.entity.StockEntity;
import com.chenhe.dao.entity.StockListEntity;
import com.chenhe.task.QueuePool;
import com.chenhe.task.worker.StockInfoQueryWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenhe
 * @Date 2018-09-27 16:47
 * @desc
 **/
@Service
public class TaskService {
    @Autowired
    private StockMapper stockMapper;

    public void stockInfoQuery(){
        StockInfoQueryWorker.totalCount.set(0);
        List<StockListEntity> list = stockMapper.queryStockList(1);
        QueuePool.putStockInfoToQueue(list);
        list = stockMapper.queryStockList(2);
        QueuePool.putStockInfoToQueue(list);
    }

}

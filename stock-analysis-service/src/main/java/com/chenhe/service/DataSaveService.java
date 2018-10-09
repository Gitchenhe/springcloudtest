package com.chenhe.service;

import com.chenhe.dao.StockMapper;
import com.chenhe.dao.entity.StockEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chenhe
 * @Date 2018-09-27 17:49
 * @desc
 **/
@Service
public class DataSaveService {
    @Autowired
    StockMapper stockMapper;
    @Transactional(rollbackFor = Exception.class)
    public void stockInfoSave(List<StockEntity> list){
        for (int i=0; i< list.size(); i++){
            stockMapper.insert(list.get(i));
        }
    }
}

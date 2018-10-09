package com.chenhe.task.worker;

import com.chenhe.dao.entity.StockEntity;
import com.chenhe.dao.entity.StockListEntity;
import com.chenhe.service.DataSaveService;
import com.chenhe.task.QueuePool;
import com.chenhe.uitl.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenhe
 * @Date 2018-09-27 16:49
 * @desc
 **/
public class StockInfoQueryWorker implements Runnable {

    private Logger logger = LoggerFactory.getLogger(StockInfoQueryWorker.class);

    private final String url = "http://hq.sinajs.cn/list=";

    public volatile static AtomicInteger totalCount = new AtomicInteger(0);

    @Override
    public void run() {
        List<StockListEntity> list = new ArrayList<>();
        int count = 0;
        long startTime = System.currentTimeMillis();
        while (true) {
            try {
                StockListEntity stockListEntity = QueuePool.pollStockInfo();
                if (stockListEntity == null) {
                    continue;
                }
                list.add(stockListEntity);
                count++;
                totalCount.incrementAndGet();
                boolean needInsert = list.size() > 0 && (count > 20 || System.currentTimeMillis() - startTime > 1000 * 10);
                if (needInsert) {
                    save(list);
                    count = 0;
                    startTime = System.currentTimeMillis();
                    list.clear();
                }
            } catch (Exception e) {
                logger.error("任务执行异常", e);
            }
        }
    }

    private void save(List<StockListEntity> list) {

        StringBuilder stringBuilder = new StringBuilder();
        for (StockListEntity entity : list) {
            stringBuilder.append(entity.getMarketNo() == 1 ? "sh" : "sz")
                    .append(entity.getReportCode())
                    .append(",");
        }

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url + stringBuilder.toString(), String.class);

        if (StringUtils.isBlank(response)) {
            return;
        }
        List<StockEntity> stockEntities = new ArrayList<>();
        String[] infoList = response.split(";");
        for (int i = 0; i < infoList.length; i++) {
            String info = infoList[i].replace("var hq_str_", "");
            if (StringUtils.isBlank(info) || info.trim().length() < 15) {
                continue;
            }
            logger.info("---> {}", info);
            StockEntity stockEntity = new StockEntity();
            stockEntity.parseFromString(info);
            stockEntities.add(stockEntity);
        }
        SpringUtils.getBean(DataSaveService.class).stockInfoSave(stockEntities);
        logger.info("总数量:{}",totalCount.get());
    }
}

package com.chenhe.task;

import com.chenhe.service.TaskService;
import com.chenhe.uitl.SpringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author chenhe
 * @Date 2018-09-28 15:41
 * @desc
 **/
public class StockQueryJob implements Job {
    Logger logger = LoggerFactory.getLogger(StockQueryJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SpringUtils.getBean(TaskService.class).stockInfoQuery();

        String nextfire = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(jobExecutionContext.getNextFireTime());
        logger.info("下次执行时间:{}", nextfire);
    }
}
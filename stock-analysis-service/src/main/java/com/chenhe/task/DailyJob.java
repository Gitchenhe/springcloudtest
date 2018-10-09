package com.chenhe.task;

import com.chenhe.uitl.PropertiesRead;
import org.apache.commons.lang3.time.FastDateFormat;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @author chenhe
 * @Date 2018-09-28 14:51
 * @desc
 **/
@Component
public class DailyJob implements InitializingBean, DisposableBean {

    static Logger logger = LoggerFactory.getLogger(DailyJob.class);

    @Autowired
    PropertiesRead propertiesRead;
    Scheduler scheduler = null;

    public void start() {

        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        JobDetail jobDetail = JobBuilder.newJob()
                .withDescription("证券信息查询任务")
                .withIdentity("stockJob")
                .ofType(StockQueryJob.class)
                .build();

        DailyTimeIntervalScheduleBuilder dailySchedule = DailyTimeIntervalScheduleBuilder
                .dailyTimeIntervalSchedule()
                .withIntervalInHours(24)
                .onDaysOfTheWeek(2, 3, 4, 5,6)
                .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(propertiesRead.getHour(), propertiesRead.getMinute()));

        Trigger trigger = TriggerBuilder.newTrigger()
                .withDescription("每天执行证券信息查询")
                .withIdentity("证券信息查询任务触发器")
                .withSchedule(dailySchedule)
                .startAt(new Date())//不设置，默认为当前时间
                .build();         //创建调度器，粘合工作和触发器


        try {
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
            String nextFire = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(trigger.getNextFireTime());
            logger.info("证券信息查询任务下次执行时间:{}", nextFire);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void destroy() throws Exception {
        if (scheduler != null){
            scheduler.shutdown();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        start();
    }
}

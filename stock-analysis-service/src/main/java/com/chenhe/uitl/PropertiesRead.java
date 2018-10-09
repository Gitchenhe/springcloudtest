package com.chenhe.uitl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author chenhe
 * @Date 2018-09-28 14:34
 * @desc
 **/

@Component
@ConfigurationProperties(prefix = "query.task.execute")
@PropertySource("classpath:application.yml")
public class PropertiesRead {
    int hour ;
    int minute;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}

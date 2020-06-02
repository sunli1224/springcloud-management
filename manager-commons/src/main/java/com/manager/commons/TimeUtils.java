package com.manager.commons;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * @author sunli
 * @date 2020/5/27 3:12
 */
public class TimeUtils {

    public String getLocalTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

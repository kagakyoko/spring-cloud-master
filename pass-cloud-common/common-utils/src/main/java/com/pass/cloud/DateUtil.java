package com.pass.cloud;

import java.util.Date;

import com.xiaoleilu.hutool.date.DateField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author takesi
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    /**
     * 获取系统前时间.
     *
     * @param minute the minute
     * @return the before time[yyyy-MM-dd HH:mm:ss]
     */
    public static String getBeforeTime(int minute) {
        Date newDate = com.xiaoleilu.hutool.date.DateUtil.offset(new Date(), DateField.MINUTE, -minute);
        return com.xiaoleilu.hutool.date.DateUtil.formatDateTime(newDate);
    }

}

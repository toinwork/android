package com.toin.work.base.utils;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {

    private static final SimpleDateFormat dateFormat_MM_dd_HH_mm         = new SimpleDateFormat(
            "M-d HH:mm", Locale.CHINA);
    private static final SimpleDateFormat dateFormat_yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    private static final SimpleDateFormat dateFormat_yyyy_MM_dd_HH_mm    = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm", Locale.CHINA);
    private static final SimpleDateFormat dateFormat_yyyy_MM_dd          = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.CHINA);
    private static final SimpleDateFormat dateFormat_yyyy_MM_dd_Two      = new SimpleDateFormat(
            "yyyy.MM.dd", Locale.CHINA);
    private static final SimpleDateFormat dateFormat_yyyy_MM_dd_HH_mm_Two    = new SimpleDateFormat(
            "yyyy年MM月dd日 HH:mm", Locale.CHINA);
    public static String getCurrentDate() {
        Date date = new Date(System.currentTimeMillis());
        return dateFormat_yyyy_MM_dd_HH_mm_ss.format(date);
    }

    public static String getShortDate(String dateString) {
        try {
            Date date = dateFormat_yyyy_MM_dd.parse(dateString);
            return dateFormat_yyyy_MM_dd.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateString;
    }

    public static String toDataString(Date date) {
        return dateFormat_yyyy_MM_dd_HH_mm_ss.format(date);
    }

    public static String toDataStringByYYYYMMdd(Date date) {
        return dateFormat_yyyy_MM_dd.format(date);
    }

    public static String toDataStringByYYYYMMddTwo(Date date) {
        return dateFormat_yyyy_MM_dd_Two.format(date);
    }

    public static String toDataStringByYYYYMMdd_HHmm(Date date) {
        return dateFormat_yyyy_MM_dd_HH_mm.format(date);
    }

    public static String toDataStringByYYYYMMddHHmmtwo(Date date) {
        return dateFormat_yyyy_MM_dd_HH_mm_Two.format(date);
    }

    public static String toDataStringByMMdd_HHmm(Date date) {
        return dateFormat_MM_dd_HH_mm.format(date);
    }

    public static String toChineseDateString(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        return cd.get(Calendar.YEAR) + "年" + (cd.get(Calendar.MONTH) + 1) + "月"
                + cd.get(Calendar.DATE) + "日";

    }

    public static Date toDateByString(String dateStr) {
        Date date = null;
        try {
            date = dateFormat_yyyy_MM_dd.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date toDateByStringTwo(String dateStr) {
        Date date = null;
        try {
            date = dateFormat_yyyy_MM_dd.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 两个时间段是否在5分钟以内
     * 
     * @param from
     * @param to
     * @return
     */
    public static boolean isBetweenFiveMinites(Date from, Date to) {

        if (from != null && to != null) {
            long minite = (to.getTime() - from.getTime()) / (60 * 1000);
            if (minite > 5) {
                return false;
            }
        }
        return true;
    }

    public static String formatFriendlyDataByString(String time) {
        Date date = toDateByString(time);
        if (date != null) {
            return formatFriendlyDateTime(date.getTime());
        } else {
            return time;
        }
    }

    public static String formatFriendlyDateTime(long baseTime) {
        long now = System.currentTimeMillis();
        long dif = now - baseTime;
        long dif_second = dif / (1000);// 秒
        long dif_minute = dif_second / 60;// 分钟
        long dif_hour = dif_minute / 60;// 小时
        long dif_day = dif_hour / 24;// 天

        if (dif_minute <= 1) {
            return "刚刚";
        } else if (dif_minute < 60) {
            return dif_minute + "分钟前";
        } else if (dif_hour < 24) {
            return dif_hour + "小时前";
        } else if (dif_day < 10) {
            return dif_day + "天前";
        } else {
            DateFormat dateFormat = new SimpleDateFormat("MM月dd日", Locale.CHINA);
            return dateFormat.format(new Date(baseTime));
        }
    }

    /**
     * 获取Date时间
     * 
     * @param dateTime
     * @return
     */
    public static Date getDateTime(String dateTime) {
        Date date = null;
        try {
            date = dateFormat_yyyy_MM_dd_HH_mm_ss.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 返回四位年份
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getYear(Date date) {
        if (date == null)
            return -1;
        return date.getYear() + 1900;
    }

    /**
     * 返回月数(0-11)
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getMonth(Date date) {
        if (date == null)
            return -1;
        return date.getMonth();
    }

    /**
     * 返回月几(1-31)
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getMonthDay(Date date) {
        if (date == null)
            return -1;
        return date.getDate();
    }

    /**
     * 返回周几 returned value (<tt>0</tt> = Sunday, <tt>1</tt> = Monday, <tt>2</tt>
     * = Tuesday, <tt>3</tt> = Wednesday, <tt>4</tt> = Thursday, <tt>5</tt> =
     * Friday, <tt>6</tt> = Saturday)
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getWeekDay(Date date) {
        if (date == null)
            return -1;
        return date.getDay();
    }

    /**
     * 判断字符串是否指定格式
     * 
     * @param str_input
     * @param str_input
     * @return boolean;
     */
    public static boolean isDate(String str_input, String rDateFormat) {
        if (!TextUtils.isEmpty(str_input)) {
            SimpleDateFormat formatter = new SimpleDateFormat(rDateFormat);
            formatter.setLenient(false);
            try {
                formatter.format(formatter.parse(str_input));
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }
    /**
     * 返回00:00:00
     *
     * @param time
     * @return String;
     */
    public static String showTime(int time) {
        time /= 1000;
        int minute = time / 60;
        int hour = minute / 60;
        int second = time % 60;
        minute %= 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }


}

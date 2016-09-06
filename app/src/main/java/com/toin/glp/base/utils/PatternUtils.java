package com.toin.glp.base.utils;

import java.util.regex.Pattern;

/**
 * Created by hb on 15/12/4.
 */
public class PatternUtils {
    /**
     * 手机号
     *
     * @param phone
     * @return
     */
    public static boolean isPhoneNum(String phone) {
        boolean bool = false;
        if ((phone != null) && (phone.length() == 11)) {
            if (phone.substring(0, 1).equals("1")) {
                bool = Pattern.compile("^1[1-9]\\d{9}$").matcher(phone).matches();
            }
        }
        return bool;
    }
}

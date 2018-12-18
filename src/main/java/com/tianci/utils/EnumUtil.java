package com.tianci.utils;

import com.tianci.enums.CodeEnum;

/**
 * Create by tianci
 * 2018/12/17 16:50
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getBycode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
               return each;
            }
        }
        return null;
    }
}

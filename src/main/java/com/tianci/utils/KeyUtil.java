package com.tianci.utils;

import java.util.Random;

/**
 * Create by tianci
 * 2018/11/19 14:24
 */
public class KeyUtil {

    /**
     * 获取随机生成ID
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(num);
    }
}

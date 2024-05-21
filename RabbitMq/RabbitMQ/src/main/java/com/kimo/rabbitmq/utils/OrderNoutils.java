package com.kimo.rabbitmq.utils;

import cn.hutool.core.lang.Snowflake;

/**
 * 雪花算法生产唯一id
 */
public class OrderNoutils {

    private static Snowflake flake;

    static {
        flake = new Snowflake();
    }


    public static String idStr(){
        return flake.nextIdStr();
    }

    public static Long id(){
        return flake.nextId();
    }
}

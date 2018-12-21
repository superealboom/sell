package com.tianci.enums;

import lombok.Getter;

/**
 * 商品状态
 * Create by tianci
 * 2018/11/8 14:19
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(0, "在架"),
    DOWN(1, "下架")
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

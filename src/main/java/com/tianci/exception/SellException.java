package com.tianci.exception;

import com.tianci.enums.ResultEnum;
import lombok.Data;

/**
 * Create by tianci
 * 2018/11/19 13:59
 */
@Data
public class SellException extends RuntimeException {

    private Integer code;

    private String message;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

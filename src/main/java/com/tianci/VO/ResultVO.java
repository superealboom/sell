package com.tianci.VO;

import lombok.Data;

/**
 * Create by tianci
 * 2018/11/8 15:48
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    /*错误码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    /*具体内容*/
    private T data;

}

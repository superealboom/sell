package com.tianci.utils;

import com.tianci.VO.ResultVO;

/**
 * Create by tianci
 * 2018/11/8 17:39
 */
public class ResultVOUtils {

    public static ResultVO success(Object object) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO<Object> success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}

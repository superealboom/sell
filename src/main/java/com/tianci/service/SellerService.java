package com.tianci.service;

import com.tianci.dataobject.SellerInfo;

/**
 * Create by tianci
 * 2019/1/2 16:27
 */
public interface SellerService {

    /**
     * 通过openid查找卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}

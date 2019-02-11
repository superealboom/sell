package com.tianci.service.Impl;

import com.tianci.dataobject.SellerInfo;
import com.tianci.repository.SellerInfoRepository;
import com.tianci.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by tianci
 * 2019/1/2 16:29
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}

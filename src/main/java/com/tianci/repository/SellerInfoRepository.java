package com.tianci.repository;

import com.tianci.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by tianci
 * 2019/1/2 16:23
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}

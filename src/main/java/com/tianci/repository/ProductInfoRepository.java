package com.tianci.repository;

import com.tianci.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create by tianci
 * 2018/11/8 11:56
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    ProductInfo findByProductId(String productId);
}

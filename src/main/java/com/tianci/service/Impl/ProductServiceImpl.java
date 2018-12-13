package com.tianci.service.Impl;

import com.tianci.dataobject.ProductInfo;
import com.tianci.dto.CartDTO;
import com.tianci.enums.ProductStatusEnum;
import com.tianci.enums.ResultEnum;
import com.tianci.exception.SellException;
import com.tianci.repository.ProductInfoRepository;
import com.tianci.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by tianci
 * 2018/11/8 14:01
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findByProductId(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer num  = cartDTO.getProductStock() + productInfo.getProductStock();
            productInfo.setProductStock(num);
            repository.save(productInfo);
        }
    }

    /**
     * 这里以后会用到redis锁来解决
     *  多线程同时进入方法，导致超迈bug
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findByProductId(cartDTO.getProductId());
            if (productInfo == null) {
               throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer stock = productInfo.getProductStock() - cartDTO.getProductStock();
            if (stock < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(stock);

            repository.save(productInfo);
        }
    }
}

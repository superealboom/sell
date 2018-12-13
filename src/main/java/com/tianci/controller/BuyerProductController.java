package com.tianci.controller;

import com.tianci.VO.ProductInfoVO;
import com.tianci.VO.ProductVO;
import com.tianci.VO.ResultVO;
import com.tianci.dataobject.ProductCategory;
import com.tianci.dataobject.ProductInfo;
import com.tianci.service.CategoryService;
import com.tianci.service.ProductService;
import com.tianci.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Create by tianci
 * 2018/11/8 15:42
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 商家商品清单
     * @return 返回Json对象。包含上架类目和商品信息。
     */
    @GetMapping("/list")
    public ResultVO list() {
        /* 1 拿到已上架商品信息 */
        List<ProductInfo> productInfoList = productService.findUpAll();
        //第一种方法查询所有已上架的类目编号
//        List<Integer> categoryTypeList = new ArrayList<Integer>();
//        for(ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //第二种方法查询所有已上架的类目编号(java8特性)
        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());

        /* 2 拿到已上架商品所属类目信息 */
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        /* 3 数据拼装 */
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtils.success(productVOList);
    }
}

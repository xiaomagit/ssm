package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有商品
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;

}

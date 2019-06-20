package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.OrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersDao ordersDao;

    /**
     * 查询所有的订单信息
     * @return
     * @throws Exception
     */
    /*@Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }*/

    /**
     * 查询所有的订单信息,并且分页
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }
}

package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询全部的订单
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = orderService.findAll();
        modelAndView.addObject("ordersList", ordersList);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }
}


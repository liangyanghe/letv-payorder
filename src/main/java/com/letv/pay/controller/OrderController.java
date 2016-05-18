package com.letv.pay.controller;

import com.letv.pay.server.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author ash
 */
@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    @ResponseBody
    public String addOrder(int userId, int price) {
        orderService.addOrder(userId, price);
        return "ok";
    }

}

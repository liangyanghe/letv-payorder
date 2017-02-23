package com.letv.pay.controller;

import com.letv.pay.server.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/addOrder", method = {RequestMethod.POST, RequestMethod.GET})
    public String addOrder(int userId, int price, Model model) {
        String orderId = orderService.addOrder(userId, price);
        String dbInfo = String.valueOf((userId / 10) % 8 + 1);
        String tableInfo = String.valueOf(userId % 10);
        model.addAttribute("orderId", orderId);
        model.addAttribute("dbInfo", dbInfo);
        model.addAttribute("tableInfo", tableInfo);
        return "succ";
    }

}

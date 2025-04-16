package com.example.petstoresep.service.impl;

import com.example.petstoresep.entity.CartStore;
import com.example.petstoresep.entity.Order;
import com.example.petstoresep.persistence.ItemMapper;
import com.example.petstoresep.persistence.OrderMapper;
import com.example.petstoresep.service.OrderService;
import com.example.petstoresep.vo.CartVO;
import com.example.petstoresep.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public Order getOrder(String userName) {
        Order order = new Order();
        List<Order> orders = orderMapper.getOrder(userName);
        for (Order order1 : orders) {
            String itemId = order1.getItemId();
            String code = order1.getCode();
            Date addTime=order1.getAddTime();
            Integer total=order1.getTotal();
            Integer status=order1.getStatus();
            ItemVO item = itemMapper.getItemById(itemId);
            System.out.println(item);
            if (item == null){
                continue;
            }
            order.addOrder(itemId,code,addTime,total,status);
        }
        return order;
    }

    @Override
    public boolean submitOrder(String username,String code){
        try {
            orderMapper.submitOrder(username,code);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String username, String code){
        try {
            orderMapper.delete(username,code);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean receive(String username, String code){
        try {
            orderMapper.receive(username,code);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}

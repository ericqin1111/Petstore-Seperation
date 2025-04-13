package com.example.petstoresep.service.impl;

import com.example.petstoresep.persistence.OrderMapper;
import com.example.petstoresep.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public boolean submitOrder(String username,Integer id){
        try {
            orderMapper.submitOrder(username,id);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}

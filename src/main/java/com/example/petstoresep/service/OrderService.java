package com.example.petstoresep.service;

import com.example.petstoresep.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    boolean submitOrder(Integer id, String itemid, String username, String code, Date addtime, Integer total, Integer isdelete, Integer status);
    List<Order> getOrder(String username);
    boolean delete(String username, String code);
    boolean receive(String username, String code);
}

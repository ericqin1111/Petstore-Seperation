package com.example.petstoresep.service;

import com.example.petstoresep.entity.Order;

public interface OrderService {
    boolean submitOrder(String username, String code);
    Order getOrder(String username);
    boolean delete(String username, String code);
    boolean receive(String username, String code);
}

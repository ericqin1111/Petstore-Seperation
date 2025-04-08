package com.example.petstoresep.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.petstoresep.entity.CartStore;
import com.example.petstoresep.persistence.CartStoreMapper;
import com.example.petstoresep.persistence.ItemMapper;
import com.example.petstoresep.service.CartService;
import com.example.petstoresep.vo.CartItemVO;
import com.example.petstoresep.vo.CartVO;
import com.example.petstoresep.vo.ItemVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service("CartService")
public class CartServiceImpl implements CartService {

    @Autowired
    ItemMapper itemMapper;
    @Autowired
    CartStoreMapper cartStoreMapper;



    @Override
    public CartVO getCart(String userName) {
        CartVO cart = new CartVO();
        List<CartStore> cartStores = cartStoreMapper.getCartStoreByUsername(userName);
        for (CartStore cartStore : cartStores) {
            String itemId = cartStore.getItemId();
            int quantity = cartStore.getQuantity();
            ItemVO item = itemMapper.getItemById(itemId);
            cart.addItem(item, quantity, true);
        }
        return cart;
    }

    @Override
    public void addItem(String itemId, HttpSession session) {
//        CartVO cart = (CartVO) session.getAttribute("cart");
//        CartItemVO cartItem = cart.getItemMap().get(itemId);
//
//        if (cartItem == null) {
//            ItemVO item = itemMapper.getItemById(itemId);
//            cart.addItem(item, true);
//
//
//        }
//        else {
//            cartItem.incrementQuantity();
//
//        }
    }

    @Override
    public void deleteItem(String itemId, HttpSession session) {


    }

    @Override
    public void updateItem(HttpServletRequest req) {



    }

    @Override
    public void loadCart(HttpServletRequest httpServletRequest) {

    }


}

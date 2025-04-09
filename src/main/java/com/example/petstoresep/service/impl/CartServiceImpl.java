package com.example.petstoresep.service.impl;

import com.example.petstoresep.entity.CartStore;
import com.example.petstoresep.persistence.CartStoreMapper;
import com.example.petstoresep.persistence.ItemMapper;
import com.example.petstoresep.service.CartService;
import com.example.petstoresep.vo.CartVO;
import com.example.petstoresep.vo.ItemVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Boolean deleteItem(String username, String itemId) {
        try {
            cartStoreMapper.deleteCartStoreByUsernameAndItemId(username, itemId);

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean addItem(String userName, String itemId) {
        try{
            if (cartStoreMapper.isCartStoreExist(userName, itemId)) {
                cartStoreMapper.increaseCartStoreQuantity(userName, itemId);
            }
            else {
                cartStoreMapper.insertCartStore(userName, itemId, 1);
            }
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateItem(String userName, String itemId, int quantity) {
        if (cartStoreMapper.isCartStoreExist(userName, itemId)) {
            try {
                cartStoreMapper.updateCartStoreQuantity(userName, itemId, quantity);
            }catch (Exception e){
                System.out.println(e);
                return false;
            }

            return true;

        }
        else {
            return false;
        }


    }



}

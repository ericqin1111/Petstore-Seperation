package com.example.petstoresep.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.petstoresep.entity.CartStore;
import com.example.petstoresep.entity.Image;
import com.example.petstoresep.persistence.CartStoreMapper;
import com.example.petstoresep.persistence.ImageMapper;
import com.example.petstoresep.persistence.ItemMapper;
import com.example.petstoresep.service.CartService;
import com.example.petstoresep.vo.CartItemVO;
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
    @Autowired
    ImageMapper imageMapper;


    @Override
    public CartVO getCart(String userName) {
        CartVO cart = new CartVO();
        List<CartStore> cartStores = cartStoreMapper.getCartStoreByUsername(userName);
        for (CartStore cartStore : cartStores) {
            String itemId = cartStore.getItemId();
            int quantity = cartStore.getQuantity();
            ItemVO item = itemMapper.getItemById(itemId);
            QueryWrapper<Image> qw=new QueryWrapper<>();
            qw.eq("itemId",itemId);
            System.out.println("itemid"+itemId);
            Image image = imageMapper.selectOne(qw);
            System.out.println("image"+image);
            if (image != null){
                item.setImageName(image.getFileName());
            }
//            System.out.println(item);
            if (item == null){
                continue;
            }
            cart.addItem(item, quantity, true);
        }
//        List<CartItemVO> cartItems = cart.getCartItems();
//        for (CartItemVO cartItem : cartItems) {
//            String itemId = cartItem.getItem().getItemId();
//            int quantity = cartItem.getQuantity();
//            cartStoreMapper.updateCartStoreQuantity(userName, itemId, quantity);
//        }
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

    public Boolean deleteAll(String userName) {
        try {
            cartStoreMapper.clearCartStoreByUsername(userName);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}

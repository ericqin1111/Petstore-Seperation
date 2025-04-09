package com.example.petstoresep.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

@Data
public class CartVO {
    private List<CartItemVO> cartItems = new ArrayList<CartItemVO>();
    private int numberOfItems;
    private BigDecimal subTotal;



    public void addItem(ItemVO item, int quantity, boolean isInStock) {

        CartItemVO cartItem = new CartItemVO();
        cartItem.setItem(item);
        cartItem.setQuantity(quantity);
        cartItem.setInStock(isInStock);
        cartItems.add(cartItem);
        numberOfItems++;



    }

    public BigDecimal getSubTotal() {
        BigDecimal subTotal = new BigDecimal("0");
        Iterator<CartItemVO> items = cartItems.iterator();
        while (items.hasNext()) {
            CartItemVO cartItem = (CartItemVO) items.next();
            ItemVO item = cartItem.getItem();
            BigDecimal listPrice = item.getListPrice();
            BigDecimal quantity = new BigDecimal(String.valueOf(cartItem.getQuantity()));
            subTotal = subTotal.add(listPrice.multiply(quantity));
        }
        return subTotal;
    }
}
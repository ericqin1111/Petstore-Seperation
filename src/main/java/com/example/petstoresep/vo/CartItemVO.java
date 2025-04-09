package com.example.petstoresep.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemVO {
    private ItemVO item;
    private int quantity;
    private boolean inStock;
    private BigDecimal total;

    public void incrementQuantity() {
        quantity++;
        calculateTotal();
    }

    public void calculateTotal() {
        if (item != null && item.getListPrice() != null) {
            total = item.getListPrice().multiply(new BigDecimal(quantity));
        } else {
            total = null;
        }
    }
}
package com.example.petstoresep.service;
import com.example.petstoresep.vo.CartVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;




public interface CartService {
    CartVO getCart(String userName);
    void addItem(String itemId, HttpSession session);
    void deleteItem(String itemId, HttpSession session);
    void updateItem(HttpServletRequest request);
    void loadCart(HttpServletRequest httpServletRequest);

}

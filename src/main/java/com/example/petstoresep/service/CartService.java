package com.example.petstoresep.service;
import com.example.petstoresep.vo.CartVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;




public interface CartService {
    CartVO getCart(String userName);
    Boolean deleteItem(String username, String itemId);
    Boolean addItem(String userName, String itemId);
    Boolean deleteAll(String userName);
    Boolean updateItem(String userName, String itemId, int quantity);

}

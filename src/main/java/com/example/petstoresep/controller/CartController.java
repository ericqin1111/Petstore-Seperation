package com.example.petstoresep.controller;

import com.example.petstoresep.service.CartService;
import com.example.petstoresep.util.Response;
import com.example.petstoresep.vo.CartVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    //获取数据库里该用户的储存订单
    @GetMapping("getCart")
    public ResponseEntity<Response> getCart(@RequestParam String userName) {
        System.out.println(userName);
        CartVO cart = cartService.getCart(userName);
        return ResponseEntity.ok(Response.success(cart));
    }

    @RequestMapping("removeCartItem")
    public String removeCartItem(@RequestParam String workingItemId, HttpSession session) {
        cartService.deleteItem(workingItemId, session);
        return "redirect:cartForm";
    }

    @PostMapping("updateCart")
    public String updateCart(HttpServletRequest request) {
        cartService.updateItem(request);
        return "redirect:cartForm";
    }

}


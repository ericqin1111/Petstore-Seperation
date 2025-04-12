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

import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    //获取数据库里该用户的储存订单
    @GetMapping("getCart")
    public ResponseEntity<Response> getCart(@RequestAttribute String username) {
        System.out.println(username);
        CartVO cart = cartService.getCart(username);
        System.out.println(cart);
        return ResponseEntity.ok(Response.success(cart));
    }

    @PostMapping("remove")
    public ResponseEntity<Response> removeCartItem(@RequestAttribute String username, @RequestBody Map<String, String> requestBody) {
        String itemId = requestBody.get("itemId");
        if(cartService.deleteItem(username, itemId)) {
            return ResponseEntity.ok(Response.success(true));
        }
        else {
            return ResponseEntity.ok(Response.success(false));
        }
    }

    @PostMapping("add")
    public ResponseEntity<Response> addCartItem(@RequestAttribute String username, @RequestBody Map<String, String> requestBody) {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String itemId = requestBody.get("itemId");
        if (cartService.addItem(username, itemId)) {
            return ResponseEntity.ok(Response.success(true));
        }
        else {
            return ResponseEntity.ok(Response.success(false));
        }

    }

    @PostMapping("update")
    public ResponseEntity<Response> updateCart(@RequestAttribute String username, @RequestBody Map<String, String> requestBody) {
        String itemId = requestBody.get("itemId");
        int quantity = Integer.parseInt(requestBody.get("quantity"));
        if (cartService.updateItem(username, itemId, quantity)) {
            return ResponseEntity.ok(Response.success(true));
        }
        else {
            return ResponseEntity.ok(Response.success(false));
        }

    }

    @PostMapping("deleteAll")
    public ResponseEntity<Response> deleteAll(@RequestAttribute String username, @RequestBody Map<String, String> requestBody) {
        if (cartService.deleteAll(username)) {
            return ResponseEntity.ok(Response.success(true));
        }
        else {
            return ResponseEntity.ok(Response.success(false));
        }

    }

}


package com.example.petstoresep.controller;

import com.example.petstoresep.service.OrderService;
import com.example.petstoresep.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/itemOrder")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("CDS")
    public ResponseEntity<Response> submitOrder(@RequestAttribute String username, @RequestBody Map<String, String> requestBody) {
        Integer id=Integer.valueOf(requestBody.get("id"));
        if (orderService.submitOrder(username,id)) {
            return ResponseEntity.ok(Response.success(true));
        }
        else {
            return ResponseEntity.ok(Response.success(false));
        }

    }
}

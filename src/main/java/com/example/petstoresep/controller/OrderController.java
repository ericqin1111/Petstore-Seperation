package com.example.petstoresep.controller;

import com.example.petstoresep.entity.Order;
import com.example.petstoresep.service.OrderService;
import com.example.petstoresep.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/itemOrder")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("getOrder")
    public ResponseEntity<Response> getOrder(/*@RequestAttribute String username,*/@RequestBody Map<String, String> requestBody) {
        String username=requestBody.get("username");
        System.out.println(username);
        List<Order> order = orderService.getOrder(username);
        System.out.println(order);
        return ResponseEntity.ok(Response.success(order));
    }

    @PostMapping("CDS")
    public ResponseEntity<Response> submitOrder(/*@RequestAttribute String username,*/ @RequestBody Map<String, String> requestBody) {
        Integer id=Integer.valueOf(requestBody.get("id"));
        System.out.println(id);
        String itemid=requestBody.get("itemid");
        String username=requestBody.get("username");
        String code=requestBody.get("code");
        Date addtime=new Date(requestBody.get("addtime"));
        Integer total=Integer.valueOf(requestBody.get("total"));
        Integer isdelete=Integer.valueOf(requestBody.get("isdelete"));
        Integer status=Integer.valueOf(requestBody.get("status"));
        System.out.println(id+" "+itemid+" "+username+" "+code+" "+addtime+" "+total+" "+isdelete+" "+status);
        if (orderService.submitOrder(id,itemid,username,code,addtime,total,isdelete,status)) {
            return ResponseEntity.ok(Response.success(true));
        }
        else {
            return ResponseEntity.ok(Response.success(false));
        }

    }

    @PostMapping("delete")
    public ResponseEntity<Response> delete(/*@RequestAttribute String username, */@RequestBody Map<String, String> requestBody) {
        String username=requestBody.get("username");
        String code=requestBody.get("code");
        if (orderService.delete(username,code)) {
            return ResponseEntity.ok(Response.success(true));
        }
        else {
            return ResponseEntity.ok(Response.success(false));
        }

    }

    @PostMapping("receive")
    public ResponseEntity<Response> receive(/*@RequestAttribute String username,*/ @RequestBody Map<String, String> requestBody) {
        String username=requestBody.get("username");
        String code=requestBody.get("code");
        if (orderService.receive(username,code)) {
            return ResponseEntity.ok(Response.success(true));
        }
        else {
            return ResponseEntity.ok(Response.success(false));
        }

    }
}

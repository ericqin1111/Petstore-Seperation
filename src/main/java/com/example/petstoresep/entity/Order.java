package com.example.petstoresep.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@TableName("item_order")
public class Order implements Serializable {

    private List<Order> orders=new ArrayList<Order>();
    private int numberOfOrders;
    
    @TableId("id")
    private Integer id;  //
    @TableField("item_id")
    private String itemId; //商品id
    @TableField("user_name")
    private String userName; //用户id
    private String code; //订单编号
    @TableField("add_time")
    private Date addTime; //下单时间
    private Integer total; //购买数量
    @TableField("is_delete")
    private Integer isDelete;
    private Integer status; //0待发货 1已取消 2已发货 3已收货 4已评价

    public void addOrder(String itemId,String code,Date addTime,Integer total,Integer status){
            Order order = new Order();
            order.setItemId(itemId);
            order.setCode(code);
            order.setAddTime(addTime);
            order.setTotal(total);
            order.setStatus(status);
            orders.add(order);
            numberOfOrders++;
    }
}
package com.example.petstoresep.controller;

import com.example.petstoresep.entity.Category;
import com.example.petstoresep.entity.Item;
import com.example.petstoresep.service.CatalogService;
import com.example.petstoresep.util.Response;
import com.example.petstoresep.vo.CategoryVO;
import com.example.petstoresep.vo.ItemP;
import com.example.petstoresep.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;


    @GetMapping("category/{categoryId}")
    @ResponseBody
    public ResponseEntity<Response> getCategory(@PathVariable String categoryId){
        CategoryVO categoryVO=catalogService.getCategory(categoryId);
        System.out.println("CVO:"+categoryVO.getProductList());
        return ResponseEntity.ok(Response.success(categoryVO));
    }

    @GetMapping("product/{productId}")
    public ResponseEntity<Response> getProduct(@PathVariable String productId){
        ProductVO productVO=catalogService.getProduct(productId);
        System.out.println("VPO:"+productVO.getProductId());
        System.out.println("VPO:"+productVO.getItemList());
        return ResponseEntity.ok(Response.success(productVO));
    }


    @GetMapping("search/{key}")
    public ResponseEntity<Response> search(@PathVariable String key){

        List<ItemP> itemList=catalogService.searchItem(key);
        System.out.println(itemList);
        return ResponseEntity.ok(Response.success(itemList));
    }

//    @GetMapping("search/{type}/{key}")
//    public ResponseEntity<List<?>> search(
//            @RequestParam String type,
//            @RequestParam String key) {
//
//        switch (type) {
//            case "user":
//                return ResponseEntity.ok(userService.searchByName(keyword));
//            case "product":
//                return ResponseEntity.ok(productService.searchByName(keyword));
//            // 更多情况...
//            default:
//                return ResponseEntity.badRequest().body(Collections.emptyList());
//        }
//    }

}

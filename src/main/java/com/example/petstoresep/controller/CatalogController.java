package com.example.petstoresep.controller;

import com.example.petstoresep.entity.Category;
import com.example.petstoresep.entity.Item;
import com.example.petstoresep.entity.Product;
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

import java.util.Base64;
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

    @GetMapping("category")
    @ResponseBody
    public ResponseEntity<Response> getAllCate(){
        List<Category> allCate=catalogService.getAllCate();
        System.out.println("allCate:"+allCate);
        return ResponseEntity.ok(Response.success(allCate));
    }

    @GetMapping("product")
    @ResponseBody
    public ResponseEntity<Response> getAllPro(){
        List<Product> allPro=catalogService.getAllPro();
        System.out.println("allCate:"+allPro);
        return ResponseEntity.ok(Response.success(allPro));
    }

    @GetMapping("item")
    @ResponseBody
    public ResponseEntity<Response> getAllItem(){
        List<ItemP> allItem=catalogService.getAllItem();
        for (ItemP item : allItem) {
//            if (item.getImageData() != null) {
//                String mimeType = getMimeTypeFromFileName(item.getFileName());
//                String base64 = Base64.getEncoder().encodeToString(item.getImageData());
//                item.setBase64Image("data:" + mimeType + ";base64," + base64);
//            }
            item.setImageUrl("images/" + item.getItemId());
            item.setImageData(null);
            item.setFileName(null);
        }
        System.out.println("allItem:"+allItem);
        return ResponseEntity.ok(Response.success(allItem));
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
        if(itemList!=null){
            return ResponseEntity.ok(Response.success(itemList));
        }
        else
            return ResponseEntity.ok(Response.error(1,"查询结果为空"));
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

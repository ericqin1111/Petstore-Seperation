package com.example.petstoresep.controller;

import com.example.petstoresep.service.impl.CatalogServiceImpl;
import com.example.petstoresep.vo.ItemP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import static com.example.petstoresep.util.ImageUtil.getMimeTypeFromFileName;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    CatalogServiceImpl catalogService;
    @GetMapping("{itemId}")
    public ResponseEntity<byte[]> getImage(@PathVariable String itemId) {
        ItemP item = catalogService.getItem(itemId);
        if (item == null || item.getImageData() == null) {
            return ResponseEntity.notFound().build();
        }

        String mimeType = getMimeTypeFromFileName(item.getFileName());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(mimeType));
        headers.setCacheControl(CacheControl.maxAge(30, TimeUnit.DAYS)); // ✅ 浏览器缓存 30 天
        return new ResponseEntity<>(item.getImageData(), headers, HttpStatus.OK);
    }
}

package com.example.petstoresep.util;

import lombok.Data;

@Data
public class ImageUtil {
    public static String getMimeTypeFromFileName(String fileName) {
        if (fileName == null) return "image/png"; // 默认值

        String ext = fileName.toLowerCase();
        if (ext.endsWith(".jpg") || ext.endsWith(".jpeg")) return "image/jpeg";
        if (ext.endsWith(".png")) return "image/png";
        if (ext.endsWith(".gif")) return "image/gif";
        return "image/png"; // 默认
    }
}

//package com.example.petstoresep.config;
//
////import com.example.petstoresep.interceptor.JwtInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    JwtInterceptor jwtInterceptor;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(jwtInterceptor)
//              .addPathPatterns("/**")
//                .excludePathPatterns("/tokens","/user");
//    }


//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:8080") // Vue地址
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//    }
//}


//
//import com.example.petstoresep.interceptor.JwtInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    JwtInterceptor jwtInterceptor;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(jwtInterceptor)
//              .addPathPatterns("/cart/**")
//                .excludePathPatterns("/tokens","/user");
//    }
//
//
//
//}


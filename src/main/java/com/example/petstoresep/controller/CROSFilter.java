//package com.example.petstoresep.controller;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//@WebFilter(filterName = "CROSFilter")
//public class CROSFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletResponse response=(HttpServletResponse) servletResponse;
//        HttpServletRequest request=(HttpServletRequest) servletRequest;
//        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Credentials","true");
//        response.setHeader("Access-Control-Allow-Methods","POST,GET,PATCH,DELETE,PUT");
//        response.setHeader("Access-Control-Max-Age","3600");
//        response.setHeader("Access-Control-Allow-Headers","Authorization");
//
//        filterChain.doFilter(request,response);
//    }
//}
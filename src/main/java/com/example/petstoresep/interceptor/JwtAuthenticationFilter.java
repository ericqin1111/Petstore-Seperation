package com.example.petstoresep.interceptor;


import com.example.petstoresep.service.CustomUserDetailsService;
import com.example.petstoresep.util.JwtUtil;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {


    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException, java.io.IOException {

        String path = request.getRequestURI();
        if (path.startsWith("/user")|| path.startsWith("/tokens")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 1. 从请求头提取 Token
        String token = extractToken(request);

        if (token != null && JwtUtil.verifyToken(token)) {
            // 2. 解析 Token 获取用户名
            String username = JwtUtil.getUsername(token);

            request.setAttribute("username", username);

            // 3. 加载用户信息
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 4. 构建 Authentication 对象
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

            // 5. 设置到 SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) ) {
            return bearerToken;
        }
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
        return null;
    }
}
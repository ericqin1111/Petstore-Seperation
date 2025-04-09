package com.example.petstoresep.interceptor;

import com.example.petstoresep.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("Authorization");
        if(token==null||!token.startsWith("Bearer ")){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            System.out.println("token1"+token);
            response.getWriter().write("令牌丢失或无效");
            return false;
        }

        String authToken=token.substring(7);

        //获取用户名放在attribute
        String username = JwtUtil.getUsername(authToken);
        request.setAttribute("username",username);

        boolean isValid= JwtUtil.verifyToken(authToken);
        if(!isValid){
            System.out.println("token2:"+token);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("令牌无效或已过期");
            return false; // 中断请求
        }

        return true;
    }
}

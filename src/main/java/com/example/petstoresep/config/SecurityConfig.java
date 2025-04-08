package com.example.petstoresep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // 禁用 CSRF 防护
                .authorizeRequests()
                .requestMatchers("/user/**").permitAll()// 配置请求的访问规则
                .requestMatchers("/tokens/**").permitAll() // 开放登录和注册页面
//                .anyRequest().authenticated() // 其他请求需要认证
                .and()
                .httpBasic(); // 使用基本认证方式
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 密码加密方式
    }

    @Bean
    public UserDetailsService userDetailsService() {

        return username -> {
            // 你可以根据需求自定义加载用户信息
            // 示例中返回一个简单的用户
            if ("user".equals(username)) {
                return User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("password")) // 加密密码
                        .roles("USER")
                        .build();
            }
            throw new UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

        // 配置AuthenticationManager
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

        return authenticationManagerBuilder.build();
    }
}

package com.example.petstoresep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // 创建基于内存的用户信息管理器
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();


        manager.createUser(
                // 创建UserDetails对象，用于管理用户名、用户密码、用户角色、用户权限等内容
                User.withDefaultPasswordEncoder().username("user").password("user123").roles("USER").build()
        );
        // 如果自己配置的有账号密码, 那么上面讲的 user 和 随机字符串 的默认密码就不能用了
        return manager;
    }
}

package com.example.demo.config;

import com.example.demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity //开启webSecurity服务
public class SecurityConfig {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    //通过配置类对AuthenticationManager与自定义的UserDetails和PasswordEncoder进行关联
    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //将编写的UserDetailsService注入进来
        provider.setUserDetailsService(myUserDetailsService);
        //将使用的密码编译器加入进来
        provider.setPasswordEncoder(passwordEncoder);
        //将provider放置到AuthenticationManager 中
        ProviderManager providerManager = new ProviderManager(provider);

        return providerManager;
    }

    //使用 BCryptPasswordEncoder 作为密码加密和解析器
    @Bean
    public PasswordEncoder passwordEncoder(){
        /*
         * 在security安全框架中，提供了若干密码解析器实现类型。
         * 其中BCryptPasswordEncoder 叫强散列加密。可以保证相同的明文，多次加密后，
         * 密码有相同的散列数据，而不是相同的结果。
         * 匹配时，是基于相同的散列数据做的匹配。
         * Spring Security 推荐使用 BCryptPasswordEncoder 作为密码加密和解析器。
         * */
        return new BCryptPasswordEncoder();
    }
}

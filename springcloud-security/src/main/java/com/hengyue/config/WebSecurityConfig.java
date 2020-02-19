package com.hengyue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    public void configGlobal(AuthenticationManagerBuilder auth) throws  Exception{
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* 表示所有的访问都必须要进行认证处理之后才可以正常访问 */
        http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated() ;
        /* 所有的rest服务一定要设置为无状态，以提升性能 */
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) ;
        /*CSRF会将微服务的注册也给过滤了，虽然不会影响注册中心，但是其他客户端是注册不了的。*/
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/hystrix.stream", "turbine.stream");//忽略的访问路径名称
    }
}

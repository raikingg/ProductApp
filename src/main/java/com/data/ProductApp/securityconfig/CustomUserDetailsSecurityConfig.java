package com.data.ProductApp.securityconfig;


import com.data.ProductApp.service.CustomerUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class CustomUserDetailsSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public UserDetailsService mongoUserDetails() {
        return new CustomerUserDetailsService();
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 
        UserDetailsService userDetailsService = mongoUserDetails();
        auth.userDetailsService(userDetailsService);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.cors().disable();

        http.authorizeRequests().antMatchers("/datapoem/*").permitAll()
                .and().httpBasic();
    }
 
}
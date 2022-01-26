//package com.LogisticsCompany.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private UserDetailsService userDetailsService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public SecurityConfig() {
//    }
//
//    public SecurityConfig(boolean disableDefaults) {
//        super(disableDefaults);
//    }
//
//    public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    public SecurityConfig(boolean disableDefaults, UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        super(disableDefaults);
//        this.userDetailsService = userDetailsService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    //@Bean
//    //public BCryptPasswordEncoder passwordEncoder() {
//        //return new BCryptPasswordEncoder();
//    //}
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }
//}

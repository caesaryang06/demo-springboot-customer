package com.example.demospringbootcustomer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author CAESAR
 * @Classname WebConfig
 * @Description springmvc 配置信息
 * @Date 2019-09-14 14:35
 */
@Configuration
@EnableWebMvc  // 开启springmvc功能
@ComponentScan(basePackages = {"com.example.demospringbootcustomer.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {

    //需要配置视图转化器


}

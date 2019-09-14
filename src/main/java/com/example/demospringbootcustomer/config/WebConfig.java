package com.example.demospringbootcustomer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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


    /**
     *  创建SpringMVC视图解析器   springboot 整合 jsp  最好 war
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        //可以在JSP页面中通过${}访问beans
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }


}

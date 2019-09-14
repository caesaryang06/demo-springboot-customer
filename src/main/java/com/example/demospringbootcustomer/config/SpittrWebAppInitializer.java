package com.example.demospringbootcustomer.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author CAESAR
 * @Classname SpittrWebAppInitializer
 * @Description springmvc--dispatcherservlet
 * @Date 2019-09-14 14:14
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     *加载根配置信息  spring核心
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }


    /**
     * springmvc 加载配置信息
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * springmvc 拦截url映射   拦截所有请求
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

package com.example.demospringbootcustomer;


import com.example.demospringbootcustomer.servlet.IndexServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;


/**
 * java语言启动tomcat
 * 使用java内置tomcat运行springmvc框架原理 tomcat加载到springmvc注解启动方法 就会创建springmvc容器
 */
public class StartTomcatApplication {

    private static int SERVER_PORT=8080;

    private static String CONTEXT_PATH="/server";

    private static String SERVLET_NAME = "indexServlet";

    public static void main(String[] args) throws Exception {
        start();

    }


    /**
     * 启动tomcat  加载springmvc  初始化容器
     * @throws ServletException
     * @throws LifecycleException
     */
    public static void start() throws ServletException, LifecycleException {

        Tomcat tomcatServer = new Tomcat();
        tomcatServer.setPort(SERVER_PORT);

        // 读取项目路径 加载静态资源
        StandardContext  context = (StandardContext) tomcatServer.addWebapp("/", new File("src/main").getAbsolutePath());

        // 禁止重新载入
        context.setReloadable(false);

        // class文件读取地址
        File addClass2Web = new File("target/classes");

        // 创建webroot
        WebResourceRoot resourceRoot = new StandardRoot(context);

        // tomcat内部读取class执行
        resourceRoot.addPreResources(
                new DirResourceSet(resourceRoot,"/WEB_INF/classes",addClass2Web.getAbsolutePath(),"/")
        );

        tomcatServer.start();
        // 异步接收请求
        tomcatServer.getServer().await();


    }


    /**
     * 简单的servlet演示
     * @throws LifecycleException
     */
    public static void start1() throws LifecycleException {
        Tomcat tomcatServer = new Tomcat();
        tomcatServer.setPort(SERVER_PORT);

        // 是否设置自动部署
        tomcatServer.getHost().setAutoDeploy(false);

        // 获取上下文
        StandardContext standardContext = new StandardContext();
        standardContext.setPath(CONTEXT_PATH);

        // 监听上下文
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());

        // tomcat 容器添加standardcontext
        tomcatServer.getHost().addChild(standardContext);

        // 创建servlet
        tomcatServer.addServlet(CONTEXT_PATH,SERVLET_NAME,new IndexServlet());

        standardContext.addServletMappingDecoded("/index",SERVLET_NAME);
        tomcatServer.start();
        // 异步接收请求
        tomcatServer.getServer().await();
    }



}

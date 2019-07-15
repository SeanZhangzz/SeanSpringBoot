package com.sean.springboot.init;

import com.sean.springboot.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        System.out.println("hello MyWebApplicationInitializer");
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
        // ac.refresh(); //  如果配置有视图解析器，这里会报错，找不到servletContext

        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);
        app.setLoadOnStartup(1); //启动时，会调用applicationContext.refresh(),刷新spring容器
        app.addMapping("/*");
    }
}

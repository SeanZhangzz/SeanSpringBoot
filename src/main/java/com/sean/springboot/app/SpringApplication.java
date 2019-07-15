package com.sean.springboot.app;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

public class SpringApplication {

    public static void run(){
        Tomcat tomcat = new Tomcat(); // 引入tomcat jar包，可以直接new
        tomcat.setPort(9001);
        try {
            tomcat.addWebapp("/","D:\\webapp\\");
            tomcat.start();
            System.out.println("hello tomcat");

            tomcat.getServer().await(); // 等待访问
        } catch (LifecycleException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}

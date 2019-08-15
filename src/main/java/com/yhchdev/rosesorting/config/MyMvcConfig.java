package com.yhchdev.rosesorting.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("login").setViewName("login");
        registry.addViewController("Main.html").setViewName("dashboard");
        registry.addViewController("main").setViewName("dashboard");


        registry.addViewController("/icon").setViewName("icons");
        registry.addViewController("/notifications").setViewName("notifications");
        registry.addViewController("/tables").setViewName("tables");
        registry.addViewController("/upgrade").setViewName("upgrade");
        registry.addViewController("/charts").setViewName("charts");
        registry.addViewController("/typography").setViewName("typography");

        registry.addViewController("/controll").setViewName("controll");

    }
}

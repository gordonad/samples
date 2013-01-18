package com.habuma.guestbook.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class GuestbookWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        container.setInitParameter("contextConfigLocation", "com.habuma.guestbook.config");

        AnnotationConfigWebApplicationContext contextLoaderContext =
                new AnnotationConfigWebApplicationContext();
        container.addListener(new ContextLoaderListener(contextLoaderContext));

        AnnotationConfigWebApplicationContext dispatcherServletContext =
                new AnnotationConfigWebApplicationContext();
        dispatcherServletContext.setConfigLocation("");
        ServletRegistration.Dynamic dispatcher =
                container.addServlet("appServlet", new DispatcherServlet(dispatcherServletContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

}

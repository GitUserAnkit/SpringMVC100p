package com.ankit.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.ankit.config.RootAppConfig;
import com.ankit.config.WebMVCAppConfig;

public class MyWebApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		AnnotationConfigWebApplicationContext childCtx=null,rootCtx=null;
		ContextLoaderListener listener=null;
		DispatcherServlet servlet=null;
		ServletRegistration.Dynamic register=null;
		//create two container
		rootCtx=new AnnotationConfigWebApplicationContext();
		rootCtx.register(RootAppConfig.class);
		childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(WebMVCAppConfig.class);
		//create listener
		//parent Container
		listener=new ContextLoaderListener(rootCtx);
		sc.addListener(listener);
		//child Container
		servlet=new DispatcherServlet(childCtx);
		register=sc.addServlet("dispatcher",servlet);
		register.addMapping("*.htm");
		register.setLoadOnStartup(2);
		rootCtx.close();childCtx.close();
	}//method

}//class

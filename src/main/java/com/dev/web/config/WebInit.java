package com.dev.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(1)
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{AppContext.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebContext.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	public void onStartup(ServletContext servletcontext) throws ServletException{
		super.onStartup(servletcontext);
	}
}

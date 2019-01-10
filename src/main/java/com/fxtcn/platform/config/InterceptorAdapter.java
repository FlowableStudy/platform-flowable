//package com.fxtcn.platform.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import com.fxtcn.platform.filter.CustomHandlerInterceptor;
//@Configuration
//public class InterceptorAdapter extends WebMvcConfigurerAdapter {
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		
//		registry.addInterceptor(new CustomHandlerInterceptor())
//		.addPathPatterns("/**")
//		.excludePathPatterns("/","/login","/logout","toLogin","/error/**");
//		super.addInterceptors(registry);
//	}
//}

package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Administrator
 * @date 2019年10月14日
 * @version 1.0
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

	// 所有的WebMvcConfigurerAdapter组件都会一起起作用
	@Bean // 将组件注册在容器中
	public WebMvcConfigurer webMvcConfigurerAdapter() {
		return new WebMvcConfigurer() {

			// 注册拦截器
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				/*
				 * 其中addInterceptor方法用于把刚才创建的拦截器加入到registry中,addPathPatterns用户加入所要拦截的url，
				 * /表示拦截所有请求。excludePathPatterns添加不需要拦截的请求。
				 */
				registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login",
						"/img/**", "/js/**", "/style/**","/upload/**");

			}

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				// TODO Auto-generated method stub
				registry.addResourceHandler("/upload/**").addResourceLocations("file:F:/imgs/");
			
				WebMvcConfigurer.super.addResourceHandlers(registry);
			}
		};
	}

}

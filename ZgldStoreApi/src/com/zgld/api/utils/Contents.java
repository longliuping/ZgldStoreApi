package com.zgld.api.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zgld.api.service.BaseService;

public class Contents {
	public static String getBaseServiceName(){
		return "baseService";
	}
	private static String getApplicationContextConfigLocation(){
		return "classpath:applicationContext.xml";
	}
	public static BaseService getBaseService(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(getApplicationContextConfigLocation());
		BaseService baseService = (BaseService) ac.getBean(getBaseServiceName());
		return baseService;
	}
	
}

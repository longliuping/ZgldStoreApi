package com.zgld.api.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zgld.api.biz.BaseBiz;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BaseBiz baseBiz = (BaseBiz) ac.getBean("baseBiz");
		baseBiz.findAll(" from YWxpayConfig");
	}
}

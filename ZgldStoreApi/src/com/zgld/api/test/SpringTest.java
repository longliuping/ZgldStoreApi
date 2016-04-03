package com.zgld.api.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zgld.api.beans.YWxpayConfig;
import com.zgld.api.biz.BaseBiz;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BaseBiz baseBiz = (BaseBiz) ac.getBean("baseBiz");
		List<YWxpayConfig> list = (List<YWxpayConfig>)baseBiz.findAll(" from YWxpayConfig");
		for (YWxpayConfig yWxpayConfig : list) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
		}
	}
}

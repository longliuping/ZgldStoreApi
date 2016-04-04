package com.zgld.api.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YWxpayConfig;
import com.zgld.api.biz.BaseBiz;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		BaseBiz baseBiz = (BaseBiz) ac.getBean("baseBiz");
		List<YAccount> list = (List<YAccount>)baseBiz.findAll(" from YAccount ");
		for (YAccount account : list) {
			System.out.println(account.getAccountName());
		
		}
	}
}

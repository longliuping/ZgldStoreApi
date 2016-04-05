package com.zgld.api.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zgld.api.beans.UserProfile;
import com.zgld.api.beans.Users;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YWxpayConfig;
import com.zgld.api.biz.BaseBiz;

public class SpringTest {
	public static void main(String[] args) {
		String token = "123456";
		int userId = 6;
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		BaseBiz baseBiz = (BaseBiz) ac.getBean("baseBiz");
//		List<YAccount> list = (List<YAccount>)baseBiz.findAll(" from YAccount ");
//		for (YAccount account : list) {
//			System.out.println(account.getAccountName());
//		
//		}
		
		
		
//		Object obj = baseBiz.bean(" from YAccount as y, Users as u,UserProfile as p where u.userId = p.userId and p.userId = y.accountId and y.accountName = 'longliuping'");
//		Object[] object = (Object[])obj;
//		if(object == null || object.length<0){
//			
//		}else{
//			YAccount account = (YAccount)object[0];
//			if(object.length>1){
//				account.setUsers((Users)object[1]);
//				if(object.length>2){
//					account.setUserProfile((UserProfile)object[2]);
//				}
//			}
//		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		Object obj = baseBiz.bean(" from YAccount as y, Users as u,UserProfile as p where (u.userId=6 and u.appUserToken = '"+token+"') and u.userId = p.userId and p.userId = y.accountId");
		Object[] object = (Object[])obj;
		if(object!=null & object.length>0){
			YAccount account = (YAccount)object[0];
			if(object.length>1){
				account.setUsers((Users)object[1]);
				if(object.length>2){
					account.setUserProfile((UserProfile)object[2]);
				}
				
			}else{
				
			}
		}else{
			
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
}

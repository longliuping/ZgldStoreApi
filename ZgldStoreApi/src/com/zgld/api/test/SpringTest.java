package com.zgld.api.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zgld.api.beans.Products;
import com.zgld.api.beans.Sku;
import com.zgld.api.beans.Skugroup;
import com.zgld.api.beans.UserProfile;
import com.zgld.api.beans.Users;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YWxpayConfig;
import com.zgld.api.service.BaseService;
import com.zgld.api.utils.Contents;

public class SpringTest {
	public static void main(String[] args) {
		String token = "123456";
		int userId = 6;
		BaseService baseService = Contents.getBaseService();
		// Object obj = baseService.bean(" from YAccount as y, Users as
		// u,UserProfile as p where (u.userId=6 and u.appUserToken =
		// '"+token+"') and u.userId = p.userId and p.userId = y.accountId");
		// Object[] object = (Object[])obj;
		// if(object!=null & object.length>0){
		// YAccount account = (YAccount)object[0];
		// if(object.length>1){
		// account.setUsers((Users)object[1]);
		// if(object.length>2){
		// account.setUserProfile((UserProfile)object[2]);
		// }
		//
		// }else{
		//
		// }
		// }else{
		//
		// }
//		try {
//			List<Skugroup> listInfo = (List<Skugroup>) baseService.findAll(" from Skugroup as sg where sg.productId = 1");
//			for (int i = 0; i < listInfo.size(); i++) {
//				listInfo.get(i).setListSkus((List<Sku>) baseService
//						.findAll(" from Sku as s where s.skugroupId = " + listInfo.get(i).getSkugroupId()));
//			}
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		List<Products> listInfo = (List<Products>)baseService.findAll(" from Products ");
		for (Products products : listInfo) {
			System.out.println(products.getProductName());
		}
	}
}

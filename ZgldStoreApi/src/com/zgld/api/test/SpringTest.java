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
import com.zgld.api.beans.YRebateLevel;
import com.zgld.api.beans.YWxpayConfig;
import com.zgld.api.service.BaseService;
import com.zgld.api.utils.Contents;

public class SpringTest {
	static BaseService baseService = null;
	public static void main(String[] args) {
		String token = "123456";
		int userId = 6;
		baseService = Contents.getBaseService();
		rebateLevel();
		
	}
	/**
	 * 利益链等级配置
	 */
	public static void rebateLevel(){
		List<YRebateLevel> listRebateLevel = (List<YRebateLevel>)baseService.findAll(" from YRebateLevel as l order by l.rebateLevel asc ");
		for (YRebateLevel info : listRebateLevel) {
			switch (info.getRebateLevel()) {
			case 0:
				System.out.println("自己:"+info.getRebateIntro());
				break;
			case 1:
				System.out.println("一:"+info.getRebateIntro());
				break;
			case 2:
				System.out.println("二:"+info.getRebateIntro());
				break;
			case 3:
				System.out.println("三:"+info.getRebateIntro());
				break;
			}
		}
	}
}

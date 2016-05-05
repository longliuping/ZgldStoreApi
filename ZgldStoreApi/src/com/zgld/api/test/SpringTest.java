package com.zgld.api.test;

import java.util.ArrayList;
import java.util.List;

import com.zgld.api.beans.UserProfile;
import com.zgld.api.beans.YRebateLevel;
import com.zgld.api.beans.YRebateRelation;
import com.zgld.api.service.BaseService;
import com.zgld.api.utils.Contents;
import com.zgld.api.utils.PriceUtil;

public class SpringTest {
	static BaseService baseService = null;

	public static void main(String[] args) {
//		String token = "123456";
//		int userId = 6;
		baseService = Contents.getBaseService();
		ok_order();
		
		
	}
	public static void ok_order(){
		double totalPrice = 1000;//订单总金额
		System.out.println("订单总金额:"+totalPrice);
		double interestPrrice = PriceUtil.proportion(totalPrice, 10);//返利总金额
		List<YRebateLevel> list = rebateLevel();
		System.out.println("利益链总金额:"+interestPrrice);
		double  u0Price = PriceUtil.proportion(interestPrrice, list.get(0).getRebatePercent());
		double  u1Price = PriceUtil.proportion(interestPrrice, list.get(1).getRebatePercent());
		double  u2Price = PriceUtil.proportion(interestPrrice, list.get(2).getRebatePercent());
		double  u3Price = PriceUtil.proportion(interestPrrice, list.get(3).getRebatePercent());
		System.out.println("消费者返利金额:"+u0Price+"\n"+"一度人脉返利金额:"+u1Price+"\n二度人脉返利金额:"+u2Price+"\n三度人脉返利金额:"+u3Price);

	}
	/**
	 * 获取推荐的用户领导
	 */
	public static UserProfile recommendUser(int level,int userId) {
		UserProfile up = null;
		List<?> listObj  = null;
		List<YRebateRelation> listOne = null;
		StringBuffer sb = null;
		switch (level) {
		case 1:
			listObj = baseService.findAll(" from YRebateRelation as r,UserProfile as u where r.currentUserId = u.userId and r.parentUserId = " + userId);
			for (int i = 0; i < listObj.size(); i++) {
				Object[] o = (Object[]) listObj.get(i);
				YRebateRelation r = (YRebateRelation)o[0];
				up = (UserProfile)o[1];
			}
			break;
		case 2:
			listOne = (List<YRebateRelation>)baseService.findAll(
					" from YRebateRelation as r where r.parentUserId = " + userId);
			sb = new StringBuffer(" from YRebateRelation as r,UserProfile as u where (r.currentUserId = u.userId) ");
			if(listOne!=null && listOne.size()>0){
				sb.append(" and ( ");
			}
			for (YRebateRelation object : listOne) {
				 sb.append(" r.parentUserId = "+object.getCurrentUserId()+" or ");
			}
			if(listOne!=null && listOne.size()>0){
				sb.delete(sb.length()-3, sb.length());
				sb.append(" ) ");
				listObj = baseService.findAll(sb.toString());
				for (int i = 0; i < listObj.size(); i++) {
					Object[] o = (Object[]) listObj.get(i);
					YRebateRelation r = (YRebateRelation)o[0];
					up = (UserProfile)o[1];
				}
			}
			break;
		case 3:
			listOne = (List<YRebateRelation>)baseService.findAll(" from YRebateRelation as r where r.parentUserId = " + userId);
			sb = new StringBuffer(" from YRebateRelation as r ");
			if(listOne!=null && listOne.size()>0){
				sb.append(" where ( ");
				for (YRebateRelation object : listOne) {
					 sb.append(" r.parentUserId = "+object.getCurrentUserId()+" or ");
				}
				if(listOne!=null && listOne.size()>0){
					sb.delete(sb.length()-3, sb.length());
					sb.append(" ) ");
				}
				listOne = (List<YRebateRelation>)baseService.findAll(sb.toString());
				listObj = baseService.findAll(sb.toString());
				sb = new StringBuffer(" from YRebateRelation as r,UserProfile as u where (r.currentUserId = u.userId) ");
				if(listOne!=null && listOne.size()>0){
					sb.append(" and ( ");
					for (YRebateRelation object : listOne) {
						 sb.append(" r.parentUserId = "+object.getCurrentUserId()+" or ");
					}
					if(listOne!=null && listOne.size()>0){
						sb.delete(sb.length()-3, sb.length());
						sb.append(" ) ");
					}
					listObj = baseService.findAll(sb.toString());
					for (int i = 0; i < listObj.size(); i++) {
						Object[] o = (Object[]) listObj.get(i);
						YRebateRelation r = (YRebateRelation)o[0];
						up = (UserProfile)o[1];
					}
				}
				
			}
			break;

		}
		return up;
	}

	/**
	 * 利益链等级配置
	 */
	public static List<YRebateLevel> rebateLevel() {
		List<YRebateLevel> listRebateLevel = (List<YRebateLevel>) baseService
				.findAll(" from YRebateLevel as l order by l.rebateLevel asc ");
		for (YRebateLevel info : listRebateLevel) {
			switch (info.getRebateLevel()) {
			case 0:
				System.out.println("自己:" + info.getRebateIntro());
				break;
			case 1:
				System.out.println("一:" + info.getRebateIntro());
				break;
			case 2:
				System.out.println("二:" + info.getRebateIntro());
				break;
			case 3:
				System.out.println("三:" + info.getRebateIntro());
				break;
			}
		}
		return listRebateLevel;
	}
}

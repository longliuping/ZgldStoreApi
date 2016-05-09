package com.zgld.api.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.zgld.api.beans.OrderItems;
import com.zgld.api.beans.Orders;
import com.zgld.api.beans.Products;
import com.zgld.api.beans.SubmitOrderParam;
import com.zgld.api.beans.UserProfile;
import com.zgld.api.beans.YFormCombine;
import com.zgld.api.beans.YFormCombineValue;
import com.zgld.api.beans.YFormControl;
import com.zgld.api.beans.YFormTag;
import com.zgld.api.beans.YFormValue;
import com.zgld.api.beans.YRebateLevel;
import com.zgld.api.beans.YRebateRelation;
import com.zgld.api.service.BaseService;
import com.zgld.api.utils.Contents;
import com.zgld.api.utils.PriceUtil;
//com.google.gson.reflec
import com.google.gson.reflect.*;
public class SpringTest {
	static BaseService baseService = null;

	public static void main(String[] args) {
//		String token = "123456";
//		int userId = 6;
		baseService = Contents.getBaseService();
		
//		int productId = 3;
//		List<?> list = baseService.findAll(" from YFormValue as fv,YFormTag as ft where fv.tagId = ft.tagId and fv.objTable = 'Products' and fv.objId = "+productId);
//		for (Object object : list) {
//			Object obj[] = (Object[])object;
//			YFormValue fv = (YFormValue)obj[0];
//			YFormTag ft = (YFormTag)obj[1];
//			List<YFormControl> listFormControl = (List<YFormControl>)baseService.findAll(" from YFormControl as fc where fc.tagId = "+fv.getTagId());
//			System.out.print(ft.getTagName()+":");
//			for (YFormControl yFormControl : listFormControl) {
//				System.out.print(yFormControl.getControlName()+",");
//			}
//			System.out.println("");
//		}
//		
//		baseService.findAll(" from YFormCombine as fc,YFormValue as fv, where fc.objTable = 'Products' and fc.objId = "+productId);
	
//		List<?> listObj = baseService.findAll(" from YFormCombine fc,YFormValue as fv,YFormTag as ft where fv.tagId = ft.tagId and fv.objTable = 'Products' and fv.objId = "+productId+" and fv.tagFieldName = fc.tagFieldName and fc.objTable = 'Products' and fc.objId = "+productId+" and fc.combineString = '_-size-3_-color-353_'");
//		for (Object object : listObj) {
//			Object obj[] = (Object[])object;
//			YFormCombine fc = (YFormCombine)obj[0];
//			YFormValue fv = (YFormValue)obj[1];
//			YFormTag ft = (YFormTag)obj[2];
//			System.out.println(ft.getTagName()+":"+fc.getControlName());
//		}
		
		baseService.updateListObject(" delete from ShoppingCarts as sc where sc.productId = 3 and sc.userId = 2");
		
	}
	public static void submit_order(){
		List<SubmitOrderParam> listOrder = new ArrayList<>();
		SubmitOrderParam param1 = new SubmitOrderParam();
		param1.setNumber(2);
		param1.setProductId(1);
		param1.setShopId(2);
		
		SubmitOrderParam param2 = new SubmitOrderParam();
		param2.setNumber(2);
		param2.setProductId(2);
		param2.setShopId(2);
		
		SubmitOrderParam param3 = new SubmitOrderParam();
		param3.setNumber(2);
		param3.setProductId(3);
		param3.setShopId(1);
		
		listOrder.add(param1);
		listOrder.add(param2);
		listOrder.add(param3);
		
		Gson gson = new Gson();
		String json = gson.toJson(listOrder);
		System.out.println(json);
		List<SubmitOrderParam> listParam = gson.fromJson(json, new TypeToken<List<SubmitOrderParam>>() {
		}.getType());
		
		if(listParam==null || listParam.size()<=0){
			
		}else{
			String message = null;
			int userId = 2;
			double salePrice = 0.0D;
			int shopId = 0;
			List<Orders> listOrders = new ArrayList<>();
			List<OrderItems> listOrderItems = new ArrayList<>();
			shopId = listParam.get(0).getShopId();
			Orders orders = null;
			for (int i = 0; i < listParam.size(); i++) {
				SubmitOrderParam pa = listParam.get(i);
				Products products = (Products)baseService.bean(" from Products as p where p.productId = "+pa.getProductId());
				if(products==null){
					message = "产品不存在(ID)"+pa.getProductId();
				}else{
					int number = 0;
					double price = 0.0;
					if(pa.getValueId()>0){
						YFormCombineValue formCombineValue = (YFormCombineValue)baseService
								.bean(" from YFormCombineValue as fcv where fcv.objTable = 'Products' and fcv.combineValueId = "+pa.getValueId()+" and fcv.objId = "+pa.getProductId());
						if(formCombineValue!=null){
							number = formCombineValue.getGoStore();
							price = formCombineValue.getGoSalePrice();
						}else{
							message = "产品ID"+pa.getProductId()+"规格不存在"+pa.getValueId();
						}
					}else{
						number = products.getStock();
						price = products.getSalePrice();
					}
					if (pa.getNumber() > number){
						message = "产品ID"+products.getProductId()+ "库存不能大于" + number;
					}
					if(message==null){
						if(shopId==products.getShopId()){
							OrderItems items = new OrderItems();
							items.setProductId(pa.getProductId());
							if(pa.getValueId()>0){
								items.setSku(pa.getValueId());
							}
							items.setQuantity(pa.getNumber());
							items.setListPrice(Double
									.valueOf(price));
							items.setCellPrice(price);
							items.setRemark("");
							salePrice += pa.getNumber() * price;
							listOrderItems.add(items);
							
							orders = new Orders();
							orders.setUserId(Integer.valueOf(userId));
							orders.setFreight(Double.valueOf(0.0D));
							orders.setShippingId(Integer.valueOf(0));
							orders.setShipOrderNumber("");
							orders.setShippingStatus(Integer.valueOf(0));
							orders.setRefundStatus(Integer.valueOf(0));
							orders.setPaymentStatus(Integer.valueOf(0));
							orders.setOrderTotalPrice(Double.valueOf(0.0D));
							orders.setOtherCost(Double.valueOf(0.0D));
							orders.setOrderRealPrice(Double.valueOf(0.0D));
							orders.setRemark("");
							orders.setOrderDate(new Date());
							orders.setOrderTotalPrice(Double.valueOf(salePrice));
							orders.setShopId(shopId);
							
						}else{
							orders.setListOrderItems(listOrderItems);
							orders.setOrderTotalPrice(salePrice);
							listOrders.add(orders);
							orders = new Orders();
							salePrice = 0.0;
							orders.setUserId(Integer.valueOf(userId));
							orders.setFreight(Double.valueOf(0.0D));
							orders.setShippingId(Integer.valueOf(0));
							orders.setShipOrderNumber("");
							orders.setShippingStatus(Integer.valueOf(0));
							orders.setRefundStatus(Integer.valueOf(0));
							orders.setPaymentStatus(Integer.valueOf(0));
							orders.setOrderTotalPrice(Double.valueOf(0.0D));
							orders.setOtherCost(Double.valueOf(0.0D));
							orders.setOrderRealPrice(Double.valueOf(0.0D));
							orders.setRemark("");
							orders.setOrderDate(new Date());
							orders.setOrderTotalPrice(Double.valueOf(salePrice));
							orders.setShopId(shopId);
							
							salePrice = 0 ;
							listOrderItems = new ArrayList<>();
							
							OrderItems items = new OrderItems();
							items.setProductId(pa.getProductId());
							if(pa.getValueId()>0){
								items.setSku(pa.getValueId());
							}
							items.setQuantity(pa.getNumber());
							items.setListPrice(Double
									.valueOf(price));
							items.setCellPrice(price);
							items.setRemark("");
							salePrice += pa.getNumber() * price;
							listOrderItems.add(items);
						}
						
					}
				}
			}
			orders.setListOrderItems(listOrderItems);
			orders.setOrderTotalPrice(salePrice);
			listOrders.add(orders);
			for (int i = 0; i < listOrders.size(); i++) {
				Serializable s = baseService.save(listOrders.get(i));
				int orderId = Integer.parseInt(s.toString());
				for (int j = 0; j < listOrders.get(i).getListOrderItems().size(); j++) {
					OrderItems items = listOrders.get(i).getListOrderItems().get(j);
					items.setOrderId(orderId);
					baseService.save(items);
				}
			}
		}
	}
	public static void ok_order(){
		double totalPrice = 100;//订单总金额
		System.out.println("订单总金额:"+totalPrice);
		double interestPrrice = PriceUtil.proportion(totalPrice, 10);//返利总金额
		List<YRebateLevel> list = rebateLevel();
		System.out.println("利益链总金额:"+interestPrrice);
		double  u0Price = PriceUtil.proportion(interestPrrice, list.get(0).getRebatePercent());
		double  u1Price = PriceUtil.proportion(interestPrrice, list.get(1).getRebatePercent());
		double  u2Price = PriceUtil.proportion(interestPrrice, list.get(2).getRebatePercent());
		double  u3Price = PriceUtil.proportion(interestPrrice, list.get(3).getRebatePercent());
		System.out.println("消费者返利金额:"+u0Price+"\n"+"一度人脉返利金额:"+u1Price+"\n二度人脉返利金额:"+u2Price+"\n三度人脉返利金额:"+u3Price);
		//修改订单

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

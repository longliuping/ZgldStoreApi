package com.zgld.api.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.export.Data;

import com.zgld.api.beans.BalanceDetails;
import com.zgld.api.beans.Orders;
import com.zgld.api.beans.OrdersRebate;
import com.zgld.api.beans.Products;
import com.zgld.api.beans.UserProfile;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YRebateLevel;
import com.zgld.api.beans.YRebateRelation;
import com.zgld.api.beans.YShop;
import com.zgld.api.utils.PriceUtil;

/**
 * 商家action
 * 
 * @author Am
 *
 */
public class SupplierAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 商家的产品
	 * 
	 * @return
	 */
	public String supplier_product() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			if (form.getShopId() == null) {
				this.form.setJsonMsg("shopId不能为空", false, json, 1001);
			} else {
				List<Products> listInfo = (List<Products>) baseService.findPage(form.getPageNum(), form.getPageSize(),
						" from Products as hp where hp.shopId = " + form.getShopId());
				json.put(LISTINFO, listInfo);
				form.setJsonMsg(SUCCESS, true, json, 200);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	// public String hot_supplier() {
	// Map<String, Object> json = new HashMap<String, Object>();
	// try {
	// List<SupperHot> listSupperHots = (List<SupperHot>)
	// baseService.findPage(form.getPageNum(), form.getPageSize(),
	// " from SupperHot as sh where sh.hotid = " + form.getHotid());
	// List<Supplier> listInfo = new ArrayList<Supplier>();
	// if (listSupperHots != null && listSupperHots.size() > 0) {
	// StringBuffer sb = new StringBuffer(" from Supplier as s where ");
	// for (int i = 0; i < listSupperHots.size(); i++) {
	// SupperHot supperHot = listSupperHots.get(i);
	// sb.append(" s.userId = " + supperHot.getUserid() + " or ");
	// }
	// sb.delete(sb.toString().length() - 3, sb.toString().length());
	// listInfo = (List<Supplier>) baseService.findAll(sb.toString());
	// }
	// json.put(LISTINFO, listInfo);
	// form.setJsonMsg(SUCCESS, true, json, 200);
	// } catch (Exception e) {
	// // TODO: handle exception
	// e.printStackTrace();
	// form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
	// }
	// return JSON_PAGE;
	// }

	/**
	 * 根据地址和热门标签查询商家
	 * 
	 * @return
	 */
	public String hot_area_supplier() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			List<YShop> listInfo = new ArrayList<YShop>();
			List<?> obj = baseService.findPage(form.getPageNum(), form.getPageSize(),
					" from YShop as s,ShopArea as sa,ShopHot as sh where s.shopId = sa.shopId and sa.shopId = sh.shopId and sa.areaId = "
							+ form.getAreaid() + " and sh.hotId = " + form.getHotid());
			for (Object object : obj) {
				listInfo.add((YShop) ((Object[]) object)[0]);
			}
			json.put(LISTINFO, listInfo);
			form.setJsonMsg(SUCCESS, true, json, 200);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

//	public String offline_payment() {
//		Map<String, Object> json = new HashMap<String, Object>();
//		try {
//			YAccount account = getUserInfo();
//			if (account != null) {
//				YShop shop = (YShop) baseService.bean(" from YShop as s where s.shopId = " + form.getShopId());
//				if (shop == null) {
//					this.form.setJsonMsg("商家不存在", false, json, 1001);
//				} else {
//					UserProfile userProfile = (UserProfile) this.baseService
//							.bean(" from UserProfile as p where p.userId = " + shop.getUserId());
//					if (userProfile == null) {
//						this.form.setJsonMsg("商户已被删除", false, json, 1001);
//					} else if (form.getMoney() == null) {
//						this.form.setJsonMsg("money不能为空", false, json, 1001);
//					} else if (userProfile.getBalance() < form.getMoney()) {
//						this.form.setJsonMsg("商户账户余额不足" + PriceUtil.price(form.getMoney()) + ",请提醒商户充值！", false, json,
//								1001);
//					} else {
//						form.setJsonMsg("提交成功，等待商户审核!", true, json, 200);
//					}
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
//		}
//		return JSON_PAGE;
//	}

	/**
	 * 会员申请订单线下支付
	 * 
	 * @return
	 */
	public String order_offinle_payment() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if (this.form.getOrderid() == null) {
					this.form.setJsonMsg("orderid不能为空", false, json, 1001);
				} else {
					Orders order = (Orders) this.baseService
							.bean(" from Orders as o where o.userId = "+account.getUserProfile().getUserId()+" and o.orderId = " + this.form.getOrderid());
					if (order == null) {
						this.form.setJsonMsg("订单不存在", false, json, 1001);
					} else if ((order != null) && (order.getPaymentStatus().intValue() == 1)) {
						this.form.setJsonMsg("订单已经支付，不能重复支付", false, json, 1001);
					} else {
						YShop shop = (YShop) baseService.bean(" from YShop as s where s.shopId = " + order.getShopId());
						if (shop == null) {
							this.form.setJsonMsg("商家不存在", false, json, 1001);
						} else {
							UserProfile userProfile = (UserProfile) this.baseService
									.bean(" from UserProfile as p where p.userId = " + shop.getUserId());
							if (userProfile == null) {
								this.form.setJsonMsg("商家已被删除", false, json, 1001);
							} else if (userProfile.getBalance() < order.getOrderTotalPrice()) {
								this.form.setJsonMsg(
										"商家账户余额不足" + PriceUtil.price(order.getOrderTotalPrice()) + ",请提醒商户充值！", false,
										json, 1001);
							} else {
								order.setPaymentStatus(2);//会员申请线下支付
								baseService.update(order);
								form.setJsonMsg("提交成功，等待商家确认!", true, json, 200);
							}
							
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
	/**
	 * 商家确认线下支付
	 * @return
	 */
	public String order_offinle_payment_ok() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if (this.form.getOrderid() == null) {
					this.form.setJsonMsg("orderid不能为空", false, json, 1001);
				} else {
					Orders order = (Orders) this.baseService
							.bean(" from Orders as o where o.userId = "+account.getUserProfile().getUserId()+" and o.orderId = " + this.form.getOrderid());
					if (order == null) {
						this.form.setJsonMsg("订单不存在", false, json, 1001);
					} else if ((order != null) && (order.getPaymentStatus().intValue() == 1)) {
						this.form.setJsonMsg("订单已经支付，不能重复支付", false, json, 1001);
					} else if(order.getPaymentStatus()!=2){
						this.form.setJsonMsg("会员没有申请线下支付", false, json, 1001);
					}else{
						YShop shop = (YShop) baseService.bean(" from YShop as s where s.shopId = " + order.getShopId());
						if (shop == null) {
							this.form.setJsonMsg("商家不存在", false, json, 1001);
						} else {
							UserProfile userProfile = (UserProfile) this.baseService
									.bean(" from UserProfile as p where p.userId = " + shop.getUserId());
							if (userProfile == null) {
								this.form.setJsonMsg("商家已被删除", false, json, 1001);
							} else if (userProfile.getBalance() < order.getOrderTotalPrice()) {
								this.form.setJsonMsg(
										"商家账户余额不足" + PriceUtil.price(order.getOrderTotalPrice()), false,
										json, 1001);
							} else {
								order.setPaymentStatus(1);//会员申请线下支付
								baseService.update(order);
								ok_order(account, order);
								form.setJsonMsg("确认成功!", true, json, 200);
							}
							
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
	/**
	 * 订单确认使用
	 */
	public String order_ok_use() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if (this.form.getOrderid() == null) {
					this.form.setJsonMsg("orderid不能为空", false, json, 1001);
				} else {
					Orders order = (Orders) this.baseService
							.bean(" from Orders as o where o.orderId = " + this.form.getOrderid());
					if (order == null) {
						this.form.setJsonMsg("订单不存在", false, json, 1001);
					} else if ((order != null) && (order.getPaymentStatus().intValue() <= 1)) {
						this.form.setJsonMsg("订单还没有支付，不能使用", false, json, 1001);
					} else if(form.getCode()==null){
						this.form.setJsonMsg("确认码不能为空", false, json, 1001);
					}else if("1".equals(order.getConsumptionStatus())){
						this.form.setJsonMsg("已经使用", false, json, 1001);
					}else if(!form.getCode().equals(order.getConsumptionCode())){
						this.form.setJsonMsg("消费验证码错误", false, json, 1001);
					}else{
						ok_order(account, order);
						form.setJsonMsg("确认成功!", true, json, 200);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
	/**
	 * 确认订单
	 * @param account
	 * @param order
	 */
	private void ok_order(YAccount account,Orders order){
		int orderId = order.getOrderId();
		double totalPrice = order.getOrderTotalPrice();// 订单总金额
		System.out.println("订单总金额:" + totalPrice);
		double interestPrrice = PriceUtil.proportion(totalPrice, 10);// 返利总金额
		List<YRebateLevel> list = rebateLevel();
		System.out.println("利益链总金额:" + interestPrrice);
		double u0Price = PriceUtil.proportion(interestPrrice, list.get(0).getRebatePercent());
		double u1Price = PriceUtil.proportion(interestPrrice, list.get(1).getRebatePercent());
		double u2Price = PriceUtil.proportion(interestPrrice, list.get(2).getRebatePercent());
		double u3Price = PriceUtil.proportion(interestPrrice, list.get(3).getRebatePercent());
		System.out.println("消费者返利金额:" + u0Price + "\n" + "一度人脉返利金额:" + u1Price + "\n二度人脉返利金额:"
				+ u2Price + "\n三度人脉返利金额:" + u3Price);
		UserProfile userProfile = (UserProfile) this.baseService
				.bean(" from UserProfile as p where p.userId = " + account.getUserProfile().getUserId());
		userProfile.setBalance(userProfile.getBalance() + u0Price);
		baseService.update(userProfile);
		
		OrdersRebate rebate = new OrdersRebate();
		rebate.setIncomeType(0);
		rebate.setOrderId(orderId);
		rebate.setRebateDate(new Date());
		rebate.setShopId(order.getShopId());
		rebate.setUserId(account.getUserProfile().getUserId());
		rebate.setRebateState(1);
		rebate.setIncome(u0Price);
		
		Object u1[] = recommendUser(1, order.getUserId());
		if (u1 != null) {
			UserProfile user1 = (UserProfile) u1[1];
			YRebateRelation relation1 = (YRebateRelation)u1[0];
			
			rebate = new OrdersRebate();
			rebate.setIncomeType(1);
			rebate.setOrderId(orderId);
			rebate.setRebateDate(new Date());
			rebate.setShopId(order.getShopId());
			rebate.setUserId(user1.getUserId());
			rebate.setRebateState(1);
			rebate.setRebateRelationId(relation1.getRebateRelationId());
			rebate.setIncome(u1Price);
			baseService.save(rebate);
			
			user1.setBalance(user1.getBalance() + u1Price);
			baseService.update(user1);
			Object u2[] = recommendUser(2, user1.getUserId());
			if (u2 != null) {
				UserProfile user2 = (UserProfile) u1[1];
				YRebateRelation relation2 = (YRebateRelation)u2[0];
				
				rebate = new OrdersRebate();
				rebate.setIncomeType(2);
				rebate.setOrderId(orderId);
				rebate.setRebateDate(new Date());
				rebate.setShopId(order.getShopId());
				rebate.setUserId(user2.getUserId());
				rebate.setRebateState(1);
				rebate.setRebateRelationId(relation2.getRebateRelationId());
				rebate.setIncome(u2Price);
				baseService.save(rebate);
				
				user2.setBalance(user2.getBalance() + u2Price);
				baseService.update(user2);
				Object u3[] = recommendUser(3, user2.getUserId());
				if (u3 != null) {
					UserProfile user3 = (UserProfile) u1[1];
					YRebateRelation relation3 = (YRebateRelation)u3[0];
					
					rebate = new OrdersRebate();
					rebate.setIncomeType(3);
					rebate.setOrderId(orderId);
					rebate.setRebateDate(new Date());
					rebate.setShopId(order.getShopId());
					rebate.setUserId(user3.getUserId());
					rebate.setRebateState(1);
					rebate.setRebateRelationId(relation3.getRebateRelationId());
					rebate.setIncome(u3Price);
					baseService.save(rebate);
					
					user3.setBalance(user3.getBalance() + u3Price);
					baseService.update(user3);
				}
			}
		}
		order.setConsumptionStatus(1);
		order.setOrderDate(new Date());
		baseService.update(order);
	}
}

package com.zgld.api.action;

import com.alipay.util.AlipayInfo;
import com.zgld.api.beans.BalanceDetails;
import com.zgld.api.beans.Orders;
import com.zgld.api.beans.UserProfile;
import com.zgld.api.service.BaseService;
import com.zgld.api.utils.Contents;
import com.zgld.api.utils.DateUtils;
import java.io.PrintStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AlipayTrade {
	static BaseService baseService;
	static {
		baseService = Contents.getBaseService();
	}
	
	public static String alipay_recharge(AlipayInfo info) {
		String result = "fail";
		try {
			if (info != null) {
				Orders order = (Orders) baseService.bean(" from Orders as o where o.orderId = " + info.getOut_trade_no());
				if ((order != null) && (order.getPaymentStatus().intValue() != 1)) {
					order.setPaymentStatus(Integer.valueOf(1));
					baseService.update(order);
					result = "success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String alipay_order(AlipayInfo info) {
		String result = "fail";
		try {
			if (info != null) {
				Orders order = (Orders) baseService.bean(" from Orders as o where o.orderId = " + info.getOut_trade_no());
				if ((order != null) && (!"1".equals(order.getPaymentStatus()))) {
					System.out.println("修改订单付款状态");
					order.setPaymentStatus(Integer.valueOf(1));
					order.setPayTypeId(Integer.valueOf(2));
					order.setPayTradeNo(info.getTrade_no());
					order.setPayDateTime(DateUtils.strDateTimeToDate(info.getGmt_payment()));
					order.setPayTotalFee(Double.valueOf(Double.parseDouble(info.getTotal_fee())));
					order.setBuyerId(info.getBuyer_id());
					order.setBuyerAccount(info.getBuyer_email());
					baseService.update(order);
					result = "success";
					System.out.println("修改订单状态成功");
				}
				if (order != null) {
					System.out.println("订单存在，订单状态：" + order.getPaymentStatus());
					System.out.println("订单存在，订单号：" + order.getOrderId());
					if (order.getPaymentStatus().equals("1"))
						result = "success";
				} else {
					System.out.println("订单不存在");
				}
			} else {
				System.out.println("参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("订单出现异常:" + e.getMessage());
		}
		return result;
	}

	public static String full_refund(AlipayInfo info) {
		String result = "fail";
		try {
			if (info != null) {
				Orders order = (Orders) baseService.bean(" from Orders as o where o.orderId = " + info.getOut_trade_no());
				if ((order != null) && (!"1".equals(order.getPaymentStatus()))
						&& (!"1".equals(order.getRefundStatus()))) {
					System.out.println("修改订单退款状态");
					order.setRefundStatus(Integer.valueOf(1));
					order.setRefundDateTime(DateUtils.strDateTimeToDate(info.getGmt_refund()));
					order.setRefundTotalFee(Double.valueOf(Double.parseDouble(info.getTotal_fee())));
					baseService.update(order);
					result = "success";
					System.out.println("修改订单退款状态成功");
				}

				if (order != null) {
					System.out.println("订单存在，订单支付状态：" + order.getPaymentStatus());
					System.out.println("订单，退款状态：" + order.getRefundStatus());
					System.out.println("订单存在，订单号：" + order.getOrderId());
					if ("1".equals(order.getRefundStatus()))
						result = "success";
				} else {
					System.out.println("订单不存在");
				}
			} else {
				System.out.println("参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("订单出现异常:" + e.getMessage());
		}
		return result;
	}
	public static String alipay_user_recharge(AlipayInfo info) {
		String result = "fail";
		try {
			if (info != null) {
				BalanceDetails balance = (BalanceDetails)baseService.bean(" from BalanceDetails as b where b.balanceId = "+info.getOut_trade_no().replace("ZXCZ", ""));
				if(balance!=null){
					if(balance.getPayTradeNo()!=null && balance.getPayTradeNo().length()>2){
						System.out.println("充值号已经付款，无需重复修改");
					}else{
						System.out.println("修改充值号付款状态");
						balance.setPayTotalFee(Double.parseDouble(info.getTotal_fee()));
						balance.setBuyerAccount(info.getBuyer_email());
						balance.setBuyerId(info.getBuyer_id());
						balance.setPayDateTime(DateUtils.strDateTimeToDate(info.getGmt_payment()));
						balance.setPayTradeNo(info.getTrade_no());
						baseService.update(balance);
						UserProfile up = (UserProfile)baseService.bean(" from UserProfile as up where up.userId = "+balance.getUserId());
						if(up!=null){
							up.setBalance(up.getBalance()+balance.getBalance());
							baseService.update(up);
						}
					}
					result = "success";
					System.out.println("修改充值号状态成功");
				}else{
					System.out.println("充值号不存在");
				}
				if (balance != null) {
//					System.out.println("订单存在，订单状态：" + balance.getPaymentStatus());
					System.out.println("订单存在，订单号：" + balance.getBalanceId());
						result = "success";
				} else {
					System.out.println("订单不存在");
				}
			} else {
				System.out.println("参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("订单出现异常:" + e.getMessage());
		}
		return result;
	}
	public static void main(String[] args) {
		AlipayInfo info = new AlipayInfo();
		info.setOut_trade_no("ZXCZ2");
		info.setGmt_payment("2016-04-29 14:29:46");
		info.setBuyer_email("longliuping@live.cn");
		info.setBuyer_id("2088902255191013");
		info.setTrade_no("2016042921001004010220091513");
		info.setTotal_fee("0.01");
		alipay_user_recharge(info);
	}
}
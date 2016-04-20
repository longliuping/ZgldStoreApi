package com.zgld.api.action;

import com.alipay.util.AlipayInfo;
import com.zgld.api.beans.Orders;
import com.zgld.api.biz.BaseBiz;
import com.zgld.api.utils.DateUtils;
import java.io.PrintStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AlipayTrade {
	static BaseBiz baseBiz;
	static {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		baseBiz = (BaseBiz) ac.getBean("baseBiz");
	}

	public static String alipay_recharge(AlipayInfo info) {
		String result = "fail";
		try {
			if (info != null) {
				Orders order = (Orders) baseBiz.bean(" from Orders as o where o.orderId = " + info.getOut_trade_no());
				if ((order != null) && (order.getPaymentStatus().intValue() != 1)) {
					order.setPaymentStatus(Integer.valueOf(1));
					baseBiz.update(order);
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
				Orders order = (Orders) baseBiz.bean(" from Orders as o where o.orderId = " + info.getOut_trade_no());
				if ((order != null) && (!"1".equals(order.getPaymentStatus()))) {
					System.out.println("修改订单付款状态");
					order.setPaymentStatus(Integer.valueOf(1));
					order.setPayTypeId(Integer.valueOf(2));
					order.setPayTradeNo(info.getTrade_no());
					order.setPayDateTime(DateUtils.strDateTimeToDate(info.getGmt_payment()));
					order.setPayTotalFee(Double.valueOf(Double.parseDouble(info.getTotal_fee())));
					order.setBuyerId(info.getBuyer_id());
					order.setBuyerAccount(info.getBuyer_email());
					baseBiz.update(order);
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
				Orders order = (Orders) baseBiz.bean(" from Orders as o where o.orderId = " + info.getOut_trade_no());
				if ((order != null) && (!"1".equals(order.getPaymentStatus()))
						&& (!"1".equals(order.getRefundStatus()))) {
					System.out.println("修改订单退款状态");
					order.setRefundStatus(Integer.valueOf(1));
					order.setRefundDateTime(DateUtils.strDateTimeToDate(info.getGmt_refund()));
					order.setRefundTotalFee(Double.valueOf(Double.parseDouble(info.getTotal_fee())));
					baseBiz.update(order);
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
}
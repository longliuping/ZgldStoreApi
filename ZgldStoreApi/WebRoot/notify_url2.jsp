
<%
	/* *
	 功能：支付宝服务器异步通知页面
	 版本：3.3
	 日期：2012-08-17
	 说明：
	 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

	 //***********页面功能说明***********
	 创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
	 该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
	 该页面调试工具请使用写文本函数logResult，该函数在com.alipay.util文件夹的AlipayNotify.java类文件中
	 如果没有收到该页面返回的 success 信息，支付宝会在24小时内按一定的时间策略重发通知
	 //********************************
	 * */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.alipay.util.*"%>
<%@ page import="com.alipay.config.*"%>
<%@ page import="com.zgld.api.action.AlipayTrade"%>

<%
	try {
		//获取支付宝POST过来反馈信息
		System.out.println("支付宝发送来的数据如下");
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
// 			System.out.println("name:" + name);
// 			System.out.println("valueStr:" + valueStr);
			params.put(name, valueStr);
		}
// 		if (params != null) {
// 			for (String key : params.keySet()) {
// 				System.out.println("key= " + key + " and value= " + params.get(key));
// 			}
// 		}
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号	
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("商户订单号out_trade_no:" + out_trade_no);
		//支付宝交易号	
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("支付宝交易号trade_no:" + trade_no);
		//交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("交易状态trade_status:" + trade_status);
		String refund_status = request.getParameter("refund_status");
		System.out.println("退款状态:" + refund_status);
		String gmt_payment = request.getParameter("gmt_payment");
		System.out.println("交易付款时间:"+gmt_payment);
		String buyer_id = request.getParameter("buyer_id");
		System.out.println("买家支付宝用户号:"+buyer_id);
		String buyer_email = request.getParameter("buyer_email");
		System.out.println("买家支付宝账号:"+buyer_email);
		String total_fee = request.getParameter("total_fee");
		System.out.println("交易金额:"+total_fee);
		String gmt_refund = request.getParameter("gmt_refund");
		System.out.println("退款时间:"+gmt_refund);
		String seller_id = request.getParameter("seller_id");
		System.out.println("卖家支付宝用户号:"+seller_id);
		String seller_email = request.getParameter("seller_email");
		System.out.println("卖家支付宝账号:"+seller_email);
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

		if (AlipayNotify.verify(params)) {//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码
			System.out.println("验证成功");
			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			String result = "fail";
			AlipayInfo info = new AlipayInfo();
			info.setTrade_status(trade_status);
			info.setOut_trade_no(out_trade_no);
			info.setTrade_no(trade_no);
			if(gmt_payment!=null){
				info.setGmt_payment(gmt_payment);
			}
			if(buyer_id!=null){
				info.setBuyer_id(buyer_id);
			}
			if(buyer_email!=null){
				info.setBuyer_email(buyer_email);
			}
			if(total_fee!=null){
				info.setTotal_fee(total_fee);
			}
			if(gmt_refund!=null){
				info.setGmt_refund(gmt_refund);
			}
			if ("REFUND_SUCCESS".equals(refund_status) && "TRADE_CLOSED".equals(trade_status)) {
				System.out.println("全额退款");
				result = AlipayTrade.full_refund(info);
			} else if ("REFUND_SUCCESS".equals(refund_status) && "TRADE_SUCCESS".equals(trade_status)) {
				System.out.println("非全额退款");
				result = AlipayTrade.full_refund(info);
			} else if ("TRADE_FINISHED".equals(trade_status)) {
				System.out.println("交易成功");
				result = "success";
			} else if ("TRADE_SUCCESS".equals(trade_status)) {
				System.out.println("支付成功");
				result = AlipayTrade.alipay_order(info);
			} else if ("WAIT_BUYER_PAY".equals(trade_status)) {
				System.out.println("交易创建");
				result = "success";
			} else if ("TRADE_CLOSED".equals(trade_status)) {
				System.out.println("退款关闭");
				result = "success";
			} else {
				System.out.println("订单未知");
			}
			out.println(result);
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			//out.println("success");	//请不要修改或删除

			//////////////////////////////////////////////////////////////////////////////////////////
		} else {//验证失败
			System.out.println("验证失败");
			out.println("fail");
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("异常:"+e.getMessage());
	}
%>

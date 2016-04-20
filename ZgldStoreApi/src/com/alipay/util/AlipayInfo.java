package com.alipay.util;

import java.io.Serializable;

public class AlipayInfo implements Serializable {
	String out_trade_no;
	String trade_no;
	String trade_status;
	String total_fee;
	String seller_id;
	String gmt_payment;
	String gmt_create;
	String buyer_id;
	String buyer_email;
	String gmt_refund;

	public String getOut_trade_no() {
		return this.out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTrade_no() {
		return this.trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getTrade_status() {
		return this.trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public String getTotal_fee() {
		return this.total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSeller_id() {
		return this.seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getGmt_payment() {
		return this.gmt_payment;
	}

	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	public String getGmt_create() {
		return this.gmt_create;
	}

	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}

	public String getBuyer_id() {
		return this.buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getBuyer_email() {
		return this.buyer_email;
	}

	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	public String getGmt_refund() {
		return this.gmt_refund;
	}

	public void setGmt_refund(String gmt_refund) {
		this.gmt_refund = gmt_refund;
	}
}
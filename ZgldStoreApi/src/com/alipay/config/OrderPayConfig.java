package com.alipay.config;

import java.io.Serializable;

public class OrderPayConfig implements Serializable {
	Integer orderId;
	String subject;
	String body;
	Double expenses;
	Double total_fee;
	String partner;
	String seller_id;
	String rsa_private;
	String rsa_public;
	String notify_url;

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Double getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public Double getTotal_fee() {
		return this.total_fee;
	}

	public void setTotal_fee(Double total_fee) {
		this.total_fee = total_fee;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getSeller_id() {
		return this.seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getRsa_private() {
		return this.rsa_private;
	}

	public void setRsa_private(String rsa_private) {
		this.rsa_private = rsa_private;
	}

	public String getRsa_public() {
		return this.rsa_public;
	}

	public void setRsa_public(String rsa_public) {
		this.rsa_public = rsa_public;
	}

	public String getNotify_url() {
		return this.notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
}
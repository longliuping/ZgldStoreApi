package com.zgld.api.beans;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractOrders implements Serializable {
	private Integer orderId;
	private Integer shopId;
	private Integer userId;
	private Double freight;
	private Integer shippingId;
	private String shipOrderNumber;
	private Integer shippingStatus;
	private Integer refundStatus;
	private Integer paymentStatus;
	private Double orderTotalPrice;
	private Integer orderPoint;
	private Double otherCost;
	private Double orderRealPrice;
	private String remark;
	private Date orderDate;
	private String mobile;
	private String shipTo;
	private String address;
	private String zipcode;
	private Integer payTypeId;
	private String payTradeNo;
	private Date payDateTime;
	private Double payTotalFee;
	private String buyerId;
	private String buyerAccount;
	private Date refundDateTime;
	private Double refundTotalFee;

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getFreight() {
		return this.freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Integer getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public String getShipOrderNumber() {
		return this.shipOrderNumber;
	}

	public void setShipOrderNumber(String shipOrderNumber) {
		this.shipOrderNumber = shipOrderNumber;
	}

	public Integer getShippingStatus() {
		return this.shippingStatus;
	}

	public void setShippingStatus(Integer shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public Integer getRefundStatus() {
		return this.refundStatus;
	}

	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public Integer getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Double getOrderTotalPrice() {
		return this.orderTotalPrice;
	}

	public void setOrderTotalPrice(Double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Integer getOrderPoint() {
		return this.orderPoint;
	}

	public void setOrderPoint(Integer orderPoint) {
		this.orderPoint = orderPoint;
	}

	public Double getOtherCost() {
		return this.otherCost;
	}

	public void setOtherCost(Double otherCost) {
		this.otherCost = otherCost;
	}

	public Double getOrderRealPrice() {
		return this.orderRealPrice;
	}

	public void setOrderRealPrice(Double orderRealPrice) {
		this.orderRealPrice = orderRealPrice;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getShipTo() {
		return this.shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getPayTypeId() {
		return this.payTypeId;
	}

	public void setPayTypeId(Integer payTypeId) {
		this.payTypeId = payTypeId;
	}

	public String getPayTradeNo() {
		return this.payTradeNo;
	}

	public void setPayTradeNo(String payTradeNo) {
		this.payTradeNo = payTradeNo;
	}

	public Date getPayDateTime() {
		return this.payDateTime;
	}

	public void setPayDateTime(Date payDateTime) {
		this.payDateTime = payDateTime;
	}

	public Double getPayTotalFee() {
		return this.payTotalFee;
	}

	public void setPayTotalFee(Double payTotalFee) {
		this.payTotalFee = payTotalFee;
	}

	public String getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerAccount() {
		return this.buyerAccount;
	}

	public void setBuyerAccount(String buyerAccount) {
		this.buyerAccount = buyerAccount;
	}

	public Date getRefundDateTime() {
		return this.refundDateTime;
	}

	public void setRefundDateTime(Date refundDateTime) {
		this.refundDateTime = refundDateTime;
	}

	public Double getRefundTotalFee() {
		return this.refundTotalFee;
	}

	public void setRefundTotalFee(Double refundTotalFee) {
		this.refundTotalFee = refundTotalFee;
	}
}
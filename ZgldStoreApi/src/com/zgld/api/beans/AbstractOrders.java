package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractOrders entity provides the base persistence definition of the Orders
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOrders implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public AbstractOrders() {
	}

	/** full constructor */
	public AbstractOrders(Integer shopId, Integer userId, Double freight, Integer shippingId, String shipOrderNumber, Integer shippingStatus, Integer refundStatus, Integer paymentStatus, Double orderTotalPrice, Integer orderPoint, Double otherCost, Double orderRealPrice, String remark, Date orderDate) {
		this.shopId = shopId;
		this.userId = userId;
		this.freight = freight;
		this.shippingId = shippingId;
		this.shipOrderNumber = shipOrderNumber;
		this.shippingStatus = shippingStatus;
		this.refundStatus = refundStatus;
		this.paymentStatus = paymentStatus;
		this.orderTotalPrice = orderTotalPrice;
		this.orderPoint = orderPoint;
		this.otherCost = otherCost;
		this.orderRealPrice = orderRealPrice;
		this.remark = remark;
		this.orderDate = orderDate;
	}

	// Property accessors

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

}
package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.List;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
public class Orders extends AbstractOrders implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(Integer shopId, Integer userId, Double freight, Integer shippingId, String shipOrderNumber, Integer shippingStatus, Integer refundStatus, Integer paymentStatus, Double orderTotalPrice, Integer orderPoint, Double otherCost, Double orderRealPrice, String remark, Timestamp orderDate) {
		super(shopId, userId, freight, shippingId, shipOrderNumber, shippingStatus, refundStatus, paymentStatus, orderTotalPrice, orderPoint, otherCost, orderRealPrice, remark, orderDate);
	}
	List<OrderItems> listOrderItems;
	public List<OrderItems> getListOrderItems() {
		return listOrderItems;
	}

	public void setListOrderItems(List<OrderItems> listOrderItems) {
		this.listOrderItems = listOrderItems;
	}
	
}

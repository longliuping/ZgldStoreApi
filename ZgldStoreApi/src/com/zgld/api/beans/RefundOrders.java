package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * RefundOrders entity. @author MyEclipse Persistence Tools
 */
public class RefundOrders extends AbstractRefundOrders implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public RefundOrders() {
	}

	/** full constructor */
	public RefundOrders(Integer orderId, Integer isOrderRefund, Double totalBalance, String remark, String cellPhone, Timestamp addedDate) {
		super(orderId, isOrderRefund, totalBalance, remark, cellPhone, addedDate);
	}

}

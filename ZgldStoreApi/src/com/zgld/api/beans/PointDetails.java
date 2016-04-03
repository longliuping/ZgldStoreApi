package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * PointDetails entity. @author MyEclipse Persistence Tools
 */
public class PointDetails extends AbstractPointDetails implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PointDetails() {
	}

	/** full constructor */
	public PointDetails(Integer orderId, Integer userId, Timestamp tradeDate, Integer increased, Integer reduced, Integer points, String remark) {
		super(orderId, userId, tradeDate, increased, reduced, points, remark);
	}

}

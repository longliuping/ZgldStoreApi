package com.zgld.api.beans;

import java.sql.Date;

/**
 * BalanceFreezeDetails entity. @author MyEclipse Persistence Tools
 */
public class BalanceFreezeDetails extends AbstractBalanceFreezeDetails implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public BalanceFreezeDetails() {
	}

	/** full constructor */
	public BalanceFreezeDetails(Date freezeTime, Double amount, Integer userId, String remark) {
		super(freezeTime, amount, userId, remark);
	}

}

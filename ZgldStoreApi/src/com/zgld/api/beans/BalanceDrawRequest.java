package com.zgld.api.beans;

import java.sql.Date;

/**
 * BalanceDrawRequest entity. @author MyEclipse Persistence Tools
 */
public class BalanceDrawRequest extends AbstractBalanceDrawRequest implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public BalanceDrawRequest() {
	}

	/** full constructor */
	public BalanceDrawRequest(Date requestTime, Double amount, Integer userId, Integer requestStatus, String remark) {
		super(requestTime, amount, userId, requestStatus, remark);
	}

}

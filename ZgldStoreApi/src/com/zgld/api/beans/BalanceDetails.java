package com.zgld.api.beans;

import java.sql.Date;

/**
 * BalanceDetails entity. @author MyEclipse Persistence Tools
 */
public class BalanceDetails extends AbstractBalanceDetails implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public BalanceDetails() {
	}

	/** full constructor */
	public BalanceDetails(Integer userId, Date tradeDate, Date income, Double expenses, Double reduced, Double balance, Integer payer, Integer payee, String remark) {
		super(userId, tradeDate, income, expenses, reduced, balance, payer, payee, remark);
	}

}

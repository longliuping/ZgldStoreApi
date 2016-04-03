package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * InpourRequest entity. @author MyEclipse Persistence Tools
 */
public class InpourRequest extends AbstractInpourRequest implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public InpourRequest() {
	}

	/** full constructor */
	public InpourRequest(Integer userId, Timestamp tradeDate, Double inpourBlance, String paymentGateway) {
		super(userId, tradeDate, inpourBlance, paymentGateway);
	}

}

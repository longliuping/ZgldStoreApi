package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * PromoteSales entity. @author MyEclipse Persistence Tools
 */
public class PromoteSales extends AbstractPromoteSales implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PromoteSales() {
	}

	/** full constructor */
	public PromoteSales(Integer shopId, String name, Integer promoteType, String description, Timestamp startTime, Timestamp closingTime) {
		super(shopId, name, promoteType, description, startTime, closingTime);
	}

}

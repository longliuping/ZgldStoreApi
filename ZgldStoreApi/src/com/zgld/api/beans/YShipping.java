package com.zgld.api.beans;

import java.sql.Date;

/**
 * YShipping entity. @author MyEclipse Persistence Tools
 */
public class YShipping extends AbstractYShipping implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YShipping() {
	}

	/** minimal constructor */
	public YShipping(Date shipTime) {
		super(shipTime);
	}

	/** full constructor */
	public YShipping(Integer unitSetId, Integer accountActId, String shipName, String shipGoodsPlace, Integer shipSendInTime, Date shipTime) {
		super(unitSetId, accountActId, shipName, shipGoodsPlace, shipSendInTime, shipTime);
	}

}

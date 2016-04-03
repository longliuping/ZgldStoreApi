package com.zgld.api.beans;

import java.sql.Date;

/**
 * YUnitMatchAccount entity. @author MyEclipse Persistence Tools
 */
public class YUnitMatchAccount extends AbstractYUnitMatchAccount implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YUnitMatchAccount() {
	}

	/** minimal constructor */
	public YUnitMatchAccount(Date unitMatchTime) {
		super(unitMatchTime);
	}

	/** full constructor */
	public YUnitMatchAccount(Integer unitSetId, Integer accountId, Integer unitMatchState, Integer isDelete, Date unitMatchTime) {
		super(unitSetId, accountId, unitMatchState, isDelete, unitMatchTime);
	}

}

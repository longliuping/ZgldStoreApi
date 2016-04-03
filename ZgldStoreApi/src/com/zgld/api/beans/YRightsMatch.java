package com.zgld.api.beans;

import java.sql.Date;

/**
 * YRightsMatch entity. @author MyEclipse Persistence Tools
 */
public class YRightsMatch extends AbstractYRightsMatch implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YRightsMatch() {
	}

	/** minimal constructor */
	public YRightsMatch(Date rightsMatchTime) {
		super(rightsMatchTime);
	}

	/** full constructor */
	public YRightsMatch(Integer riSetId, Integer accountId, Integer accountActId, Integer isDelete, Date rightsMatchTime) {
		super(riSetId, accountId, accountActId, isDelete, rightsMatchTime);
	}

}

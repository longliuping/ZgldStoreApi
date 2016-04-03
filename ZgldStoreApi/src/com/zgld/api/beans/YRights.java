package com.zgld.api.beans;

import java.sql.Date;

/**
 * YRights entity. @author MyEclipse Persistence Tools
 */
public class YRights extends AbstractYRights implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YRights() {
	}

	/** minimal constructor */
	public YRights(Date riTime) {
		super(riTime);
	}

	/** full constructor */
	public YRights(Integer riSetId, String tableEnName, String riName, Integer accountActId, String riDes, Integer isDelete, Date riTime) {
		super(riSetId, tableEnName, riName, accountActId, riDes, isDelete, riTime);
	}

}

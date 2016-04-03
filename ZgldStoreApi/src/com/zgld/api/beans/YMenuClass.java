package com.zgld.api.beans;

import java.sql.Date;

/**
 * YMenuClass entity. @author MyEclipse Persistence Tools
 */
public class YMenuClass extends AbstractYMenuClass implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YMenuClass() {
	}

	/** minimal constructor */
	public YMenuClass(Date meClassTime) {
		super(meClassTime);
	}

	/** full constructor */
	public YMenuClass(Integer meParentClassId, Integer meClassSetId, Integer accountActId, String meClassName, Integer isDelete, Date meClassTime) {
		super(meParentClassId, meClassSetId, accountActId, meClassName, isDelete, meClassTime);
	}

}

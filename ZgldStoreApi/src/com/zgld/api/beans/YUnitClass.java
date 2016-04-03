package com.zgld.api.beans;

import java.sql.Date;

/**
 * YUnitClass entity. @author MyEclipse Persistence Tools
 */
public class YUnitClass extends AbstractYUnitClass implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YUnitClass() {
	}

	/** minimal constructor */
	public YUnitClass(Date unitClassTime) {
		super(unitClassTime);
	}

	/** full constructor */
	public YUnitClass(Integer unitClassSetId, Integer unitParentClassId, Integer accountActId, String unitClassName, Integer unitClassTotal, Integer unitClassOrder, Integer unitClassTopOrder, Integer isDelete, Date unitClassTime) {
		super(unitClassSetId, unitParentClassId, accountActId, unitClassName, unitClassTotal, unitClassOrder, unitClassTopOrder, isDelete, unitClassTime);
	}

}

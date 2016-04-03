package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YArea entity. @author MyEclipse Persistence Tools
 */
public class YArea extends AbstractYArea implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YArea() {
	}

	/** minimal constructor */
	public YArea(Timestamp areaTime) {
		super(areaTime);
	}

	/** full constructor */
	public YArea(Integer areaParentId, String areaName, String areaCode, Integer areaLevel, Integer areaOrder, String areaX, String areaY, Integer accountActId, Integer isDelete, Timestamp areaTime) {
		super(areaParentId, areaName, areaCode, areaLevel, areaOrder, areaX, areaY, accountActId, isDelete, areaTime);
	}

}

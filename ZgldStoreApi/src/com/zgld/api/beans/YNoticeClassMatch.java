package com.zgld.api.beans;

import java.sql.Date;

/**
 * YNoticeClassMatch entity. @author MyEclipse Persistence Tools
 */
public class YNoticeClassMatch extends AbstractYNoticeClassMatch implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YNoticeClassMatch() {
	}

	/** minimal constructor */
	public YNoticeClassMatch(Date noClassMatchTime) {
		super(noClassMatchTime);
	}

	/** full constructor */
	public YNoticeClassMatch(Integer noClassSetId, Integer unitSetId, Date noClassMatchTime) {
		super(noClassSetId, unitSetId, noClassMatchTime);
	}

}

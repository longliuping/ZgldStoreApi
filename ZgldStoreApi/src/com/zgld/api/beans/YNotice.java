package com.zgld.api.beans;

import java.sql.Date;

/**
 * YNotice entity. @author MyEclipse Persistence Tools
 */
public class YNotice extends AbstractYNotice implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YNotice() {
	}

	/** minimal constructor */
	public YNotice(Date noTime) {
		super(noTime);
	}

	/** full constructor */
	public YNotice(Integer noClassSetId, Integer noType, Integer noState, Integer unitSetId, Integer accountActId,
			String noTitle, String noContent, Integer noOrder, Integer noTopOrder, Integer isDelete, Date noTime) {
		super(noClassSetId, noType, noState, unitSetId, accountActId, noTitle, noContent, noOrder, noTopOrder, isDelete,
				noTime);
	}

}

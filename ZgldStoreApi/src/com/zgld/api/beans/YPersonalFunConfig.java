package com.zgld.api.beans;

import java.sql.Date;

/**
 * YPersonalFunConfig entity. @author MyEclipse Persistence Tools
 */
public class YPersonalFunConfig extends AbstractYPersonalFunConfig implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YPersonalFunConfig() {
	}

	/** minimal constructor */
	public YPersonalFunConfig(Date personalTime) {
		super(personalTime);
	}

	/** full constructor */
	public YPersonalFunConfig(Integer unitSetId, Integer accountId, Integer personalIsMessage, Integer personalIsNotice,
			Integer personalIsComment, Integer personalIsEmail, Integer isDelete, Date personalTime) {
		super(unitSetId, accountId, personalIsMessage, personalIsNotice, personalIsComment, personalIsEmail, isDelete,
				personalTime);
	}

}

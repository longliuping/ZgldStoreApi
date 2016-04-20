package com.zgld.api.beans;

import java.sql.Date;

/**
 * YReceiveAddress entity. @author MyEclipse Persistence Tools
 */
public class YReceiveAddress extends AbstractYReceiveAddress implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YReceiveAddress() {
	}

	/** minimal constructor */
	public YReceiveAddress(Date addressTime) {
		super(addressTime);
	}

	/** full constructor */
	public YReceiveAddress(Integer accountActId, Integer areaId, String addressDetail, String userName,
			String userMobile, Integer isDefault, Date addressTime) {
		super(accountActId, areaId, addressDetail, userName, userMobile, isDefault, addressTime);
	}

}

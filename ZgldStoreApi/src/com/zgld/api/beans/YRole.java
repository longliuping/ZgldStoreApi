package com.zgld.api.beans;

import java.sql.Date;

/**
 * YRole entity. @author MyEclipse Persistence Tools
 */
public class YRole extends AbstractYRole implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YRole() {
	}

	/** minimal constructor */
	public YRole(Date roleTime) {
		super(roleTime);
	}

	/** full constructor */
	public YRole(Integer roleSetId, String roleName, Integer accountActId, Integer isDelete, Date roleTime) {
		super(roleSetId, roleName, accountActId, isDelete, roleTime);
	}

}

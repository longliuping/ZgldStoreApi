package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YAdminGroup entity. @author MyEclipse Persistence Tools
 */
public class YAdminGroup extends AbstractYAdminGroup implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YAdminGroup() {
	}

	/** minimal constructor */
	public YAdminGroup(Timestamp adminGroupTime) {
		super(adminGroupTime);
	}

	/** full constructor */
	public YAdminGroup(Integer adminParentGroupId, Integer adminGroupSetId, String adminGroupName, Integer accountActId, Integer isDelete, Timestamp adminGroupTime) {
		super(adminParentGroupId, adminGroupSetId, adminGroupName, accountActId, isDelete, adminGroupTime);
	}

}

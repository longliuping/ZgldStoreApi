package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
public class Users extends AbstractUsers implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(Integer userAccountStatus, String appUserToken, String userBankCard, Timestamp lastActivity, Integer deleted, Integer userType) {
		super(userAccountStatus, appUserToken, userBankCard, lastActivity, deleted, userType);
	}

}

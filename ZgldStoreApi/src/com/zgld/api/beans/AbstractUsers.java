package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractUsers entity provides the base persistence definition of the Users
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUsers implements java.io.Serializable {

	// Fields
	private Integer accountId;
	private Integer userId;
	private Integer userAccountStatus;
	private String appUserToken;
	private String userBankCard;
	private Date lastActivity;
	private Integer deleted;
	private Integer userType;

	// Constructors

	/** default constructor */
	public AbstractUsers() {
	}


	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserAccountStatus() {
		return this.userAccountStatus;
	}

	public void setUserAccountStatus(Integer userAccountStatus) {
		this.userAccountStatus = userAccountStatus;
	}

	public String getAppUserToken() {
		return this.appUserToken;
	}

	public void setAppUserToken(String appUserToken) {
		this.appUserToken = appUserToken;
	}

	public String getUserBankCard() {
		return this.userBankCard;
	}

	public void setUserBankCard(String userBankCard) {
		this.userBankCard = userBankCard;
	}

	public Date getLastActivity() {
		return this.lastActivity;
	}

	public void setLastActivity(Date lastActivity) {
		this.lastActivity = lastActivity;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}


	public Integer getAccountId() {
		return accountId;
	}


	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}
package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractUserProfile entity provides the base persistence definition of the
 * UserProfile entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserProfile implements java.io.Serializable {

	// Fields

	private Integer userProfileId;
	private Integer userId;
	private Integer enablePrivateMessages;
	private Integer enableOnlineStatus;
	private Integer enableEmail;
	private Integer enableHtmlEmail;
	private String publicToken;
	private Double expenditure;
	private Integer enableTradePassword;
	private String tradePassword;
	private String realName;
	private Integer points;
	private Integer regionId;
	private String address;
	private String qq;
	private String msn;
	private String telPhone;
	private String cellPhone;
	private Integer userRank;
	private Date birthDate;
	private Integer gender;
	private Double balance;
	private Double deductMoney;
	private String alipayAccount;

	// Constructors

	/** default constructor */
	public AbstractUserProfile() {
	}


	// Property accessors

	public Integer getUserProfileId() {
		return this.userProfileId;
	}

	public void setUserProfileId(Integer userProfileId) {
		this.userProfileId = userProfileId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEnablePrivateMessages() {
		return this.enablePrivateMessages;
	}

	public void setEnablePrivateMessages(Integer enablePrivateMessages) {
		this.enablePrivateMessages = enablePrivateMessages;
	}

	public Integer getEnableOnlineStatus() {
		return this.enableOnlineStatus;
	}

	public void setEnableOnlineStatus(Integer enableOnlineStatus) {
		this.enableOnlineStatus = enableOnlineStatus;
	}

	public Integer getEnableEmail() {
		return this.enableEmail;
	}

	public void setEnableEmail(Integer enableEmail) {
		this.enableEmail = enableEmail;
	}

	public Integer getEnableHtmlEmail() {
		return this.enableHtmlEmail;
	}

	public void setEnableHtmlEmail(Integer enableHtmlEmail) {
		this.enableHtmlEmail = enableHtmlEmail;
	}

	public String getPublicToken() {
		return this.publicToken;
	}

	public void setPublicToken(String publicToken) {
		this.publicToken = publicToken;
	}

	public Double getExpenditure() {
		return this.expenditure;
	}

	public void setExpenditure(Double expenditure) {
		this.expenditure = expenditure;
	}

	public Integer getEnableTradePassword() {
		return this.enableTradePassword;
	}

	public void setEnableTradePassword(Integer enableTradePassword) {
		this.enableTradePassword = enableTradePassword;
	}

	public String getTradePassword() {
		return this.tradePassword;
	}

	public void setTradePassword(String tradePassword) {
		this.tradePassword = tradePassword;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getTelPhone() {
		return this.telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Integer getUserRank() {
		return this.userRank;
	}

	public void setUserRank(Integer userRank) {
		this.userRank = userRank;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getDeductMoney() {
		return this.deductMoney;
	}

	public void setDeductMoney(Double deductMoney) {
		this.deductMoney = deductMoney;
	}


	public String getAlipayAccount() {
		return alipayAccount;
	}


	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}

}
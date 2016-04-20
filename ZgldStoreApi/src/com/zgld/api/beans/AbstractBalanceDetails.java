package com.zgld.api.beans;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractBalanceDetails implements Serializable {
	private Integer balanceId;
	private Integer userId;
	private Date tradeDate;
	private Double income;
	private Double expenses;
	private Double reduced;
	private Double balance;
	private Integer payer;
	private Integer payee;
	private String remark;
	private Integer payTypeId;
	private String payTradeNo;
	private Date payDateTime;
	private Double payTotalFee;
	private String buyerId;
	private String buyerAccount;

	public Integer getBalanceId() {
		return this.balanceId;
	}

	public void setBalanceId(Integer balanceId) {
		this.balanceId = balanceId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTradeDate() {
		return this.tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Double getIncome() {
		return this.income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public Double getReduced() {
		return this.reduced;
	}

	public void setReduced(Double reduced) {
		this.reduced = reduced;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getPayer() {
		return this.payer;
	}

	public void setPayer(Integer payer) {
		this.payer = payer;
	}

	public Integer getPayee() {
		return this.payee;
	}

	public void setPayee(Integer payee) {
		this.payee = payee;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getPayTypeId() {
		return this.payTypeId;
	}

	public void setPayTypeId(Integer payTypeId) {
		this.payTypeId = payTypeId;
	}

	public String getPayTradeNo() {
		return this.payTradeNo;
	}

	public void setPayTradeNo(String payTradeNo) {
		this.payTradeNo = payTradeNo;
	}

	public Date getPayDateTime() {
		return this.payDateTime;
	}

	public void setPayDateTime(Date payDateTime) {
		this.payDateTime = payDateTime;
	}

	public Double getPayTotalFee() {
		return this.payTotalFee;
	}

	public void setPayTotalFee(Double payTotalFee) {
		this.payTotalFee = payTotalFee;
	}

	public String getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerAccount() {
		return this.buyerAccount;
	}

	public void setBuyerAccount(String buyerAccount) {
		this.buyerAccount = buyerAccount;
	}
}
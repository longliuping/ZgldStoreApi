package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractYLog entity provides the base persistence definition of the YLog
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYLog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Integer accountActId;
	private String logNote;
	private String logIp;
	private Integer isDelete;
	private Date logTime;

	// Constructors

	/** default constructor */
	public AbstractYLog() {
	}

	/** minimal constructor */
	public AbstractYLog(Date logTime) {
		this.logTime = logTime;
	}

	/** full constructor */
	public AbstractYLog(Integer accountActId, String logNote, String logIp, Integer isDelete, Date logTime) {
		this.accountActId = accountActId;
		this.logNote = logNote;
		this.logIp = logIp;
		this.isDelete = isDelete;
		this.logTime = logTime;
	}

	// Property accessors

	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getAccountActId() {
		return this.accountActId;
	}

	public void setAccountActId(Integer accountActId) {
		this.accountActId = accountActId;
	}

	public String getLogNote() {
		return this.logNote;
	}

	public void setLogNote(String logNote) {
		this.logNote = logNote;
	}

	public String getLogIp() {
		return this.logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getLogTime() {
		return this.logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

}
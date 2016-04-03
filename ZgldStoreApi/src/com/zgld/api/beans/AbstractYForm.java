package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractYForm entity provides the base persistence definition of the YForm
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYForm implements java.io.Serializable {

	// Fields

	private Integer formId;
	private Integer classSetId;
	private String tableName;
	private String formName;
	private Integer accountActId;
	private Integer isDelete;
	private Date formTime;

	// Constructors

	/** default constructor */
	public AbstractYForm() {
	}

	/** minimal constructor */
	public AbstractYForm(Date formTime) {
		this.formTime = formTime;
	}

	/** full constructor */
	public AbstractYForm(Integer classSetId, String tableName, String formName, Integer accountActId, Integer isDelete, Date formTime) {
		this.classSetId = classSetId;
		this.tableName = tableName;
		this.formName = formName;
		this.accountActId = accountActId;
		this.isDelete = isDelete;
		this.formTime = formTime;
	}

	// Property accessors

	public Integer getFormId() {
		return this.formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public Integer getClassSetId() {
		return this.classSetId;
	}

	public void setClassSetId(Integer classSetId) {
		this.classSetId = classSetId;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFormName() {
		return this.formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public Integer getAccountActId() {
		return this.accountActId;
	}

	public void setAccountActId(Integer accountActId) {
		this.accountActId = accountActId;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getFormTime() {
		return this.formTime;
	}

	public void setFormTime(Date formTime) {
		this.formTime = formTime;
	}

}
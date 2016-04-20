package com.zgld.api.beans;

import java.sql.Date;

/**
 * AbstractYRights entity provides the base persistence definition of the
 * YRights entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYRights implements java.io.Serializable {

	// Fields

	private Integer riId;
	private Integer riSetId;
	private String tableEnName;
	private String riName;
	private Integer accountActId;
	private String riDes;
	private Integer isDelete;
	private Date riTime;

	// Constructors

	/** default constructor */
	public AbstractYRights() {
	}

	/** minimal constructor */
	public AbstractYRights(Date riTime) {
		this.riTime = riTime;
	}

	/** full constructor */
	public AbstractYRights(Integer riSetId, String tableEnName, String riName, Integer accountActId, String riDes,
			Integer isDelete, Date riTime) {
		this.riSetId = riSetId;
		this.tableEnName = tableEnName;
		this.riName = riName;
		this.accountActId = accountActId;
		this.riDes = riDes;
		this.isDelete = isDelete;
		this.riTime = riTime;
	}

	// Property accessors

	public Integer getRiId() {
		return this.riId;
	}

	public void setRiId(Integer riId) {
		this.riId = riId;
	}

	public Integer getRiSetId() {
		return this.riSetId;
	}

	public void setRiSetId(Integer riSetId) {
		this.riSetId = riSetId;
	}

	public String getTableEnName() {
		return this.tableEnName;
	}

	public void setTableEnName(String tableEnName) {
		this.tableEnName = tableEnName;
	}

	public String getRiName() {
		return this.riName;
	}

	public void setRiName(String riName) {
		this.riName = riName;
	}

	public Integer getAccountActId() {
		return this.accountActId;
	}

	public void setAccountActId(Integer accountActId) {
		this.accountActId = accountActId;
	}

	public String getRiDes() {
		return this.riDes;
	}

	public void setRiDes(String riDes) {
		this.riDes = riDes;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getRiTime() {
		return this.riTime;
	}

	public void setRiTime(Date riTime) {
		this.riTime = riTime;
	}

}
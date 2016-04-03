package com.zgld.api.beans;

import java.sql.Date;

/**
 * AbstractYNoticeClassMatch entity provides the base persistence definition of
 * the YNoticeClassMatch entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYNoticeClassMatch implements java.io.Serializable {

	// Fields

	private Integer noClassMatchId;
	private Integer noClassSetId;
	private Integer unitSetId;
	private Date noClassMatchTime;

	// Constructors

	/** default constructor */
	public AbstractYNoticeClassMatch() {
	}

	/** minimal constructor */
	public AbstractYNoticeClassMatch(Date noClassMatchTime) {
		this.noClassMatchTime = noClassMatchTime;
	}

	/** full constructor */
	public AbstractYNoticeClassMatch(Integer noClassSetId, Integer unitSetId, Date noClassMatchTime) {
		this.noClassSetId = noClassSetId;
		this.unitSetId = unitSetId;
		this.noClassMatchTime = noClassMatchTime;
	}

	// Property accessors

	public Integer getNoClassMatchId() {
		return this.noClassMatchId;
	}

	public void setNoClassMatchId(Integer noClassMatchId) {
		this.noClassMatchId = noClassMatchId;
	}

	public Integer getNoClassSetId() {
		return this.noClassSetId;
	}

	public void setNoClassSetId(Integer noClassSetId) {
		this.noClassSetId = noClassSetId;
	}

	public Integer getUnitSetId() {
		return this.unitSetId;
	}

	public void setUnitSetId(Integer unitSetId) {
		this.unitSetId = unitSetId;
	}

	public Date getNoClassMatchTime() {
		return this.noClassMatchTime;
	}

	public void setNoClassMatchTime(Date noClassMatchTime) {
		this.noClassMatchTime = noClassMatchTime;
	}

}
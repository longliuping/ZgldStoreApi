package com.zgld.api.beans;

import java.sql.Date;

/**
 * AbstractYWorkerClassMatch entity provides the base persistence definition of
 * the YWorkerClassMatch entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYWorkerClassMatch implements java.io.Serializable {

	// Fields

	private Integer workerClassMatchId;
	private Integer workerClassSetId;
	private Integer unitSetId;
	private Date workerClassMatchTime;

	// Constructors

	/** default constructor */
	public AbstractYWorkerClassMatch() {
	}

	/** minimal constructor */
	public AbstractYWorkerClassMatch(Date workerClassMatchTime) {
		this.workerClassMatchTime = workerClassMatchTime;
	}

	/** full constructor */
	public AbstractYWorkerClassMatch(Integer workerClassSetId, Integer unitSetId, Date workerClassMatchTime) {
		this.workerClassSetId = workerClassSetId;
		this.unitSetId = unitSetId;
		this.workerClassMatchTime = workerClassMatchTime;
	}

	// Property accessors

	public Integer getWorkerClassMatchId() {
		return this.workerClassMatchId;
	}

	public void setWorkerClassMatchId(Integer workerClassMatchId) {
		this.workerClassMatchId = workerClassMatchId;
	}

	public Integer getWorkerClassSetId() {
		return this.workerClassSetId;
	}

	public void setWorkerClassSetId(Integer workerClassSetId) {
		this.workerClassSetId = workerClassSetId;
	}

	public Integer getUnitSetId() {
		return this.unitSetId;
	}

	public void setUnitSetId(Integer unitSetId) {
		this.unitSetId = unitSetId;
	}

	public Date getWorkerClassMatchTime() {
		return this.workerClassMatchTime;
	}

	public void setWorkerClassMatchTime(Date workerClassMatchTime) {
		this.workerClassMatchTime = workerClassMatchTime;
	}

}
package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractYLinksClassMatch entity provides the base persistence definition of
 * the YLinksClassMatch entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYLinksClassMatch implements java.io.Serializable {

	// Fields

	private Integer liClassMatchId;
	private Integer liClassSetId;
	private Integer unitSetId;
	private Date liClassMatchTime;

	// Constructors

	/** default constructor */
	public AbstractYLinksClassMatch() {
	}

	/** minimal constructor */
	public AbstractYLinksClassMatch(Date liClassMatchTime) {
		this.liClassMatchTime = liClassMatchTime;
	}

	/** full constructor */
	public AbstractYLinksClassMatch(Integer liClassSetId, Integer unitSetId, Date liClassMatchTime) {
		this.liClassSetId = liClassSetId;
		this.unitSetId = unitSetId;
		this.liClassMatchTime = liClassMatchTime;
	}

	// Property accessors

	public Integer getLiClassMatchId() {
		return this.liClassMatchId;
	}

	public void setLiClassMatchId(Integer liClassMatchId) {
		this.liClassMatchId = liClassMatchId;
	}

	public Integer getLiClassSetId() {
		return this.liClassSetId;
	}

	public void setLiClassSetId(Integer liClassSetId) {
		this.liClassSetId = liClassSetId;
	}

	public Integer getUnitSetId() {
		return this.unitSetId;
	}

	public void setUnitSetId(Integer unitSetId) {
		this.unitSetId = unitSetId;
	}

	public Date getLiClassMatchTime() {
		return this.liClassMatchTime;
	}

	public void setLiClassMatchTime(Date liClassMatchTime) {
		this.liClassMatchTime = liClassMatchTime;
	}

}
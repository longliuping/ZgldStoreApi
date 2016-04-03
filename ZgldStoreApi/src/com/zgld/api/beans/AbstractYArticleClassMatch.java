package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractYArticleClassMatch entity provides the base persistence definition of
 * the YArticleClassMatch entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYArticleClassMatch implements java.io.Serializable {

	// Fields

	private Integer arClassMatchId;
	private Integer arClassSetId;
	private Integer unitSetId;
	private Date arClassMatchTime;

	// Constructors

	/** default constructor */
	public AbstractYArticleClassMatch() {
	}

	/** minimal constructor */
	public AbstractYArticleClassMatch(Date arClassMatchTime) {
		this.arClassMatchTime = arClassMatchTime;
	}

	/** full constructor */
	public AbstractYArticleClassMatch(Integer arClassSetId, Integer unitSetId, Date arClassMatchTime) {
		this.arClassSetId = arClassSetId;
		this.unitSetId = unitSetId;
		this.arClassMatchTime = arClassMatchTime;
	}

	// Property accessors

	public Integer getArClassMatchId() {
		return this.arClassMatchId;
	}

	public void setArClassMatchId(Integer arClassMatchId) {
		this.arClassMatchId = arClassMatchId;
	}

	public Integer getArClassSetId() {
		return this.arClassSetId;
	}

	public void setArClassSetId(Integer arClassSetId) {
		this.arClassSetId = arClassSetId;
	}

	public Integer getUnitSetId() {
		return this.unitSetId;
	}

	public void setUnitSetId(Integer unitSetId) {
		this.unitSetId = unitSetId;
	}

	public Date getArClassMatchTime() {
		return this.arClassMatchTime;
	}

	public void setArClassMatchTime(Date arClassMatchTime) {
		this.arClassMatchTime = arClassMatchTime;
	}

}
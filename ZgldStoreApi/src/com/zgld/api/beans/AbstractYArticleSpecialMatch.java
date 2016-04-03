package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractYArticleSpecialMatch entity provides the base persistence definition
 * of the YArticleSpecialMatch entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYArticleSpecialMatch implements java.io.Serializable {

	// Fields

	private Integer arSpecialMatchId;
	private Integer arSpecialSetId;
	private Integer unitSetId;
	private Date arSpecialMatchTime;

	// Constructors

	/** default constructor */
	public AbstractYArticleSpecialMatch() {
	}

	/** minimal constructor */
	public AbstractYArticleSpecialMatch(Date arSpecialMatchTime) {
		this.arSpecialMatchTime = arSpecialMatchTime;
	}

	/** full constructor */
	public AbstractYArticleSpecialMatch(Integer arSpecialSetId, Integer unitSetId, Date arSpecialMatchTime) {
		this.arSpecialSetId = arSpecialSetId;
		this.unitSetId = unitSetId;
		this.arSpecialMatchTime = arSpecialMatchTime;
	}

	// Property accessors

	public Integer getArSpecialMatchId() {
		return this.arSpecialMatchId;
	}

	public void setArSpecialMatchId(Integer arSpecialMatchId) {
		this.arSpecialMatchId = arSpecialMatchId;
	}

	public Integer getArSpecialSetId() {
		return this.arSpecialSetId;
	}

	public void setArSpecialSetId(Integer arSpecialSetId) {
		this.arSpecialSetId = arSpecialSetId;
	}

	public Integer getUnitSetId() {
		return this.unitSetId;
	}

	public void setUnitSetId(Integer unitSetId) {
		this.unitSetId = unitSetId;
	}

	public Date getArSpecialMatchTime() {
		return this.arSpecialMatchTime;
	}

	public void setArSpecialMatchTime(Date arSpecialMatchTime) {
		this.arSpecialMatchTime = arSpecialMatchTime;
	}

}
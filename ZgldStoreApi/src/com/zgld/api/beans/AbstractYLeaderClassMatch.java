package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractYLeaderClassMatch entity provides the base persistence definition of
 * the YLeaderClassMatch entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYLeaderClassMatch implements java.io.Serializable {

	// Fields

	private Integer leaderClassMatchId;
	private Integer leaderClassSetId;
	private Integer unitSetId;
	private Date leaderClassMatchTime;

	// Constructors

	/** default constructor */
	public AbstractYLeaderClassMatch() {
	}

	/** minimal constructor */
	public AbstractYLeaderClassMatch(Date leaderClassMatchTime) {
		this.leaderClassMatchTime = leaderClassMatchTime;
	}

	/** full constructor */
	public AbstractYLeaderClassMatch(Integer leaderClassSetId, Integer unitSetId, Date leaderClassMatchTime) {
		this.leaderClassSetId = leaderClassSetId;
		this.unitSetId = unitSetId;
		this.leaderClassMatchTime = leaderClassMatchTime;
	}

	// Property accessors

	public Integer getLeaderClassMatchId() {
		return this.leaderClassMatchId;
	}

	public void setLeaderClassMatchId(Integer leaderClassMatchId) {
		this.leaderClassMatchId = leaderClassMatchId;
	}

	public Integer getLeaderClassSetId() {
		return this.leaderClassSetId;
	}

	public void setLeaderClassSetId(Integer leaderClassSetId) {
		this.leaderClassSetId = leaderClassSetId;
	}

	public Integer getUnitSetId() {
		return this.unitSetId;
	}

	public void setUnitSetId(Integer unitSetId) {
		this.unitSetId = unitSetId;
	}

	public Date getLeaderClassMatchTime() {
		return this.leaderClassMatchTime;
	}

	public void setLeaderClassMatchTime(Date leaderClassMatchTime) {
		this.leaderClassMatchTime = leaderClassMatchTime;
	}

}
package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YLeaderClassMatch entity. @author MyEclipse Persistence Tools
 */
public class YLeaderClassMatch extends AbstractYLeaderClassMatch implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YLeaderClassMatch() {
	}

	/** minimal constructor */
	public YLeaderClassMatch(Timestamp leaderClassMatchTime) {
		super(leaderClassMatchTime);
	}

	/** full constructor */
	public YLeaderClassMatch(Integer leaderClassSetId, Integer unitSetId, Timestamp leaderClassMatchTime) {
		super(leaderClassSetId, unitSetId, leaderClassMatchTime);
	}

}

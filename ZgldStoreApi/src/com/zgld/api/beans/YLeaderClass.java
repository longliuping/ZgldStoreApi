package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YLeaderClass entity. @author MyEclipse Persistence Tools
 */
public class YLeaderClass extends AbstractYLeaderClass implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YLeaderClass() {
	}

	/** minimal constructor */
	public YLeaderClass(Timestamp leaderClassTime) {
		super(leaderClassTime);
	}

	/** full constructor */
	public YLeaderClass(Integer unitSetId, Integer accountActId, Integer leaderParentClassId, Integer leaderClassSetId, String leaderClassName, Integer leaderClassOrder, Integer leaderClassTopOrder, Integer isDelete, Timestamp leaderClassTime) {
		super(unitSetId, accountActId, leaderParentClassId, leaderClassSetId, leaderClassName, leaderClassOrder, leaderClassTopOrder, isDelete, leaderClassTime);
	}

}

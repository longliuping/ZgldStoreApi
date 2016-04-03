package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YLeader entity. @author MyEclipse Persistence Tools
 */
public class YLeader extends AbstractYLeader implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YLeader() {
	}

	/** minimal constructor */
	public YLeader(Timestamp leaderTime) {
		super(leaderTime);
	}

	/** full constructor */
	public YLeader(Integer leaderClassSetId, Integer unitSetId, Integer accountActId, Integer accountId, String leaderTitle, String accountRealName, String accountName, String accountPassword, String leaderIntro, Integer leaderOrder, Integer leaderTopOrder, Integer isDelete, Timestamp leaderTime) {
		super(leaderClassSetId, unitSetId, accountActId, accountId, leaderTitle, accountRealName, accountName, accountPassword, leaderIntro, leaderOrder, leaderTopOrder, isDelete, leaderTime);
	}

}

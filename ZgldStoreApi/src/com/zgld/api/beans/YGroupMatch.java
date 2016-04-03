package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YGroupMatch entity. @author MyEclipse Persistence Tools
 */
public class YGroupMatch extends AbstractYGroupMatch implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YGroupMatch() {
	}

	/** minimal constructor */
	public YGroupMatch(Timestamp matchTime) {
		super(matchTime);
	}

	/** full constructor */
	public YGroupMatch(Integer chatGroupId, Integer accountId, Integer isAdmin, Integer isDelete, Timestamp matchTime) {
		super(chatGroupId, accountId, isAdmin, isDelete, matchTime);
	}

}

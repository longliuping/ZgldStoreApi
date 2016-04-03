package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YAdMatch entity. @author MyEclipse Persistence Tools
 */
public class YAdMatch extends AbstractYAdMatch implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YAdMatch() {
	}

	/** minimal constructor */
	public YAdMatch(Timestamp adMatchTime) {
		super(adMatchTime);
	}

	/** full constructor */
	public YAdMatch(Integer adId, Integer adPositionSetId, Integer isDelete, Timestamp adMatchTime) {
		super(adId, adPositionSetId, isDelete, adMatchTime);
	}

}

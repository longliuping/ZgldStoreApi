package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YAdPosition entity. @author MyEclipse Persistence Tools
 */
public class YAdPosition extends AbstractYAdPosition implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YAdPosition() {
	}

	/** minimal constructor */
	public YAdPosition(Timestamp adPositionTime) {
		super(adPositionTime);
	}

	/** full constructor */
	public YAdPosition(Integer adPositionSetId, String adPositionName, String adPositionIntro, Integer unitSetId, Integer accountActId, Integer adPositionOrder, Integer adPositionTopOrder, Integer isDelete, Timestamp adPositionTime) {
		super(adPositionSetId, adPositionName, adPositionIntro, unitSetId, accountActId, adPositionOrder, adPositionTopOrder, isDelete, adPositionTime);
	}

}

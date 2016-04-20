package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YAd entity. @author MyEclipse Persistence Tools
 */
public class YAd extends AbstractYAd implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YAd() {
	}

	/** minimal constructor */
	public YAd(Timestamp adTime) {
		super(adTime);
	}

	/** full constructor */
	public YAd(String adName, Integer adType, Integer unitSetId, Integer accountActId, Integer adOrder,
			Integer adTopOrder, Integer isDelete, Timestamp adTime) {
		super(adName, adType, unitSetId, accountActId, adOrder, adTopOrder, isDelete, adTime);
	}

}

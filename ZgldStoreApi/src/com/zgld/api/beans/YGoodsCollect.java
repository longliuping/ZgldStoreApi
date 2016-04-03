package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YGoodsCollect entity. @author MyEclipse Persistence Tools
 */
public class YGoodsCollect extends AbstractYGoodsCollect implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YGoodsCollect() {
	}

	/** minimal constructor */
	public YGoodsCollect(Timestamp goCollectTime) {
		super(goCollectTime);
	}

	/** full constructor */
	public YGoodsCollect(Integer accountActId, Integer goId, Timestamp goCollectTime) {
		super(accountActId, goId, goCollectTime);
	}

}

package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YGoodsScan entity. @author MyEclipse Persistence Tools
 */
public class YGoodsScan extends AbstractYGoodsScan implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YGoodsScan() {
	}

	/** minimal constructor */
	public YGoodsScan(Timestamp goScanTime) {
		super(goScanTime);
	}

	/** full constructor */
	public YGoodsScan(Integer goId, Integer accountActId, Timestamp goScanTime) {
		super(goId, accountActId, goScanTime);
	}

}

package com.zgld.api.beans;

import java.sql.Date;

/**
 * YSmsSendMatch entity. @author MyEclipse Persistence Tools
 */
public class YSmsSendMatch extends AbstractYSmsSendMatch implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YSmsSendMatch() {
	}

	/** minimal constructor */
	public YSmsSendMatch(Date smsScanTime) {
		super(smsScanTime);
	}

	/** full constructor */
	public YSmsSendMatch(Integer accountId, Integer smsSendId, Integer isScan, Integer isDelete, Date smsScanTime) {
		super(accountId, smsSendId, isScan, isDelete, smsScanTime);
	}

}

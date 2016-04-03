package com.zgld.api.beans;

import java.sql.Date;

/**
 * YSmsSend entity. @author MyEclipse Persistence Tools
 */
public class YSmsSend extends AbstractYSmsSend implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YSmsSend() {
	}

	/** minimal constructor */
	public YSmsSend(Date smsSendTime) {
		super(smsSendTime);
	}

	/** full constructor */
	public YSmsSend(Integer accountActId, Integer unitSetId, Integer smsSendType, String smsSendTitle, String smsSendContent, Integer smsOrder, Integer smsTopOrder, Integer isDelete, Date smsSendTime) {
		super(accountActId, unitSetId, smsSendType, smsSendTitle, smsSendContent, smsOrder, smsTopOrder, isDelete, smsSendTime);
	}

}

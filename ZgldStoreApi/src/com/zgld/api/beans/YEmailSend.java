package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YEmailSend entity. @author MyEclipse Persistence Tools
 */
public class YEmailSend extends AbstractYEmailSend implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YEmailSend() {
	}

	/** minimal constructor */
	public YEmailSend(Timestamp emailSendTime) {
		super(emailSendTime);
	}

	/** full constructor */
	public YEmailSend(Integer accountActId, Integer unitSetId, Integer emailSendType, String emailSendTitle, String emailSendContent, Integer emailOrder, Integer emailTopOrder, Integer isDelete, Timestamp emailSendTime) {
		super(accountActId, unitSetId, emailSendType, emailSendTitle, emailSendContent, emailOrder, emailTopOrder, isDelete, emailSendTime);
	}

}

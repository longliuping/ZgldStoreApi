package com.zgld.api.beans;

import java.sql.Date;

/**
 * YOrderSend entity. @author MyEclipse Persistence Tools
 */
public class YOrderSend extends AbstractYOrderSend implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YOrderSend() {
	}

	/** minimal constructor */
	public YOrderSend(Date sendTime) {
		super(sendTime);
	}

	/** full constructor */
	public YOrderSend(Integer shipId, String shipNumber, Integer orderId, Integer accountActId, String sendInfo, Date sendTime) {
		super(shipId, shipNumber, orderId, accountActId, sendInfo, sendTime);
	}

}

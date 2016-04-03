package com.zgld.api.beans;

import java.sql.Date;

/**
 * YServiceChat entity. @author MyEclipse Persistence Tools
 */
public class YServiceChat extends AbstractYServiceChat implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YServiceChat() {
	}

	/** minimal constructor */
	public YServiceChat(Date chatTime) {
		super(chatTime);
	}

	/** full constructor */
	public YServiceChat(Integer accountId, String connectionId, String chatInfo, Integer isDelete, Date chatTime) {
		super(accountId, connectionId, chatInfo, isDelete, chatTime);
	}

}

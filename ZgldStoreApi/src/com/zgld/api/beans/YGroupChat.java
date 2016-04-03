package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YGroupChat entity. @author MyEclipse Persistence Tools
 */
public class YGroupChat extends AbstractYGroupChat implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YGroupChat() {
	}

	/** minimal constructor */
	public YGroupChat(Timestamp chatGoupTime) {
		super(chatGoupTime);
	}

	/** full constructor */
	public YGroupChat(Integer chatGroupId, Integer accountActId, String chatGroupInfo, Integer isDelete, Timestamp chatGoupTime) {
		super(chatGroupId, accountActId, chatGroupInfo, isDelete, chatGoupTime);
	}

}

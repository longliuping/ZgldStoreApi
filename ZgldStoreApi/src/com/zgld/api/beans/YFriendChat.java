package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YFriendChat entity. @author MyEclipse Persistence Tools
 */
public class YFriendChat extends AbstractYFriendChat implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YFriendChat() {
	}

	/** minimal constructor */
	public YFriendChat(Timestamp chatTime) {
		super(chatTime);
	}

	/** full constructor */
	public YFriendChat(Integer friendId, Integer accountActId, String chatInfo, Integer isDelete, Timestamp chatTime) {
		super(friendId, accountActId, chatInfo, isDelete, chatTime);
	}

}

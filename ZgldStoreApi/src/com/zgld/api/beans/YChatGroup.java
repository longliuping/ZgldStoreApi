package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YChatGroup entity. @author MyEclipse Persistence Tools
 */
public class YChatGroup extends AbstractYChatGroup implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YChatGroup() {
	}

	/** minimal constructor */
	public YChatGroup(Timestamp chatGroupTime) {
		super(chatGroupTime);
	}

	/** full constructor */
	public YChatGroup(Integer accountActId, String chatGroupName, Integer chatGroupTotal, Integer chatGroupOrder, Integer chatGroupTopOrder, String chatGroupDefaultImg, String chatGroupHoverImg, String chatGroupVisitedImg, String chatGroupIntro, Integer isDelete, Timestamp chatGroupTime) {
		super(accountActId, chatGroupName, chatGroupTotal, chatGroupOrder, chatGroupTopOrder, chatGroupDefaultImg, chatGroupHoverImg, chatGroupVisitedImg, chatGroupIntro, isDelete, chatGroupTime);
	}

}

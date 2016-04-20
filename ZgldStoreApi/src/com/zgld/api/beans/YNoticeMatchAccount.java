package com.zgld.api.beans;

import java.sql.Date;

/**
 * YNoticeMatchAccount entity. @author MyEclipse Persistence Tools
 */
public class YNoticeMatchAccount extends AbstractYNoticeMatchAccount implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YNoticeMatchAccount() {
	}

	/** minimal constructor */
	public YNoticeMatchAccount(Date noticeMatchTime) {
		super(noticeMatchTime);
	}

	/** full constructor */
	public YNoticeMatchAccount(Integer noId, Integer accountId, Integer noMatchState, Integer isDelete,
			Date noticeMatchTime) {
		super(noId, accountId, noMatchState, isDelete, noticeMatchTime);
	}

}

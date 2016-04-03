package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YLog entity. @author MyEclipse Persistence Tools
 */
public class YLog extends AbstractYLog implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YLog() {
	}

	/** minimal constructor */
	public YLog(Timestamp logTime) {
		super(logTime);
	}

	/** full constructor */
	public YLog(Integer accountActId, String logNote, String logIp, Integer isDelete, Timestamp logTime) {
		super(accountActId, logNote, logIp, isDelete, logTime);
	}

}

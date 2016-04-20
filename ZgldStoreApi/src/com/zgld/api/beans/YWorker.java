package com.zgld.api.beans;

import java.sql.Date;

/**
 * YWorker entity. @author MyEclipse Persistence Tools
 */
public class YWorker extends AbstractYWorker implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YWorker() {
	}

	/** minimal constructor */
	public YWorker(Date workerTime) {
		super(workerTime);
	}

	/** full constructor */
	public YWorker(Integer workerClassSetId, Integer unitSetId, Integer accountActId, Integer accountId,
			String workerTitle, String accountRealName, String accountName, String accountPassword, String workerIntro,
			Integer workerOrder, Integer workerTopOrder, Integer isDelete, Date workerTime) {
		super(workerClassSetId, unitSetId, accountActId, accountId, workerTitle, accountRealName, accountName,
				accountPassword, workerIntro, workerOrder, workerTopOrder, isDelete, workerTime);
	}

}

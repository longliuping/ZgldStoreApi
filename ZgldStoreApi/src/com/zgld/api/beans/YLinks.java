package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YLinks entity. @author MyEclipse Persistence Tools
 */
public class YLinks extends AbstractYLinks implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YLinks() {
	}

	/** minimal constructor */
	public YLinks(Timestamp liTime) {
		super(liTime);
	}

	/** full constructor */
	public YLinks(Integer liClassSetId, Integer liState, Integer unitSetId, Integer accountActId, String liTitle,
			String liUrl, String liImg, Integer liOrder, Integer liTopOrder, Integer isDelete, Timestamp liTime) {
		super(liClassSetId, liState, unitSetId, accountActId, liTitle, liUrl, liImg, liOrder, liTopOrder, isDelete,
				liTime);
	}

}

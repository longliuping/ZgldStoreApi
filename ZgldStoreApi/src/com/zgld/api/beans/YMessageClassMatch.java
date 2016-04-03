package com.zgld.api.beans;

import java.sql.Date;

/**
 * YMessageClassMatch entity. @author MyEclipse Persistence Tools
 */
public class YMessageClassMatch extends AbstractYMessageClassMatch implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YMessageClassMatch() {
	}

	/** minimal constructor */
	public YMessageClassMatch(Date msgClassMatchTime) {
		super(msgClassMatchTime);
	}

	/** full constructor */
	public YMessageClassMatch(Integer msgClassSetId, Integer unitSetId, Date msgClassMatchTime) {
		super(msgClassSetId, unitSetId, msgClassMatchTime);
	}

}

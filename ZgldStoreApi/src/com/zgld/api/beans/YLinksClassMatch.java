package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YLinksClassMatch entity. @author MyEclipse Persistence Tools
 */
public class YLinksClassMatch extends AbstractYLinksClassMatch implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YLinksClassMatch() {
	}

	/** minimal constructor */
	public YLinksClassMatch(Timestamp liClassMatchTime) {
		super(liClassMatchTime);
	}

	/** full constructor */
	public YLinksClassMatch(Integer liClassSetId, Integer unitSetId, Timestamp liClassMatchTime) {
		super(liClassSetId, unitSetId, liClassMatchTime);
	}

}

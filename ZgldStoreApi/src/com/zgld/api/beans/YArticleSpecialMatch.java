package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YArticleSpecialMatch entity. @author MyEclipse Persistence Tools
 */
public class YArticleSpecialMatch extends AbstractYArticleSpecialMatch implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YArticleSpecialMatch() {
	}

	/** minimal constructor */
	public YArticleSpecialMatch(Timestamp arSpecialMatchTime) {
		super(arSpecialMatchTime);
	}

	/** full constructor */
	public YArticleSpecialMatch(Integer arSpecialSetId, Integer unitSetId, Timestamp arSpecialMatchTime) {
		super(arSpecialSetId, unitSetId, arSpecialMatchTime);
	}

}

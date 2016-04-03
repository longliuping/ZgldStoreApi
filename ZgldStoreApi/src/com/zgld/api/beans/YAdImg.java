package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YAdImg entity. @author MyEclipse Persistence Tools
 */
public class YAdImg extends AbstractYAdImg implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YAdImg() {
	}

	/** minimal constructor */
	public YAdImg(Timestamp adImgTime) {
		super(adImgTime);
	}

	/** full constructor */
	public YAdImg(Integer adId, String adImgUrl, String adImgSrc, String adImgTitle, String adImgIntro, Integer unitSetId, Integer accountActId, Integer adImgOrder, Integer adImgTopOrder, Integer isDelete, Timestamp adImgTime) {
		super(adId, adImgUrl, adImgSrc, adImgTitle, adImgIntro, unitSetId, accountActId, adImgOrder, adImgTopOrder, isDelete, adImgTime);
	}

}

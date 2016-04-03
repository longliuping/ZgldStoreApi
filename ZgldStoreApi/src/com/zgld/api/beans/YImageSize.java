package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YImageSize entity. @author MyEclipse Persistence Tools
 */
public class YImageSize extends AbstractYImageSize implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YImageSize() {
	}

	/** minimal constructor */
	public YImageSize(Timestamp imgSizeTime) {
		super(imgSizeTime);
	}

	/** full constructor */
	public YImageSize(Integer imgSizeWidth, Integer imgSizeHeight, Integer isDefault, Integer isDelete, Timestamp imgSizeTime) {
		super(imgSizeWidth, imgSizeHeight, isDefault, isDelete, imgSizeTime);
	}

}

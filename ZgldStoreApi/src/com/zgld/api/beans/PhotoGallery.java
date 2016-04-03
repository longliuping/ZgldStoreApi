package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * PhotoGallery entity. @author MyEclipse Persistence Tools
 */
public class PhotoGallery extends AbstractPhotoGallery implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PhotoGallery() {
	}

	/** full constructor */
	public PhotoGallery(Integer categoryId, String photoName, String photoPath, Integer fileSize, Timestamp uploadTime, Timestamp lastUpdateTime) {
		super(categoryId, photoName, photoPath, fileSize, uploadTime, lastUpdateTime);
	}

}

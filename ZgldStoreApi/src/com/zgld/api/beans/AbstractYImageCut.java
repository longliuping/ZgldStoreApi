package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractYImageCut entity provides the base persistence definition of the
 * YImageCut entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYImageCut implements java.io.Serializable {

	// Fields

	private Integer imgCutId;
	private Integer fiId;
	private Integer imgCutWidth;
	private Integer imgCutHeight;
	private String imgCutUrl;
	private Integer isDelete;
	private Date imgCutTime;

	// Constructors

	/** default constructor */
	public AbstractYImageCut() {
	}

	/** minimal constructor */
	public AbstractYImageCut(Date imgCutTime) {
		this.imgCutTime = imgCutTime;
	}

	/** full constructor */
	public AbstractYImageCut(Integer fiId, Integer imgCutWidth, Integer imgCutHeight, String imgCutUrl,
			Integer isDelete, Date imgCutTime) {
		this.fiId = fiId;
		this.imgCutWidth = imgCutWidth;
		this.imgCutHeight = imgCutHeight;
		this.imgCutUrl = imgCutUrl;
		this.isDelete = isDelete;
		this.imgCutTime = imgCutTime;
	}

	// Property accessors

	public Integer getImgCutId() {
		return this.imgCutId;
	}

	public void setImgCutId(Integer imgCutId) {
		this.imgCutId = imgCutId;
	}

	public Integer getFiId() {
		return this.fiId;
	}

	public void setFiId(Integer fiId) {
		this.fiId = fiId;
	}

	public Integer getImgCutWidth() {
		return this.imgCutWidth;
	}

	public void setImgCutWidth(Integer imgCutWidth) {
		this.imgCutWidth = imgCutWidth;
	}

	public Integer getImgCutHeight() {
		return this.imgCutHeight;
	}

	public void setImgCutHeight(Integer imgCutHeight) {
		this.imgCutHeight = imgCutHeight;
	}

	public String getImgCutUrl() {
		return this.imgCutUrl;
	}

	public void setImgCutUrl(String imgCutUrl) {
		this.imgCutUrl = imgCutUrl;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getImgCutTime() {
		return this.imgCutTime;
	}

	public void setImgCutTime(Date imgCutTime) {
		this.imgCutTime = imgCutTime;
	}

}
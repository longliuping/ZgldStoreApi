package com.zgld.api.beans;

/**
 * AbstractShopHot entity provides the base persistence definition of the
 * ShopHot entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractShopHot implements java.io.Serializable {

	// Fields

	private Integer shopHotId;
	private Integer hotId;
	private Integer shopId;

	// Constructors

	/** default constructor */
	public AbstractShopHot() {
	}

	/** full constructor */
	public AbstractShopHot(Integer hotId, Integer shopId) {
		this.hotId = hotId;
		this.shopId = shopId;
	}

	// Property accessors

	public Integer getShopHotId() {
		return this.shopHotId;
	}

	public void setShopHotId(Integer shopHotId) {
		this.shopHotId = shopHotId;
	}

	public Integer getHotId() {
		return this.hotId;
	}

	public void setHotId(Integer hotId) {
		this.hotId = hotId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

}
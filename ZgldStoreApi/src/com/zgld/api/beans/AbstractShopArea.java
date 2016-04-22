package com.zgld.api.beans;

/**
 * AbstractShopArea entity provides the base persistence definition of the
 * ShopArea entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractShopArea implements java.io.Serializable {

	// Fields

	private Integer shopAreaId;
	private Integer areaId;
	private Integer shopId;

	// Constructors

	/** default constructor */
	public AbstractShopArea() {
	}

	/** full constructor */
	public AbstractShopArea(Integer areaId, Integer shopId) {
		this.areaId = areaId;
		this.shopId = shopId;
	}

	// Property accessors

	public Integer getShopAreaId() {
		return this.shopAreaId;
	}

	public void setShopAreaId(Integer shopAreaId) {
		this.shopAreaId = shopAreaId;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

}
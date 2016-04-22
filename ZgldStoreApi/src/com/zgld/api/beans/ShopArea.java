package com.zgld.api.beans;

/**
 * ShopArea entity. @author MyEclipse Persistence Tools
 */
public class ShopArea extends AbstractShopArea implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ShopArea() {
	}

	/** full constructor */
	public ShopArea(Integer areaId, Integer shopId) {
		super(areaId, shopId);
	}

}

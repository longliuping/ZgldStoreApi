package com.zgld.api.beans;

import java.io.Serializable;

public abstract class AbstractSkugroup implements Serializable {
	private Integer skugroupId;
	private Integer shopId;
	private Integer productId;
	private String skugroupName;

	public AbstractSkugroup() {
	}

	public AbstractSkugroup(Integer shopId, Integer productId, String skugroupName) {
		this.shopId = shopId;
		this.productId = productId;
		this.skugroupName = skugroupName;
	}

	public Integer getSkugroupId() {
		return this.skugroupId;
	}

	public void setSkugroupId(Integer skugroupId) {
		this.skugroupId = skugroupId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSkugroupName() {
		return this.skugroupName;
	}

	public void setSkugroupName(String skugroupName) {
		this.skugroupName = skugroupName;
	}
}
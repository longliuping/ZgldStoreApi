package com.zgld.api.beans;

import java.io.Serializable;
import java.util.List;

public class Skugroup extends AbstractSkugroup implements Serializable {
	Sku sku;
	List<Sku> listSkus;

	public Skugroup() {
	}

	public Skugroup(Integer shopId, Integer productId, String skugroupName) {
		super(shopId, productId, skugroupName);
	}

	public Sku getSku() {
		return this.sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public List<Sku> getListSkus() {
		return this.listSkus;
	}

	public void setListSkus(List<Sku> listSkus) {
		this.listSkus = listSkus;
	}
}
package com.zgld.api.beans;

import java.io.Serializable;

public class OrderItems extends AbstractOrderItems implements Serializable {
	Products products;

	public OrderItems() {
	}

	public OrderItems(Integer orderId, Integer productId, Integer sku, Integer quantity, Double listPrice,
			Double cellPrice, String remark) {
		super(orderId, productId, sku, quantity, listPrice, cellPrice, remark);
	}

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
}
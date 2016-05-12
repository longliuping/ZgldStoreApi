package com.zgld.api.beans;

import java.io.Serializable;

public class OrderItems extends AbstractOrderItems implements Serializable {
	Products products;

	public OrderItems() {
	}

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
}
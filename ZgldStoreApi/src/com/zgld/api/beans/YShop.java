package com.zgld.api.beans;

import java.sql.Date;
import java.util.List;

/**
 * YShop entity. @author MyEclipse Persistence Tools
 */
public class YShop extends AbstractYShop implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YShop() {
	}

	Products products;
	List<Products> listProducts;
	List<ShoppingCarts> listShoppingCarts;
	List<Orders> listOrders;
	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public List<Products> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Products> listProducts) {
		this.listProducts = listProducts;
	}

	public List<ShoppingCarts> getListShoppingCarts() {
		return listShoppingCarts;
	}

	public void setListShoppingCarts(List<ShoppingCarts> listShoppingCarts) {
		this.listShoppingCarts = listShoppingCarts;
	}

	public List<Orders> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Orders> listOrders) {
		this.listOrders = listOrders;
	}

}

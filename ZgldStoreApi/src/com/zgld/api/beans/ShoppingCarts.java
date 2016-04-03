package com.zgld.api.beans;

/**
 * ShoppingCarts entity. @author MyEclipse Persistence Tools
 */
public class ShoppingCarts extends AbstractShoppingCarts implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ShoppingCarts() {
	}

	/** full constructor */
	public ShoppingCarts(Integer shopId, Integer userId, Integer productId, Integer sku, Integer quantity) {
		super(shopId, userId, productId, sku, quantity);
	}

}

package com.zgld.api.beans;

/**
 * PromoteSalesGive entity. @author MyEclipse Persistence Tools
 */
public class PromoteSalesGive extends AbstractPromoteSalesGive implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PromoteSalesGive() {
	}

	/** full constructor */
	public PromoteSalesGive(Integer buyQuantity, Integer giveQuantity) {
		super(buyQuantity, giveQuantity);
	}

}

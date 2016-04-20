package com.zgld.api.beans;

import java.util.List;

/**
 * Categories entity. @author MyEclipse Persistence Tools
 */
public class Categories extends AbstractCategories implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Categories() {
	}

	/** full constructor */
	public Categories(Integer parentCategoryId, String name, Integer displaysequence, String iconUrl, String indexChar,
			String title, String metaDescription, String metaKeywords, String description, Integer depth) {
		super(parentCategoryId, name, displaysequence, iconUrl, indexChar, title, metaDescription, metaKeywords,
				description, depth);
	}

	List<Products> listProducts;

	public List<Products> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Products> listProducts) {
		this.listProducts = listProducts;
	}

}

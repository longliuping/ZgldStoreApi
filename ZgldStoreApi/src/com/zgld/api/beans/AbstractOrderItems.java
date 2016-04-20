package com.zgld.api.beans;

import java.io.Serializable;

public abstract class AbstractOrderItems implements Serializable {
	private Integer itemId;
	private Integer orderId;
	private Integer productId;
	private Integer sku;
	private Integer quantity;
	private Double listPrice;
	private Double cellPrice;
	private String remark;

	public AbstractOrderItems() {
	}

	public AbstractOrderItems(Integer orderId, Integer productId, Integer sku, Integer quantity, Double listPrice,
			Double cellPrice, String remark) {
		this.orderId = orderId;
		this.productId = productId;
		this.sku = sku;
		this.quantity = quantity;
		this.listPrice = listPrice;
		this.cellPrice = cellPrice;
		this.remark = remark;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getSku() {
		return this.sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public Double getCellPrice() {
		return this.cellPrice;
	}

	public void setCellPrice(Double cellPrice) {
		this.cellPrice = cellPrice;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
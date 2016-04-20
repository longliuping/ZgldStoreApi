package com.zgld.api.beans;

import java.io.Serializable;
import java.util.List;

public class Orders extends AbstractOrders implements Serializable {
	List<OrderItems> listOrderItems;

	public List<OrderItems> getListOrderItems() {
		return this.listOrderItems;
	}

	public void setListOrderItems(List<OrderItems> listOrderItems) {
		this.listOrderItems = listOrderItems;
	}
}
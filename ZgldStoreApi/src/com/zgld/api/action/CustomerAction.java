package com.zgld.api.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.zgld.api.beans.OrderItems;
import com.zgld.api.beans.Orders;
import com.zgld.api.beans.Products;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YShop;

/**
 * 客户
 * 
 * @author Am
 *
 */
public class CustomerAction extends BaseAction {
	/**
	 * 商家所有订单
	 * 
	 * @return
	 */
	public String find_all_order() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				YShop shop = (YShop) baseService
						.bean(" from YShop as s where s.userId = " + account.getUserProfile().getUserId());
				if (shop == null) {
					this.form.setJsonMsg("商家不存在", false, json, 1001);
				} else {
					StringBuffer sb = new StringBuffer(
							" from Orders as ho where ho.userId = " + account.getUsers().getUserId());
					if ((this.form.getId() != null) && (this.form.getId().intValue() >= 0)) {
						sb.append(" and ho.paymentStatus = " + this.form.getId());
					}
					sb.append(" order by ho.orderDate desc ");
					List hishopOrders = this.baseService.findPage(this.form.getPageNum().intValue(),
							this.form.getPageSize().intValue(), sb.toString());
					for (int i = 0; i < hishopOrders.size(); i++) {
						List list = this.baseService.findAll(
								" from OrderItems as oi, Products as p where oi.productId = p.productId and oi.orderId = "
										+ ((Orders) hishopOrders.get(i)).getOrderId());
						List items = new ArrayList();
						for (Iterator localIterator = list.iterator(); localIterator.hasNext();) {
							Object object = localIterator.next();
							Object[] obj = (Object[]) object;
							OrderItems item = (OrderItems) obj[0];
							if (obj.length > 1) {
								Products pro = (Products) obj[1];
								item.setProducts(pro);
							}
							items.add(item);
						}
						((Orders) hishopOrders.get(i)).setListOrderItems(items);
					}
					json.put(LISTINFO, hishopOrders);
					this.form.setJsonMsg("success", true, json, 200);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 使用订单
	 * 
	 * @return
	 */
	public String use_order() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if (form.getOrderid() == null) {
					this.form.setJsonMsg("orderid不能为空", false, json, 1001);
				} else if (form.getCode() == null) {
					this.form.setJsonMsg("code不能为空", false, json, 1001);
				} else {
					YShop shop = (YShop) baseService
							.bean(" from YShop as s where s.userId = " + account.getUserProfile().getUserId());
					if (shop == null) {
						this.form.setJsonMsg("商家不存在", false, json, 1001);
					} else {

					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 搜索订单
	 * 
	 * @return
	 */
	public String search_order() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if (form.getOrderid() == null) {
					this.form.setJsonMsg("orderid不能为空", false, json, 1001);
				} else {
					YShop shop = (YShop) baseService
							.bean(" from YShop as s where s.userId = " + account.getUserProfile().getUserId());
					if (shop == null) {
						this.form.setJsonMsg("商家不存在", false, json, 1001);
					} else {

					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
}

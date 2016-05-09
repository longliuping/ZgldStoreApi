package com.zgld.api.action;

import com.alipay.config.OrderPayConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zgld.api.beans.OrderItems;
import com.zgld.api.beans.Orders;
import com.zgld.api.beans.Products;
import com.zgld.api.beans.Sku;
import com.zgld.api.beans.SubmitOrderParam;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YFormCombineValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 订单相关
 * 
 * @author Am
 *
 */
public class OrderAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	/**
	 * 根据订单orderId获取订单要支付的信息
	 * 
	 * @return
	 */
	public String alipay_order_config() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if (this.form.getOrderid() == null) {
					this.form.setJsonMsg("orderid不能为空", false, json, 1001);
				} else {
					Orders order = (Orders) this.baseService.bean(" from Orders as o where o.orderId = " + this.form.getOrderid());
					if (order == null) {
						this.form.setJsonMsg("订单不存在", false, json, 1001);
					} else if ((order != null) && (order.getPaymentStatus().intValue() == 1)) {
						this.form.setJsonMsg("订单已经支付，不能重复支付", false, json, 1001);
					} else {
						String subject = "众观利达：";
						String body = "众观利达：";
						List listItem = this.baseService.findAll(" from OrderItems as oi,Products as p where oi.productId = p.productId and oi.orderId=" + order.getOrderId());
						if (listItem != null) {
							for (int i = 0; i < listItem.size(); i++) {
								Object[] o = (Object[]) listItem.get(i);
								if (o.length > 0) {
									Products p = (Products) o[1];
									subject = subject + p.getProductName();
									body = body + p.getShortDescription();
								}
							}
						}
						OrderPayConfig config = new OrderPayConfig();
						config.setBody(body);
						config.setSubject(subject);
						config.setExpenses(Double.valueOf(0.0D));
						config.setTotal_fee(order.getOrderTotalPrice());
						config.setNotify_url("http://115.28.20.167:8090/webapi/notify_url.jsp");
						config.setOrderId(order.getOrderId() + "");
						config.setPartner("2088221599054403");
						config.setSeller_id("709877070@qq.com");
						config.setRsa_private(
								"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALhgnZ3yOtEbHr0WD/a7ekU3+UBdPz1+Rq1FGkM+duEKCMqWlJE2ow+WG8tR/WT3VtvYjeZGQsDpaEK6IuoBbkIl1+a2n4i8amMp5bELaLkwbsN24fuMrO6zno3uVD4BXcn9GxTPHn7yiimuE2hvLuCD8OkHseCDc/rf7+4B6SbpAgMBAAECgYBdi8+MipDi9TKUVzRER/ySUALrcCQc7Aup78ySX4frR68MMngwcRssVknFz9STvJZaNrZQJkfKHuJiMJR0S8OHeZ7wZt2u3cXn3tbvkqoYscc7WMmBM10k16npC8uw0eB1XU/y4dT53zFPtGe6HQ5UG9AiOKoerWQtTqSp1FD1AQJBAOBgEa4g6lhuobs4D4kE1BsQ+xK4utbvuKG+YLfebfsLUZZ1NmBbrzO3qYEa8PeB95YPK1OkFlPi6wRLBkO31OECQQDSXVb0oWeplZO1t/O858DOgVIKtRkJs7GSPFAfUak1p0/GZ+fbokUhiaNS6HLfcnMx3LyE7PFyZS4MFitm7QsJAkB7LQJHv5YnGgT7jJkqtVXjzfynmHYpzMxlLuhVyGxEJ0CRAqPpXivejnMlhy7GEbljzcwRTMFdJ/OxFabIwkDBAkEAjkvbJREFGP538yTid7bggg+SGnIT5K8rf3rSy8ymRAfP+6qPeM8UKjJ7Svq3sZQufd0NnHDWhgYRFtXsN+xCWQJAGWVeTpdFzdlPNaOflq7D2TFqo7H5kqz2s+FbByGVsNz4At5DsITBTvneHazkvWSrY11kWXui/Vd41fMl5pEBAA==");

						config.setRsa_public(
								"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4YJ2d8jrRGx69Fg/2u3pFN/lA\nXT89fkatRRpDPnbhCgjKlpSRNqMPlhvLUf1k91bb2I3mRkLA6WhCuiLqAW5CJdfmtp+IvGpjKeWxC2i5MG7DduH7jKzus56N7lQ+AV3J/RsUzx5+8ooprhNoby7gg/DpB7Hgg3P63+/uAekm6QIDAQAB");

						json.put(INFO, config);
						this.form.setJsonMsg("success", false, json, 200);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 提交订单
	 * 
	 * @return
	 */
	public String submit_order() {
		Map json = new HashMap();
		try {
			String sku = "";// 产品|数量|规格
			YAccount account = getUserInfo();
			if (account != null) {
				if (this.form.getJson() == null) {
					this.form.setJsonMsg("json不能为空", false, json, 1001);
				} else {
					Gson gson = new Gson();
					System.out.println(json);
					List<SubmitOrderParam> listParam = gson.fromJson(form.getJson(), new TypeToken<List<SubmitOrderParam>>() {
					}.getType());
					if (listParam == null || listParam.size() <= 0) {
						this.form.setJsonMsg("请选择产品", false, json, 1001);
					} else {
						String message = null;
						int userId = 2;
						double salePrice = 0.0D;
						int shopId = 0;
						List<Orders> listOrders = new ArrayList<>();
						List<OrderItems> listOrderItems = new ArrayList<>();
						shopId = listParam.get(0).getShopId();
						Orders orders = null;
						for (int i = 0; i < listParam.size(); i++) {
							SubmitOrderParam pa = listParam.get(i);
							Products products = (Products) baseService.bean(" from Products as p where p.productId = " + pa.getProductId());
							if (products == null) {
								message = "产品不存在(ID)" + pa.getProductId();
							} else {
								int number = 0;
								double price = 0.0;
								if (pa.getValueId() > 0) {
									YFormCombineValue formCombineValue = (YFormCombineValue) baseService.bean(
											" from YFormCombineValue as fcv where fcv.objTable = 'Products' and fcv.combineValueId = " + pa.getValueId() + " and fcv.objId = " + pa.getProductId());
									if (formCombineValue != null) {
										number = formCombineValue.getGoStore();
										price = formCombineValue.getGoSalePrice();
									} else {
										message = "产品ID" + pa.getProductId() + "规格不存在" + pa.getValueId();
									}
								} else {
									number = products.getStock();
									price = products.getSalePrice();
								}
								if (pa.getNumber() > number) {
									message = "产品ID" + products.getProductId() + "库存不能大于" + number;
								}
								if (message == null) {
									if (shopId == products.getShopId()) {
										OrderItems items = new OrderItems();
										items.setProductId(pa.getProductId());
										if (pa.getValueId() > 0) {
											items.setSku(pa.getValueId());
										}
										items.setQuantity(pa.getNumber());
										items.setListPrice(Double.valueOf(price));
										items.setCellPrice(price);
										items.setRemark("");
										salePrice += pa.getNumber() * price;
										listOrderItems.add(items);

										orders = new Orders();
										orders.setUserId(Integer.valueOf(userId));
										orders.setFreight(Double.valueOf(0.0D));
										orders.setShippingId(Integer.valueOf(0));
										orders.setShipOrderNumber("");
										orders.setShippingStatus(Integer.valueOf(0));
										orders.setRefundStatus(Integer.valueOf(0));
										orders.setPaymentStatus(Integer.valueOf(0));
										orders.setOrderTotalPrice(Double.valueOf(0.0D));
										orders.setOtherCost(Double.valueOf(0.0D));
										orders.setOrderRealPrice(Double.valueOf(0.0D));
										orders.setRemark("");
										orders.setOrderDate(new Date());
										orders.setOrderTotalPrice(Double.valueOf(salePrice));
										orders.setShopId(shopId);

									} else {
										orders.setListOrderItems(listOrderItems);
										orders.setOrderTotalPrice(salePrice);
										listOrders.add(orders);
										orders = new Orders();
										salePrice = 0.0;
										orders.setUserId(Integer.valueOf(userId));
										orders.setFreight(Double.valueOf(0.0D));
										orders.setShippingId(Integer.valueOf(0));
										orders.setShipOrderNumber("");
										orders.setShippingStatus(Integer.valueOf(0));
										orders.setRefundStatus(Integer.valueOf(0));
										orders.setPaymentStatus(Integer.valueOf(0));
										orders.setOrderTotalPrice(Double.valueOf(0.0D));
										orders.setOtherCost(Double.valueOf(0.0D));
										orders.setOrderRealPrice(Double.valueOf(0.0D));
										orders.setRemark("");
										orders.setOrderDate(new Date());
										orders.setOrderTotalPrice(Double.valueOf(salePrice));
										orders.setShopId(shopId);

										salePrice = 0;
										listOrderItems = new ArrayList<>();

										OrderItems items = new OrderItems();
										items.setProductId(pa.getProductId());
										if (pa.getValueId() > 0) {
											items.setSku(pa.getValueId());
										}
										items.setQuantity(pa.getNumber());
										items.setListPrice(Double.valueOf(price));
										items.setCellPrice(price);
										items.setRemark("");
										salePrice += pa.getNumber() * price;
										listOrderItems.add(items);
									}
								}
							}
						}
						if (message != null) {
							this.form.setJsonMsg(message, false, json, 1001);
						} else {
							orders.setListOrderItems(listOrderItems);
							orders.setOrderTotalPrice(salePrice);
							listOrders.add(orders);
							int orderId = 0;
							for (int i = 0; i < listOrders.size(); i++) {
								Serializable s = baseService.save(listOrders.get(i));
								orderId = Integer.parseInt(s.toString());
								for (int j = 0; j < listOrders.get(i).getListOrderItems().size(); j++) {
									OrderItems items = listOrders.get(i).getListOrderItems().get(j);
									items.setOrderId(orderId);
									baseService.save(items);
								}
							}
							json.put("orderId", orderId);
							if (listOrders.size() > 1) {
								this.form.setJsonMsg("提交订单成功(含有多个商家产品,需要分" + listOrders.size() + ")次付款", true, json, 200);
							} else {
								this.form.setJsonMsg("提交订单成功", true, json, 200);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 查询用户的订单
	 * 
	 * @return
	 */
	public String user_order() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				StringBuffer sb = new StringBuffer(" from Orders as ho where ho.userId = " + account.getUsers().getUserId());
				if ((this.form.getId() != null) && (this.form.getId().intValue() >= 0)) {
					sb.append(" and ho.paymentStatus = " + this.form.getId());
				}
				sb.append(" order by ho.orderDate desc ");
				List hishopOrders = this.baseService.findPage(this.form.getPageNum().intValue(), this.form.getPageSize().intValue(), sb.toString());
				for (int i = 0; i < hishopOrders.size(); i++) {
					List list = this.baseService.findAll(" from OrderItems as oi, Products as p where oi.productId = p.productId and oi.orderId = " + ((Orders) hishopOrders.get(i)).getOrderId());
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
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 用户订单申请退款
	 * 
	 * @return
	 */
	public String user_order_apply_refound() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if (this.form.getOrderid() == null) {
					this.form.setJsonMsg("orderid不能为空", false, json, 1001);
				} else {
					Orders order = (Orders) this.baseService.bean(" from Orders as o where o.userId = " + account.getUsers().getUserId() + " and o.orderId = " + this.form.getOrderid());
					if (order == null) {
						this.form.setJsonMsg("订单不存在", false, json, 1001);
					} else if ((order == null) || (order.getPaymentStatus().intValue() != 1)) {
						this.form.setJsonMsg("此订单暂时不能申请退款", false, json, 1001);
					} else {
						order.setRefundStatus(1);// 申请退款
						baseService.update(order);
						form.setJsonMsg("提交成功，等待商户审核!", true, json, 200);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 用户删除订单
	 * 
	 * @return
	 */
	public String user_delete_order() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if (this.form.getOrderid() == null) {
					this.form.setJsonMsg("orderid不能为空", false, json, 1001);
				} else {
					Orders order = (Orders) this.baseService.bean(" from Orders as o where o.userId = " + account.getUsers().getUserId() + " and o.orderId = " + this.form.getOrderid());
					if (order == null) {
						this.form.setJsonMsg("订单不存在", false, json, 1001);
					} else if ((order == null) || (order.getPaymentStatus().intValue() != 0)) {
						this.form.setJsonMsg("此订单暂时不能删除", false, json, 1001);
					} else {
						baseService.delete(order);
						baseService.updateListObject(" delete from OrderItems as o where o.orderId = " + order.getOrderId());
						form.setJsonMsg("删除成功!", true, json, 200);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
}
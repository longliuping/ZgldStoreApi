package com.zgld.api.action;

import com.zgld.api.base.BaseForm;
import com.zgld.api.beans.Products;
import com.zgld.api.beans.ShoppingCarts;
import com.zgld.api.beans.Sku;
import com.zgld.api.beans.Users;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YShop;
import com.zgld.api.service.BaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	/**
	 * 添加产品到购物车
	 * @return
	 */
	public String add_product_car() {
		Map json = new HashMap();
		try {
			if (this.form.getSkuId() == null) {
				this.form.setJsonMsg("skuId不能为空", false, json, 1001);
			} else if ((this.form.getProductId() == null) || (this.form.getSkuId().isEmpty())) {
				this.form.setJsonMsg("productuId不能为空", false, json, 1001);
			} else if (this.form.getNumber() == null) {
				this.form.setJsonMsg("number不能为空", false, json, 1001);
			} else {
				YAccount account = getUserInfo();
				if (account == null) {
					this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
				} else {
					int userId = account.getUsers().getUserId().intValue();
					String skuId = this.form.getSkuId();
					int productId = this.form.getProductId().intValue();
					int number = this.form.getNumber().intValue();
					Sku hishopSkus = (Sku) this.baseService
							.bean(" from Sku as hs where hs.sku = " + skuId + " and hs.productId = " + productId);
					if (hishopSkus == null) {
						this.form.setJsonMsg("产品信息不存在", true, json, 1001);
					} else if (number > hishopSkus.getStock().intValue()) {
						this.form.setJsonMsg("购买数量不能大于库存数量:" + hishopSkus.getStock(), true, json, 1001);
					} else {
						ShoppingCarts hishopShoppingCarts = (ShoppingCarts) this.baseService
								.bean(" from ShoppingCarts as sc where sc.sku = " + skuId + " and sc.userId = " + userId
										+ " and sc.productId = " + productId);
						if (hishopShoppingCarts != null) {
							if (hishopShoppingCarts.getQuantity().intValue() + number > hishopSkus.getStock()
									.intValue()) {
								this.form.setJsonMsg("购买数量不能大于库存数量:" + hishopSkus.getStock(), true, json, 1001);
							} else {
								hishopShoppingCarts.setQuantity(
										Integer.valueOf(hishopShoppingCarts.getQuantity().intValue() + number));
								this.baseService.update(hishopShoppingCarts);
								this.form.setJsonMsg("加入购物车成功", true, json, 200);
							}
						} else {
							ShoppingCarts carts = new ShoppingCarts();
							carts.setProductId(Integer.valueOf(productId));
							carts.setQuantity(Integer.valueOf(number));
							carts.setSku(Integer.valueOf(Integer.parseInt(skuId)));
							if (hishopSkus.getShopId() != null) {
								carts.setShopId(hishopSkus.getShopId());
							}
							carts.setUserId(Integer.valueOf(userId));
							this.baseService.save(carts);
							this.form.setJsonMsg("加入购物车成功", true, json, 200);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}
	/**
	 * 删除购物车产品
	 * @return
	 */
	public String delete_car_product() {
		Map json = new HashMap();
		try {
			if (this.form.getProductId() == null) {
				this.form.setJsonMsg("productId不能为空", false, json, 1001);
			} else if ((this.form.getSkuId() == null) || (this.form.getSkuId().isEmpty())) {
				this.form.setJsonMsg("skuId不能为空", false, json, 1001);
			} else {
				YAccount account = getUserInfo();
				if (account == null) {
					this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
				} else {
					int userId = account.getUsers().getUserId().intValue();
					String skuId = this.form.getSkuId();
					int productId = this.form.getProductId().intValue();
					ShoppingCarts shoppingCarts = (ShoppingCarts) this.baseService
							.bean(" from ShoppingCarts as hsc where hsc.userId = " + userId + " and hsc.sku=" + skuId
									+ " and hsc.productId=" + productId);
					if (shoppingCarts == null) {
						this.form.setJsonMsg("购物车产品信息不存在", true, json, 1001);
					} else {
						this.baseService.delete(shoppingCarts);
						this.form.setJsonMsg("删除购物车产品成功", true, json, 200);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}
	/**
	 * 更新购物车产品数量
	 * @return
	 */
	public String update_car_product_quantity() {
		Map json = new HashMap();
		try {
			if ((this.form.getSkuId() == null) || (this.form.getSkuId().isEmpty())) {
				this.form.setJsonMsg("skuId不能为空", false, json, 1001);
			} else if (this.form.getSkuNumber() == null) {
				this.form.setJsonMsg("skuNumber不能为空", false, json, 1001);
			} else {
				String[] skuIds = this.form.getSkuId().split("|");
				String[] skuNumbers = this.form.getSkuNumber().split("|");
				if (skuIds.length != skuNumbers.length) {
					this.form.setJsonMsg("数据格式错误", false, json, 1001);
				} else {
					YAccount account = getUserInfo();
					if (account == null) {
						this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
					} else {
						int userId = account.getUsers().getUserId().intValue();
						StringBuffer sbHql = new StringBuffer(" select count(*) from ShoppingCarts as hsc where ");
						for (String string : skuIds) {
							sbHql.append(" hsc.sku = '" + string + "' or ");
						}
						sbHql.delete(sbHql.length() - 3, sbHql.length());
						int count = this.baseService.count(sbHql.toString() + " and hsc.userId = " + userId);
						if (count != skuIds.length) {
							this.form.setJsonMsg("购物车有部分产品已经被删除了，请刷新购物车后重试！", false, json, 1001);
						} else {
							String message = "";
							for (int i = 0; i < skuIds.length; i++) {
								Sku hishopSkus = (Sku) this.baseService
										.bean(" from Sku as hs where hs.sku = '" + skuIds[i] + "'");
								if (skuNumbers.length > hishopSkus.getStock().intValue()) {
									message = message + "商品货号:" + hishopSkus.getSku() + "   购买数量不能大于库存数量:"
											+ hishopSkus.getStock() + "  请修改购买数量后重试!";
									break;
								}
							}
							if (message.length() > 5)
								this.form.setJsonMsg(message, false, json, 1001);
							else
								for (int i = 0; i < skuIds.length; i++) {
									ShoppingCarts hsc = (ShoppingCarts) this.baseService
											.bean(" from ShoppingCarts as hsc where hsc.sku = '" + skuIds[i]
													+ "' and hsc.userId = " + userId);
									hsc.setQuantity(Integer.valueOf(Integer.parseInt(skuNumbers[i])));
									this.baseService.save(hsc);
									this.form.setJsonMsg("修改成功", true, json, 200);
								}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}
	/**
	 * 用户购物车的所有产品
	 * @return
	 */
	public String user_car_product() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else {
				int userId = account.getUsers().getUserId().intValue();
				List lsitHishopShoppingCarts = this.baseService.findAll(
						" from ShoppingCarts as sc where sc.userId = " + userId + " order by sc.lineItemId desc ");
				for (int i = 0; i < lsitHishopShoppingCarts.size(); i++) {
					ShoppingCarts hishopShoppingCarts = (ShoppingCarts) lsitHishopShoppingCarts.get(i);
					Products products = (Products) this.baseService
							.bean(" from Products as hp where hp.productId = " + hishopShoppingCarts.getProductId());

					Sku sku = (Sku) this.baseService.bean(" from Sku as hs where hs.productId =" + products.getProductId()
							+ " and hs.sku = '" + hishopShoppingCarts.getSku() + "'");
					products.setSku(sku);
					List listProducts = new ArrayList();
					listProducts.add(products);
					hishopShoppingCarts.setListProducts(listProducts);
					lsitHishopShoppingCarts.set(i, hishopShoppingCarts);
				}
				if ((lsitHishopShoppingCarts != null) && (lsitHishopShoppingCarts.size() > 0)) {
					for (int i = 0; i < lsitHishopShoppingCarts.size(); i++) {
						ShoppingCarts carts = (ShoppingCarts) lsitHishopShoppingCarts.get(i);
						YShop supplier = (YShop) this.baseService.bean(" from YShop as s where s.shopId = "
								+ ((Products) carts.getListProducts().get(0)).getShopId());
						carts.setyShop(supplier);
						lsitHishopShoppingCarts.set(i, carts);
					}
				}
				json.put("listInfo", lsitHishopShoppingCarts);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}
}
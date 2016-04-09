package com.zgld.api.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zgld.api.beans.Products;
import com.zgld.api.beans.ShoppingCarts;
import com.zgld.api.beans.Sku;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YShop;

public class CarAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 加入产品到购物车
	 * 
	 * @return
	 */
	public String add_product_car() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			// if (form.getSkuId() == null) {
			// form.setJsonMsg("skuId不能为空", false, json, 1001);
			// } else if (form.getProductId() == null ||
			// form.getSkuId().isEmpty()) {
			// form.setJsonMsg("productuId不能为空", false, json, 1001);
			// } else if (form.getNumber() == null) {
			// form.setJsonMsg("number不能为空", false, json, 1001);
			// } else {
			// AspnetUsers aspnetUsers = getUserInfo();
			// if (aspnetUsers == null) {
			// form.setJsonMsg(NO_USER, false, json, 201);
			// } else {
			// int userId = aspnetUsers.getUserId();
			// String skuId = form.getSkuId();
			// int productId = form.getProductId();
			// int number = form.getNumber();
			// HishopSkus hishopSkus = (HishopSkus)
			// baseBiz.bean(" from HishopSkus as hs where hs.skuId = '" + skuId
			// + "' and hs.productId = " + productId);
			// if (hishopSkus == null) {
			// form.setJsonMsg("产品信息不存在", true, json, 1001);
			// } else if (number > hishopSkus.getStock()) {
			// form.setJsonMsg("购买数量不能大于库存数量:" + hishopSkus.getStock(), true,
			// json, 1001);
			// } else {
			// HishopShoppingCarts hishopShoppingCarts = (HishopShoppingCarts)
			// baseBiz.bean(" from HishopShoppingCarts as sc where sc.skuId = '"
			// + skuId + "' and sc.productId = " + productId);
			// if (hishopShoppingCarts != null) {
			// if (hishopShoppingCarts.getQuantity() + number >
			// hishopSkus.getStock()) {
			// form.setJsonMsg("购买数量不能大于库存数量:" + hishopSkus.getStock(), true,
			// json, 1001);
			// } else {
			// hishopShoppingCarts.setQuantity(hishopShoppingCarts.getQuantity()
			// + number);
			// baseBiz.update(hishopShoppingCarts);
			// form.setJsonMsg("添加成功", true, json, 200);
			// }
			// } else {
			// HishopShoppingCarts carts = new HishopShoppingCarts();
			// carts.setAddTime(new Date());
			// carts.setProductId(productId);
			// carts.setQuantity(number);
			// carts.setSkuId(skuId);
			// carts.setUserId(userId);
			// baseBiz.save(carts);
			// form.setJsonMsg("添加成功", true, json, 200);
			// }
			// }
			// }
			// }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 删除购物车产品
	 * 
	 * @return
	 */
	public String delete_car_product() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			if (form.getProductId() == null) {
				form.setJsonMsg("productId不能为空", false, json, 1001);
			} else if (form.getSkuId() == null || form.getSkuId().isEmpty()) {
				form.setJsonMsg("skuId不能为空", false, json, 1001);
			} else {
				YAccount account = getUserInfo();
				if (account == null) {
					form.setJsonMsg(NO_USER, false, json, 201);
				} else {
					int userId = account.getUsers().getUserId();
					String skuId = form.getSkuId();
					int productId = form.getProductId();
					ShoppingCarts shoppingCarts = (ShoppingCarts) baseBiz.bean(" from ShoppingCarts as hsc where hsc.userId = " + userId + " and hsc.sku='" + skuId + "' and hsc.productId=" + productId);
					if (shoppingCarts == null) {
						form.setJsonMsg("购物车产品信息不存在", true, json, 1001);
					} else {
						baseBiz.delete(shoppingCarts);
						form.setJsonMsg("删除成功", true, json, 200);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 更新购物车产品数量
	 * 
	 * @return
	 */
	public String update_car_product_quantity() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			if (form.getSkuId() == null || form.getSkuId().isEmpty()) {
				form.setJsonMsg("skuId不能为空", false, json, 1001);
			} else if (form.getSkuNumber() == null) {
				form.setJsonMsg("skuNumber不能为空", false, json, 1001);
			} else {
				String skuIds[] = form.getSkuId().split("|");
				String skuNumbers[] = form.getSkuNumber().split("|");
				if (skuIds.length != skuNumbers.length) {
					form.setJsonMsg("数据格式错误", false, json, 1001);
				} else {
					YAccount account = getUserInfo();
					if (account == null) {
						form.setJsonMsg(NO_USER, false, json, 201);
					} else {
						int userId = account.getUsers().getUserId();
						StringBuffer sbHql = new StringBuffer(" select count(*) from ShoppingCarts as hsc where ");
						for (String string : skuIds) {
							sbHql.append(" hsc.sku = '" + string + "' or ");
						}
						sbHql.delete(sbHql.length() - 3, sbHql.length());
						int count = baseBiz.count(sbHql.toString() + " and hsc.userId = " + userId);
						if (count != skuIds.length) {
							form.setJsonMsg("购物车有部分产品已经被删除了，请刷新购物车后重试！", false, json, 1001);
						} else {
							String message = "";
							for (int i = 0; i < skuIds.length; i++) {
								Sku hishopSkus = (Sku) baseBiz.bean(" from Sku as hs where hs.sku = '" + skuIds[i] + "'");
								if (skuNumbers.length > hishopSkus.getStock()) {
									message += "商品货号:" + hishopSkus.getSku() + "   购买数量不能大于库存数量:" + hishopSkus.getStock() + "  请修改购买数量后重试!";
									break;
								}
							}
							if (message.length() > 5) {
								form.setJsonMsg(message, false, json, 1001);
							} else {
								for (int i = 0; i < skuIds.length; i++) {
									ShoppingCarts hsc = (ShoppingCarts) baseBiz.bean(" from ShoppingCarts as hsc where hsc.sku = '" + skuIds[i] + "' and hsc.userId = " + userId);
									hsc.setQuantity(Integer.parseInt(skuNumbers[i]));
									baseBiz.save(hsc);
									form.setJsonMsg("修改成功", true, json, 200);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 查询用户购物车的所有产品
	 * 
	 * @return
	 */
	public String user_car_product() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				int userId = account.getUsers().getUserId();
				List<ShoppingCarts> lsitHishopShoppingCarts = (List<ShoppingCarts>) baseBiz.findAll(" from ShoppingCarts as sc where sc.userId = " + userId + " order by sc.addTime desc ");
				for (int i = 0; i < lsitHishopShoppingCarts.size(); i++) {
					ShoppingCarts hishopShoppingCarts = lsitHishopShoppingCarts.get(i);
					Products products = (Products) baseBiz.bean(" from Products as hp where hp.productId = " + hishopShoppingCarts.getProductId());
					// 产品价格
					Sku sku = (Sku) baseBiz.bean(" from Sku as hs where hs.productId =" + products.getProductId() + " and hs.sku = '" + hishopShoppingCarts.getSku() + "'");
					products.setSku(sku);
					List<Products> listProducts = new ArrayList<Products>();
					listProducts.add(products);
					hishopShoppingCarts.setListProducts(listProducts);
					lsitHishopShoppingCarts.set(i, hishopShoppingCarts);
				}
				if (lsitHishopShoppingCarts != null && lsitHishopShoppingCarts.size() > 0) {
					for (int i = 0; i < lsitHishopShoppingCarts.size(); i++) {
						ShoppingCarts carts = lsitHishopShoppingCarts.get(i);
						YShop supplier = (YShop) baseBiz.bean(" from YShop as s where s.shopId = " + carts.getListProducts().get(0).getShopId());
						carts.setyShop(supplier);
						lsitHishopShoppingCarts.set(i, carts);
					}
				}
				json.put(LISTINFO, lsitHishopShoppingCarts);
				form.setJsonMsg(SUCCESS, true, json, 200);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

}

package com.zgld.api.action;

import com.zgld.api.beans.Products;
import com.zgld.api.beans.ShoppingCarts;
import com.zgld.api.beans.Sku;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YFormCombine;
import com.zgld.api.beans.YFormCombineValue;
import com.zgld.api.beans.YFormTag;
import com.zgld.api.beans.YFormValue;
import com.zgld.api.beans.YShop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	/**
	 * 添加产品到购物车
	 * 
	 * @return
	 */
	public String add_product_car() {
		Map json = new HashMap();
		try {
			if (this.form.getProductId() == null) {
				this.form.setJsonMsg("productuId不能为空", false, json, 1001);
			} else if (this.form.getNumber() == null) {
				this.form.setJsonMsg("number不能为空", false, json, 1001);
			} else {
				YAccount account = getUserInfo();
				if (account != null) {
					int userId = account.getUsers().getUserId().intValue();
					int productId = this.form.getProductId().intValue();
					int number = this.form.getNumber().intValue();
					String skuId = this.form.getSkuId();
					if (skuId != null && !skuId.isEmpty()) {

						YFormCombineValue hishopSkus = (YFormCombineValue) this.baseService
								.bean(" from YFormCombineValue as fcv where fcv.objTable = 'Products' and fcv.combineValueId = " + skuId + " and fcv.objId = " + productId);
						if (hishopSkus == null) {
							this.form.setJsonMsg("产品信息不存在", true, json, 1001);
						} else if (number > hishopSkus.getGoStore().intValue()) {
							this.form.setJsonMsg("购买数量不能大于库存数量:" + hishopSkus.getGoStore(), true, json, 1001);
						} else {
							ShoppingCarts hishopShoppingCarts = (ShoppingCarts) this.baseService
									.bean(" from ShoppingCarts as sc where sc.sku = " + skuId + " and sc.userId = " + userId + " and sc.productId = " + productId);
							if (hishopShoppingCarts != null) {
								if (hishopShoppingCarts.getQuantity().intValue() + number > hishopSkus.getGoStore().intValue()) {
									this.form.setJsonMsg("购买数量不能大于库存数量:" + hishopSkus.getGoStore(), true, json, 1001);
								} else {
									hishopShoppingCarts.setQuantity(Integer.valueOf(hishopShoppingCarts.getQuantity().intValue() + number));
									this.baseService.update(hishopShoppingCarts);
									this.form.setJsonMsg("加入购物车成功", true, json, 200);
								}
							} else {
								ShoppingCarts carts = new ShoppingCarts();
								Products product = (Products) baseService.bean(" from Products as p where p.productId = " + productId);
								carts.setProductId(Integer.valueOf(productId));
								carts.setQuantity(Integer.valueOf(number));
								carts.setSku(Integer.valueOf(Integer.parseInt(skuId)));
								if (product.getShopId() != null) {
									carts.setShopId(product.getShopId());
								}
								carts.setUserId(Integer.valueOf(userId));
								this.baseService.save(carts);
								this.form.setJsonMsg("加入购物车成功", true, json, 200);
							}
						}
					} else {
						Products product = (Products) baseService.bean(" from Products as f where f.productId = " + productId);
						ShoppingCarts hishopShoppingCarts = (ShoppingCarts) this.baseService.bean(" from ShoppingCarts as sc where sc.userId = " + userId + " and sc.productId = " + productId);
						if (hishopShoppingCarts != null) {
							if (hishopShoppingCarts.getQuantity().intValue() + number > product.getStock().intValue()) {
								this.form.setJsonMsg("购买数量不能大于库存数量:" + product.getStock(), true, json, 1001);
							} else {
								hishopShoppingCarts.setQuantity(Integer.valueOf(hishopShoppingCarts.getQuantity().intValue() + number));
								this.baseService.update(hishopShoppingCarts);
								this.form.setJsonMsg("加入购物车成功", true, json, 200);
							}
						} else {
							ShoppingCarts carts = new ShoppingCarts();
							carts.setProductId(Integer.valueOf(productId));
							carts.setQuantity(Integer.valueOf(number));
							if (skuId != null && !skuId.isEmpty()) {
								carts.setSku(Integer.valueOf(Integer.parseInt(skuId)));
							}
							if (product.getShopId() != null) {
								carts.setShopId(product.getShopId());
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
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 删除购物车产品
	 * 
	 * @return
	 */
	public String delete_car_product() {
		Map json = new HashMap();
		try {
			if (this.form.getProductId() == null) {
				this.form.setJsonMsg("productId不能为空", false, json, 1001);
			} else {
				YAccount account = getUserInfo();
				if (account != null) {
					int userId = account.getUsers().getUserId().intValue();
					String skuId = this.form.getSkuId();
					int productId = this.form.getProductId().intValue();
					String hql = " from ShoppingCarts as hsc where hsc.userId = " + userId + " and hsc.productId=" + productId;
					if(skuId!=null && !skuId.isEmpty()){
						hql = hql+" and hsc.sku=" + skuId;
					}
					ShoppingCarts shoppingCarts = (ShoppingCarts) this.baseService
							.bean(hql);
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
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 更新购物车产品数量
	 * 
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
					if (account != null) {
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
								YFormCombineValue hishopSkus = (YFormCombineValue) this.baseService
										.bean(" from YFormCombineValue as fcv where fcv.objTable = 'Products' and fcv.combineValueId = " + skuIds[i]);
								if (skuNumbers.length > hishopSkus.getGoStore().intValue()) {
									message = message + "商品货号:" + hishopSkus.getObjId() + "   购买数量不能大于库存数量:" + hishopSkus.getGoStore() + "  请修改购买数量后重试!";
									break;
								}
							}
							if (message.length() > 5)
								this.form.setJsonMsg(message, false, json, 1001);
							else
								for (int i = 0; i < skuIds.length; i++) {
									ShoppingCarts hsc = (ShoppingCarts) this.baseService.bean(" from ShoppingCarts as hsc where hsc.sku = '" + skuIds[i] + "' and hsc.userId = " + userId);
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
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 用户购物车的所有产品
	 * 
	 * @return
	 */
	public String user_car_all_product() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				List<YShop> listShop = new ArrayList<>();
				int userId = account.getUsers().getUserId().intValue();
				List lsitHishopShoppingCarts = this.baseService.findAll(" from ShoppingCarts as sc where sc.userId = " + userId + " order by sc.shopId desc,sc.lineItemId desc ");
				int shopId = 0;
				YShop shop = null;
				if (lsitHishopShoppingCarts != null && lsitHishopShoppingCarts.size() > 0) {
					ShoppingCarts ca = (ShoppingCarts) lsitHishopShoppingCarts.get(0);
					shopId = ca.getShopId();
					shop = (YShop) this.baseService.bean(" from YShop as s where s.shopId = " + shopId);
				}
				List<ShoppingCarts> listCarts = new ArrayList<>();
				for (int i = 0; i < lsitHishopShoppingCarts.size(); i++) {
					ShoppingCarts hishopShoppingCarts = (ShoppingCarts) lsitHishopShoppingCarts.get(i);
					int productId = hishopShoppingCarts.getProductId();
					Products products = (Products) this.baseService.bean(" from Products as hp where hp.productId = " + productId);
					String hqlFormcombineValue = " from YFormCombineValue as fcv where fcv.objTable = 'Products' and fcv.objId = " + productId;
					if (hishopShoppingCarts.getSku() != null && hishopShoppingCarts.getSku() > 0) {
						hqlFormcombineValue = hqlFormcombineValue + " and fcv.combineValueId = " + hishopShoppingCarts.getSku();
					}
					YFormCombineValue formCombineValue = (YFormCombineValue) this.baseService.bean(hqlFormcombineValue);
					String str = "";
					if (formCombineValue != null) {
						List<?> listObj = baseService.findAll(" from YFormCombine fc,YFormValue as fv,YFormTag as ft where fv.tagId = ft.tagId and fv.objTable = 'Products' and fv.objId = "
								+ productId + " and fv.tagFieldName = fc.tagFieldName and fc.objTable = 'Products' and fc.objId = " + productId + " and fc.combineString = '"
								+ formCombineValue.getCombineString() + "'");
						for (Object object : listObj) {
							Object obj[] = (Object[]) object;
							YFormCombine fc = (YFormCombine) obj[0];
							YFormValue fv = (YFormValue) obj[1];
							YFormTag ft = (YFormTag) obj[2];
							str = str + ft.getTagName() + ":" + fc.getControlName() + ";";
						}
					} else {
						str = products.getShortDescription();
					}
					products.setSelectStr(str);
					products.setFormCombineValue(formCombineValue);
					if (shopId == hishopShoppingCarts.getShopId()) {
						hishopShoppingCarts.setProducts(products);
						listCarts.add(hishopShoppingCarts);
					} else {
						if (listCarts != null && listCarts.size() > 0) {
							shop.setListShoppingCarts(listCarts);
							listShop.add(shop);
							listCarts = new ArrayList<>();
							shop = new YShop();
						}
						shopId = hishopShoppingCarts.getShopId();
						hishopShoppingCarts.setProducts(products);
						listCarts.add(hishopShoppingCarts);
					}
				}
				if(shopId>0){
					shop = (YShop) this.baseService.bean(" from YShop as s where s.shopId = " + shopId);
					if(shop!=null){
						shop.setListShoppingCarts(listCarts);
						listShop.add(shop);
					}
				}
				listCarts = new ArrayList<>();
				shop = new YShop();
				json.put(LISTINFO, listShop);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
}
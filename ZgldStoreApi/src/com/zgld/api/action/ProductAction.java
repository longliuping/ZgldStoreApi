package com.zgld.api.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zgld.api.beans.Categories;
import com.zgld.api.beans.Products;
import com.zgld.api.beans.Sku;
import com.zgld.api.beans.YShop;

public class ProductAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 根据分类id 查询产品列表
	 * 
	 * @return
	 */
	public String home_type_product() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			if (form.getId() == null || form.getId() <= 0) {
				form.setJsonMsg("产品类型id不能为空", false, json);
			} else {
				List<Products> listProducts = (List<Products>) baseBiz.findPage(form.getPageNum(), form.getPageSize(), " from Products as p where p.categoryId = " + form.getId() + " order by p.addedDate desc ");
				json.put(LISTINFO, listProducts);
				form.setJsonMsg(SUCCESS, true, json, 200);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 产品详细页面
	 */
	public String product_detail() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			if (form.getId() == null) {
				form.setJsonMsg("产品id不能为空", false, json, 1001);
			} else {
				int productId = form.getId();
				// 查询产品详细
				Products product = (Products) baseBiz.bean(" from Products as p where p.productId = " + productId);
				YShop info = (YShop) baseBiz.bean(" from YShop as s where s.shopId = " + product.getShopId());
				// 规格
				List<Sku> listSkus = (List<Sku>) baseBiz.findAll(" from Sku as s where s.productId = " + productId);
				product.setListSkus(listSkus);
				info.setProducts(product);
				json.put(INFO, info);
				form.setJsonMsg(SUCCESS, true, json, 200);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 查询每一个分类产品
	 * 
	 * @return
	 */
	public String home_all_product() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			List<Categories> listCategories = (List<Categories>) baseBiz.findAll(" from Categories as hc where hc.depth = 1");
			for (int i = 0; i < listCategories.size(); i++) {
				listCategories.get(i).setListProducts((List<Products>) baseBiz.findPage(1, 3, " from Products as hp where pc.categoryId =" + listCategories.get(i).getCategoryId() + " order by hp.addedDate asc "));
			}
			json.put(LISTINFO, listCategories);
			form.setJsonMsg(SUCCESS, true, json, 200);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

}

package com.zgld.api.action;

import com.zgld.api.base.BaseForm;
import com.zgld.api.beans.Categories;
import com.zgld.api.beans.Products;
import com.zgld.api.beans.Sku;
import com.zgld.api.beans.Skugroup;
import com.zgld.api.beans.YShop;
import com.zgld.api.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 产品action
 * @author Am
 *
 */
public class ProductAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	/**
	 * 根据分类ID查询产品信息
	 * @return
	 */
	public String home_type_product() {
		Map json = new HashMap();
		try {
			if ((this.form.getId() == null) || (this.form.getId().intValue() <= 0)) {
				this.form.setJsonMsg("产品类型id不能为空", false, json);
			} else {
				List listProducts = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(), " from Products as p where p.categoryId = "
								+ this.form.getId() + " order by p.addedDate desc ");
				json.put("listInfo", listProducts);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
	/**
	 * 产品详情
	 * @return
	 */
	public String product_detail() {
		Map json = new HashMap();
		try {
			if (this.form.getId() == null) {
				this.form.setJsonMsg("产品id不能为空", false, json, 1001);
			} else {
				int productId = this.form.getId().intValue();

				Products product = (Products) this.baseService.bean(" from Products as p where p.productId = " + productId);
				if (product == null) {
					this.form.setJsonMsg("产品不存在", false, json, 1001);
				} else {
					List listImages = this.baseService
							.findAll(" from ProductImages as pi where pi.productId = " + product.getProductId());
					product.setListProductImages(listImages);
					YShop info = (YShop) this.baseService.bean(" from YShop as s where s.shopId = " + product.getShopId());
					List<Skugroup> listSkugroups = (List<Skugroup>) this.baseService
							.findAll(" from Skugroup as sg where sg.productId = " + productId);
					for (int i = 0; i < listSkugroups.size(); i++) {
						List<Sku> listSku = (List<Sku>) this.baseService.findAll(" from Sku as s where s.skugroupId = "
								+ ((Skugroup) listSkugroups.get(i)).getSkugroupId());
						listSkugroups.get(i).setListSkus(listSku);
					}
					product.setListSkugroups(listSkugroups);
					info.setProducts(product);
					json.put("info", info);
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
	 * 每一个分类下的前几条数据
	 * @return
	 */
	public String home_all_product() {
		Map json = new HashMap();
		try {
			List listCategories = this.baseService.findAll(" from Categories as hc ");
			for (int i = 0; i < listCategories.size(); i++) {
				String hql = " from Products as hp where hp.categoryId ="
						+ ((Categories) listCategories.get(i)).getCategoryId() + " order by hp.addedDate asc ";
				List listInfo = this.baseService.findPage(1, 6, hql);
				((Categories) listCategories.get(i)).setListProducts(listInfo);
			}
			json.put("listInfo", listCategories);
			this.form.setJsonMsg("success", true, json, 200);
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
}
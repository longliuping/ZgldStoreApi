package com.zgld.api.action;

import com.zgld.api.beans.Categories;
import com.zgld.api.beans.Products;
import com.zgld.api.beans.Sku;
import com.zgld.api.beans.Skugroup;
import com.zgld.api.beans.YFormCombine;
import com.zgld.api.beans.YFormCombineValue;
import com.zgld.api.beans.YFormControl;
import com.zgld.api.beans.YFormTag;
import com.zgld.api.beans.YFormValue;
import com.zgld.api.beans.YShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品action
 * 
 * @author Am
 *
 */
public class ProductAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	/**
	 * 根据分类ID查询产品信息
	 * 
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
				json.put(LISTINFO, listProducts);
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
	 * 
	 * @return
	 */
	public String product_detail() {
		Map json = new HashMap();
		try {
			if (this.form.getId() == null) {
				this.form.setJsonMsg("产品id不能为空", false, json, 1001);
			} else {
				int productId = this.form.getId().intValue();
				Products product = (Products) this.baseService
						.bean(" from Products as p where p.productId = " + productId);
				if (product == null) {
					this.form.setJsonMsg("产品不存在", false, json, 1001);
				} else {
					List listImages = this.baseService
							.findAll(" from ProductImages as pi where pi.productId = " + product.getProductId());
					product.setListProductImages(listImages);
					YShop info = (YShop) this.baseService
							.bean(" from YShop as s where s.shopId = " + product.getShopId());
					List<YFormTag> listFormTag = new ArrayList<>();
					List<?> list = baseService.findAll(" from YFormValue as fv,YFormTag as ft where fv.tagId = ft.tagId and fv.objTable = 'Products' and fv.objId = "+productId);
					for (Object object : list) {
						Object obj[] = (Object[])object;
						YFormValue fv = (YFormValue)obj[0];
						YFormTag ft = (YFormTag)obj[1];
						ft.setFormValue(fv);
						StringBuffer hql = new StringBuffer(" from YFormControl as fc where fc.tagId = "+fv.getTagId());
						List<YFormCombine> listFormCombine = (List<YFormCombine>)baseService.findAll(" from YFormCombine as fc where fc.tagFieldName = '"+fv.getTagFieldName()+"' and fc.objTable = 'Products' and fc.objId = "+productId);
						if(listFormCombine!=null && listFormCombine.size()>0){
							hql.append(" and (");
						}
						for (YFormCombine form : listFormCombine) {
							hql.append(" fc.controlValue = " + form.getControlValue() + " or ");
						}
						if(listFormCombine!=null && listFormCombine.size()>0){
							hql.delete(hql.length() - 3, hql.length());
							hql.append(" ) ");
						}
						List<YFormControl> listFormControl = (List<YFormControl>)baseService.findAll(hql.toString());
						ft.setListFormControl(listFormControl);
						listFormTag.add(ft);
					}
					List<YFormCombine> listFormCombine = (List<YFormCombine>)baseService.findAll(" from YFormCombine as fc where fc.objTable = 'Products' and fc.objId = "+productId);
					List<YFormCombineValue> listFormCombineValue = (List<YFormCombineValue>)baseService.findAll(" from YFormCombineValue as fcv where fcv.objTable = 'Products' and fcv.objId = "+productId);
					product.setListFormTag(listFormTag);
					product.setListFormCombine(listFormCombine);
					product.setListFormCombineValue(listFormCombineValue);
					info.setProducts(product);
					json.put(INFO, info);
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
	 * 
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
			json.put(LISTINFO, listCategories);
			this.form.setJsonMsg("success", true, json, 200);
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
}
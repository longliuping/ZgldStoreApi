package com.zgld.api.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zgld.api.beans.Products;

/**
 * 商家action
 * 
 * @author Am
 *
 */
public class SupplierAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 商家的产品
	 * 
	 * @return
	 */
	public String supplier_product() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			if(form.getShopId()==null){
				this.form.setJsonMsg("shopId不能为空", false, json, 1001);
			}else{
				List<Products> listInfo = (List<Products>) baseService.findPage(form.getPageNum(), form.getPageSize()," from Products as hp where hp.shopId = " + form.getShopId());
				json.put(LISTINFO, listInfo);
				form.setJsonMsg(SUCCESS, true, json, 200);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	public String hot_supplier() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			// List<SupperHot> listSupperHots = (List<SupperHot>)
			// baseService.findPage(form.getPageNum(), form.getPageSize(),
			// " from SupperHot as sh where sh.hotid = " + form.getHotid());
			// List<Supplier> listInfo = new ArrayList<Supplier>();
			// if (listSupperHots != null && listSupperHots.size() > 0) {
			// StringBuffer sb = new StringBuffer(" from Supplier as s where ");
			// for (int i = 0; i < listSupperHots.size(); i++) {
			// SupperHot supperHot = listSupperHots.get(i);
			// sb.append(" s.userId = " + supperHot.getUserid() + " or ");
			// }
			// sb.delete(sb.toString().length() - 3, sb.toString().length());
			// listInfo = (List<Supplier>) baseService.findAll(sb.toString());
			// }
			// json.put(LISTINFO, listInfo);
			// form.setJsonMsg(SUCCESS, true, json, 200);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 根据地址和热门标签查询商家
	 * 
	 * @return
	 */
	public String hot_area_supplier() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			// List<Supplier> listInfo = new ArrayList<Supplier>();
			// List<?> obj = baseService.findPage(form.getPageNum(),
			// form.getPageSize(),
			// " from Supplier as s,SupperArea as sa,SupperHot as sh where
			// s.userId = sa.userid and sa.userid = sh.userid and sa.areaid = "
			// + form.getAreaid() + " and sh.hotid = " + form.getHotid());
			// for (Object object : obj) {
			// listInfo.add((Supplier) ((Object[]) object)[0]);
			// }
			// json.put(LISTINFO, listInfo);
			// form.setJsonMsg(SUCCESS, true, json, 200);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
}

package com.zgld.api.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zgld.api.beans.Products;
import com.zgld.api.beans.ShopArea;
import com.zgld.api.beans.UserProfile;
import com.zgld.api.beans.Users;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YShop;
import com.zgld.api.utils.PriceUtil;

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
			if (form.getShopId() == null) {
				this.form.setJsonMsg("shopId不能为空", false, json, 1001);
			} else {
				List<Products> listInfo = (List<Products>) baseService.findPage(form.getPageNum(), form.getPageSize(),
						" from Products as hp where hp.shopId = " + form.getShopId());
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

	// public String hot_supplier() {
	// Map<String, Object> json = new HashMap<String, Object>();
	// try {
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
	// } catch (Exception e) {
	// // TODO: handle exception
	// e.printStackTrace();
	// form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
	// }
	// return JSON_PAGE;
	// }

	/**
	 * 根据地址和热门标签查询商家
	 * 
	 * @return
	 */
	public String hot_area_supplier() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			List<YShop> listInfo = new ArrayList<YShop>();
			List<?> obj = baseService.findPage(form.getPageNum(), form.getPageSize(),
					" from YShop as s,ShopArea as sa,ShopHot as sh where s.shopId = sa.shopId and sa.shopId = sh.shopId and sa.areaId = "
							+ form.getAreaid() + " and sh.hotId = " + form.getHotid());
			for (Object object : obj) {
				listInfo.add((YShop) ((Object[]) object)[0]);
			}
			json.put(LISTINFO, listInfo);
			form.setJsonMsg(SUCCESS, true, json, 200);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	public String offline_payment() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				YShop shop = (YShop) baseService.bean(" from YShop as s where s.shopId = " + form.getShopId());
				if (shop == null) {
					this.form.setJsonMsg("商家不存在", false, json, 1001);
				} else {
					UserProfile userProfile = (UserProfile) this.baseService
							.bean(" from UserProfile as p where p.userId = " + shop.getUserId());
					if (userProfile == null) {
						this.form.setJsonMsg("商户已被删除", false, json, 1001);
					} else if (form.getMoney() == null) {
						this.form.setJsonMsg("money不能为空", false, json, 1001);
					} else if (userProfile.getBalance() < form.getMoney()) {
						this.form.setJsonMsg("商户账户余额不足" + PriceUtil.price(form.getMoney()) + ",请提醒商户充值！", false, json,
								1001);
					} else {
						form.setJsonMsg("提交成功，等待商户审核!", true, json, 200);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
}

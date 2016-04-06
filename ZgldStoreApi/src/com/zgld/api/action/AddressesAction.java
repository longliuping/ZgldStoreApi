package com.zgld.api.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zgld.api.beans.UserShippingAddresses;
import com.zgld.api.beans.YAccount;

public class AddressesAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 删除用户收货地址信息
	 * 
	 * @return
	 */
	public String delete_user_shipping_addresses() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				int userId = account.getUsers().getUserId();
				UserShippingAddresses info = (UserShippingAddresses) baseBiz
						.bean(" from UserShippingAddresses as hu where hu.userId = "
								+ userId
								+ " and hu.addressId = "
								+ form.getAddress().getAddressId());
				if (info == null) {
					form.setJsonMsg("要删除的地址信息不存在", false, json, 1001);
				} else {
					baseBiz.delete(info);
					form.setJsonMsg("删除成功", true, json, 200);
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
	 * 添加收货地址
	 * 
	 * @return
	 */
	public String add_user_shipping_addresses() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			UserShippingAddresses info = form.getAddress();
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				int userId = account.getUsers().getUserId();
				if (info.getRegionId() == null) {
					form.setJsonMsg("address.regionId不能为空", false, json, 1001);
				} else if (info.getShipTo() == null) {
					form.setJsonMsg("address.shipTo不能为空", false, json, 1001);
				} else if (info.getAddress() == null) {
					form.setJsonMsg("address.address不能为空", false, json, 1001);
				} else if (info.getZipcode() == null) {
					form.setJsonMsg("address.zipcode不能为空", false, json, 1001);
					// } else if (info.getTelPhone() == null) {
					// form.setJsonMsg("address.telPhone不能为空", false, json,
					// 1001);
					// } else if (info.getCellPhone() == null) {
					// form.setJsonMsg("address.cellPhone不能为空", false, json,
					// 1001);
				} else {
					info.setUserId(userId);
					baseBiz.save(info);
					form.setJsonMsg("添加成功", true, json, 200);
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
	 * 用户 所有的收货地址
	 * 
	 * @return
	 */
	public String user_shipping_addresses() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				int userId = account.getUsers().getUserId();
				List<UserShippingAddresses> listInfo = (List<UserShippingAddresses>) baseBiz
						.findAll(" from UserShippingAddresses as hu where hu.userId = "
								+ userId);
				json.put(LISTINFO, listInfo);
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
	 * 修改用户收货地址信息
	 * 
	 * @return
	 */
	public String update_user_shipping_addresses() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				int userId = account.getUsers().getUserId();
				UserShippingAddresses obj = form.getAddress();
				if (obj.getAddressId() == null) {
					form.setJsonMsg("address.addressId不能为空", false, json, 1001);
				} else if (obj.getRegionId() == null) {
					form.setJsonMsg("address.regionId不能为空", false, json, 1001);
				} else if (obj.getShipTo() == null) {
					form.setJsonMsg("address.shipTo不能为空", false, json, 1001);
				} else if (obj.getAddress() == null) {
					form.setJsonMsg("address.address不能为空", false, json, 1001);
				} else if (obj.getZipcode() == null) {
					form.setJsonMsg("address.zipcode不能为空", false, json, 1001);
					// } else if (obj.getTelPhone() == null) {
					// form.setJsonMsg("address.telPhone不能为空", false, json,
					// 1001);
					// } else if (obj.getCellPhone() == null) {
					// form.setJsonMsg("address.cellPhone不能为空", false, json,
					// 1001);
				} else {
					UserShippingAddresses info = (UserShippingAddresses) baseBiz
							.bean(" from UserShippingAddresses as hu where hu.userId = "
									+ userId
									+ " and hu.addressId = "
									+ form.getAddress().getAddressId());
					if (info == null) {
						form.setJsonMsg("要修改的地址信息不存在", false, json, 1001);
					} else if (!info.getUserId().equals(userId)) {
						form.setJsonMsg("你没有权限修改", false, json, 1001);
					} else {
						info.setAddress(form.getAddress().getAddress());
						// info.setCellPhone(form.getAddress().getCellPhone());
						info.setRegionId(form.getAddress().getRegionId());
						info.setShipTo(form.getAddress().getShipTo());
						// info.setTelPhone(form.getAddress().getTelPhone());
						info.setZipcode(form.getAddress().getZipcode());
						baseBiz.update(info);
						form.setJsonMsg("修改成功", true, json, 200);
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
}

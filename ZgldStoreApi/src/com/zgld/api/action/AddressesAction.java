package com.zgld.api.action;
import com.zgld.api.beans.UserShippingAddresses;
import com.zgld.api.beans.YAccount;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressesAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	/**
	 * 删除用户收货地址
	 * @return
	 */
	public String delete_user_shipping_addresses() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else {
				int userId = account.getUsers().getUserId().intValue();
				UserShippingAddresses info = (UserShippingAddresses) this.baseService
						.bean(" from UserShippingAddresses as hu where hu.userId = " + userId + " and hu.addressId = "
								+ this.form.getAddress().getAddressId());
				if (info == null) {
					this.form.setJsonMsg("要删除的地址信息不存在", false, json, 1001);
				} else {
					this.baseService.delete(info);
					this.form.setJsonMsg("删除成功", true, json, 200);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}
	/**
	 * 添加用户收货地址
	 * @return
	 */
	public String add_user_shipping_addresses() {
		Map json = new HashMap();
		try {
			UserShippingAddresses info = this.form.getAddress();
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else {
				int userId = account.getUsers().getUserId().intValue();
				if (info.getRegionId() == null) {
					this.form.setJsonMsg("address.regionId不能为空", false, json, 1001);
				} else if (info.getShipTo() == null) {
					this.form.setJsonMsg("address.shipTo不能为空", false, json, 1001);
				} else if (info.getAddress() == null) {
					this.form.setJsonMsg("address.address不能为空", false, json, 1001);
				} else if (info.getZipcode() == null) {
					this.form.setJsonMsg("address.zipcode不能为空", false, json, 1001);
				} else if (info.getMobile() == null) {
					this.form.setJsonMsg("address.mobile不能为空", false, json, 1001);
				} else {
					info.setUserId(Integer.valueOf(userId));
					this.baseService.save(info);
					this.form.setJsonMsg("添加成功", true, json, 200);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}
	/**
	 * 用户所有的收货地址
	 * @return
	 */
	public String user_shipping_addresses() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else {
				int userId = account.getUsers().getUserId().intValue();
				List listInfo = this.baseService.findAll(" from UserShippingAddresses as hu where hu.userId = " + userId);
				json.put("listInfo", listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}
	/**
	 * 更新用户收货地址
	 * @return
	 */
	public String update_user_shipping_addresses() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else {
				int userId = account.getUsers().getUserId().intValue();
				UserShippingAddresses obj = this.form.getAddress();
				if (obj.getAddressId() == null) {
					this.form.setJsonMsg("address.addressId不能为空", false, json, 1001);
				} else if (obj.getRegionId() == null) {
					this.form.setJsonMsg("address.regionId不能为空", false, json, 1001);
				} else if (obj.getShipTo() == null) {
					this.form.setJsonMsg("address.shipTo不能为空", false, json, 1001);
				} else if (obj.getAddress() == null) {
					this.form.setJsonMsg("address.address不能为空", false, json, 1001);
				} else if (obj.getZipcode() == null) {
					this.form.setJsonMsg("address.zipcode不能为空", false, json, 1001);
				} else if (obj.getMobile() == null) {
					this.form.setJsonMsg("address.mobile不能为空", false, json, 1001);
				} else {
					UserShippingAddresses info = (UserShippingAddresses) this.baseService
							.bean(" from UserShippingAddresses as hu where hu.userId = " + userId
									+ " and hu.addressId = " + this.form.getAddress().getAddressId());
					if (info == null) {
						this.form.setJsonMsg("要修改的地址信息不存在", false, json, 1001);
					} else if (!info.getUserId().equals(Integer.valueOf(userId))) {
						this.form.setJsonMsg("你没有权限修改", false, json, 1001);
					} else {
						info.setAddress(this.form.getAddress().getAddress());
						info.setRegionId(this.form.getAddress().getRegionId());
						info.setShipTo(this.form.getAddress().getShipTo());
						info.setMobile(this.form.getAddress().getMobile());
						info.setZipcode(this.form.getAddress().getZipcode());
						this.baseService.update(info);
						this.form.setJsonMsg("修改成功", true, json, 200);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}
}
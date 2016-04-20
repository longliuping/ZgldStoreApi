package com.zgld.api.action;

import com.zgld.api.base.BaseForm;
import com.zgld.api.beans.UserProfile;
import com.zgld.api.beans.Users;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YRebateRelation;
import com.zgld.api.biz.BaseBiz;
import com.zgld.api.utils.EmailUtil;
import com.zgld.api.utils.ImageBase64;
import java.util.HashMap;
import java.util.Map;

public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	public String user_login() {
		Map json = new HashMap();
		try {
			if ((this.form.getName() == null) || (this.form.getName().isEmpty())) {
				this.form.setJsonMsg("用户名不能为空", false, json, 1001);
			} else if ((this.form.getPassword() == null) || (this.form.getPassword().isEmpty())) {
				this.form.setJsonMsg("密码不能为空", false, json, 1001);
			} else if (this.form.getId() == null) {
				this.form.setJsonMsg("id不能为空", false, json, 1001);
			} else {
				Object obj = this.baseBiz
						.bean(" from YAccount as y, Users as u,UserProfile as p where u.userId = p.userId and p.userId = y.accountId and y.accountName = '"
								+ this.form.getName() + "'");
				Object[] object = (Object[]) obj;
				if ((object == null) || (object.length < 0)) {
					this.form.setJsonMsg("用户名不存在", false, json, 1001);
				} else if (!this.form.getPassword().equals(((YAccount) object[0]).getAccountPassword())) {
					this.form.setJsonMsg("密码错误", false, json, 1001);
				} else {
					YAccount account = (YAccount) object[0];
					if (object.length > 1) {
						account.setUsers((Users) object[1]);
						if (object.length > 2) {
							account.setUserProfile((UserProfile) object[2]);
						}
					}
					json.put("info", account);
					this.form.setJsonMsg("登录成功", true, json, 200);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}

	public String user_register() {
		Map json = new HashMap();
		try {
			if ((this.form.getName() == null) || (this.form.getName().isEmpty())) {
				this.form.setJsonMsg("用户名name不能为空", false, json, 1001);
			} else if ((this.form.getPassword() == null) || (this.form.getPassword().isEmpty())) {
				this.form.setJsonMsg("密码password不能为空", false, json, 1001);
			} else if (this.form.getPassword().length() < 6) {
				this.form.setJsonMsg("密码password长度不能小于6位数", false, json, 1001);
			} else {
				YAccount user = this.baseBiz.findUserinfoByUserName(this.form.getName());
				if (user != null) {
					this.form.setJsonMsg("用户名已经存在", false, json, 1001);
				} else if ((this.form.getId() != null) && (this.form.getId().intValue() > 10)) {
					YAccount u = (YAccount) this.baseBiz
							.bean(" from YAccount as u where u.accountId = " + this.form.getId());
					if (u == null) {
						this.form.setJsonMsg("邀请码不存在", false, json, 1001);
					} else {
						YAccount account = reg_user();
						YRebateRelation re = new YRebateRelation();
						re.setParentUserId(this.form.getId());
						re.setCurrentUserId(account.getUserProfile().getUserId());
						this.baseBiz.save(re);
						json.put("info", account);
						this.form.setJsonMsg("注册成功", true, json, 200);
					}
				} else {
					json.put("info", reg_user());
					this.form.setJsonMsg("注册成功", true, json, 200);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}

	public String userinfo() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else {
				json.put("info", account);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}

	public String update_user_password() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else if (this.form.getOldPassword() == null) {
				this.form.setJsonMsg("密码oldPassword不能为空", false, json, 1001);
			} else if (this.form.getPassword() == null) {
				this.form.setJsonMsg("密码password不能为空", false, json, 1001);
			} else if (this.form.getPassword().length() < 6) {
				this.form.setJsonMsg("新密码长度不能小于6位数", false, json, 1001);
			} else if (!this.form.getOldPassword().equals(account.getAccountPassword())) {
				this.form.setJsonMsg("旧密码错误", false, json, 1001);
			} else {
				account.setAccountPassword(this.form.getPassword());
				this.baseBiz.update(account);
				json.put("info", account);
				this.form.setJsonMsg("修改成功", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}

	public String update_user_gender() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else if (this.form.getUserinfo() == null) {
				this.form.setJsonMsg("userinfo.gender不能为空", false, json, 1001);
			} else if ((this.form.getUserinfo().getAccountSex().intValue() > 1)
					|| (this.form.getUserinfo().getAccountSex().intValue() < 0)) {
				this.form.setJsonMsg("userinfo.accountSex数据传输错误(0|1)", false, json, 1001);
			} else {
				account.setAccountSex(this.form.getUserinfo().getAccountSex());
				this.baseBiz.update(account);
				json.put("info", account);
				this.form.setJsonMsg("修改成功", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}

	public String update_user_email() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else if (this.form.getUserinfo().getAccountEmail() == null) {
				this.form.setJsonMsg("userinfo.accountEmail不能为空", false, json, 1001);
			} else if (!EmailUtil.emailMatches(this.form.getUserinfo().getAccountEmail())) {
				this.form.setJsonMsg("userinfo.accountEmail格式输入错误", false, json, 1001);
			} else {
				account.setAccountEmail(this.form.getUserinfo().getAccountEmail());
				this.baseBiz.update(account);
				json.put("info", account);
				this.form.setJsonMsg("修改成功", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}

	public String update_user_head() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else if (this.form.getUserinfo().getAccountHead() == null) {
				this.form.setJsonMsg("userinfo.accountEmail不能为空", false, json, 1001);
			} else {
				String url = ImageBase64.GenerateImage(account.getAccountId().intValue(), "0.png",
						this.form.getUserinfo().getAccountHead());
				if ((url != null) && (url.length() > 10)) {
					account.setAccountHead(url);
					this.baseBiz.update(account);
					json.put("info", account);
					this.form.setJsonMsg("修改成功", true, json, 200);
				} else {
					this.form.setJsonMsg("base64图片处理失败,请重试", false, json, 1001);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}

	public String update_telphone() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else if (this.form.getTelPhone() == null) {
				this.form.setJsonMsg("userinfo.telPhone不能为空", false, json, 1001);
			} else {
				account.getUserProfile().setTelPhone(this.form.getTelPhone());
				this.baseBiz.update(account.getUserProfile());
				json.put("info", account);
				this.form.setJsonMsg("修改成功", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}

	public String update_cellphone() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("该账号已经在其它设备登录", false, json, 201);
			} else if (this.form.getCellPhone() == null) {
				this.form.setJsonMsg("userinfo.cellPhone不能为空", false, json, 1001);
			} else {
				account.getUserProfile().setCellPhone(this.form.getCellPhone());
				this.baseBiz.update(account.getUserProfile());
				json.put("info", account);
				this.form.setJsonMsg("修改成功", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return "jsonPage";
	}
}
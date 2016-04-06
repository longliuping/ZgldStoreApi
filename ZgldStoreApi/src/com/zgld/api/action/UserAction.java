package com.zgld.api.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zgld.api.beans.UserProfile;
import com.zgld.api.beans.Users;
import com.zgld.api.beans.YAccount;
import com.zgld.api.utils.EmailUtil;
import com.zgld.api.utils.ImageBase64;

public class UserAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户登录
	 */
	public String user_login() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			if (form.getName() == null || form.getName().isEmpty()) {
				form.setJsonMsg("用户名不能为空", false, json, 1001);
			} else if (form.getPassword() == null
					|| form.getPassword().isEmpty()) {
				form.setJsonMsg("密码不能为空", false, json, 1001);
			} else if (form.getId() == null) {
				form.setJsonMsg("id不能为空", false, json, 1001);
			} else {
				Object obj = baseBiz
						.bean(" from YAccount as y, Users as u,UserProfile as p where u.userId = p.userId and p.userId = y.accountId and y.accountName = '"
								+ form.getName() + "'");
				Object[] object = (Object[]) obj;
				if (object == null || object.length < 0) {
					form.setJsonMsg("用户名不存在", false, json, 1001);
				} else if (!form.getPassword().equals(
						((YAccount) object[0]).getAccountPassword())) {
					form.setJsonMsg("密码错误", false, json, 1001);
				} else {
					YAccount account = (YAccount) object[0];
					if (object.length > 1) {
						account.setUsers((Users) object[1]);
						if (object.length > 2) {
							account.setUserProfile((UserProfile) object[2]);
						}
					}
					json.put(INFO, account);
					form.setJsonMsg("登录成功", true, json, 200);
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
	 * 注册
	 * 
	 * @return
	 */
	public String user_register() {

		Map<String, Object> json = new HashMap<String, Object>();
		try {
			// if (form.getName() == null || form.getName().isEmpty()) {
			// form.setJsonMsg("用户名name不能为空", false, json, 1001);
			// } else if (form.getPassword() == null ||
			// form.getPassword().isEmpty()) {
			// form.setJsonMsg("密码password不能为空", false, json, 1001);
			// } else {
			// AspnetUsers user =
			// baseBiz.findUserinfoByUserName(form.getName());
			// if (user != null) {
			// form.setJsonMsg("用户名已经存在", false, json, 1001);
			// } else {
			// if (form.getId() != null && form.getId() > 10) {
			// AspnetUsers u = (AspnetUsers)
			// baseBiz.bean(" from AspnetUsers as u where u.userId = " +
			// form.getId());
			// if (u == null) {
			// form.setJsonMsg("邀请码不存在", false, json, 1001);
			// } else {
			// json.put(INFO, reg_user());
			// form.setJsonMsg("注册成功", true, json, 200);
			// }
			// } else {
			// json.put(INFO, reg_user());
			// form.setJsonMsg("注册成功", true, json, 200);
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
	 * 获取用户信息
	 * 
	 * @return
	 */
	public String userinfo() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				json.put(INFO, account);
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
	 * 修改用户密码
	 * 
	 * @return
	 */
	public String update_user_password() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else if (form.getOldPassword() == null) {
				form.setJsonMsg("密码oldPassword不能为空", false, json, 1001);
			} else if (form.getPassword() == null) {
				form.setJsonMsg("密码password不能为空", false, json, 1001);
			} else if (form.getPassword().length() < 6) {
				form.setJsonMsg("新密码长度不能小于6位数", false, json, 1001);
			} else {
				if (!form.getPassword().equals(account.getAccountPassword())) {
					form.setJsonMsg("旧密码错误", false, json, 1001);
				} else {
					account.setAccountPassword(form.getPassword());
					baseBiz.update(account);
					json.put(INFO, account);
					form.setJsonMsg("修改成功", true, json, 200);
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
	 * 修改性别
	 * 
	 * @return
	 */
	public String update_user_gender() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else if (form.getUserinfo() == null) {
				form.setJsonMsg("userinfo.gender不能为空", false, json, 1001);
			} else if (form.getUserinfo().getAccountSex() > 1
					|| form.getUserinfo().getAccountSex() < 0) {
				form.setJsonMsg("userinfo.accountSex数据传输错误(0|1)", false, json, 1001);
			} else {
				account.setAccountSex(form.getUserinfo().getAccountSex());
				baseBiz.update(account);
				json.put(INFO, account);
				form.setJsonMsg("修改成功", true, json, 200);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 修改用户邮箱
	 * 
	 * @return
	 */
	public String update_user_email() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
				form.setJsonMsg(NO_USER, false, json, 201);
			} else if (form.getUserinfo().getAccountEmail() == null) {
				form.setJsonMsg("userinfo.accountEmail不能为空", false, json, 1001);
			} else if (!EmailUtil.emailMatches(form.getUserinfo()
					.getAccountEmail())) {
				form.setJsonMsg("userinfo.accountEmail格式输入错误", false, json, 1001);
			} else {
				account.setAccountEmail(form.getUserinfo().getAccountEmail());
				baseBiz.update(account);
				json.put(INFO, account);
				form.setJsonMsg("修改成功", true, json, 200);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 修改用户头像
	 * 
	 * @return
	 */
	public String update_user_head() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else if (form.getUserinfo().getAccountHead() == null) {
				form.setJsonMsg("userinfo.accountEmail不能为空", false, json, 1001);
			} else {
				String url = ImageBase64.GenerateImage(account.getAccountId(),
						"0.png", form.getUserinfo().getAccountHead());
				if (url != null && url.length() > 10) {
					account.setAccountHead(url);
					baseBiz.update(account);
					json.put(INFO, account);
					form.setJsonMsg("修改成功", true, json, 200);
				} else {
					form.setJsonMsg("base64图片处理失败,请重试", false, json, 1001);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	public String update_telphone() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else if (form.getTelPhone() == null) {
				form.setJsonMsg("userinfo.telPhone不能为空", false, json, 1001);
			} else {
				account.getUserProfile().setTelPhone(form.getTelPhone());
				baseBiz.update(account.getUserProfile());
				json.put(INFO, account);
				form.setJsonMsg("修改成功", true, json, 200);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	public String update_cellphone() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				form.setJsonMsg(NO_USER, false, json, 201);
			} else if (form.getCellPhone() == null) {
				form.setJsonMsg("userinfo.cellPhone不能为空", false, json, 1001);
			} else {
				account.getUserProfile().setCellPhone(form.getCellPhone());
				baseBiz.update(account.getUserProfile());
				json.put(INFO, account);
				form.setJsonMsg("修改成功", true, json, 200);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}
}

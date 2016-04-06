package com.zgld.api.action;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zgld.api.base.BaseForm;
import com.zgld.api.beans.GsonBean;
import com.zgld.api.beans.JyPwd;
import com.zgld.api.beans.UserProfile;
import com.zgld.api.beans.Users;
import com.zgld.api.beans.YAccount;
import com.zgld.api.biz.BaseBiz;
import com.zgld.api.utils.DateUtils;
import com.zgld.api.utils.HttpUtil;
import com.zgld.api.utils.PasswordUtils;

public class BaseAction extends ActionSupport implements ModelDriven<Object> {
	protected BaseForm form = new BaseForm();
	protected static String LOGIN = "login_html";// 登录页面
	protected static String MAIN = "main_html";// 主页面
	protected static YAccount currentUser;
	protected int pageSize = 5;// 每页显示多少条记录
	protected int pageNow = 1;// 希望显示第几页
	protected int pageCount = 0;// 一共有多少页
	protected int rowCount = 0;// 一共有多少条记录

	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	protected static String datetime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String JSON_PAGE = "jsonPage";
	protected BaseBiz baseBiz;

	public BaseBiz getBaseBiz() {
		return baseBiz;
	}

	public void setBaseBiz(BaseBiz baseBiz) {
		this.baseBiz = baseBiz;
	}

	/**
	 * 分页方法
	 */
	protected void initPage() {
		pageNow = form.getPageNum();
		if (rowCount % form.getPageSize() == 0) {
			pageCount = rowCount / form.getPageSize();
		} else {
			pageCount = rowCount / form.getPageSize() + 1;
		}
	}

	/**
	 * 保存修改的资料
	 * 
	 * @return
	 */
	public String save_modify_data() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return JSON_PAGE;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return form;
	}

	public static final String INFO = "info";
	public static final String LISTINFO = "listInfo";
	public static final String NO_USER = "该账号已经在其它设备登录";

	public YAccount reg_user() {
		Date date = DateUtils.strToDateLong("1754-01-01 00:00:00");
		YAccount account = new YAccount();
		account.setRoleSetId(4);
		account.setUnitSetId(1);
		account.setAccountName(form.getName());
		account.setAccountPassword(form.getPassword());
		account.setAccountSex(0);
		account.setAccountState(1);
		account.setAccountIntro("暂无");
		account.setAccountPlace("贵州.贵阳");
		account.setAccountLeavel(1);
		account.setIsDelete(0);
		account.setAccountRegisterTime(new Date());
		Serializable s = baseBiz.save(account);
		
		int userId = s.hashCode();
		account.setAccountId(userId);
		Users users = new Users();
		users.setUserId(userId);
		users.setUserAccountStatus(1);
		users.setAppUserToken(UUID.randomUUID().toString());
		users.setDeleted(0);
		users.setUserType(3);
		baseBiz.save(users);
		account.setUsers(users);

		UserProfile profile = new UserProfile();
		profile.setUserId(userId);
		baseBiz.save(profile);
		account.setUserProfile(profile);
		return account;
	}

	public String error() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			form.setJsonMsg("错误", false, json, 1001);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	public String pwd(String pwd, String passwordformat) {
		String json = HttpUtil.submitPost(
				"http://114.215.198.143:55/Home/index",
				"password=" + pwd + "&passwordformat=1&PasswordSalt="
						+ passwordformat).toString();
		if (json != null && !json.isEmpty()) {
			Gson g = new Gson();
			Type entityType = new TypeToken<GsonBean>() {
			}.getType();
			GsonBean gsonBean = g.fromJson(json, entityType);
			return gsonBean.getPassword();
		} else {
			return "";
		}
	}

	public String jypwd(String pwd, String passwordformat) {
		String json = HttpUtil.submitPost(
				"http://114.215.198.143:56/Home/trade",
				"password=" + pwd + "&passwordformat=1&PasswordSalt="
						+ passwordformat).toString();
		if (json != null && !json.isEmpty()) {
			Gson g = new Gson();
			Type entityType = new TypeToken<JyPwd>() {
			}.getType();
			JyPwd gsonBean = g.fromJson(json, entityType);
			return gsonBean.getPassword();
		} else {
			return "";
		}
	}

	/**
	 * 获取用户信息
	 * 
	 * @param token
	 * @return
	 */
	public YAccount getUserInfo() {
//		form.setToken("123456");
//		form.setUserId(6);
		String token = form.getToken();
		int userId = form.getUserId();
		if (token == null) {
			token = "";
		}
		Object obj = baseBiz
				.bean(" from YAccount as y, Users as u,UserProfile as p where (u.userId="+userId+" and u.appUserToken = '"
						+ token
						+ "') and u.userId = p.userId and p.userId = y.accountId");
		Object[] object = (Object[]) obj;
		if (object != null && object.length > 0) {
			YAccount account = (YAccount) object[0];
			if (object.length > 1) {
				account.setUsers((Users) object[1]);
				if (object.length > 2) {
					account.setUserProfile((UserProfile) object[2]);
				}
				return account;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 设置用户token
	 * 
	 * @param userId
	 * @return
	 */
	public Users setUserToken(int userId) {
		try {
			Users userToken = new Users();
			userToken.setUserId(userId);
			userToken.setUserAccountStatus(1);
			userToken.setAppUserToken(PasswordUtils.EncoderByMd5());
			userToken.setLastActivity(new Date());
			userToken.setDeleted(1);
			userToken.setUserType(3);
			baseBiz.save(userToken);
			return userToken;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

package com.zgld.api.action;

import com.alipay.config.OrderPayConfig;
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
import com.zgld.api.service.BaseService;
import com.zgld.api.utils.DateUtils;
import com.zgld.api.utils.HttpUtil;
import com.zgld.api.utils.PasswordUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
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

public class BaseAction extends ActionSupport implements ModelDriven<Object> {
	protected BaseForm form = new BaseForm();
	protected static String LOGIN = "login_html";
	protected static String MAIN = "main_html";
	protected static YAccount currentUser;
	protected int pageSize = 5;
	protected int pageNow = 1;
	protected int pageCount = 0;
	protected int rowCount = 0;
	private static final long serialVersionUID = 1L;
	protected static final String JSON_PAGE = "jsonPage";
	protected BaseService baseService;
	public static final String INFO = "info";
	public static final String LISTINFO = "listInfo";
	public static final String NO_USER = "该账号已经在其它设备登录";
	public static final String SYS_RUN_ERROR = "系统出错";

	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNow() {
		return this.pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return this.rowCount;
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


	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	protected void initPage() {
		this.pageNow = this.form.getPageNum().intValue();
		if (this.rowCount % this.form.getPageSize().intValue() == 0)
			this.pageCount = (this.rowCount / this.form.getPageSize().intValue());
		else
			this.pageCount = (this.rowCount / this.form.getPageSize().intValue() + 1);
	}

	public String save_modify_data() {
		return JSON_PAGE;
	}

	public Object getModel() {
		return this.form;
	}

	public YAccount reg_user() {
		Date date = DateUtils.strToDateLong("1754-01-01 00:00:00");
		YAccount account = new YAccount();
		account.setRoleSetId(Integer.valueOf(4));
		account.setUnitSetId(Integer.valueOf(1));
		account.setAccountName(this.form.getName());
		account.setAccountPassword(this.form.getPassword());
		account.setAccountSex(Integer.valueOf(0));
		account.setAccountState(Integer.valueOf(1));
		account.setAccountIntro("暂无");
		account.setAccountPlace("贵州.贵阳");
		account.setAccountLeavel(Integer.valueOf(1));
		account.setIsDelete(Integer.valueOf(0));
		account.setAccountRegisterTime(new Date());
		Serializable s = this.baseService.save(account);

		int accountId = s.hashCode();
		account.setAccountId(accountId);
		Users users = new Users();
		users.setAccountId(accountId);
		users.setUserAccountStatus(Integer.valueOf(1));
		users.setAppUserToken(UUID.randomUUID().toString());
		users.setDeleted(Integer.valueOf(0));
		users.setUserType(Integer.valueOf(3));
		users.setLastActivity(new Date());
		Serializable b = this.baseService.save(users);
		
		int userId = b.hashCode();
		UserProfile profile = new UserProfile();
		profile.setUserId(Integer.valueOf(userId));
		profile.setEnablePrivateMessages(0);
		profile.setEnableOnlineStatus(0);
		profile.setEnableEmail(0);
		profile.setEnableHtmlEmail(0);
		profile.setExpenditure(0.0);
		profile.setEnableTradePassword(0);
		profile.setBalance(0.0);
		profile.setDeductMoney(0.0);
		profile.setExpenditure(0.0);
		profile.setGender(0);
		
		Serializable c = this.baseService.save(profile);
		int userProfileId = c.hashCode();
		profile.setUserProfileId(userProfileId);
		account.setUserProfile(profile);
		return account;
	}

	public String error() {
		Map json = new HashMap();
		try {
			this.form.setJsonMsg("错误", false, json, 1001);
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	public String pwd(String pwd, String passwordformat) {
		String json = HttpUtil.submitPost("http://114.215.198.143:55/Home/index",
				"password=" + pwd + "&passwordformat=1&PasswordSalt=" + passwordformat).toString();
		if ((json != null) && (!json.isEmpty())) {
			Gson g = new Gson();
			Type entityType = new TypeToken() {
			}.getType();
			GsonBean gsonBean = (GsonBean) g.fromJson(json, entityType);
			return gsonBean.getPassword();
		}
		return "";
	}

	public String jypwd(String pwd, String passwordformat) {
		String json = HttpUtil.submitPost("http://114.215.198.143:56/Home/trade",
				"password=" + pwd + "&passwordformat=1&PasswordSalt=" + passwordformat).toString();
		if ((json != null) && (!json.isEmpty())) {
			Gson g = new Gson();
			Type entityType = new TypeToken() {
			}.getType();
			JyPwd gsonBean = (JyPwd) g.fromJson(json, entityType);
			return gsonBean.getPassword();
		}
		return "";
	}

	public YAccount getUserInfo() {
		String token = this.form.getToken();
		int userId = this.form.getUserId().intValue();
		if (token == null) {
			token = "";
		}
		Object obj = this.baseService.bean(" from YAccount as y, Users as u,UserProfile as p where (u.userId=" + userId
				+ " and u.appUserToken = '" + token + "') and u.userId = p.userId and u.accountId = y.accountId ");
		Object[] object = (Object[]) obj;
		if ((object != null) && (object.length > 0)) {
			YAccount account = (YAccount) object[0];
			if (object.length > 1) {
				account.setUsers((Users) object[1]);
				if (object.length > 2) {
					account.setUserProfile((UserProfile) object[2]);
				}
				return account;
			}
			return null;
		}

		return null;
	}

	public Users setUserToken(int userId) {
		try {
			Users userToken = new Users();
			userToken.setUserId(Integer.valueOf(userId));
			userToken.setUserAccountStatus(Integer.valueOf(1));
			userToken.setAppUserToken(PasswordUtils.EncoderByMd5());
			userToken.setLastActivity(new Date());
			userToken.setDeleted(Integer.valueOf(1));
			userToken.setUserType(Integer.valueOf(3));
			this.baseService.save(userToken);
			return userToken;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取支付宝配置
	 * @param body
	 * @param subject
	 * @param expenses
	 * @param totalFee
	 * @param orderId
	 * @param notifyUrl
	 * @return
	 */
	public OrderPayConfig getAlipayconfig(String body,String subject,Double expenses,Double totalFee,int orderId,String notifyUrl){
		OrderPayConfig config = new OrderPayConfig();
		config.setBody(body);
		config.setSubject(subject);
		config.setExpenses(expenses);
		config.setTotal_fee(totalFee);
		config.setNotify_url(notifyUrl);
		config.setOrderId(orderId);
		config.setPartner("2088221599054403");
		config.setSeller_id("709877070@qq.com");
		config.setRsa_private(
				"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALhgnZ3yOtEbHr0WD/a7ekU3+UBdPz1+Rq1FGkM+duEKCMqWlJE2ow+WG8tR/WT3VtvYjeZGQsDpaEK6IuoBbkIl1+a2n4i8amMp5bELaLkwbsN24fuMrO6zno3uVD4BXcn9GxTPHn7yiimuE2hvLuCD8OkHseCDc/rf7+4B6SbpAgMBAAECgYBdi8+MipDi9TKUVzRER/ySUALrcCQc7Aup78ySX4frR68MMngwcRssVknFz9STvJZaNrZQJkfKHuJiMJR0S8OHeZ7wZt2u3cXn3tbvkqoYscc7WMmBM10k16npC8uw0eB1XU/y4dT53zFPtGe6HQ5UG9AiOKoerWQtTqSp1FD1AQJBAOBgEa4g6lhuobs4D4kE1BsQ+xK4utbvuKG+YLfebfsLUZZ1NmBbrzO3qYEa8PeB95YPK1OkFlPi6wRLBkO31OECQQDSXVb0oWeplZO1t/O858DOgVIKtRkJs7GSPFAfUak1p0/GZ+fbokUhiaNS6HLfcnMx3LyE7PFyZS4MFitm7QsJAkB7LQJHv5YnGgT7jJkqtVXjzfynmHYpzMxlLuhVyGxEJ0CRAqPpXivejnMlhy7GEbljzcwRTMFdJ/OxFabIwkDBAkEAjkvbJREFGP538yTid7bggg+SGnIT5K8rf3rSy8ymRAfP+6qPeM8UKjJ7Svq3sZQufd0NnHDWhgYRFtXsN+xCWQJAGWVeTpdFzdlPNaOflq7D2TFqo7H5kqz2s+FbByGVsNz4At5DsITBTvneHazkvWSrY11kWXui/Vd41fMl5pEBAA==");

		config.setRsa_public(
				"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4YJ2d8jrRGx69Fg/2u3pFN/lA\nXT89fkatRRpDPnbhCgjKlpSRNqMPlhvLUf1k91bb2I3mRkLA6WhCuiLqAW5CJdfmtp+IvGpjKeWxC2i5MG7DduH7jKzus56N7lQ+AV3J/RsUzx5+8ooprhNoby7gg/DpB7Hgg3P63+/uAekm6QIDAQAB");

		return config;
	}
}
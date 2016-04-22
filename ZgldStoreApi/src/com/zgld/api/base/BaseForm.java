package com.zgld.api.base;

import com.zgld.api.beans.UserShippingAddresses;
import com.zgld.api.beans.YAccount;
import com.zgld.api.utils.DateJsonValueProcessor;
import com.zgld.api.utils.JsonWrapper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class BaseForm {
	private String popMessage;
	private boolean resultBoolean;
	private String jsonText;
	private Integer pageNum = Integer.valueOf(1);
	private Integer pageSize = Integer.valueOf(50);
	private Integer newPageSize = Integer.valueOf(0);
	private Integer id;
	private Integer userId = Integer.valueOf(0);
	private Integer code;
	private String orderid;
	private Integer productId;
	private Integer hotid;
	private Integer areaid;
	private Integer number;
	private String skuId;
	private Integer shopId;
	private String skuNumber;
	private Integer shippingId;
	private Integer modeId;
	private Integer templateId;
	private Double money;
	private String content;
	private Integer display;
	private String name;
	private String password;
	private String okPassword;
	private String oldPassword;
	private String token;
	private String ip;
	private Object object;
	private Object object1;
	private Object object2;
	private Object object3;
	private Object object4;
	private String exportToExcel;
	private Map<Integer, Integer> selectedUser = new HashMap();
	private String startDate;
	private String endDate;
	private Object totalMoney;
	private Object totalPageMoney;
	private YAccount userinfo;
	private String telPhone;
	private String cellPhone;
	private Double amount;
	private String remark;
	private UserShippingAddresses address;

	public String getJsonText() {
		return this.jsonText;
	}

	public void setJsonText(String jsonText) {
		this.jsonText = jsonText;
	}

	public void setJsonMsg(Object data) {
		setJsonMsg(this.popMessage, this.resultBoolean, data);
	}

	public static Timestamp datetime() {
		return new Timestamp(new Date().getTime());
	}

	public void setJsonMsg(String msg, boolean flag, Object data, int status) {
		JsonWrapper wrapper = new JsonWrapper(flag, msg, data, status);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		setJsonText(JSONObject.fromObject(wrapper, config).toString());
	}

	public void setJsonMsg(String msg, boolean flag, Object data) {
		JsonWrapper wrapper = new JsonWrapper(flag, msg, data);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		setJsonText(JSONObject.fromObject(wrapper, config).toString());
	}

	public void setJsonMsg() {
		setJsonMsg(this.popMessage, this.resultBoolean, null);
	}

	public UserShippingAddresses getAddress() {
		return this.address;
	}

	public void setAddress(UserShippingAddresses address) {
		this.address = address;
	}

	public Integer getHotid() {
		return this.hotid;
	}

	public void setHotid(Integer hotid) {
		this.hotid = hotid;
	}

	public Integer getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public String getSkuNumber() {
		return this.skuNumber;
	}

	public void setSkuNumber(String skuNumber) {
		this.skuNumber = skuNumber;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSkuId() {
		return this.skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public Timestamp getDatetime() {
		return new Timestamp(new Date().getTime());
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getNewPageSize() {
		return this.newPageSize;
	}

	public YAccount getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(YAccount userinfo) {
		this.userinfo = userinfo;
	}

	public void setNewPageSize(Integer newPageSize) {
		this.newPageSize = newPageSize;
	}

	public String getExportToExcel() {
		return this.exportToExcel;
	}

	public void setExportToExcel(String exportToExcel) {
		this.exportToExcel = exportToExcel;
	}

	public Object getObject3() {
		return this.object3;
	}

	public void setObject3(Object object3) {
		this.object3 = object3;
	}

	public Object getObject4() {
		return this.object4;
	}

	public void setObject4(Object object4) {
		this.object4 = object4;
	}

	public Object getTotalPageMoney() {
		return this.totalPageMoney;
	}

	public void setTotalPageMoney(Object totalPageMoney) {
		this.totalPageMoney = totalPageMoney;
	}

	public Object getTotalMoney() {
		return this.totalMoney;
	}

	public void setTotalMoney(Object totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Object getObject1() {
		return this.object1;
	}

	public void setObject1(Object object1) {
		this.object1 = object1;
	}

	public Object getObject2() {
		return this.object2;
	}

	public void setObject2(Object object2) {
		this.object2 = object2;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getPopMessage() {
		return this.popMessage;
	}

	public void setPopMessage(String popMessage) {
		this.popMessage = popMessage;
	}

	public boolean isResultBoolean() {
		return this.resultBoolean;
	}

	public void setResultBoolean(boolean resultBoolean) {
		this.resultBoolean = resultBoolean;
	}

	public String getOkPassword() {
		return this.okPassword;
	}

	public void setOkPassword(String okPassword) {
		this.okPassword = okPassword;
	}

	public String getOldPassword() {
		return this.oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Integer getDisplay() {
		return this.display;
	}

	public void setDisplay(Integer display) {
		this.display = display;
	}

	public Map<Integer, Integer> getSelectedUser() {
		return this.selectedUser;
	}

	public void setSelectedUser(Map<Integer, Integer> selectedUser) {
		this.selectedUser = selectedUser;
	}

	public Integer getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public Integer getModeId() {
		return this.modeId;
	}

	public void setModeId(Integer modeId) {
		this.modeId = modeId;
	}

	public Integer getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getTelPhone() {
		return this.telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
}
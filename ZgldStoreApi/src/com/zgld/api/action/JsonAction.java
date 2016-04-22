package com.zgld.api.action;

import com.zgld.api.base.BaseForm;
import com.zgld.api.beans.HomeBanner;
import com.zgld.api.service.BaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	/**
	 * 主页banner
	 * @return
	 */
	public String home_banner() {
		Map json = new HashMap();
		try {
			List listBanner = new ArrayList();
			for (int i = 1; i < 6; i++) {
				HomeBanner banner = new HomeBanner();
				banner.setImgUrl("http://115.28.20.167:8090/webapi/banner/banner" + i + ".jpg");
				listBanner.add(banner);
			}
			json.put("items", listBanner);
			this.form.setJsonMsg("success", true, json, 200);
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return "jsonPage";
	}
	/**
	 * 主页热门标签
	 * @return
	 */
	public String home_hot_category() {
		Map json = new HashMap();
		try {
			List listInfo = this.baseService.findAll(" from HotCategory as h ");
			json.put("listInfo", listInfo);
			this.form.setJsonMsg("success", true, json, 200);
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return "jsonPage";
	}
}
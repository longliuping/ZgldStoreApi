package com.zgld.api.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zgld.api.beans.Categories;
import com.zgld.api.beans.HomeBanner;

public class JsonAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 首页的banner
	 * 
	 * @return
	 */
	public String home_banner() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			List<HomeBanner> listBanner = new ArrayList<HomeBanner>();
			HomeBanner banner = new HomeBanner();
			banner.setImgUrl("/banner/banner1.jpg");
			listBanner.add(banner);
			banner.setImgUrl("/banner/banner2.jpg");
			listBanner.add(banner);
			banner.setImgUrl("/banner/banner3.jpg");
			listBanner.add(banner);
			banner.setImgUrl("/banner/banner4.jpg");
			listBanner.add(banner);
			banner.setImgUrl("/banner/banner5.jpg");
			listBanner.add(banner);
			json.put("items", listBanner);
			form.setJsonMsg(SUCCESS, true, json, 200);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 首页热门标签
	 * 
	 * @return
	 */
	public String home_hot_category() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			List<Categories> listInfo = (List<Categories>) baseBiz.findAll(" from Categories as h ");
			json.put(LISTINFO, listInfo);
			form.setJsonMsg(SUCCESS, true, json, 200);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}
}

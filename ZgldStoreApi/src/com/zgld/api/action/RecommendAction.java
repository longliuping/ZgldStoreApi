package com.zgld.api.action;

import java.util.HashMap;
import java.util.Map;
import com.zgld.api.beans.YAccount;
import antlr.collections.List;

public class RecommendAction extends BaseAction {
	public String recommend_user() {
		Map json = new HashMap<>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg("skuId不能为空", false, json, 1001);
			} else {
				List listInfo = (List) this.baseService.findPage(form.getPageNum(), form.getPageSize(),
						" from YRebateRelation as r where r.currentUserId = " + account.getUsers().getUserId());
				json.put(LISTINFO, listInfo);
				this.form.setJsonMsg(SUCCESS, true, json, 200);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return JSON_PAGE;
	}
}

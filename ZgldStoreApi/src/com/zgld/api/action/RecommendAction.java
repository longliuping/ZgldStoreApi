package com.zgld.api.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YRebateRelation;

public class RecommendAction extends BaseAction {
	public String recommend_user() {
		Map json = new HashMap<>();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				List<YRebateRelation> listInfo = new ArrayList<>();
				List<?> listObj = this.baseService.findPage(form.getPageNum(), form.getPageSize(),
						" from YRebateRelation as r,Users as u,YAccount as a where u.accountId = a.accountId and r.currentUserId = u.userId and r.parentUserId = " + account.getUsers().getUserId());
				for (int i = 0; i < listObj.size(); i++) {
					Object[] o = (Object[]) listObj.get(i);
					YRebateRelation r = (YRebateRelation)o[0];
					YAccount a = (YAccount)o[2];
					r.setAccount(a);
					listInfo.add(r);
				}
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

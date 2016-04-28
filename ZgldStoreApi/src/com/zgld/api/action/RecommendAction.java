package com.zgld.api.action;

import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YRebateRelation;

public class RecommendAction extends BaseAction {
	public String recommend1(){
		try {
			YAccount account = getUserInfo();			
			this.baseService.findPage(form.getPageNum(), form.getPageSize(), " from YRebateRelation as r where r.currentUserId = "+account.getUsers().getUserId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return JSON_PAGE;
	}
}

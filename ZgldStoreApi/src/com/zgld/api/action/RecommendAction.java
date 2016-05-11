package com.zgld.api.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zgld.api.beans.OrdersRebate;
import com.zgld.api.beans.YAccount;
import com.zgld.api.beans.YRebateRelation;

public class RecommendAction extends BaseAction {
	public String recommend_user() {
		Map json = new HashMap<>();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if (form.getId() == null) {
					this.form.setJsonMsg("id不能为空", false, json, 1001);
				} else {
					List<YRebateRelation> listInfo = new ArrayList<>();
					List<YRebateRelation> listOne = null;
					List<?> listObj = null;
					StringBuffer sb = null;
					switch (form.getId()) {
					case 1:
						listObj = this.baseService.findPage(form.getPageNum(), form.getPageSize(),
								" from YRebateRelation as r,Users as u,YAccount as a where u.accountId = a.accountId and r.currentUserId = u.userId and r.parentUserId = "
										+ account.getUsers().getUserId());
						for (int i = 0; i < listObj.size(); i++) {
							Object[] o = (Object[]) listObj.get(i);
							YRebateRelation r = (YRebateRelation) o[0];
							YAccount a = (YAccount) o[2];
							r.setAccount(a);
							listInfo.add(r);
						}
						break;

					case 2:
						listOne = (List<YRebateRelation>) this.baseService.findPage(form.getPageNum(),
								form.getPageSize(),
								" from YRebateRelation as r where r.parentUserId = " + account.getUsers().getUserId());
						sb = new StringBuffer(
								" from YRebateRelation as r,Users as u,YAccount as a where (u.accountId = a.accountId and r.currentUserId = u.userId) ");
						if (listOne != null && listOne.size() > 0) {
							sb.append(" and ( ");
						}
						for (YRebateRelation object : listOne) {
							sb.append(" r.parentUserId = " + object.getCurrentUserId() + " or ");
						}
						if (listOne != null && listOne.size() > 0) {
							sb.delete(sb.length() - 3, sb.length());
							sb.append(" ) ");
							listObj = baseService.findAll(sb.toString());
							for (int i = 0; i < listObj.size(); i++) {
								Object[] o = (Object[]) listObj.get(i);
								YRebateRelation r = (YRebateRelation) o[0];
								YAccount a = (YAccount) o[2];
								r.setAccount(a);
								listInfo.add(r);
							}
						}
						break;
					case 3:
						listOne = (List<YRebateRelation>) this.baseService.findPage(form.getPageNum(),
								form.getPageSize(),
								" from YRebateRelation as r where r.parentUserId = " + account.getUsers().getUserId());
						sb = new StringBuffer(" from YRebateRelation as r ");
						if (listOne != null && listOne.size() > 0) {
							sb.append(" where ( ");
							for (YRebateRelation object : listOne) {
								sb.append(" r.parentUserId = " + object.getCurrentUserId() + " or ");
							}
							if (listOne != null && listOne.size() > 0) {
								sb.delete(sb.length() - 3, sb.length());
								sb.append(" ) ");
							}
							listOne = (List<YRebateRelation>) this.baseService.findAll(sb.toString());
							listObj = baseService.findAll(sb.toString());
							sb = new StringBuffer(
									" from YRebateRelation as r,Users as u,YAccount as a where (u.accountId = a.accountId and r.currentUserId = u.userId) ");
							if (listOne != null && listOne.size() > 0) {
								sb.append(" and ( ");
								for (YRebateRelation object : listOne) {
									sb.append(" r.parentUserId = " + object.getCurrentUserId() + " or ");
								}
								if (listOne != null && listOne.size() > 0) {
									sb.delete(sb.length() - 3, sb.length());
									sb.append(" ) ");
								}
								listObj = baseService.findAll(sb.toString());
								for (int i = 0; i < listObj.size(); i++) {
									Object[] o = (Object[]) listObj.get(i);
									YRebateRelation r = (YRebateRelation) o[0];
									YAccount a = (YAccount) o[2];
									r.setAccount(a);
									listInfo.add(r);
								}
							}

						}
						break;
					}
					json.put(LISTINFO, listInfo);
					this.form.setJsonMsg(SUCCESS, true, json, 200);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return JSON_PAGE;
	}
	/**
	 * 查询我下级的用户给我产生的收益记录
	 * @return
	 */
	public String find_user_order_rebate(){
		Map json = new HashMap<>();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if (form.getId() == null) {
					this.form.setJsonMsg("id不能为空", false, json, 1001);
				} else {
					YRebateRelation relation = (YRebateRelation)baseService.bean(" from YRebateRelation as r where r.rebateRelationId = "+form.getId());
					if(relation==null){
						this.form.setJsonMsg("rebateRelationId推荐关系ID不存在", false, json, 1001);
					}else{
						List<OrdersRebate> listInfo = (List<OrdersRebate>)baseService.findPage(form.getPageNum(), form.getPageSize(), " from OrdersRebate as or where or.rebateRelationId = "+form.getId()+" and or.userId = "+account.getUserProfile().getUserId());
						Double income = (Double) baseService.totalObject(" select sum(or.income) from OrdersRebate as or where or.rebateRelationId = "+form.getId()+" and or.userId = "+account.getUserProfile().getUserId());
						json.put(LISTINFO, listInfo);
						json.put("income", income);
						this.form.setJsonMsg(SUCCESS, true, json, 200);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return JSON_PAGE;
	}
}

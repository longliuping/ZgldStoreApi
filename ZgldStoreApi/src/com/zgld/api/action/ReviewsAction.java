package com.zgld.api.action;

import com.zgld.api.base.BaseForm;
import com.zgld.api.beans.ProductReviews;
import com.zgld.api.beans.YAccount;
import com.zgld.api.service.BaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReviewsAction extends BaseAction {
	public String view_product_reviews() {
		Map json = new HashMap();
		try {
			if (this.form.getProductId() == null) {
				this.form.setJsonMsg("productId不能为空", false, json, 1001);
			} else {
				int productId = this.form.getProductId().intValue();
				List listInfo = new ArrayList();
				List listObj = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(),
						" from ProductReviews as pv, YAccount as ya where pv.productId = " + productId
								+ " and pv.userId = ya.accountId order by pv.reviewDate desc ");
				for (Iterator localIterator = listObj.iterator(); localIterator.hasNext();) {
					Object object = localIterator.next();
					Object[] o = (Object[]) object;
					ProductReviews pro = (ProductReviews) o[0];
					pro.setUserInfo((YAccount) o[1]);
					listInfo.add(pro);
				}
				json.put("listInfo", listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return "jsonPage";
	}
}
package com.zgld.api.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zgld.api.beans.ProductReviews;
import com.zgld.api.beans.YAccount;
/**
 * 评论
 * @author Am
 *
 */
public class ReviewsAction extends BaseAction {
	/**
	 * 查看产品评论
	 * 
	 * @return
	 */
	public String view_product_reviews() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			if (form.getProductId() == null) {
				form.setJsonMsg("productId不能为空", false, json, 1001);
			} else {
				int productId = form.getProductId();
				List<ProductReviews> listInfo = new ArrayList<ProductReviews>();
				List<?> listObj = baseBiz.findPage(form.getPageNum(), form.getPageSize(), " from ProductReviews as pv, YAccount as ya where pv.productId = " + productId + " and pv.userId = ya.accountId order by pv.reviewDate desc ");
				for (Object object : listObj) {
					Object[] o = (Object[]) object;
					ProductReviews pro = (ProductReviews) o[0];
					pro.setUserInfo((YAccount) o[1]);
					listInfo.add(pro);
				}
				json.put(LISTINFO, listInfo);
				form.setJsonMsg(SUCCESS, true, json, 200);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}
}

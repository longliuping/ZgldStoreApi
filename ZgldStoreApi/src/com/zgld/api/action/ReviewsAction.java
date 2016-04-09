package com.zgld.api.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zgld.api.beans.ProductReviews;

public class ReviewsAction extends BaseAction {
	/**
	 * 查看产品评论
	 * @return
	 */
	public String view_product_reviews() {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			int productId = form.getProductId();
			List<ProductReviews> listReviews = (List<ProductReviews>) baseBiz.findPage(form.getPageNum(), form.getPageSize(), " from ProductReviews as pv where pv.productId = " + productId + " order by pv.reviewDate desc ");
			json.put(LISTINFO, listReviews);
			form.setJsonMsg(SUCCESS, true, json, 200);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			form.setJsonMsg("系统出错", false, json, 1001);
		}
		return JSON_PAGE;
	}
}

package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * ProductConsultations entity. @author MyEclipse Persistence Tools
 */
public class ProductConsultations extends AbstractProductConsultations implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ProductConsultations() {
	}

	/** full constructor */
	public ProductConsultations(Integer shopId, Integer productId, Integer userId, String userName, String userEmail, String consultationText, Timestamp consultationDate, String replyText, Timestamp replyDate, String replyUserId) {
		super(shopId, productId, userId, userName, userEmail, consultationText, consultationDate, replyText, replyDate, replyUserId);
	}

}

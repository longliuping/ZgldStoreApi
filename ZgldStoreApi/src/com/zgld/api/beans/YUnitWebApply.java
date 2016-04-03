package com.zgld.api.beans;

import java.sql.Date;

/**
 * YUnitWebApply entity. @author MyEclipse Persistence Tools
 */
public class YUnitWebApply extends AbstractYUnitWebApply implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YUnitWebApply() {
	}

	/** minimal constructor */
	public YUnitWebApply(Date unitWebApplyTime) {
		super(unitWebApplyTime);
	}

	/** full constructor */
	public YUnitWebApply(Integer unitSetId, Integer accountActId, String unitWebDnsName, String unitWebApplyIdCard, String unitWebApplyIdCardImg, String unitWebApplyContent, Integer unitWebApplyState, String unitWebApplyStateNote, Integer isDelete, Date unitWebApplyTime) {
		super(unitSetId, accountActId, unitWebDnsName, unitWebApplyIdCard, unitWebApplyIdCardImg, unitWebApplyContent, unitWebApplyState, unitWebApplyStateNote, isDelete, unitWebApplyTime);
	}

}

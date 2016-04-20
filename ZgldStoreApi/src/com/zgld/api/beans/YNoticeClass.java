package com.zgld.api.beans;

import java.sql.Date;

/**
 * YNoticeClass entity. @author MyEclipse Persistence Tools
 */
public class YNoticeClass extends AbstractYNoticeClass implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YNoticeClass() {
	}

	/** minimal constructor */
	public YNoticeClass(Date noClassTime) {
		super(noClassTime);
	}

	/** full constructor */
	public YNoticeClass(Integer unitSetId, Integer accountActId, Integer noClassSetId, Integer noParentClassId,
			String noClassName, Integer noClassTotal, Integer noClassOrder, Integer noClassTopOrder,
			String noClassDefaultImg, String noClassHoverImg, String noClassVisitedImg, String noClassIntro,
			Integer isDelete, Date noClassTime) {
		super(unitSetId, accountActId, noClassSetId, noParentClassId, noClassName, noClassTotal, noClassOrder,
				noClassTopOrder, noClassDefaultImg, noClassHoverImg, noClassVisitedImg, noClassIntro, isDelete,
				noClassTime);
	}

}

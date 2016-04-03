package com.zgld.api.beans;

import java.sql.Timestamp;

/**
 * YFormControl entity. @author MyEclipse Persistence Tools
 */
public class YFormControl extends AbstractYFormControl implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YFormControl() {
	}

	/** minimal constructor */
	public YFormControl(Timestamp controlTime) {
		super(controlTime);
	}

	/** full constructor */
	public YFormControl(Integer tagId, String controlName, String fieldName, String controlValue, Timestamp controlTime) {
		super(tagId, controlName, fieldName, controlValue, controlTime);
	}

}

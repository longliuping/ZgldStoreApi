package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.List;

/**
 * YFormTag entity. @author MyEclipse Persistence Tools
 */
public class YFormTag extends AbstractYFormTag implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YFormTag() {
	}
	YFormValue formValue;
	List<YFormControl> listFormControl;
	public YFormValue getFormValue() {
		return formValue;
	}
	public void setFormValue(YFormValue formValue) {
		this.formValue = formValue;
	}
	public List<YFormControl> getListFormControl() {
		return listFormControl;
	}
	public void setListFormControl(List<YFormControl> listFormControl) {
		this.listFormControl = listFormControl;
	}
	

}

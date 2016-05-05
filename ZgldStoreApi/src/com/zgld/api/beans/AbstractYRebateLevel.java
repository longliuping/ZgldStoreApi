package com.zgld.api.beans;

/**
 * AbstractYRebateLevel entity provides the base persistence definition of the
 * YRebateLevel entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYRebateLevel implements java.io.Serializable {

	// Fields

	private Integer rebateLevelId;
	private Integer rebateLevel;
	private Double rebatePercent;
	private String rebateIntro;

	// Constructors

	/** default constructor */
	public AbstractYRebateLevel() {
	}

	// Property accessors

	public Integer getRebateLevelId() {
		return this.rebateLevelId;
	}

	public void setRebateLevelId(Integer rebateLevelId) {
		this.rebateLevelId = rebateLevelId;
	}

	public Integer getRebateLevel() {
		return this.rebateLevel;
	}

	public void setRebateLevel(Integer rebateLevel) {
		this.rebateLevel = rebateLevel;
	}

	public Double getRebatePercent() {
		return this.rebatePercent;
	}

	public void setRebatePercent(Double rebatePercent) {
		this.rebatePercent = rebatePercent;
	}

	public String getRebateIntro() {
		return rebateIntro;
	}

	public void setRebateIntro(String rebateIntro) {
		this.rebateIntro = rebateIntro;
	}

}
package com.zgld.api.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractHotkeywords entity provides the base persistence definition of the
 * Hotkeywords entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHotkeywords implements java.io.Serializable {

	// Fields

	private Integer hid;
	private String keywords;
	private Date searchTime;
	private Date lasttime;
	private Integer frequency;
	private Integer userId;

	// Constructors

	/** default constructor */
	public AbstractHotkeywords() {
	}

	/** full constructor */
	public AbstractHotkeywords(String keywords, Date searchTime, Date lasttime, Integer frequency, Integer userId) {
		this.keywords = keywords;
		this.searchTime = searchTime;
		this.lasttime = lasttime;
		this.frequency = frequency;
		this.userId = userId;
	}

	// Property accessors

	public Integer getHid() {
		return this.hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Date getSearchTime() {
		return this.searchTime;
	}

	public void setSearchTime(Date searchTime) {
		this.searchTime = searchTime;
	}

	public Date getLasttime() {
		return this.lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public Integer getFrequency() {
		return this.frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
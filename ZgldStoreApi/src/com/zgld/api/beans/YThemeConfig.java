package com.zgld.api.beans;

import java.sql.Date;

/**
 * YThemeConfig entity. @author MyEclipse Persistence Tools
 */
public class YThemeConfig extends AbstractYThemeConfig implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YThemeConfig() {
	}

	/** minimal constructor */
	public YThemeConfig(Date themeTime) {
		super(themeTime);
	}

	/** full constructor */
	public YThemeConfig(String themeName, String themeTitle, String themeIntro, Integer isDefault, Integer isDelete,
			Date themeTime) {
		super(themeName, themeTitle, themeIntro, isDefault, isDelete, themeTime);
	}

}

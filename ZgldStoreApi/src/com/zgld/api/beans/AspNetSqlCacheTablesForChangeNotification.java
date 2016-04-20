package com.zgld.api.beans;

import java.sql.Date;

/**
 * AspNetSqlCacheTablesForChangeNotification entity. @author MyEclipse
 * Persistence Tools
 */
public class AspNetSqlCacheTablesForChangeNotification extends AbstractAspNetSqlCacheTablesForChangeNotification
		implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public AspNetSqlCacheTablesForChangeNotification() {
	}

	/** full constructor */
	public AspNetSqlCacheTablesForChangeNotification(Date notificationCreated, Integer changeId) {
		super(notificationCreated, changeId);
	}

}

package com.zgld.api.beans;

import java.util.Date;

/**
 * AbstractAspNetSqlCacheTablesForChangeNotification entity provides the base
 * persistence definition of the AspNetSqlCacheTablesForChangeNotification
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAspNetSqlCacheTablesForChangeNotification implements java.io.Serializable {

	// Fields

	private String tableName;
	private Date notificationCreated;
	private Integer changeId;

	// Constructors

	/** default constructor */
	public AbstractAspNetSqlCacheTablesForChangeNotification() {
	}

	/** full constructor */
	public AbstractAspNetSqlCacheTablesForChangeNotification(Date notificationCreated, Integer changeId) {
		this.notificationCreated = notificationCreated;
		this.changeId = changeId;
	}

	// Property accessors

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Date getNotificationCreated() {
		return this.notificationCreated;
	}

	public void setNotificationCreated(Date notificationCreated) {
		this.notificationCreated = notificationCreated;
	}

	public Integer getChangeId() {
		return this.changeId;
	}

	public void setChangeId(Integer changeId) {
		this.changeId = changeId;
	}

}
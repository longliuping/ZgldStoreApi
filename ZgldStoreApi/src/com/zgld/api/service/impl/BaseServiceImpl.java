package com.zgld.api.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.zgld.api.beans.YAccount;
import com.zgld.api.dao.BaseDao;
import com.zgld.api.service.BaseService;

public class BaseServiceImpl implements BaseService {
	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public Object bean(String hql) {
		// TODO Auto-generated method stub
		return baseDao.bean(hql);
	}

	public int count(String hql) {
		// TODO Auto-generated method stub
		return baseDao.count(hql).intValue();
	}

	public void delete(Object object) {
		// TODO Auto-generated method stub
		baseDao.delete(object);
	}

	public List<?> findAll(String hql) {
		// TODO Auto-generated method stub
		return baseDao.findAll(hql);
	}

	public List<?> findPage(int pageNum, int pageSize, String hql) {
		// TODO Auto-generated method stub
		return baseDao.findPage(pageNum, pageSize, hql);
	}

	public Serializable save(Object object) {
		// TODO Auto-generated method stub
		return baseDao.save(object);
	}

	public Object totalObject(String hql) {
		// TODO Auto-generated method stub
		return baseDao.totalObject(hql);
	}

	public void update(Object object) {
		// TODO Auto-generated method stub
		baseDao.update(object);
	}

	public void updateListObject(String hql) {
		// TODO Auto-generated method stub
		baseDao.updateListObject(hql);
	}

	public YAccount findUserinfoByUserid(int userid) {
		// TODO Auto-generated method stub
		return (YAccount) baseDao.bean(" from YAccount as u where u.accountId = " + userid + "");
	}

	public YAccount findUserinfoByUserName(String username) {
		// TODO Auto-generated method stub
		return (YAccount) baseDao
				.bean(" from YAccount as u where u.accountName = '" + username + "' order by u.accountId desc ");
	}

	public Object getObjectInfo(String hql) {
		// TODO Auto-generated method stub
		return baseDao.bean(hql);
	}

	public YAccount login(String name, String password) {
		// TODO Auto-generated method stub
		return (YAccount) baseDao.bean(" from YAccount as au where au.accountName = '" + name
				+ "' and au.accountPassword = '" + password + "'");
	}

	public int saveUserinfo(YAccount account) {
		// TODO Auto-generated method stub
		YAccount user = new YAccount();
		return Integer.parseInt(baseDao.save(user).toString());
	}
}

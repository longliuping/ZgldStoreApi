package com.zgld.api.biz.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.zgld.api.beans.YAccount;
import com.zgld.api.biz.BaseBiz;
import com.zgld.api.dao.BaseDao;

public class BaseBizImpl implements BaseBiz {
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
		return (YAccount) baseDao.bean(" from AspnetUsers as u where u.userId = " + userid + "");
	}

	public YAccount findUserinfoByUserName(String username) {
		// TODO Auto-generated method stub
		return (YAccount) baseDao.bean(" from AspnetUsers as u where u.userName = '" + username + "' order by u.userId desc ");
	}

	public Object getObjectInfo(String hql) {
		// TODO Auto-generated method stub
		return baseDao.bean(hql);
	}

	public YAccount login(String name, String password) {
		// TODO Auto-generated method stub
		return (YAccount) baseDao.bean(" from AspnetUsers as au where au.userName = '" + name + "' and au.password = '" + password + "'");
	}

	public int saveUserinfo(YAccount account) {
		// TODO Auto-generated method stub
		YAccount user = new YAccount();
		return Integer.parseInt(baseDao.save(user).toString());
	}
}

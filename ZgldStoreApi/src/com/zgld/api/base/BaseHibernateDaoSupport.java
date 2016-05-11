package com.zgld.api.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseHibernateDaoSupport extends HibernateDaoSupport {
	public List<Object> findObjectPage(int pageNum, int pageSize, String hql) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		List list = query.list();

		return list;
	}

	public int countObject(String hql) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		int count = ((Long) query.iterate().next()).intValue();
		return count;
	}

	public Object totalBaseObject(String hql) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		return query.iterate().next();
	}

	public void deleteObject(Object object) {
		getHibernateTemplate().delete(object);
	}

	public Serializable saveObject(Object object) {
		return getHibernateTemplate().save(object);
	}

	public void updateObject(Object object) {
		getHibernateTemplate().update(object);
	}

	public Object beanObject(String hql) {
		Object object = null;
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List list = query.list();
		if (list != null) {
			for (Iterator localIterator = list.iterator(); localIterator.hasNext();) {
				Object object2 = localIterator.next();
				object = object2;
			}

		}

		return object;
	}

	public Object findAllObject(String hql) {
		return getHibernateTemplate().find(hql);
	}

	public void updateAllObject(final String hql) {
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List result = new ArrayList();
				Query query = session.createQuery(hql);
				result.add(Integer.valueOf(query.executeUpdate()));
				return result;
			}
		});
	}
}
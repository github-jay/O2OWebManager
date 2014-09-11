package com.o2oweb.common.dao;

/**
 * @author 作者姓名 zj
 * 类说明
 */
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import com.o2oweb.common.dao.support.BeanUtils;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.common.dao.support.PageBean;

@Component
public class HibernateGenericDao extends HibernateDaoSupport {
	@Resource(name = "sessionFactory")
	public void setSuperHibernateTemplate(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> entityClass, Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<T> entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<T> entityClass, String orderBy,
			boolean isAsc) {
		Assert.hasText(orderBy);
		if (isAsc) {
			return getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(entityClass).addOrder(
							Order.asc(orderBy)));
		}
		return getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(entityClass).addOrder(
						Order.desc(orderBy)));
	}

	public void save(Object o) {
		getHibernateTemplate().saveOrUpdate(o);
	}

	@SuppressWarnings("unchecked")
	public void save(Collection c) {
		getHibernateTemplate().saveOrUpdateAll(c);
	}

	public void merge(Object t) {
		getHibernateTemplate().merge(t);
	}

	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	public void remove(Object o) {
		getHibernateTemplate().delete(o);
	}

	@SuppressWarnings("unchecked")
	public void removeAll(Collection c) {
		getHibernateTemplate().deleteAll(c);
	}

	@SuppressWarnings("unchecked")
	public void deleteAll(Collection collection) {
		getHibernateTemplate().deleteAll(collection);
	}

	public <T> void removeById(Class<T> entityClass, Serializable id) {
		remove(get(entityClass, id));
	}

	public void flush() {
		getHibernateTemplate().flush();
	}

	public void clear() {
		getHibernateTemplate().clear();
	}

	public Query createQuery(String hql, Object[] values) {
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}

	public <T> Criteria createCriteria(Class<T> entityClass,
			Criterion[] criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	public <T> Criteria createCriteria(Class<T> entityClass, String orderBy,
			boolean isAsc, Criterion[] criterions) {
		Assert.hasText(orderBy);

		Criteria criteria = createCriteria(entityClass, criterions);

		if (isAsc)
			criteria.addOrder(Order.asc(orderBy));
		else {
			criteria.addOrder(Order.desc(orderBy));
		}
		return criteria;
	}

	public List find(String hql, Object[] values) {
		Assert.hasText(hql);
		return getHibernateTemplate().find(hql, values);
	}

	@SuppressWarnings("unchecked")
	public List find(String hql) {
		if ((hql == null) || (hql.trim().equals(""))) {
			return null;
		}
		return getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findBy(Class<T> entityClass, String propertyName,
			Object value) {
		Assert.hasText(propertyName);
		return createCriteria(entityClass,
				new Criterion[] { Restrictions.eq(propertyName, value) })
				.list();
	}

	public <T> List<T> findBy(Class<T> entityClass, String propertyName,
			Object value, String orderBy, boolean isAsc) {
		Assert.hasText(propertyName);
		Assert.hasText(orderBy);
		return createCriteria(entityClass, orderBy, isAsc,
				new Criterion[] { Restrictions.eq(propertyName, value) })
				.list();
	}

	public <T> T findUniqueBy(Class<T> entityClass, String propertyName,
			Object value) {
		Assert.hasText(propertyName);
		return (T) createCriteria(entityClass,
				new Criterion[] { Restrictions.eq(propertyName, value) })
				.uniqueResult();
	}

	public Page pagedQuery(String hql, int startIndex, int pageSize,
			Object[] values) {
		Assert.hasText(hql);
		Assert.isTrue(startIndex >= 0, "startIndex should start from 0");

		String countQueryString = " select count (*) "
				+ removeSelect(removeOrders(hql));
		List countlist = getHibernateTemplate().find(countQueryString, values);
		long totalCount = ((Long) countlist.get(0)).longValue();

		if (totalCount < 1L) {
			return new Page();
		}
		Query query = createQuery(hql, values);

		if (pageSize > 0) {
			if (startIndex < 0) {
				query.setFirstResult(0);
			} else {
				if (startIndex >= totalCount) {
					return new Page();
				}
				query.setFirstResult(startIndex);
			}
			query.setMaxResults(pageSize);
		}
		return new Page(startIndex, totalCount, pageSize, query.list());
	}

	public PageBean pageQuery(String hql, int pageNo, int pageSize,
			Object[] values) {
		Assert.hasText(hql);

		if (pageNo == 0) {
			pageNo = 1;
		}

		String countQueryString = " select count (*) "
				+ removeSelect(removeOrders(hql));
		List countlist = getHibernateTemplate().find(countQueryString, values);
		int totalCount = 0;
		if ((countlist != null) && (countlist.size() > 0))
			totalCount = ((Long) countlist.get(0)).intValue();

		if (totalCount < 1) {
			return new PageBean();
		}
		int startIndex = PageBean.countOffset(pageSize, pageNo);

		while (startIndex >= totalCount) {
			pageNo--;
			startIndex = PageBean.countOffset(pageSize, pageNo);
		}

		Query query = createQuery(hql, values);
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize)
				.list();

		return new PageBean(totalCount, pageNo, pageSize, list);
	}

	public PageBean pagedQuery(Criteria criteria, int pageNo, int pageSize) {
		Assert.notNull(criteria);

		if (pageNo == 0) {
			pageNo = 1;
		}

		CriteriaImpl impl = (CriteriaImpl) criteria;

		Projection projection = impl.getProjection();
		try {
			List orderEntries = (List) BeanUtils.forceGetProperty(impl,
					"orderEntries");
			BeanUtils.forceSetProperty(impl, "orderEntries", new ArrayList());
		} catch (Exception e) {
			throw new InternalError(" Runtime Exception impossibility throw ");
		}
		List orderEntries = null;
		int totalCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();

		criteria.setProjection(projection);

		criteria
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		try {
			BeanUtils.forceSetProperty(impl, "orderEntries", orderEntries);
		} catch (Exception e) {
			throw new InternalError(" Runtime Exception impossibility throw ");
		}

		if (totalCount < 1) {
			return new PageBean();
		}
		int startIndex = PageBean.countOffset(pageSize, pageNo);
		while (startIndex >= totalCount) {
			pageNo--;
			startIndex = PageBean.countOffset(pageSize, pageNo);
		}
		List list = criteria.setFirstResult(startIndex).setMaxResults(pageSize)
				.list();
		return new PageBean(totalCount, pageNo, pageSize, list);
	}

	public PageBean pageQuery(DetachedCriteria detachedCriteria,
			int startIndex, int pageSize) {
		Assert.notNull(detachedCriteria);

		Criteria criteria = detachedCriteria
				.getExecutableCriteria(getSession());
		CriteriaImpl impl = (CriteriaImpl) criteria;

		Projection projection = impl.getProjection();
		try {
			List orderEntries = (List) BeanUtils.forceGetProperty(impl,
					"orderEntries");
			BeanUtils.forceSetProperty(impl, "orderEntries", new ArrayList());
		} catch (Exception e) {
			throw new InternalError(" Runtime Exception impossibility throw ");
		}
		List orderEntries = null;
		int totalCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();

		criteria.setProjection(projection);
		if (projection == null) {
			criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		try {
			BeanUtils.forceSetProperty(impl, "orderEntries", orderEntries);
		} catch (Exception e) {
			throw new InternalError(" Runtime Exception impossibility throw ");
		}

		if (totalCount < 1) {
			return new PageBean();
		}
		if (pageSize > 0) {
			if (startIndex < 0)
				criteria.setFirstResult(0);
			else if (startIndex >= totalCount)
				criteria.setFirstResult(totalCount - 1);
			else {
				criteria.setFirstResult(startIndex);
			}
			criteria.setMaxResults(pageSize);
		}
		return new PageBean(totalCount, startIndex, pageSize, criteria.list());
	}

	public Page pagedQuery(DetachedCriteria detachedCriteria, int startIndex,
			int pageSize) {
		Assert.notNull(detachedCriteria);
		Assert.isTrue(startIndex >= 0, "startIndex should start from 0");

		Criteria criteria = detachedCriteria
				.getExecutableCriteria(getSession());
		CriteriaImpl impl = (CriteriaImpl) criteria;

		Projection projection = impl.getProjection();
		
		System.out.println("criteria:" + criteria + ",projection:" + projection);

		long totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).longValue();

		criteria.setProjection(projection);
		if (projection == null) {
			criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}

		if (totalCount < 1L)
			return new Page();
		if (pageSize <= 0) {
			pageSize = (int) totalCount;
		}
		if (pageSize > 0) {
			if (startIndex < 0) {
				criteria.setFirstResult(0);
			} else {
				if (startIndex >= totalCount) {
					return new Page();
				}
				criteria.setFirstResult(startIndex);
			}
			criteria.setMaxResults(pageSize);
		}
//		System.out.println(startIndex + " " + totalCount + " " + pageSize);
		return new Page(startIndex, totalCount, pageSize, criteria.list());
	}

	public PageBean pagedQuery(Class entityClass, int pageNo, int pageSize,
			Criterion[] criterions) {
		Criteria criteria = createCriteria(entityClass, criterions);
		return pagedQuery(criteria, pageNo, pageSize);
	}

	public PageBean pagedQuery(Class entityClass, int pageNo, int pageSize,
			String orderBy, boolean isAsc, Criterion[] criterions) {
		Criteria criteria = createCriteria(entityClass, orderBy, isAsc,
				criterions);
		return pagedQuery(criteria, pageNo, pageSize);
	}

	public <T> boolean isUnique(Class<T> entityClass, Object entity,
			String uniquePropertyNames) {
		Assert.hasText(uniquePropertyNames);
		Criteria criteria = createCriteria(entityClass, new Criterion[0])
				.setProjection(Projections.rowCount());
		String[] nameList = uniquePropertyNames.split(",");
		try {
			for (String name : nameList) {
				criteria.add(Restrictions.eq(name, PropertyUtils.getProperty(
						entity, name)));
			}

			String idName = getIdName(entityClass);

			Serializable id = getId(entityClass, entity);

			if (id != null)
				criteria.add(Restrictions.not(Restrictions.eq(idName, id)));
		} catch (Exception e) {
			ReflectionUtils.handleReflectionException(e);
		}
		return ((Integer) criteria.uniqueResult()).intValue() == 0;
	}

	public Serializable getId(Class entityClass, Object entity)
			throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		Assert.notNull(entity);
		Assert.notNull(entityClass);
		return (Serializable) PropertyUtils.getProperty(entity,
				getIdName(entityClass));
	}

	public String getIdName(Class clazz) {
		Assert.notNull(clazz);
		ClassMetadata meta = getSessionFactory().getClassMetadata(clazz);
		Assert.notNull(meta, "Class " + clazz
				+ " not define in hibernate session factory.");
		String idName = meta.getIdentifierPropertyName();
		Assert.hasText(idName, clazz.getSimpleName()
				+ " has no identifier property define.");
		return idName;
	}

	public static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql
				+ " must has a keyword 'from'");
		return hql.substring(beginPos);
	}

	public static String removeGroup(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("group\\s*by[\\w|\\W|\\s|\\S]*", 2);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	public static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", 2);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	public void saveAll(Collection transientInstance) {
		try {
			getHibernateTemplate().saveOrUpdateAll(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(String hqlDelete, Object[] parameter) {
		Query query = getSession().createQuery(hqlDelete);
		if ((parameter != null) && (parameter.length > 0)) {
			for (int i = 0; i < parameter.length; i++) {
				query.setParameter(i, parameter[i]);
			}
		}
		query.executeUpdate();
	}

	public List getObjectsMap(String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	// hql,不要参数
    public int count(final String hql) {
        return count(hql, null);
    }
   
    // hql,一个参数
    public int count(final String hql, final Object value) {
        return count(hql, new Object[] { value });
    }
   
    // hql,多个参数
    public int count(final String hql, final Object[] values) {
        int rowCount = (Integer) getHibernateTemplate().execute(
                new HibernateCallback() {
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        String hql2 = hql;
                        // 截断order by
                        int endIndex = hql2.lastIndexOf("order by");
                        if (endIndex > 0) {
                            hql2 = hql2.substring(0, endIndex);
                        }
                        Query query = session.createQuery(hql2);
                        if (values != null) {
                            for (int i = 0; i < values.length; ++i) {
                                query.setParameter(i, values[i]);
                            }
                        }
                        return Integer.parseInt(query.list().get(0).toString());
                    }
                });
        return rowCount;
    }
    
	 // hql,0个参数
    public <T> int update(final String hql) {
        return update(hql, null);
    }
   
    // hql,1个参数
    public <T> int update(final String hql, final Object value) {
        return update(hql, new Object[] { value });
    }
   
    // hql,多个参数
    public <T> int update(final String hql, final Object[] values) {
        int affectedRow = (Integer) getHibernateTemplate().execute(
                new HibernateCallback() {
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        Query update = session.createQuery(hql);
                        if (values != null) {
                            for (int i = 0; i < values.length; ++i) {
                                update.setParameter(i, values[i]);
                            }
                        }
                        return update.executeUpdate();
                    }
                });
        return affectedRow;
    }

	public void updateAllByTransaction(List<?> list) {
		updateAllByTransaction(list, 50);
	}

	public void updateAllByTransaction(List<?> list, int max_size) {
		Session session = null;
		boolean bln_tr = false;
		Transaction transaction = null;
		try {
			session = getSession();

			bln_tr = session.getTransaction().isActive();
			if ((list != null) && (list.size() > 0)) {
				if (!bln_tr) {
					transaction = session.beginTransaction();
				}
				int count = 0;
				if (max_size <= 0) {
					max_size = 50;
				}
				for (Iterator localIterator = list.iterator(); localIterator
						.hasNext();) {
					Object obj = localIterator.next();
					if (obj != null) {
						session.update(obj);
					}

				}

				if (!bln_tr)
					transaction.commit();
			}
		} catch (Exception e) {
			if ((!bln_tr) && (session != null))
				transaction.rollback();
		} finally {
			if ((!bln_tr) && (session != null))
				session.close();
		}
	}

	public void saveAllByTransaction(Collection<?> list) {
		saveAllByTransaction(list, 50);
	}

	public void saveAllByTransaction(Collection<?> list, int max_size) {
		Session session = null;
		boolean bln_tr = false;
		Transaction transaction = null;
		try {
			session = getSession();

			bln_tr = session.getTransaction().isActive();
			if ((list != null) && (list.size() > 0)) {
				if (!bln_tr) {
					transaction = session.beginTransaction();
				}
				int count = 0;
				if (max_size <= 0) {
					max_size = 50;
				}
				for (Iterator localIterator = list.iterator(); localIterator
						.hasNext();) {
					Object obj = localIterator.next();
					if (obj != null) {
						session.saveOrUpdate(obj);
					}

				}

				if (!bln_tr)
					transaction.commit();
			}
		} catch (Exception e) {
			if ((!bln_tr) && (session != null))
				transaction.rollback();
		} finally {
			if ((!bln_tr) && (session != null))
				session.close();
		}
	}

	public void deleteBatchById(String sql, List<Integer> list) {
		deleteBatchById(sql, list, 1000);
	}

	public void deleteBatchById(String sql, List<Integer> list, int max_size) {
		if ((list == null) || (list.size() <= 0) || (max_size <= 0)) {
			return;
		}
		Session session = null;
		Connection conn = null;
		PreparedStatement p = null;
		Transaction tx = null;
		boolean bln = false;
		try {
			session = getSession();
			bln = session.getTransaction().isActive();
			if (!bln) {
				tx = session.beginTransaction();
			}
			conn = session.connection();
			conn.setAutoCommit(false);
			p = conn.prepareStatement(sql);
			int count = 0;
			for (Integer id : list) {
				p.setInt(1, id.intValue());
				p.addBatch();
				if (count++ >= max_size) {
					p.executeBatch();

					count = 0;
					p.clearBatch();
					p.clearParameters();
				}
			}
			if (count > 0) {
				p.executeBatch();
			}
			if (!bln)
				tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			try {
				if (p != null) {
					p.close();
					p = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception localException1) {
			}
		} finally {
			try {
				if (p != null) {
					p.close();
					p = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception localException2) {
			}
		}
	}

	public void saveAllByTransactionForMQ(List<?> list, int max_size) {
		Session session = null;
		boolean bln_tr = false;
		Transaction transaction = null;
		try {
			session = getSession();

			bln_tr = session.getTransaction().isActive();
			if ((list != null) && (list.size() > 0)) {
				if (!bln_tr) {
					transaction = session.beginTransaction();
				}
				int count = 0;
				if (max_size <= 0) {
					max_size = 50;
				}
				for (Iterator localIterator = list.iterator(); localIterator
						.hasNext();) {
					Object obj = localIterator.next();
					if (obj != null) {
						session.save(obj);

						if (count++ == max_size) {
							count = 0;
							session.flush();
							session.clear();
						}
					}
				}

				if (!bln_tr)
					transaction.commit();
			}
		} catch (Exception e) {
			this.logger.error("saveAllByTransactionForMQ 报错", e);
			if ((!bln_tr) && (session != null))
				transaction.rollback();
		} finally {
			if ((!bln_tr) && (session != null))
				session.close();
		}
	}

	public <T> List<T> findAllByCriteria(final DetachedCriteria detachedCriteria) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Criteria criteria = detachedCriteria
						.getExecutableCriteria(session);
				detachedCriteria
						.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
				return criteria.list();
			}
		}, true);
	}

	public List getListForPage(final String hql, final int offset,
			final int length) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}

	public void updateAllByTransactionForMQ(List<?> list, int max_size) {
		Session session = null;
		boolean bln_tr = false;
		Transaction transaction = null;
		try {
			session = getSession();

			bln_tr = session.getTransaction().isActive();
			if ((list != null) && (list.size() > 0)) {
				if (!bln_tr) {
					transaction = session.beginTransaction();
				}
				int count = 0;
				if (max_size <= 0) {
					max_size = 50;
				}
				for (Iterator localIterator = list.iterator(); localIterator
						.hasNext();) {
					Object obj = localIterator.next();
					if (obj != null) {
						session.update(obj);

						if (count++ == max_size) {
							count = 0;
							session.flush();
							session.clear();
						}
					}
				}

				if (!bln_tr)
					transaction.commit();
			}
		} catch (Exception e) {
			this.logger.error("updateAllByTransactionForMQ 报错", e);
			if ((!bln_tr) && (session != null))
				transaction.rollback();
		} finally {
			if ((!bln_tr) && (session != null))
				session.close();
		}
	}
}
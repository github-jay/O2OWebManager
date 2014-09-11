package com.o2oweb.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

import com.o2oweb.common.dao.support.GenericsUtils;

/**
 * @author ×÷ÕßÐÕÃû zj
 */
public class HibernateEntityDao<T> extends HibernateGenericDao implements
		EntityDao<T> {

	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public HibernateEntityDao() {
		this.entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}

	protected Class<T> getEntityClass()
	  {
	    return this.entityClass;
	  }

	  public T get(Serializable id)
	  {
	    return get(getEntityClass(), id);
	  }

	  public List<T> getAll()
	  {
	    return getAll(getEntityClass());
	  }

	  public List<T> getAll(String orderBy, boolean isAsc)
	  {
	    return getAll(getEntityClass(), orderBy, isAsc);
	  }

	  public void removeById(Serializable id)
	  {
	    removeById(getEntityClass(), id);
	  }

	  public Criteria createCriteria(Criterion[] criterions)
	  {
	    return createCriteria(getEntityClass(), criterions);
	  }

	  public Criteria createCriteria(String orderBy, boolean isAsc, Criterion[] criterions)
	  {
	    return createCriteria(getEntityClass(), orderBy, isAsc, criterions);
	  }

	  public List<T> findBy(String propertyName, Object value)
	  {
	    return findBy(getEntityClass(), propertyName, value);
	  }

	  public List<T> findBy(String propertyName, Object value, String orderBy, boolean isAsc)
	  {
	    return findBy(getEntityClass(), propertyName, value, orderBy, isAsc);
	  }

	  public T findUniqueBy(String propertyName, Object value)
	  {
	    return findUniqueBy(getEntityClass(), propertyName, value);
	  }

	  public boolean isUnique(Object entity, String uniquePropertyNames)
	  {
	    return isUnique(getEntityClass(), entity, uniquePropertyNames);
	  }

	  public void evcit(Object entity)
	  {
	    getHibernateTemplate().evict(entity);
	  }

}
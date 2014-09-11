package com.o2oweb.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.Order;

public interface OrderDao {
	public void save(Order order);
	public void remove(Order order);
	public void update(Order order);
	public Order getOrder(String OrderNum);
	public Page pagedQuery(DetachedCriteria detachedCriteria, int start, int limit);
}

package com.o2oweb.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.OrderDao;
import com.o2oweb.entity.Order;
import com.o2oweb.entity.OrderItem;
@Component("OrderDao")
public class OrderDaoImpl extends HibernateEntityDao<Order> implements OrderDao{

	public void save(Order order) {
		// TODO Auto-generated method stub
		super.save(order);
		
	}

	public void remove(Order order) {
		// TODO Auto-generated method stub
		List<OrderItem> items = super.find("from Orderitem o where o.orderNum=?", new Object[]{order.getOrderNum()});
		super.removeAll(items);
		super.remove(order);
	}

	public void update(Order order) {
		// TODO Auto-generated method stub
		super.save(order);
	}

	public Order getOrder(String OrderNum) {
		// TODO Auto-generated method stub
		List result = super.find("from Order o where o.orderNum=?", new Object[]{OrderNum});
		if (result != null && result.size() != 0)
			return (Order) result.get(0);
		else
			return null;
	}
	public Page pagedQuery(DetachedCriteria detachedCriteria, int start, int limit) {
		return super.pagedQuery(detachedCriteria, start, limit);
	}
}

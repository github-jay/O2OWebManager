package com.o2oweb.service;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.o2oweb.bo.RequestParamBean;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.OrderDao;
import com.o2oweb.entity.Order;

@Component("orderService")
public class OrderService {

	private OrderDao orderDao;

	public void save(Order order) {
		this.orderDao.save(order);
	}

	public void remove(Order order) {
		this.orderDao.remove(order);
	}

	public void update(Order order) {
		this.orderDao.update(order);
	}

	public Order getOrder(String OrderNum) {
		return orderDao.getOrder(OrderNum);
	}

	public Page findPageBean(RequestParamBean paramBean) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Order.class);
		if (paramBean == null) {
			return null;
		}
		return this.orderDao.pagedQuery(detachedCriteria, paramBean.getStart(),
				paramBean.getLimit());
	}

	@Resource
	public void setorderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}

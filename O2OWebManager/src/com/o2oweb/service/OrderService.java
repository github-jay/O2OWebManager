package com.o2oweb.service;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

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

	public Page pagedQuery(DetachedCriteria dc,int rows,int page){
		Page p = this.orderDao.pagedQuery(dc, rows * page, rows);
		return p;
	}

	@Resource
	public void setorderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}

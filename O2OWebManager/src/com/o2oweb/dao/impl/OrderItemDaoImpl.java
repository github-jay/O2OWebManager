package com.o2oweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.OrderItemDao;
import com.o2oweb.entity.OrderItem;

@Component("orderItemDao")
public class OrderItemDaoImpl extends HibernateEntityDao<OrderItem> implements
		OrderItemDao {

	public void save(OrderItem orderItem) {
		super.merge(orderItem);
	}

	public void update(OrderItem orderItem) {
		super.merge(orderItem);
	}

	public void remove(OrderItem orderItem) {
		super.remove(orderItem);
	}

	public OrderItem getOrderItem(int orderItemID) {
		return super.findUniqueBy("idOrderItem", orderItemID);
	}

	public List<OrderItem> getItems(String orderNum) {
		List<OrderItem> result = super.find(
				"from Orderitem o where o.orderNum=?",
				new Object[] { orderNum });
		return result;
	}

}

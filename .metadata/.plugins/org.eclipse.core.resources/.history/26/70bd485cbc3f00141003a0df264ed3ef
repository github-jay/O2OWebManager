package com.o2oweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.OrderItemDao;
import com.o2oweb.entity.Orderitem;

@Component("orderItemDao")
public class OrderItemDaoImpl extends HibernateEntityDao<Orderitem> implements
		OrderItemDao {

	public void save(Orderitem orderItem) {
		super.merge(orderItem);
	}

	public void update(Orderitem orderItem) {
		super.merge(orderItem);
	}

	public void remove(Orderitem orderItem) {
		super.remove(orderItem);
	}

	public Orderitem getOrderItem(int orderItemID) {
		return super.findUniqueBy("idOrderItem", orderItemID);
	}

	public List<Orderitem> getItems(String orderNum) {
		List<Orderitem> result = super.find(
				"from Orderitem o where o.orderNum=?",
				new Object[] { orderNum });
		return result;
	}

}

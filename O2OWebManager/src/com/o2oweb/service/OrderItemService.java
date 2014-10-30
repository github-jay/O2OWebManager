package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.OrderItemDao;
import com.o2oweb.entity.OrderItem;
import com.o2oweb.util.PriceUtil;

@Component("orderItemService")
public class OrderItemService {

	private OrderItemDao orderItemDao;

	public void save(OrderItem orderItem) {
		this.orderItemDao.save(orderItem);
	}

	public void remove(OrderItem orderItem) {
		this.orderItemDao.remove(orderItem);
	}

	public void update(OrderItem orderItem) {
		this.orderItemDao.update(orderItem);
	}

	public OrderItem getOrderItem(int orderItemID) {
		return orderItemDao.getOrderItem(orderItemID);
	}

	public List<OrderItem> getItems(String orderNum) {
		return orderItemDao.getItems(orderNum);
	}

	public float getTotalPriceByOrderNum(String orderNum) {
		List<OrderItem> list = this.orderItemDao.getItems(orderNum);

		return PriceUtil.getTotal(list);
	}

	@Resource
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}
}

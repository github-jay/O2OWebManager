package com.o2oweb.dao;

import java.util.List;

import com.o2oweb.entity.OrderItem;

public interface OrderItemDao {
	public void save(OrderItem orderItem);
	public void update(OrderItem orderItem);
	public void remove(OrderItem orderItem);
	public OrderItem getOrderItem(int orderItemID);
	public List<OrderItem> getItems(String orderNum);
}

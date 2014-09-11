package com.o2oweb.dao;

import java.util.List;

import com.o2oweb.entity.Orderitem;

public interface OrderItemDao {
	public void save(Orderitem orderItem);
	public void update(Orderitem orderItem);
	public void remove(Orderitem orderItem);
	public Orderitem getOrderItem(int orderItemID);
	public List<Orderitem> getItems(String orderNum);
}

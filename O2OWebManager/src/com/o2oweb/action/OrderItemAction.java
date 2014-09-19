package com.o2oweb.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.entity.OrderItem;
import com.o2oweb.service.OrderItemService;
import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("orderItemAction")
public class OrderItemAction extends BaseAction {

	private OrderItemService orderItemService;

	private Integer idOrderItem;
	private Integer itemId;
	private String orderNum;
	private Integer itemNum;
	private float itemPrice;

	public void save() {
		OrderItem orderItem = new OrderItem(itemId, orderNum, itemNum,
				itemPrice);

		this.orderItemService.save(orderItem);

		writeResponse(true);
	}

	public void remove() {
		OrderItem orderItem = new OrderItem();
		orderItem.setIdOrderItem(idOrderItem);

		this.orderItemService.remove(orderItem);

		writeResponse(true);
	}

	public void update() {
		OrderItem orderItem = new OrderItem(itemId, orderNum, itemNum,
				itemPrice);
		orderItem.setIdOrderItem(idOrderItem);

		this.orderItemService.update(orderItem);

		writeResponse(true);
	}

	public void getOrderItem() {
		OrderItem orderItem = this.orderItemService.getOrderItem(idOrderItem);

		JSONObject obj = JSONObject.fromObject(orderItem);
		writeResponse(obj.toString());
	}

	public void getAllByOrderNum() {
		List<OrderItem> list = this.orderItemService.getItems(orderNum);

		JSONArray array = JSONArray.fromObject(list);
		writeResponse(array.toString());
	}

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}

	@Resource
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	public Integer getIdOrderItem() {
		return idOrderItem;
	}

	public void setIdOrderItem(Integer idOrderItem) {
		this.idOrderItem = idOrderItem;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getItemNum() {
		return itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

}

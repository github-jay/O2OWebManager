package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderitem", catalog = "o2owebsit")
public class OrderItem implements java.io.Serializable {

	// Fields

	private Integer idOrderItem;
	private Integer itemId;
	private String orderNum;
	private Integer itemNum;
	private float itemPrice;

	// Constructors

	/** default constructor */
	public OrderItem() {
	}

	/** full constructor */
	public OrderItem(Integer itemId, String orderNum, Integer itemNum,
			float itemPrice) {
		this.itemId = itemId;
		this.orderNum = orderNum;
		this.itemNum = itemNum;
		this.itemPrice = itemPrice;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "idOrderItem", unique = true, nullable = false)
	public Integer getIdOrderItem() {
		return this.idOrderItem;
	}

	public void setIdOrderItem(Integer idOrderItem) {
		this.idOrderItem = idOrderItem;
	}

	@Column(name = "ItemId", nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "OrderNum", nullable = false, length = 45)
	public String getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "ItemNum", nullable = false)
	public Integer getItemNum() {
		return this.itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	@Column(name = "ItemPrice", nullable = false, precision = 12, scale = 0)
	public float getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

}
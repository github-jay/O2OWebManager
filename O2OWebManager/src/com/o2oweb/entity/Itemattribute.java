package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Itemattribute entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "itemattribute", catalog = "o2owebsit")
public class Itemattribute implements java.io.Serializable {

	// Fields

	private Integer itemAttributeId;
	private String attributeDetail;
	private Integer itemId;
	private Integer fatherId=0;

	// Constructors

	/** default constructor */
	public Itemattribute() {
	}

	/** full constructor */
	public Itemattribute(String attributeDetail, Integer itemId,
			Integer fatherId) {
		this.attributeDetail = attributeDetail;
		this.itemId = itemId;
		this.fatherId = fatherId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ItemAttributeId", unique = true, nullable = false)
	public Integer getItemAttributeId() {
		return this.itemAttributeId;
	}

	public void setItemAttributeId(Integer itemAttributeId) {
		this.itemAttributeId = itemAttributeId;
	}

	@Column(name = "AttributeDetail", nullable = false, length = 45)
	public String getAttributeDetail() {
		return this.attributeDetail;
	}

	public void setAttributeDetail(String attributeDetail) {
		this.attributeDetail = attributeDetail;
	}

	@Column(name = "ItemId", nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "FatherId", nullable = false,columnDefinition="INT default 0")
	public Integer getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

}
package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sailer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sailer", catalog = "o2owebsit")
public class Sailer implements java.io.Serializable {

	// Fields

	private Integer sailerId;
	private String name;
	private String address;
	private Integer addCode;
	private String conName;
	private String conTel;

	// Constructors

	/** default constructor */
	public Sailer() {
	}

	/** minimal constructor */
	public Sailer(String name, String address, Integer addCode) {
		this.name = name;
		this.address = address;
		this.addCode = addCode;
	}

	/** full constructor */
	public Sailer(String name, String address, Integer addCode, String conName,
			String conTel) {
		this.name = name;
		this.address = address;
		this.addCode = addCode;
		this.conName = conName;
		this.conTel = conTel;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "sailerid", unique = true, nullable = false)
	public Integer getSailerId() {
		return this.sailerId;
	}

	public void setSailerId(Integer sailerId) {
		this.sailerId = sailerId;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", nullable = false, length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "addCode", nullable = false)
	public Integer getAddCode() {
		return this.addCode;
	}

	public void setAddCode(Integer addCode) {
		this.addCode = addCode;
	}

	@Column(name = "conName", length = 45)
	public String getConName() {
		return this.conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	@Column(name = "conTel", length = 45)
	public String getConTel() {
		return this.conTel;
	}

	public void setConTel(String conTel) {
		this.conTel = conTel;
	}

}
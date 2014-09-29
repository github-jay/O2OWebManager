package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Itemf entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "itemf", catalog = "o2owebsit")
public class Itemf implements java.io.Serializable {

	// Fields

	private Integer idItemF;
	private Integer fnum;
	private String fname;
	private Integer indexId;
	private Integer item1;
	private Integer item2;
	private Integer item3;
	private Integer item4;
	private Integer item5;
	private Integer item6;
	private Integer item7;
	private Integer item8;

	// Constructors

	/** default constructor */
	public Itemf() {
	}

	/** minimal constructor */
	public Itemf(Integer fnum, Integer indexId) {
		this.fnum = fnum;
		this.indexId = indexId;
	}

	/** full constructor */
	public Itemf(Integer fnum, String fname, Integer indexId, Integer item1,
			Integer item2, Integer item3, Integer item4, Integer item5,
			Integer item6, Integer item7, Integer item8) {
		this.fnum = fnum;
		this.fname = fname;
		this.indexId = indexId;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
		this.item7 = item7;
		this.item8 = item8;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "idItemF", unique = true, nullable = false)
	public Integer getIdItemF() {
		return this.idItemF;
	}

	public void setIdItemF(Integer idItemF) {
		this.idItemF = idItemF;
	}

	@Column(name = "Fnum", nullable = false)
	public Integer getFnum() {
		return this.fnum;
	}

	public void setFnum(Integer fnum) {
		this.fnum = fnum;
	}

	@Column(name = "FName", length = 45)
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name = "IndexId", nullable = false)
	public Integer getIndexId() {
		return this.indexId;
	}

	public void setIndexId(Integer indexId) {
		this.indexId = indexId;
	}

	@Column(name = "item1")
	public Integer getItem1() {
		return this.item1;
	}

	public void setItem1(Integer item1) {
		this.item1 = item1;
	}

	@Column(name = "item2")
	public Integer getItem2() {
		return this.item2;
	}

	public void setItem2(Integer item2) {
		this.item2 = item2;
	}

	@Column(name = "item3")
	public Integer getItem3() {
		return this.item3;
	}

	public void setItem3(Integer item3) {
		this.item3 = item3;
	}

	@Column(name = "item4")
	public Integer getItem4() {
		return this.item4;
	}

	public void setItem4(Integer item4) {
		this.item4 = item4;
	}

	@Column(name = "item5")
	public Integer getItem5() {
		return this.item5;
	}

	public void setItem5(Integer item5) {
		this.item5 = item5;
	}

	@Column(name = "item6")
	public Integer getItem6() {
		return this.item6;
	}

	public void setItem6(Integer item6) {
		this.item6 = item6;
	}

	@Column(name = "item7")
	public Integer getItem7() {
		return this.item7;
	}

	public void setItem7(Integer item7) {
		this.item7 = item7;
	}

	@Column(name = "item8")
	public Integer getItem8() {
		return this.item8;
	}

	public void setItem8(Integer item8) {
		this.item8 = item8;
	}

}
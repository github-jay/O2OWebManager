package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Index3 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "index3", catalog = "o2owebsit")
public class Index3 implements java.io.Serializable {

	// Fields

	private Integer idindex3;
	private Integer rollbarid;
	private Integer foneId;
	private Integer ftwoId;
	private Integer fthreeId;
	private Integer ffourId;

	// Constructors

	/** default constructor */
	public Index3() {
	}

	/** full constructor */
	public Index3(Integer rollbarid, Integer foneId, Integer ftwoId,
			Integer fthreeId, Integer ffourId) {
		this.rollbarid = rollbarid;
		this.foneId = foneId;
		this.ftwoId = ftwoId;
		this.fthreeId = fthreeId;
		this.ffourId = ffourId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "idindex3", unique = true, nullable = false)
	public Integer getIdindex3() {
		return this.idindex3;
	}

	public void setIdindex3(Integer idindex3) {
		this.idindex3 = idindex3;
	}

	@Column(name = "rollbarid")
	public Integer getRollbarid() {
		return this.rollbarid;
	}

	public void setRollbarid(Integer rollbarid) {
		this.rollbarid = rollbarid;
	}

	@Column(name = "FoneId")
	public Integer getFoneId() {
		return this.foneId;
	}

	public void setFoneId(Integer foneId) {
		this.foneId = foneId;
	}

	@Column(name = "FtwoId")
	public Integer getFtwoId() {
		return this.ftwoId;
	}

	public void setFtwoId(Integer ftwoId) {
		this.ftwoId = ftwoId;
	}

	@Column(name = "FthreeId")
	public Integer getFthreeId() {
		return this.fthreeId;
	}

	public void setFthreeId(Integer fthreeId) {
		this.fthreeId = fthreeId;
	}

	@Column(name = "FfourId")
	public Integer getFfourId() {
		return this.ffourId;
	}

	public void setFfourId(Integer ffourId) {
		this.ffourId = ffourId;
	}

}
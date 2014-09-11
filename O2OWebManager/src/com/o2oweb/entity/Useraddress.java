package com.o2oweb.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Useraddress entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "useraddress", catalog = "o2owebsit")
public class Useraddress implements java.io.Serializable {

	// Fields

	private Integer idUserAddress;
	private String address;
	private String username;
	private String tel;
	private Integer userId;
	private Date lastuse;

	// Constructors

	/** default constructor */
	public Useraddress() {
	}

	/** full constructor */
	public Useraddress(String address, String username, String tel,
			Integer userId, Date lastuse) {
		this.address = address;
		this.username = username;
		this.tel = tel;
		this.userId = userId;
		this.lastuse = lastuse;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "idUserAddress", unique = true, nullable = false)
	public Integer getIdUserAddress() {
		return this.idUserAddress;
	}

	public void setIdUserAddress(Integer idUserAddress) {
		this.idUserAddress = idUserAddress;
	}

	@Column(name = "Address", nullable = false, length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Username", nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "tel", nullable = false, length = 45)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "UserId", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lastuse", nullable = false, length = 10)
	public Date getLastuse() {
		return this.lastuse;
	}

	public void setLastuse(Date lastuse) {
		this.lastuse = lastuse;
	}

}
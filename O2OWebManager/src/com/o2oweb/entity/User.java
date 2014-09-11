package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "o2owebsit", uniqueConstraints = {
		@UniqueConstraint(columnNames = "userName"),
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "nickName") })
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private String tel;
	private String userQq;
	private String nickName;
	private String userLevel;
	private String score;
	private String iconAddr;
	private Integer power;
	private Integer addrId;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String password, String email, String tel,
			String userQq, Integer power) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.userQq = userQq;
		this.power = power;
	}

	/** full constructor */
	public User(String userName, String password, String email, String tel,
			String userQq, String nickName, String userLevel, String score,
			String iconAddr, Integer power, Integer addrId) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.userQq = userQq;
		this.nickName = nickName;
		this.userLevel = userLevel;
		this.score = score;
		this.iconAddr = iconAddr;
		this.power = power;
		this.addrId = addrId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "userName", unique = true, nullable = false, length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", unique = true, nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "tel", nullable = false, length = 45)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "userQQ", nullable = false, length = 45)
	public String getUserQq() {
		return this.userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	@Column(name = "nickName", unique = true, length = 45)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "userLevel", length = 45)
	public String getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	@Column(name = "score", length = 45)
	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Column(name = "IconAddr")
	public String getIconAddr() {
		return this.iconAddr;
	}

	public void setIconAddr(String iconAddr) {
		this.iconAddr = iconAddr;
	}

	@Column(name = "power", nullable = false)
	public Integer getPower() {
		return this.power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	@Column(name = "AddrId")
	public Integer getAddrId() {
		return this.addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

}
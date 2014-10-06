package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rollbar entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rollbar", catalog = "o2owebsit")
public class Rollbar implements java.io.Serializable {

	// Fields

	private Integer idRollBar;
	private Integer image1;
	private String image1name;
	private Integer image2;
	private String image2name;
	private Integer image3;
	private String image3name;
	private Integer image4;
	private String image4name;
	private Integer image5;
	private String image5name;
	private Integer image6;
	private String image6name;

	// Constructors

	/** default constructor */
	public Rollbar() {
	}

	/** full constructor */
	public Rollbar(Integer image1, String image1name, Integer image2,
			String image2name, Integer image3, String image3name,
			Integer image4, String image4name, Integer image5,
			String image5name, Integer image6, String image6name) {
		this.image1 = image1;
		this.image1name = image1name;
		this.image2 = image2;
		this.image2name = image2name;
		this.image3 = image3;
		this.image3name = image3name;
		this.image4 = image4;
		this.image4name = image4name;
		this.image5 = image5;
		this.image5name = image5name;
		this.image6 = image6;
		this.image6name = image6name;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "idRollBar", unique = true, nullable = false)
	public Integer getIdRollBar() {
		return this.idRollBar;
	}

	public void setIdRollBar(Integer idRollBar) {
		this.idRollBar = idRollBar;
	}

	@Column(name = "Image1")
	public Integer getImage1() {
		return this.image1;
	}

	public void setImage1(Integer image1) {
		this.image1 = image1;
	}

	@Column(name = "Image1Name", length = 45)
	public String getImage1name() {
		return this.image1name;
	}

	public void setImage1name(String image1name) {
		this.image1name = image1name;
	}

	@Column(name = "Image2")
	public Integer getImage2() {
		return this.image2;
	}

	public void setImage2(Integer image2) {
		this.image2 = image2;
	}

	@Column(name = "Image2Name", length = 45)
	public String getImage2name() {
		return this.image2name;
	}

	public void setImage2name(String image2name) {
		this.image2name = image2name;
	}

	@Column(name = "Image3")
	public Integer getImage3() {
		return this.image3;
	}

	public void setImage3(Integer image3) {
		this.image3 = image3;
	}

	@Column(name = "Image3Name", length = 45)
	public String getImage3name() {
		return this.image3name;
	}

	public void setImage3name(String image3name) {
		this.image3name = image3name;
	}

	@Column(name = "Image4")
	public Integer getImage4() {
		return this.image4;
	}

	public void setImage4(Integer image4) {
		this.image4 = image4;
	}

	@Column(name = "Image4Name", length = 45)
	public String getImage4name() {
		return this.image4name;
	}

	public void setImage4name(String image4name) {
		this.image4name = image4name;
	}

	@Column(name = "Image5")
	public Integer getImage5() {
		return this.image5;
	}

	public void setImage5(Integer image5) {
		this.image5 = image5;
	}

	@Column(name = "Image5Name", length = 45)
	public String getImage5name() {
		return this.image5name;
	}

	public void setImage5name(String image5name) {
		this.image5name = image5name;
	}

	@Column(name = "Image6")
	public Integer getImage6() {
		return this.image6;
	}

	public void setImage6(Integer image6) {
		this.image6 = image6;
	}

	@Column(name = "Image6Name", length = 45)
	public String getImage6name() {
		return this.image6name;
	}

	public void setImage6name(String image6name) {
		this.image6name = image6name;
	}

}
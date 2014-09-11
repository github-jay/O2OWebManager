package com.o2oweb.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rollbar entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rollbar", catalog = "o2owebsit")
public class Rollbar implements java.io.Serializable {

	// Fields

	private Integer rollBarId;
	private Image imageByRollIconId;
	private Index3ainfo index3ainfo;
	private Image imageByRollImageId;
	private String rollText;
	private Date creatTime;

	// Constructors

	/** default constructor */
	public Rollbar() {
	}

	/** minimal constructor */
	public Rollbar(Date creatTime) {
		this.creatTime = creatTime;
	}

	/** full constructor */
	public Rollbar(Image imageByRollIconId, Index3ainfo index3ainfo,
			Image imageByRollImageId, String rollText, Date creatTime) {
		this.imageByRollIconId = imageByRollIconId;
		this.index3ainfo = index3ainfo;
		this.imageByRollImageId = imageByRollImageId;
		this.rollText = rollText;
		this.creatTime = creatTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "RollBar_id", unique = true, nullable = false)
	public Integer getRollBarId() {
		return this.rollBarId;
	}

	public void setRollBarId(Integer rollBarId) {
		this.rollBarId = rollBarId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RollIconID")
	public Image getImageByRollIconId() {
		return this.imageByRollIconId;
	}

	public void setImageByRollIconId(Image imageByRollIconId) {
		this.imageByRollIconId = imageByRollIconId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PageId")
	public Index3ainfo getIndex3ainfo() {
		return this.index3ainfo;
	}

	public void setIndex3ainfo(Index3ainfo index3ainfo) {
		this.index3ainfo = index3ainfo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RollImageID")
	public Image getImageByRollImageId() {
		return this.imageByRollImageId;
	}

	public void setImageByRollImageId(Image imageByRollImageId) {
		this.imageByRollImageId = imageByRollImageId;
	}

	@Column(name = "RollText", length = 45)
	public String getRollText() {
		return this.rollText;
	}

	public void setRollText(String rollText) {
		this.rollText = rollText;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CreatTime", nullable = false, length = 10)
	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

}
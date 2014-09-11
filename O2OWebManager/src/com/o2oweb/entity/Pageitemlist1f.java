package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Pageitemlist1f entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pageitemlist1f", catalog = "o2owebsit")
public class Pageitemlist1f extends AbstractPageitem implements java.io.Serializable {

	// Fields

	private Integer listItemId;
	private Index3ainfo index3ainfo;
	private Image image;
	private String itemName;
	private Integer itemId;

	// Constructors

	/** default constructor */
	public Pageitemlist1f() {
	}

	/** minimal constructor */
	public Pageitemlist1f(Index3ainfo index3ainfo, String itemName,
			Integer itemId) {
		this.index3ainfo = index3ainfo;
		this.itemName = itemName;
		this.itemId = itemId;
	}

	/** full constructor */
	public Pageitemlist1f(Index3ainfo index3ainfo, Image image,
			String itemName, Integer itemId) {
		this.index3ainfo = index3ainfo;
		this.image = image;
		this.itemName = itemName;
		this.itemId = itemId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ListItemId", unique = true, nullable = false)
	public Integer getListItemId() {
		return this.listItemId;
	}

	public void setListItemId(Integer listItemId) {
		this.listItemId = listItemId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "page_id", nullable = false)
	public Index3ainfo getIndex3ainfo() {
		return this.index3ainfo;
	}

	public void setIndex3ainfo(Index3ainfo index3ainfo) {
		this.index3ainfo = index3ainfo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ItemImageID")
	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Column(name = "ItemName", nullable = false, length = 45)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "ItemId", nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

}
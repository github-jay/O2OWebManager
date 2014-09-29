package com.o2oweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Image entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "image", catalog = "o2owebsit")
public class Image implements java.io.Serializable {

	// Fields

	private Integer idimage;
	private String imageUrl;
	private String imageName;
	private Integer itemId;

	// Constructors

	/** default constructor */
	public Image() {
	}

	/** minimal constructor */
	public Image(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/** full constructor */
	public Image(String imageUrl, String imageName, Integer itemId) {
		this.imageUrl = imageUrl;
		this.imageName = imageName;
		this.itemId = itemId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "idimage", unique = true, nullable = false)
	public Integer getIdimage() {
		return this.idimage;
	}

	public void setIdimage(Integer idimage) {
		this.idimage = idimage;
	}

	@Column(name = "imageURL", nullable = false, length = 45)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "imageName", length = 45)
	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Column(name = "itemID")
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

}
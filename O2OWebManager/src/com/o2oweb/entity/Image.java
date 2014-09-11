package com.o2oweb.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private Set<Rollbar> rollbarsForRollIconId = new HashSet<Rollbar>(0);
	private Set<Pageitemlist1f> pageitemlist1fs = new HashSet<Pageitemlist1f>(0);
	private Set<Rollbar> rollbarsForRollImageId = new HashSet<Rollbar>(0);
	private Set<Pageitemlist2f> pageitemlist2fs = new HashSet<Pageitemlist2f>(0);
	private Set<Pageitemlist3f> pageitemlist3fs = new HashSet<Pageitemlist3f>(0);

	// Constructors

	/** default constructor */
	public Image() {
	}

	/** minimal constructor */
	public Image(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/** full constructor */
	public Image(String imageUrl, String imageName,
			Set<Rollbar> rollbarsForRollIconId,
			Set<Pageitemlist1f> pageitemlist1fs,
			Set<Rollbar> rollbarsForRollImageId,
			Set<Pageitemlist2f> pageitemlist2fs,
			Set<Pageitemlist3f> pageitemlist3fs) {
		this.imageUrl = imageUrl;
		this.imageName = imageName;
		this.rollbarsForRollIconId = rollbarsForRollIconId;
		this.pageitemlist1fs = pageitemlist1fs;
		this.rollbarsForRollImageId = rollbarsForRollImageId;
		this.pageitemlist2fs = pageitemlist2fs;
		this.pageitemlist3fs = pageitemlist3fs;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "imageByRollIconId")
	public Set<Rollbar> getRollbarsForRollIconId() {
		return this.rollbarsForRollIconId;
	}

	public void setRollbarsForRollIconId(Set<Rollbar> rollbarsForRollIconId) {
		this.rollbarsForRollIconId = rollbarsForRollIconId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	public Set<Pageitemlist1f> getPageitemlist1fs() {
		return this.pageitemlist1fs;
	}

	public void setPageitemlist1fs(Set<Pageitemlist1f> pageitemlist1fs) {
		this.pageitemlist1fs = pageitemlist1fs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "imageByRollImageId")
	public Set<Rollbar> getRollbarsForRollImageId() {
		return this.rollbarsForRollImageId;
	}

	public void setRollbarsForRollImageId(Set<Rollbar> rollbarsForRollImageId) {
		this.rollbarsForRollImageId = rollbarsForRollImageId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	public Set<Pageitemlist2f> getPageitemlist2fs() {
		return this.pageitemlist2fs;
	}

	public void setPageitemlist2fs(Set<Pageitemlist2f> pageitemlist2fs) {
		this.pageitemlist2fs = pageitemlist2fs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	public Set<Pageitemlist3f> getPageitemlist3fs() {
		return this.pageitemlist3fs;
	}

	public void setPageitemlist3fs(Set<Pageitemlist3f> pageitemlist3fs) {
		this.pageitemlist3fs = pageitemlist3fs;
	}

}
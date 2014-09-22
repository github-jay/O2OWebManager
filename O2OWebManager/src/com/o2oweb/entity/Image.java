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

	// Fieldsaa

	private Integer idimage;
	private String imageUrl;
	private String imageName;
	private Integer itemId;
	private Set<Rollbar> rollbarsForRollIconId = new HashSet<Rollbar>(0);
	private Set<Rollbar> rollbarsForRollImageId = new HashSet<Rollbar>(0);
	private Set<Pageitemlist3f> pageitemlist3fs = new HashSet<Pageitemlist3f>(0);
	private Set<Pageitemlist2f> pageitemlist2fs = new HashSet<Pageitemlist2f>(0);
	private Set<Pageitemlist1f> pageitemlist1fs = new HashSet<Pageitemlist1f>(0);
	private Set<Rollbar> rollbarsForRollImageId_1 = new HashSet<Rollbar>(0);
	private Set<Rollbar> rollbarsForRollIconId_1 = new HashSet<Rollbar>(0);
	private Set<Pageitemlist2f> pageitemlist2fs_1 = new HashSet<Pageitemlist2f>(
			0);
	private Set<Pageitemlist3f> pageitemlist3fs_1 = new HashSet<Pageitemlist3f>(
			0);
	private Set<Pageitemlist1f> pageitemlist1fs_1 = new HashSet<Pageitemlist1f>(
			0);

	// Constructors

	/** default constructor */
	public Image() {
	}

	/** minimal constructor */
	public Image(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/** full constructor */
	public Image(String imageUrl, String imageName, Integer itemId,
			Set<Rollbar> rollbarsForRollIconId,
			Set<Rollbar> rollbarsForRollImageId,
			Set<Pageitemlist3f> pageitemlist3fs,
			Set<Pageitemlist2f> pageitemlist2fs,
			Set<Pageitemlist1f> pageitemlist1fs,
			Set<Rollbar> rollbarsForRollImageId_1,
			Set<Rollbar> rollbarsForRollIconId_1,
			Set<Pageitemlist2f> pageitemlist2fs_1,
			Set<Pageitemlist3f> pageitemlist3fs_1,
			Set<Pageitemlist1f> pageitemlist1fs_1) {
		this.imageUrl = imageUrl;
		this.imageName = imageName;
		this.itemId = itemId;
		this.rollbarsForRollIconId = rollbarsForRollIconId;
		this.rollbarsForRollImageId = rollbarsForRollImageId;
		this.pageitemlist3fs = pageitemlist3fs;
		this.pageitemlist2fs = pageitemlist2fs;
		this.pageitemlist1fs = pageitemlist1fs;
		this.rollbarsForRollImageId_1 = rollbarsForRollImageId_1;
		this.rollbarsForRollIconId_1 = rollbarsForRollIconId_1;
		this.pageitemlist2fs_1 = pageitemlist2fs_1;
		this.pageitemlist3fs_1 = pageitemlist3fs_1;
		this.pageitemlist1fs_1 = pageitemlist1fs_1;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "imageByRollIconId")
	public Set<Rollbar> getRollbarsForRollIconId() {
		return this.rollbarsForRollIconId;
	}

	public void setRollbarsForRollIconId(Set<Rollbar> rollbarsForRollIconId) {
		this.rollbarsForRollIconId = rollbarsForRollIconId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "imageByRollImageId")
	public Set<Rollbar> getRollbarsForRollImageId() {
		return this.rollbarsForRollImageId;
	}

	public void setRollbarsForRollImageId(Set<Rollbar> rollbarsForRollImageId) {
		this.rollbarsForRollImageId = rollbarsForRollImageId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	public Set<Pageitemlist3f> getPageitemlist3fs() {
		return this.pageitemlist3fs;
	}

	public void setPageitemlist3fs(Set<Pageitemlist3f> pageitemlist3fs) {
		this.pageitemlist3fs = pageitemlist3fs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	public Set<Pageitemlist2f> getPageitemlist2fs() {
		return this.pageitemlist2fs;
	}

	public void setPageitemlist2fs(Set<Pageitemlist2f> pageitemlist2fs) {
		this.pageitemlist2fs = pageitemlist2fs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	public Set<Pageitemlist1f> getPageitemlist1fs() {
		return this.pageitemlist1fs;
	}

	public void setPageitemlist1fs(Set<Pageitemlist1f> pageitemlist1fs) {
		this.pageitemlist1fs = pageitemlist1fs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "imageByRollImageId")
	public Set<Rollbar> getRollbarsForRollImageId_1() {
		return this.rollbarsForRollImageId_1;
	}

	public void setRollbarsForRollImageId_1(
			Set<Rollbar> rollbarsForRollImageId_1) {
		this.rollbarsForRollImageId_1 = rollbarsForRollImageId_1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "imageByRollIconId")
	public Set<Rollbar> getRollbarsForRollIconId_1() {
		return this.rollbarsForRollIconId_1;
	}

	public void setRollbarsForRollIconId_1(Set<Rollbar> rollbarsForRollIconId_1) {
		this.rollbarsForRollIconId_1 = rollbarsForRollIconId_1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	public Set<Pageitemlist2f> getPageitemlist2fs_1() {
		return this.pageitemlist2fs_1;
	}

	public void setPageitemlist2fs_1(Set<Pageitemlist2f> pageitemlist2fs_1) {
		this.pageitemlist2fs_1 = pageitemlist2fs_1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	public Set<Pageitemlist3f> getPageitemlist3fs_1() {
		return this.pageitemlist3fs_1;
	}

	public void setPageitemlist3fs_1(Set<Pageitemlist3f> pageitemlist3fs_1) {
		this.pageitemlist3fs_1 = pageitemlist3fs_1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	public Set<Pageitemlist1f> getPageitemlist1fs_1() {
		return this.pageitemlist1fs_1;
	}

	public void setPageitemlist1fs_1(Set<Pageitemlist1f> pageitemlist1fs_1) {
		this.pageitemlist1fs_1 = pageitemlist1fs_1;
	}

}
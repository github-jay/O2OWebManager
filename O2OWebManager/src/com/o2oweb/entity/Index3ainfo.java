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
import javax.persistence.UniqueConstraint;

/**
 * Index3ainfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "index3ainfo", catalog = "o2owebsit", uniqueConstraints = {
		@UniqueConstraint(columnNames = "arercode"),
		@UniqueConstraint(columnNames = "pageId") })
public class Index3ainfo implements java.io.Serializable {

	// Fields

	private Integer idIndex3ainfo;
	private String pageId;
	private String arercode;
	private Set<Pageitemlist1f> pageitemlist1fs = new HashSet<Pageitemlist1f>(0);
	private Set<Pageitemlist2f> pageitemlist2fs = new HashSet<Pageitemlist2f>(0);
	private Set<Rollbar> rollbars = new HashSet<Rollbar>(0);
	private Set<Pageitemlist3f> pageitemlist3fs = new HashSet<Pageitemlist3f>(0);

	// Constructors

	/** default constructor */
	public Index3ainfo() {
	}

	/** minimal constructor */
	public Index3ainfo(String pageId) {
		this.pageId = pageId;
	}

	/** full constructor */
	public Index3ainfo(String pageId, String arercode,
			Set<Pageitemlist1f> pageitemlist1fs,
			Set<Pageitemlist2f> pageitemlist2fs, Set<Rollbar> rollbars,
			Set<Pageitemlist3f> pageitemlist3fs) {
		this.pageId = pageId;
		this.arercode = arercode;
		this.pageitemlist1fs = pageitemlist1fs;
		this.pageitemlist2fs = pageitemlist2fs;
		this.rollbars = rollbars;
		this.pageitemlist3fs = pageitemlist3fs;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "idIndex3AInfo", unique = true, nullable = false)
	public Integer getIdIndex3ainfo() {
		return this.idIndex3ainfo;
	}

	public void setIdIndex3ainfo(Integer idIndex3ainfo) {
		this.idIndex3ainfo = idIndex3ainfo;
	}

	@Column(name = "pageId", unique = true, nullable = false, length = 45)
	public String getPageId() {
		return this.pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	@Column(name = "arercode", unique = true, length = 45)
	public String getArercode() {
		return this.arercode;
	}

	public void setArercode(String arercode) {
		this.arercode = arercode;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "index3ainfo")
	public Set<Pageitemlist1f> getPageitemlist1fs() {
		return this.pageitemlist1fs;
	}

	public void setPageitemlist1fs(Set<Pageitemlist1f> pageitemlist1fs) {
		this.pageitemlist1fs = pageitemlist1fs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "index3ainfo")
	public Set<Pageitemlist2f> getPageitemlist2fs() {
		return this.pageitemlist2fs;
	}

	public void setPageitemlist2fs(Set<Pageitemlist2f> pageitemlist2fs) {
		this.pageitemlist2fs = pageitemlist2fs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "index3ainfo")
	public Set<Rollbar> getRollbars() {
		return this.rollbars;
	}

	public void setRollbars(Set<Rollbar> rollbars) {
		this.rollbars = rollbars;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "index3ainfo")
	public Set<Pageitemlist3f> getPageitemlist3fs() {
		return this.pageitemlist3fs;
	}

	public void setPageitemlist3fs(Set<Pageitemlist3f> pageitemlist3fs) {
		this.pageitemlist3fs = pageitemlist3fs;
	}

}
package com.o2oweb.dto;

import java.util.List;

public class ItemLevelBean {
	private Integer id;
	private String text;
	private String state = "open";
	private List<ItemLevelBean> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<ItemLevelBean> getChildren() {
		return children;
	}

	public void setChildren(List<ItemLevelBean> children) {
		this.children = children;
	}

}

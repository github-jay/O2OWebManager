package com.o2oweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.Page3Dao;
import com.o2oweb.entity.Index3ainfo;

@Component("page3Service")
public class Page3Service {

	private Page3Dao page3Dao;

	public void save(Index3ainfo page3) {
		this.page3Dao.save(page3);
	}

	public void remove(Index3ainfo page3) {
		this.page3Dao.remove(page3);
	}

	public void update(Index3ainfo page3) {
		this.page3Dao.update(page3);
	}

	public Index3ainfo getPage(String pageId) {
		return this.page3Dao.getPage(pageId);
	}

	public Index3ainfo getPageByAreacode(String areacode) {
		return this.page3Dao.getPageByAreacode(areacode);
	}

	@Resource
	public void setpage3Dao(Page3Dao page3Dao) {
		this.page3Dao = page3Dao;
	}
}
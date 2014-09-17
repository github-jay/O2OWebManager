package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.Pageitemlist1fDao;
import com.o2oweb.entity.Pageitemlist1f;

@Component("pageitemlist1fService")
public class Pageitemlist1fService {

	private Pageitemlist1fDao pageitemlist1fDao;

	public void save(Pageitemlist1f pageitemlist1f) {
		this.pageitemlist1fDao.save(pageitemlist1f);
	}

	public void remove(Pageitemlist1f pageitemlist1f) {
		this.pageitemlist1fDao.remove(pageitemlist1f);
	}

	public void update(Pageitemlist1f pageitemlist1f) {
		this.pageitemlist1fDao.update(pageitemlist1f);
	}

	public Pageitemlist1f getpageitemlist1f(String loginMes, char type) {
		return pageitemlist1fDao.getPageitemlist1f(loginMes, type);
	}

	public List<Pageitemlist1f> find(String hql) {
		return this.pageitemlist1fDao.find(hql);
	}

	@Resource
	public void setpageitemlist1fDao(Pageitemlist1fDao pageitemlist1fDao) {
		this.pageitemlist1fDao = pageitemlist1fDao;
	}
}

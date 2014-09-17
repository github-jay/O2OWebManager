package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.Pageitemlist2fDao;
import com.o2oweb.entity.Pageitemlist2f;

@Component("pageitemlist2fService")
public class Pageitemlist2fService {

	private Pageitemlist2fDao pageitemlist2fDao;

	public void save(Pageitemlist2f pageitemlist2f) {
		this.pageitemlist2fDao.save(pageitemlist2f);
	}

	public void remove(Pageitemlist2f pageitemlist2f) {
		this.pageitemlist2fDao.remove(pageitemlist2f);
	}

	public void update(Pageitemlist2f pageitemlist2f) {
		this.pageitemlist2fDao.update(pageitemlist2f);
	}

	public Pageitemlist2f getpageitemlist2f(String loginMes, char type) {
		return pageitemlist2fDao.getPageitemlist2f(loginMes, type);
	}

	public List<Pageitemlist2f> find(String hql) {
		return this.pageitemlist2fDao.find(hql);
	}

	@Resource
	public void setpageitemlist2fDao(Pageitemlist2fDao pageitemlist2fDao) {
		this.pageitemlist2fDao = pageitemlist2fDao;
	}
}

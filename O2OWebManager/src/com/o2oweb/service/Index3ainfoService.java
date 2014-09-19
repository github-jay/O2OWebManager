package com.o2oweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.Index3ainfoDao;
import com.o2oweb.entity.Index3ainfo;

@Component("index3ainfoService")
public class Index3ainfoService {

	private Index3ainfoDao index3ainfoDao;

	public void save(Index3ainfo user) {
		this.index3ainfoDao.save(user);
	}

	public void remove(Index3ainfo user) {
		this.index3ainfoDao.remove(user);
	}

	public void update(Index3ainfo user) {
		this.index3ainfoDao.update(user);
	}

	public Index3ainfo getIndex3ainfo(Integer id) {
		return index3ainfoDao.getIndex3ainfo(id);
	}

	@Resource
	public void setindex3ainfoDao(Index3ainfoDao index3ainfoDao) {
		this.index3ainfoDao = index3ainfoDao;
	}
}

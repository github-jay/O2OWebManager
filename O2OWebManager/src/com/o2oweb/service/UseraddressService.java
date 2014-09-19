package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.o2oweb.bo.RequestParamBean;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.UseraddressDao;
import com.o2oweb.entity.Useraddress;

@Component("useraddressService")
public class UseraddressService {

	private UseraddressDao useraddressDao;

	public void save(Useraddress useraddress) {
		this.useraddressDao.save(useraddress);
	}

	public void remove(Useraddress useraddress) {
		this.useraddressDao.removeAddr(useraddress);
	}

	public void update(Useraddress useraddress) {
		this.useraddressDao.update(useraddress);
	}

	public Useraddress getUseraddress(int addId) {
		return useraddressDao.getAddr(addId);
	}

	public Page pagedQuery(DetachedCriteria dc, int rows, int page) {
		Page p = this.useraddressDao.pagedQuery(dc, rows * page, rows);
		return p;
	}

	public List<Useraddress> getAddrs(int userId) {
		return this.useraddressDao.getAddrs(userId);
	}

	@Resource
	public void setuseraddressDao(UseraddressDao useraddressDao) {
		this.useraddressDao = useraddressDao;
	}
}

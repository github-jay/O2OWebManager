package com.o2oweb.service;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.o2oweb.bo.RequestParamBean;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.UserDao;
import com.o2oweb.entity.User;

@Component("userService")
public class UserService {

	private UserDao userDao;

	public void save(User user) {
		this.userDao.save(user);
	}

	public void remove(User user) {
		this.userDao.remove(user);
	}
	

	public void update(User user) {
		this.userDao.update(user);
	}

	public User getUser(String loginMes, char type) {
		return userDao.getUser(loginMes, type);
	}

	public Page findPageBean(RequestParamBean paramBean) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(User.class);
		if (paramBean == null) {
			return null;
		}
		return this.userDao.pagedQuery(detachedCriteria, paramBean.getStart(),
				paramBean.getLimit());
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}

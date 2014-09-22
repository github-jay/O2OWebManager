package com.o2oweb.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.UserDao;
import com.o2oweb.entity.User;
import com.o2oweb.util.PasswordUtil;

@Component("userDao")
public class UserDaoImpl extends HibernateEntityDao<User> implements UserDao {
	public void save(User user) {
		String password = PasswordUtil.toMd5(user.getPassword());
		user.setPassword(password);
		super.merge(user);
	}

	public void update(User user) {
		User temp = super.findUniqueBy("userId", user.getUserId());
		if (!user.getPassword().equals(user.getPassword())) { 
			String password = PasswordUtil.toMd5(user.getPassword());
			temp.setPassword(password);
		}
		temp.setIconAddr(user.getIconAddr());
		temp.setAddrId(user.getAddrId());
		temp.setScore(user.getScore());
		super.merge(temp);
	}

	public void remove(User user) {
		super.remove(user);
	}

	public User getUser(String loginMes, char type) {
		switch (type) {
		case 'q':
			return super.findUniqueBy("userQq", loginMes);
			// break;
		case 'u':
			return super.findUniqueBy("userName", loginMes);
		case 'e':
			return super.findUniqueBy("email", loginMes);
		default:
			break;
		}
		
		return null;
	}
	
	public List<User> find(String hql) {
		try		{
			return super.find(hql);
		} catch (RuntimeException e)		{
			throw e;
		}
	}
	
	public Page pagedQuery(DetachedCriteria detachedCriteria, int start,
			int limit) {
		return super.pagedQuery(detachedCriteria, start, limit);
	}

}

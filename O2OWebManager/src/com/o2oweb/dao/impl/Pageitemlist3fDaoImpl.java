package com.o2oweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.Pageitemlist3fDao;
import com.o2oweb.entity.Pageitemlist3f;

@Component("pageitemlist3fDao")
public class Pageitemlist3fDaoImpl extends HibernateEntityDao<Pageitemlist3f> implements Pageitemlist3fDao {
	public void save(Pageitemlist3f pageitemlist3f) {
		super.merge(pageitemlist3f);
	}

	public void update(Pageitemlist3f pageitemlist3f) {
		super.merge(pageitemlist3f);
	}

	public void remove(Pageitemlist3f pageitemlist3f) {
		super.remove(pageitemlist3f);
	}

	public Pageitemlist3f getPageitemlist3f(String loginMes, char type) {
		switch (type) {
		case 'q':
			return super.findUniqueBy("Pageitemlist3fQq", loginMes);
			// break;
		case 'u':
			return super.findUniqueBy("Pageitemlist3fName", loginMes);
		case 'e':
			return super.findUniqueBy("email", loginMes);
		default:
			break;
		}
		
		return null;
	}
	
	public List<Pageitemlist3f> find(String hql) {
		try		{
			return super.find(hql);
		} catch (RuntimeException e)		{
			throw e;
		}
	}
}

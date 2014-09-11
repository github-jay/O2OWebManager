package com.o2oweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.Pageitemlist2fDao;
import com.o2oweb.entity.Pageitemlist2f;

@Component("pageitemlist2fDao")
public class Pageitemlist2fDaoImpl extends HibernateEntityDao<Pageitemlist2f> implements Pageitemlist2fDao {
	public void save(Pageitemlist2f pageitemlist2f) {
		super.merge(pageitemlist2f);
	}

	public void update(Pageitemlist2f pageitemlist2f) {
		super.merge(pageitemlist2f);
	}

	public void remove(Pageitemlist2f pageitemlist2f) {
		super.remove(pageitemlist2f);
	}

	public Pageitemlist2f getPageitemlist2f(String loginMes, char type) {
		switch (type) {
		case 'q':
			return super.findUniqueBy("Pageitemlist2fQq", loginMes);
			// break;
		case 'u':
			return super.findUniqueBy("Pageitemlist2fName", loginMes);
		case 'e':
			return super.findUniqueBy("email", loginMes);
		default:
			break;
		}
		
		return null;
	}
	
	public List<Pageitemlist2f> find(String hql) {
		try		{
			return super.find(hql);
		} catch (RuntimeException e)		{
			throw e;
		}
	}
}

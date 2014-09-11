package com.o2oweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.Pageitemlist1fDao;
import com.o2oweb.entity.Pageitemlist1f;

@Component("pageitemlist1fDao")
public class Pageitemlist1fDaoImpl extends HibernateEntityDao<Pageitemlist1f> implements Pageitemlist1fDao {
	public void save(Pageitemlist1f Pageitemlist1f) {
		super.merge(Pageitemlist1f);
	}

	public void update(Pageitemlist1f pageitemlist1f) {
		super.merge(pageitemlist1f);
	}

	public void remove(Pageitemlist1f pageitemlist1f) {
		super.remove(pageitemlist1f);
	}

	public Pageitemlist1f getPageitemlist1f(String loginMes, char type) {
		switch (type) {
		case 'q':
			return super.findUniqueBy("Pageitemlist1fQq", loginMes);
			// break;
		case 'u':
			return super.findUniqueBy("Pageitemlist1fName", loginMes);
		case 'e':
			return super.findUniqueBy("email", loginMes);
		default:
			break;
		}
		
		return null;
	}
	
	public List<Pageitemlist1f> find(String hql) {
		try		{
			return super.find(hql);
		} catch (RuntimeException e)		{
			throw e;
		}
	}
}

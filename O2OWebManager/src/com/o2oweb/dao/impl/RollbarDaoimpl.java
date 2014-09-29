package com.o2oweb.dao.impl;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.RollBarDao;
import com.o2oweb.entity.Rollbar;

@Component("rollbarDao")
public class RollbarDaoImpl extends HibernateEntityDao<Rollbar> implements RollBarDao {

	public Rollbar getRollbar(int rollbarID) {
		// TODO Auto-generated method stub
		return super.get(rollbarID);
	}

	public void save(Rollbar rollbar) {
		super.merge(rollbar);
	}

	public void remove(Rollbar rollbar) {
		super.remove(rollbar);
	}

	public void update(Rollbar rollbar) {
		super.merge(rollbar);
	}

}

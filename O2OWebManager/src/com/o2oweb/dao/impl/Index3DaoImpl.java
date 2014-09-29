package com.o2oweb.dao.impl;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.Index3Dao;
import com.o2oweb.entity.Index3;

@Component("index3Dao")
public class Index3DaoImpl extends HibernateEntityDao<Index3> implements Index3Dao {

	public Index3 getIndex3(int index3id) {
		return super.get(index3id);
	}

	public void remove(Index3 index3) {
		// TODO Auto-generated method stub
		super.remove(index3);
	}

	public void update(Index3 index3) {
		super.merge(index3);
	}

	public void save(Index3 index3) {
		super.merge(index3);

	}

}

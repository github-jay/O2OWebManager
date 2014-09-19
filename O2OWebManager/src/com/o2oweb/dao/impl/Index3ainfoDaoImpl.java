package com.o2oweb.dao.impl;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.Index3ainfoDao;
import com.o2oweb.entity.Index3ainfo;

@Component("index3ainfoDao")
public class Index3ainfoDaoImpl extends HibernateEntityDao<Index3ainfo> implements Index3ainfoDao{

	public void save(Index3ainfo index3ainfo) {
		super.merge(index3ainfo);
		
	}

	public Index3ainfo getIndex3ainfo(Integer id) {
		return super.get(id);
	}

	public void remove(Index3ainfo index3ainfo) {
		super.remove(index3ainfo);
		
	}

	public void update(Index3ainfo index3ainfo) {
		super.merge(index3ainfo);
		
	}

}

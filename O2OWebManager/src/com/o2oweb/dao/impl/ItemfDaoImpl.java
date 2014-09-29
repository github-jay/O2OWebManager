package com.o2oweb.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.ItemfDao;
import com.o2oweb.entity.Itemf;

@Component("itemfDao")
public class ItemfDaoImpl extends HibernateEntityDao<Itemf> implements ItemfDao {

	public Itemf getItemf(int itemfId) {
		return super.get(itemfId);
	}

	

	public void remove(Itemf itemf) {
		super.remove(itemf);

	}

	public void save(Itemf itemf) {
		super.merge(itemf);
	}

	public void update(Itemf itemf) {
		super.merge(itemf);
	}



	public Page getIndexfs(DetachedCriteria dc, int start, int limit) {
		return super.pagedQuery(dc, start, limit);
	}

}

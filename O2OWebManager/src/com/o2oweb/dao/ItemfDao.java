package com.o2oweb.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.Itemf;

public interface ItemfDao {
	public Itemf getItemf(int itemfId);
	public Page getIndexfs(DetachedCriteria dc,int start,int limit);
	public void remove(Itemf itemf);
	public void save(Itemf itemf);
	public void update(Itemf itemf);
}

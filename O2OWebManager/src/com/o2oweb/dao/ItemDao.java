package com.o2oweb.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.Item;

public interface ItemDao {
	public void save(Item item);
	public void ChangeStock(Item item,int num);
	public void remove(Item item);
	public void update(Item item);
	public Item getItem(int itemId);
	public Page pagedQuery(DetachedCriteria detachedCriteria, int start, int limit);
}

package com.o2oweb.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.ItemDao;
import com.o2oweb.entity.Item;

@Component("itemDao")
public class ItemDaoImpl extends HibernateEntityDao<Item> implements
 ItemDao {

	public void save(Item item) {
		try {
			super.merge(item);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public void remove(Item item) {
		try {
			super.remove(item);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public void update(Item item) {
		try {
			super.merge(item);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public Item getItem(int itemId) {
		try {
			return super.findUniqueBy("itemId", itemId);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public Page pagedQuery(DetachedCriteria detachedCriteria, int start, int limit) {
		return super.pagedQuery(detachedCriteria, start, limit);
	}

	public void ChangeStock(Item item, int num) {
		// TODO Auto-generated method stub
		Item temp = super.findUniqueBy("itemId", item.getItemId());
		if (temp!=null&&(temp.getStockNum() - num) < 0) {
			throw new RuntimeException("商品名："+temp.getItemName()+"ID: "+temp.getItemId()+" 库存不足");
		} else {
			temp = item;
			temp.setStockNum(temp.getStockNum() - num);
			super.merge(temp);
		}

	}
	
}

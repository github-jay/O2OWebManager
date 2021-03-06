package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.ItemattributeDao;
import com.o2oweb.entity.Itemattribute;

@Component("itemattributeService")
public class ItemattributeService {

	private ItemattributeDao itemattributeDao;

	public void save(Itemattribute Itemattribute) {
		this.itemattributeDao.save(Itemattribute);
	}

	public void remove(Itemattribute Itemattribute) {
		this.itemattributeDao.remove(Itemattribute);
	}

	public void update(Itemattribute Itemattribute) {
		this.itemattributeDao.update(Itemattribute);
	}

	public Itemattribute getItemattribute(int itemAttributeId) {
		return itemattributeDao.getItemAttribute(itemAttributeId);
	}

	public List<Itemattribute> getAttributes(int itemId) {
		return itemattributeDao.getAttributes(itemId);
	}

	@Resource
	public void setItemattributeDao(ItemattributeDao ItemattributeDao) {
		this.itemattributeDao = ItemattributeDao;
	}
}

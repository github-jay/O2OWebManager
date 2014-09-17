package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.ItemLevelDao;
import com.o2oweb.entity.Itemlevel;

@Component("itemLevelService")
public class ItemLevelService {

	private ItemLevelDao ItemLevelDao;

	public void save(Itemlevel ItemLevel) {
		this.ItemLevelDao.save(ItemLevel);
	}

	public void remove(Itemlevel ItemLevel) {
		this.ItemLevelDao.remove(ItemLevel);
	}

	public void update(Itemlevel ItemLevel) {
		this.ItemLevelDao.update(ItemLevel);
	}

	public Itemlevel getLevel(int levelID) {
		return ItemLevelDao.getLevel(levelID);
	}

	public List<Itemlevel> getAllLevel(int levelID) {
		return ItemLevelDao.getAllLevel(levelID);
	}

	public List<Itemlevel> getNextLevels(int levelID) {
		return ItemLevelDao.getNextLevels(levelID);
	}

	@Resource
	public void setItemLevelDao(ItemLevelDao ItemLevelDao) {
		this.ItemLevelDao = ItemLevelDao;
	}
}

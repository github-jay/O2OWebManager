package com.o2oweb.dao;

import java.util.List;

import com.o2oweb.entity.Itemlevel;

public interface ItemLevelDao {
	public void save(Itemlevel itemLevel);
	public void update(Itemlevel itemLevel);
	public void remove(Itemlevel itemLevel);
	public Itemlevel getLevel(int levelID);
	public List<Itemlevel> getAllLevel(int levelID);
	public List<Itemlevel> getNextLevels(int levelID);
}

package com.o2oweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.ItemLevelDao;
import com.o2oweb.entity.Itemlevel;

@Component("itemLevelDao")
public class ItemlevelDaoImpl extends HibernateEntityDao<Itemlevel> implements
		ItemLevelDao {

	public void save(Itemlevel itemLevel) {
		super.merge(itemLevel);
	}

	public void update(Itemlevel itemLevel) {
		super.merge(itemLevel);
	}

	public void remove(Itemlevel itemLevel) {
		List<Itemlevel> nextLevels = super.find(
				"from Itemlevel lev where lev.surperId=?",
				new Object[] { itemLevel.getIdItemLevel() });
		for (Itemlevel level : nextLevels) {
			this.remove(level);
		}
		super.remove(itemLevel);
	}

	public Itemlevel getLevel(int levelID) {
		return super.findUniqueBy("idItemLevel", levelID);
	}

	public List<Itemlevel> getAllLevel(int levelID) {
		// List<Itemlevel> result = new LinkedList<Itemlevel>();
		List<Itemlevel> result = super.find(
				"from Itemlevel lev where lev.surperId=?",
				new Object[] { levelID });
		return result;
	}

	public List<Itemlevel> getNextLevels(int levelID) {
		List<Itemlevel> result = super.find(
				"from Itemlevel lev where lev.surperId=?",
				new Object[] { levelID });

		return result;
	}

}

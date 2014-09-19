package com.o2oweb.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.Sailer;

public interface SailerDao {
	public void save(Sailer sailer);
	public void update(Sailer sailer);
	public void remove(Sailer sailer);
	public Sailer getSailer(int sailerId);
	public List<Sailer> getSailers(int [] sailerIds);
	public Page pagedQuery(DetachedCriteria detachedCriteria, int start,
			int limit);
}

package com.o2oweb.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.SailerDao;
import com.o2oweb.entity.Sailer;

@Component("sailerDao")
public class SailerDaoImpl extends HibernateEntityDao<Sailer> implements
		SailerDao {

	public void save(Sailer sailer) {
		super.merge(sailer);
	}

	public void update(Sailer sailer) {
		super.merge(sailer);
	}

	public void remove(Sailer sailer) {
		super.remove(sailer);
	}

	public Sailer getSailer(int sailerId) {
		return super.findUniqueBy("sailerid", sailerId);
	}

	public List<Sailer> getSailers(int[] sailerIds) {
		List<Sailer> result = new LinkedList<Sailer>();
		for (int Id : sailerIds) {
			result.add(super.findUniqueBy("sailerid", Id));
		}
		return result;
	}

	public Page pagedQuery(DetachedCriteria detachedCriteria, int start,
			int limit) {
		return super.pagedQuery(detachedCriteria, start, limit);
	}

}

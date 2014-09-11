package com.o2oweb.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.SailerDao;
import com.o2oweb.entity.Sailer;
@Component("sailerDao")
public class SailerDaoImpl extends HibernateEntityDao<Sailer> implements SailerDao{

	public void save(Sailer sailer) {
		// TODO Auto-generated method stub
		super.merge(sailer);
	}

	public void update(Sailer sailer) {
		// TODO Auto-generated method stub
		super.merge(sailer);
	}

	public void remove(Sailer sailer) {
		// TODO Auto-generated method stub
		super.remove(sailer);
	}

	public Sailer getSailer(int sailerId) {
		// TODO Auto-generated method stub
		return super.findUniqueBy("sailerid", sailerId);
	}

	public List<Sailer> getSailers(int[] sailerIds) {
		// TODO Auto-generated method stub
		List<Sailer> result = new LinkedList<Sailer>();
		for(int Id:sailerIds){
			result.add(super.findUniqueBy("sailerid", Id));
		}
		return result;
	}

}

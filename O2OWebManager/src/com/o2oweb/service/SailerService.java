package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.SailerDao;
import com.o2oweb.entity.Sailer;

@Component("sailerService")
public class SailerService {

	private SailerDao sailerDao;

	public void save(Sailer sailer) {
		this.sailerDao.save(sailer);
	}

	public void remove(Sailer sailer) {
		this.sailerDao.remove(sailer);
	}

	public void update(Sailer sailer) {
		this.sailerDao.update(sailer);
	}

	public Sailer getsailer(int sailerId) {
		return sailerDao.getSailer(sailerId);
	}

	public List<Sailer> getSailers(int[] sailerIds) {
		return this.sailerDao.getSailers(sailerIds);
	}

	@Resource
	public void setsailerDao(SailerDao sailerDao) {
		this.sailerDao = sailerDao;
	}
}

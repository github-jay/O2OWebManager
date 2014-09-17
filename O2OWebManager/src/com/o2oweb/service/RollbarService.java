package com.o2oweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.RollbarDao;
import com.o2oweb.entity.Rollbar;

@Component("rollbarService")
public class RollbarService {

	private RollbarDao rollbarDao;

	public void save(Rollbar rollbar) {
		this.rollbarDao.save(rollbar);
	}

	public void remove(Rollbar rollbar) {
		this.rollbarDao.remove(rollbar);
	}

	public void update(Rollbar rollbar) {
		this.rollbarDao.update(rollbar);
	}

	public Rollbar getRollbar(int rollbarId) {
		return rollbarDao.getRollbar(rollbarId);
	}

	@Resource
	public void setrollbarDao(RollbarDao rollbarDao) {
		this.rollbarDao = rollbarDao;
	}
}

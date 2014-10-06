package com.o2oweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.RollBarDao;
import com.o2oweb.entity.Rollbar;

@Component("rollbarService")
public class RollbarService {

	private RollBarDao RollBarDao;

	public void save(Rollbar rollbar) {
		this.RollBarDao.save(rollbar);
	}

	public void remove(Rollbar rollbar) {
		this.RollBarDao.remove(rollbar);
	}

	public void update(Rollbar rollbar) {
		this.RollBarDao.update(rollbar);
	}

	public Rollbar getRollbar(int rollbarId) {
		return RollBarDao.getRollbar(rollbarId);
	}

	@Resource
	public void setRollBarDao(RollBarDao RollBarDao) {
		this.RollBarDao = RollBarDao;
	}
}

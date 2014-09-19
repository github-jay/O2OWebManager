package com.o2oweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.RollbarDao;
import com.o2oweb.entity.Rollbar;

/**
 * 三级页面滚动条Dao接口实现
 * 
 * @author Administrator
 * 
 */
@Component("rollbarDao")
public class RollbarDaoImpl extends HibernateEntityDao<Rollbar> implements
		RollbarDao {

	public void save(Rollbar rollbar) {
		try {
			super.merge(rollbar);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Rollbar rollbar) {
		try {
			super.merge(rollbar);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Rollbar rollbar) {
		try {
			super.remove(rollbar);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Rollbar getRollbar(int rollbarId) {
		try {
			return super.findUniqueBy("rollBarId", rollbarId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Rollbar> getAll() {
		return super.getAll();
	}
	
}

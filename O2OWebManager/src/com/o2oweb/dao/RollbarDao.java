package com.o2oweb.dao;

import java.util.List;

import com.o2oweb.entity.Rollbar;
/**
 * 三级页面滚动条Dao接口
 * @author Administrator
 *
 */
public interface RollbarDao {
	public void save(Rollbar rollbar);
	public void update(Rollbar rollbar);
	public void remove(Rollbar rollbar);
	public Rollbar getRollbar(int rollbarId);
	public List<Rollbar> getAll();
}

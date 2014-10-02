package com.o2oweb.dao;

import com.o2oweb.entity.Rollbar;

public interface RollBarDao{
	public Rollbar getRollbar(int rollbarID);
	public void save(Rollbar rollbar);
	public void remove(Rollbar rollbar);
	public void update(Rollbar rollbar);
}

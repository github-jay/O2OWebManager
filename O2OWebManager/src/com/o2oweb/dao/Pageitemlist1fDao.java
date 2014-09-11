package com.o2oweb.dao;

import java.util.List;

import com.o2oweb.entity.Pageitemlist1f;

public interface Pageitemlist1fDao {

	public void save(Pageitemlist1f Pageitemlist1f);
	public void update(Pageitemlist1f Pageitemlist1f);
	public void remove(Pageitemlist1f Pageitemlist1f);
	public Pageitemlist1f getPageitemlist1f(String loginMes,char type);
	public List<Pageitemlist1f> find(String hql);
}

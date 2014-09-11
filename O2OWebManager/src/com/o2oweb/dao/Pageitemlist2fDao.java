package com.o2oweb.dao;

import java.util.List;

import com.o2oweb.entity.Pageitemlist2f;

public interface Pageitemlist2fDao {

	public void save(Pageitemlist2f pageitemlist2f);
	public void update(Pageitemlist2f pageitemlist2f);
	public void remove(Pageitemlist2f pageitemlist2f);
	public Pageitemlist2f getPageitemlist2f(String loginMes,char type);
	public List<Pageitemlist2f> find(String hql);
}

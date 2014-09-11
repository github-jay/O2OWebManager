package com.o2oweb.dao;

import java.util.List;

import com.o2oweb.entity.Pageitemlist3f;

public interface Pageitemlist3fDao {

	public void save(Pageitemlist3f pageitemlist3f);
	public void update(Pageitemlist3f pageitemlist3f);
	public void remove(Pageitemlist3f pageitemlist3f);
	public Pageitemlist3f getPageitemlist3f(String loginMes,char type);
	public List<Pageitemlist3f> find(String hql);
}

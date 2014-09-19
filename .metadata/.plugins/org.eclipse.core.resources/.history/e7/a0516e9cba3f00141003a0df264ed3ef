package com.o2oweb.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.Useraddress;

public interface UseraddressDao {
	public void save(Useraddress address);
	public void update(Useraddress address);
	public void removeAddr(Useraddress address);
	public Useraddress getAddr(int userId);
	public List<Useraddress> getAddrs(int addrId);
	public Page pagedQuery(DetachedCriteria detachedCriteria, int start, int limit);
}

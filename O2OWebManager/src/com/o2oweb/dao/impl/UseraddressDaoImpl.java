package com.o2oweb.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.UseraddressDao;
import com.o2oweb.entity.Useraddress;

@Component("userAddressDao")
public class UseraddressDaoImpl extends HibernateEntityDao<Useraddress>
		implements UseraddressDao {

	public void save(Useraddress address) {
		super.merge(address);
	}

	public void update(Useraddress address) {
		super.merge(address);
	}

	public void removeAddr(Useraddress address) {
		super.remove(address);
	}

	public Useraddress getAddr(int addrId) {
		return super.findUniqueBy("idUserAddress", addrId);
	}

	public List<Useraddress> getAddrs(int userId) {
		List<Useraddress> result = super.find(
				"from Useraddress addr where addr.userId=?",
				new Object[] { userId });
		return result;
	}

	public Page pagedQuery(DetachedCriteria detachedCriteria, int start, int limit) {
		return super.pagedQuery(detachedCriteria, start, limit);
	}
}

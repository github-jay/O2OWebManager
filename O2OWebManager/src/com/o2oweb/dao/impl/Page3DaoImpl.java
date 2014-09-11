package com.o2oweb.dao.impl;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.Page3Dao;
import com.o2oweb.entity.Index3ainfo;
/**
 * 三级页面Dao接口实现
 * @author Administrator
 *
 */
@Component("page3Dao")
public class Page3DaoImpl extends HibernateEntityDao<Index3ainfo> implements Page3Dao {

	public void save(Index3ainfo index3Ainfo) {
		try {
			super.merge(index3Ainfo);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Index3ainfo index3Ainfo) {
		try {
			super.merge(index3Ainfo);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Index3ainfo index3Ainfo) {
		try {
			super.remove(index3Ainfo);
		} catch (Exception e) {
			new RuntimeException(e);
		}
	}

	public Index3ainfo getPage(String pageId) {
		try{
			return super.findUniqueBy("pageId", pageId);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Index3ainfo getPageByAreacode(String areacode) {
		try{
			return super.findUniqueBy("arercode", areacode);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

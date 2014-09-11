package com.o2oweb.dao;

import com.o2oweb.entity.Index3ainfo;
/**
 * 3级页面数据库DAO接口
 * @author Administrator
 *
 */
public interface Page3Dao {
	public void save(Index3ainfo index3Ainfo);
	public void update(Index3ainfo index3Ainfo);
	public void remove(Index3ainfo index3Ainfo);
	public Index3ainfo getPage(String pageId);
	public Index3ainfo getPageByAreacode(String areacode);
}

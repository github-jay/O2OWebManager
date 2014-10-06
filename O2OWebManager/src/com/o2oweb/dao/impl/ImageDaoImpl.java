package com.o2oweb.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.common.dao.support.Page;
import com.o2oweb.common.dao.support.PageBean;
import com.o2oweb.dao.ImageDao;
import com.o2oweb.entity.Image;

@Component("imageDao")
public class ImageDaoImpl extends HibernateEntityDao<Image> implements ImageDao{

	public void save(Image image) {
		super.merge(image);
		
	}

	public Image getImage(Integer id) {
		return super.get(id);
	}

	public void remove(Image image) {
		super.remove(image);
		
	}

	public void update(Image image) {
		super.merge(image);
		
	}

	public Page query(DetachedCriteria dc, int start, int limit) {
		
		Page p = super.pagedQuery(dc, start, limit);
		return p;
	}
	
}

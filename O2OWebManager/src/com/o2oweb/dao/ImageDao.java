package com.o2oweb.dao;

import com.o2oweb.entity.Image;

public interface ImageDao {

	public void save(Image image);
	public Image getImage(Integer id);
	public void remove(Image image);
	public void update(Image image);
}

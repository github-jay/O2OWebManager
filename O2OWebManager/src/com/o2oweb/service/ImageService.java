package com.o2oweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.ImageDao;
import com.o2oweb.entity.Image;

@Component("imageService")
public class ImageService {

	private ImageDao imageDao;

	public void save(Image user) {
		this.imageDao.save(user);
	}

	public void remove(Image user) {
		this.imageDao.remove(user);
	}

	public void update(Image user) {
		this.imageDao.update(user);
	}

	public Image getImage(Integer id) {
		return imageDao.getImage(id);
	}

	@Resource
	public void setimageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
}
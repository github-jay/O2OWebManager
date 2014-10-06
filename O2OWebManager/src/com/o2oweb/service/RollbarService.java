package com.o2oweb.service;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.o2oweb.dao.RollBarDao;
import com.o2oweb.entity.Rollbar;

@Component("rollbarService")
public class RollbarService {

	private RollBarDao RollBarDao;
	
	private static String imgpre = "image";
	private static String imgend = "name";

	public void save(Rollbar rollbar) {
		this.RollBarDao.save(rollbar);
	}

	public void remove(Rollbar rollbar) {
		this.RollBarDao.remove(rollbar);
	}

	public void update(Rollbar rollbar) {
		this.RollBarDao.update(rollbar);
	}

	public Rollbar getRollbar(int rollbarId) {
		return RollBarDao.getRollbar(rollbarId);
	}
	
	public void setrollimgid(int index,Rollbar rollbar,int imgid,String imgtitle) throws Exception{
		String imgfname = imgpre+index;
		String titlefname = imgpre+index+imgend;
		Class rollclass = Rollbar.class;
		
		Field idfield = rollclass.getDeclaredField(imgfname);
		idfield.setAccessible(true);
		Field titlefield = rollclass.getDeclaredField(titlefname);
		titlefield.setAccessible(true);
		
		idfield.set(rollbar, imgid);
		titlefield.set(rollbar, imgtitle);
		
	}

	@Resource
	public void setRollBarDao(RollBarDao RollBarDao) {
		this.RollBarDao = RollBarDao;
	}
}

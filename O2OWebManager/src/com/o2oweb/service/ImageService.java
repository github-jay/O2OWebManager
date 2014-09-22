package com.o2oweb.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.dao.ImageDao;
import com.o2oweb.dao.ItemDao;
import com.o2oweb.entity.Image;
import com.o2oweb.entity.Item;

@Component("imageService")
public class ImageService {

	private ImageDao imageDao;
	@Autowired
	private ItemDao itemDao;
	

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
	
	public JSONObject getimageInfo(Integer itemId){
		JSONObject obj = new JSONObject();
		DetachedCriteria dc = DetachedCriteria.forClass(Image.class);
		dc.add(Restrictions.eq("itemId", itemId));
		//取得所有图片
		Page p = imageDao.query(dc, 0, 100);
		Item item = itemDao.getItem(itemId);
		
		//组拼json
		if(item.getImageId() != null){
			obj.accumulate("mainImage", item.getImageId());
		}else{
			obj.accumulate("mainImage", "N/A");
		}
		List images = (List) p.getData();
		if(images != null && images.size() != 0){
			JSONArray jsa = new JSONArray();
			for(int i = 0; i < images.size();i++){
				Image image =  (Image) images.get(i);
				JSONObject imgobj = new JSONObject();
				imgobj.accumulate("imageId", image.getIdimage());
				jsa.add(imgobj);
			}
			obj.accumulate("subImages", jsa);
		}else{
			obj.accumulate("subImages", "N/A");
		}
		
		return obj;
	}

	public JSONObject setmainImage(Integer itemId, Integer imageId) {
		JSONObject obj = new JSONObject();
		Item item = itemDao.getItem(itemId);
		Image image = imageDao.getImage(imageId);
		//获取原先的主图片对象
		Image oldmainimage = imageDao.getImage(item.getImageId());
		if(oldmainimage != null){	//如果不为空则维护次要图片关系
			oldmainimage.setItemId(itemId);
		}
		item.setImageId(imageId);
		image.setItemId(null);
		try {
			itemDao.update(item);
			imageDao.update(image);
			imageDao.update(oldmainimage);
		} catch (Exception e) {
			obj.accumulate("status", false);
			obj.accumulate("info", "设置主图片失败");
			return obj;
		}
		obj.accumulate("status", true);
		obj.accumulate("info", "设置成功");
		return obj;
	}
	
}

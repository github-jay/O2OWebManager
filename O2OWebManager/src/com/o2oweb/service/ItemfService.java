package com.o2oweb.service;

import java.lang.reflect.Field;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.o2oweb.dao.ItemfDao;
import com.o2oweb.entity.Itemf;

@Component("itemfService")
public class ItemfService {

	@Autowired
	private ItemfDao itemfDao;
	
	public JSONObject changeFName(int FNum,String FName){
		JSONObject obj = new JSONObject();
		try {
			
			Itemf itemf = itemfDao.getItemf(FNum);
			itemf.setFname(FName);
			itemfDao.update(itemf);
		} catch (Exception e) {
			obj.accumulate("status", false);
			obj.accumulate("info", "名称修改失败");
			return obj;
		}
		obj.accumulate("status", true);
		obj.accumulate("info", "修改成功");
		
		return obj;
	}
	
	public JSONObject changeItem(int FNum,String itemId,int index){
		JSONObject obj = new JSONObject();
		try {
			int itemID = Integer.valueOf(itemId);
			Itemf itemf = itemfDao.getItemf(FNum);
			refsetvalue(itemf, index, itemID);
			itemfDao.update(itemf);
		} catch (Exception e) {
			obj.accumulate("status", false);
			obj.accumulate("info", "编辑失败");
			return obj;
		}
		obj.accumulate("status", true);
		obj.accumulate("info", "商品编辑成功");
		return obj;
	}
	private void refsetvalue(Itemf itemf,int index,int itemID) throws Exception{
		Class itemclass = itemf.getClass();
		String propertyName = "item"+index;
		Field field = itemclass.getDeclaredField(propertyName);
		field.setAccessible(true);
		field.set(itemf, itemID);
	}
}

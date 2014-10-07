package com.o2oweb.action;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.dao.ImageDao;
import com.o2oweb.dao.ItemDao;
import com.o2oweb.entity.Item;
import com.o2oweb.service.ImageService;
import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("DetailAction")
public class ItemDetail extends BaseAction {
	private static String RESULT = "result";
	private static String INFO = "info";
	private String[] fields = {"itemId","itemName","price","discount","imageId","stockNum"};

	@Autowired
	private ImageService imageService;

	@Autowired
	private ItemDao itemDao;
	
	private int itemID;

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	@Override
	public String execute() throws Exception {
		JSONObject obj = new JSONObject();
		
		Item item = itemDao.getItem(itemID);
		if(item == null){
			obj.accumulate(RESULT, false);
			obj.accumulate(INFO, "请求的商品不存在");
		}else{
			int[] images = imageService.getImageIDS(itemID);
			obj.accumulate("images", images);
			JSONObject itemobj = item2json(item);
			obj.accumulate("item", itemobj);
		}
		
		writeResponse(obj);
		return super.execute();
	}
	
	private JSONObject item2json(Item item){
		JSONObject itemobj = new JSONObject();
		
		itemobj.accumulate("itemId", item.getItemId());
		itemobj.accumulate("itemName", item.getItemName());
		itemobj.accumulate("price", item.getPrice());
		itemobj.accumulate("discount", item.getDiscount());
		itemobj.accumulate("imageId", item.getImageId());
		itemobj.accumulate("stockNum", item.getStockNum());
		itemobj.accumulate("detials", item.getItemDetail());
		
		return itemobj;
	}
}
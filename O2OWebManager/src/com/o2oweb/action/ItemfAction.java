package com.o2oweb.action;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.service.ItemfService;
import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("itemfAction")
public class ItemfAction extends BaseAction {

	@Autowired
	private ItemfService itemfService;
	
	private int FNum;
	private String FName;
	private String itemId;
	private int index;
	
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getFNum() {
		return FNum;
	}
	public String getFName() {
		return FName;
	}
	public void setFNum(int fNum) {
		FNum = fNum;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	
	public void changeFname(){
		JSONObject obj = itemfService.changeFName(FNum, FName);
		writeResponse(obj);
	}
	
	public void changeItem(){
		JSONObject obj = itemfService.changeItem(FNum, itemId, index);
		writeResponse(obj);
	}
	
}

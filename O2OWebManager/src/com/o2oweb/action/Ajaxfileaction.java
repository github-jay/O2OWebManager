package com.o2oweb.action;


import java.io.File;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("ajaxfileAction")
public class Ajaxfileaction extends BaseAction{

	private File file2upload;
	private String itemId;
	
	@Override
	public String execute() throws Exception {
		System.out.println(file2upload);
		System.out.println(itemId);
		writeResponse("aaaa");
		return super.execute();
	}


	public File getFile2upload() {
		return file2upload;
	}


	public void setFile2upload(File file2upload) {
		this.file2upload = file2upload;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	
}

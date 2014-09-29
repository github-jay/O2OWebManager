package com.o2oweb.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

import com.o2oweb.service.Index3Service;
import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("index3Action")
public class index3Action extends BaseAction {
	
	@Autowired
	private Index3Service index3Service;
	
	public void getEntirePage(){
		JSONObject obj = index3Service.getEntirePage();
		writeResponse(obj);
	}
}

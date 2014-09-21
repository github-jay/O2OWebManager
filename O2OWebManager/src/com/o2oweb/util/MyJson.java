package com.o2oweb.util;

import java.util.List;

import com.o2oweb.common.dao.support.Page;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MyJson {

	public static JSONObject page2Jsobj(Page page){
		JSONObject obj = new JSONObject();
		obj.accumulate("total", page.getTotalCount());
		List rows = (List) page.getData();
		JSONArray jsa = JSONArray.fromObject(rows);
		
		obj.accumulate("rows", jsa);
		return obj;
	}
}

package com.o2oweb.action;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import com.o2oweb.entity.Image;
import com.o2oweb.service.ImageService;
import com.o2oweb.service.ItemService;
import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("getImage")
public class ImageAction extends BaseAction {
	@Autowired
	private ImageService imageService;

	private ByteArrayInputStream inputStream;

	private String imageID;

	private Integer itemId;
	
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getImageID() {
		return imageID;
	}

	public void setImageID(String imageID) {
		this.imageID = imageID;
	}

	
	
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Override
	public String execute() throws Exception {
		String imagePath = getImagePath(imageID);
		if (!isExits(imagePath)) {
			throw new RuntimeException("请求的图片不存在");
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InputStream input = new BufferedInputStream(new FileInputStream(
				imagePath));
		byte[] buffer = new byte[1024];
		while (input.read(buffer) > 0) {
			bos.write(buffer);
		}
		this.inputStream = new ByteArrayInputStream(bos.toByteArray());
		bos.close();
		input.close();
		return super.execute();
	}

	private boolean isExits(String imagePath) {
		File imageFile = new File(imagePath);
		return imageFile.exists();
	}

	private String getImagePath(String ID) {
		Image image = imageService.getImage(Integer.valueOf(imageID));
		return image.getImageUrl();
	}
	
	//获取所有商品图片信息
	public void getImageinfo(){
		JSONObject obj = this.imageService.getimageInfo(itemId);
		writeResponse(obj);
	}
	//设置商品主图片
	public void setmainItemimage(){
		JSONObject obj = this.imageService.setmainImage(itemId,Integer.valueOf(imageID));
		writeResponse(obj);
	}
	
	//移除图片
	public void removeItemimage(){
		JSONObject obj = this.imageService.removeImage(itemId,Integer.valueOf(imageID));
		writeResponse(obj);
	}
}

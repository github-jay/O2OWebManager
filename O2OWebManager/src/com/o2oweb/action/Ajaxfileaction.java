package com.o2oweb.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.entity.Image;
import com.o2oweb.service.ImageService;
import com.o2oweb.service.ItemService;
import com.o2oweb.util.BaseAction;
import com.o2oweb.util.PropertiesUtil;

@Scope("request")
@Service("ajaxfileAction")
public class Ajaxfileaction extends BaseAction {

	@Autowired
	private ItemService itemService;
	@Autowired
	private ImageService imageService;

	private File file2upload;
	private String itemId;

	@Override
	public String execute() throws Exception {
		// 得到工程保存图片的路径
		PropertiesUtil pu = new PropertiesUtil();
		String root = pu.getValue("imageURL");

		InputStream is = new FileInputStream(file2upload);

		// 得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
		File destFile = new File(root, createFileName());

		// 把图片写入到上面设置的路径里
		OutputStream os = new FileOutputStream(destFile);
		byte[] buffer = new byte[400];
		int length = 0;
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();

		Image image = new Image();
		image.setImageUrl(destFile.getAbsolutePath());
		image.setItemId(Integer.parseInt(itemId));
		imageService.save(image);

		writeResponse("aaaa");
		return super.execute();
	}
	
	private String createFileName() {
		Random r = new Random();
		DateFormat df = new SimpleDateFormat("yyMMddhhmmss");
		return String.format("%s%06d", new Object[] { df.format(new Date()),
				Integer.valueOf(r.nextInt(100000)) });
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

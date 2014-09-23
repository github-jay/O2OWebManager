package com.o2oweb.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.entity.Image;
import com.o2oweb.entity.Item;
import com.o2oweb.service.ImageService;
import com.o2oweb.service.ItemService;
import com.o2oweb.util.BaseAction;
import com.o2oweb.util.POIUtil;
import com.o2oweb.util.PropertiesUtil;

@Scope("request")
@Service("ajaxfileAction")
public class Ajaxfileaction extends BaseAction {

	@Autowired
	private ItemService itemService;
	@Autowired
	private ImageService imageService;

	private File file2upload;
	private File excel2upload;
	

	private String itemId;
	private String fileName;
	private String fileExt;

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

		JSONObject obj = new JSONObject();
		obj.accumulate("status", true);
		obj.accumulate("info", "上传成功");

		writeResponse(obj);
		return super.execute();
	}

	public void importExcel() {

		JSONObject obj = new JSONObject();
		try {
			// 若上传文件不为excel，返回错误信息
			if (!fileExt.equals("xls") && !fileExt.equals("xlsx")) {
				obj.accumulate("status", false);
				obj.accumulate("info", "上传失败，文件格式错误！");
				writeResponse(obj);
				return;
			}
			String keys = "名称（必填）,分类（必填）,条码（必填）,库存量（必填）,进货价（必填）,销售价（必填）";

			List<Map<String, String>> list = POIUtil.importExcelToMap(
					excel2upload, keys);

			for (Map<String, String> row : list) {
				Item item = new Item();
				item.setDiscount(1);
				item.setLevelId(0);
				item.setItemName(row.get("名称（必填）").trim());
				item.setPrice(Float.valueOf(row.get("销售价（必填）").trim()));
				item.setStockNum(Integer.valueOf(row.get("库存量（必填）").trim()));
				item.setBarCode(row.get("条码（必填）").trim());
				item.setInPrice(Float.valueOf(row.get("进货价（必填）").trim()));
				itemService.save(item);
			}
			obj.accumulate("status", true);
			obj.accumulate("info", "导入成功");
			writeResponse(obj);

		} catch (Exception e) {
			obj.accumulate("status", false);
			obj.accumulate("info", "数据导入异常");
			writeResponse(obj);
			e.printStackTrace();
		}
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public File getExcel2upload() {
		return excel2upload;
	}

	public void setExcel2upload(File excel2upload) {
		this.excel2upload = excel2upload;
	}
}

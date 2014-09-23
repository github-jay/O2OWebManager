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

import javax.annotation.Resource;

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
@Service("fileAction")
public class FileAction extends BaseAction {
	private ItemService itemService;
	private ImageService imageService;
	// 上传文件集合
	private List<File> file;
	// 上传文件名集合
	private List<String> fileFileName;
	// 上传文件内容类型集合
	private List<String> fileContentType;

	public void importExcel() {

		try {
			for (int i = 0; i < file.size(); i++) {
				String fileName = fileFileName.get(i);

				// 若上传文件不为excel，返回错误信息
				if (!fileName.endsWith(".xls") || !fileName.endsWith(".xlsx")) {
					writeResponse(false, "上传失败，文件格式错误！");
					return;
				}
				File excelFile = file.get(i);
				String keys = "名称（必填）,分类（必填）,条码（必填）,库存量（必填）,进货价（必填）,销售价（必填）";

				List<Map<String, String>> list = POIUtil.importExcelToMap(
						excelFile, keys);

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
			}

			writeResponse(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void importPicture() {
		try {
			// 得到工程保存图片的路径
			PropertiesUtil pu = new PropertiesUtil();
			// String root = pu.getValue("imageURL");
			String root = "D://ItemImages";

			// 循环上传的文件
			for (int i = 0; i < file.size(); i++) {
				InputStream is = new FileInputStream(file.get(i));

				// 得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
				File destFile = new File(root,
						createFileName(fileFileName.get(i)));

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
				image.setImageName(fileFileName.get(i));
				imageService.save(image);
			}

			writeResponse(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String createFileName(String name) {
		Random r = new Random();
		DateFormat df = new SimpleDateFormat("yyMMddhhmmss");
		return String.format("%s%06d%s", new Object[] { df.format(new Date()),
				Integer.valueOf(r.nextInt(100000)), name });
	}

	public ItemService getItemService() {
		return itemService;
	}

	@Resource
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public ImageService getImageService() {
		return imageService;
	}

	@Resource
	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

}

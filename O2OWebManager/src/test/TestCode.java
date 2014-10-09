package test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.o2oweb.entity.Item;
import com.o2oweb.util.POIUtil;
import com.o2oweb.util.PropertiesUtil;

public class TestCode {
	@Test
	public void testName() {
		String code = "test";
		Random r = new Random();
		DateFormat df = new SimpleDateFormat("yyMMddhhmmss");
		System.out.println(String.format(
				"%s%s%06d",
				new Object[] { code, df.format(new Date()),
						Integer.valueOf(r.nextInt(100000)) }));
	}

	@Test
	public void testProperties() {
		PropertiesUtil pu = new PropertiesUtil();
		String root = pu.getValue("imageURL");
		System.out.println(root);
	}

	@Test
	public void getValue() {
		Properties prop = new Properties();
		InputStream in = Object.class.getResourceAsStream("/server.properties");
		try {
			prop.load(in);
			System.out.println(prop.getProperty("imageURL").trim());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void getPath() {
//		System.out.println(this.getClass().getClassLoader()
//				.getResource("server.properties").toString());
		Double dou = (Double)null;
		if(dou == null)
			dou = 0.0;
		System.out.println(dou.toString());
	}
	
	@Test
	public void testPOI() {
		File excelFile = new File("D://学生基本信息 学生证.xlsx");
		String keys = "学号";
		List<Map<String, String>> list = POIUtil.importExcelToMap(
				excelFile, keys);
		for (Map<String, String> row : list) {
			System.out.println(row.get("学号"));
		}
	}
}

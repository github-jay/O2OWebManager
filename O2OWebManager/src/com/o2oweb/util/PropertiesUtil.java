package com.o2oweb.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public String getValue(String key) {
		Properties prop = new Properties();
		String url = this.getClass().getClassLoader()
				.getResource("server.properties").toString().substring(6);
		String empUrl = url.replace("%20", " ");// 如果你的文件路径中包含空格，是必定会报错的
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(empUrl));
			prop.load(in);
			String value = prop.getProperty(key).trim();
			in.close();
			return value;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

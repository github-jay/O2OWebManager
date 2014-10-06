package com.o2oweb.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public String getValue(String key) {
		Properties prop = new Properties();
//		String url = this.getClass().getClassLoader()
//				.getResource("config.properties").toString().substring(6);
//		String empUrl = url.replace("%20", " ");// �������ļ�·���а�ո��Ǳض��ᱨ���
		String empUrl = this.getClass().getClassLoader().getResource("config.properties").getFile();
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

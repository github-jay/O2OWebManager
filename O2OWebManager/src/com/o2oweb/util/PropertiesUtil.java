package com.o2oweb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static String getValue(String key) {
		Properties prop = new Properties();
		InputStream in = Object.class.getResourceAsStream("/server.properties");
		try {
			prop.load(in);
			return prop.getProperty(key).trim();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

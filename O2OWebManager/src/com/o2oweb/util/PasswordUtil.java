package com.o2oweb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class PasswordUtil {

	public static MessageDigest md5;
	public static String toMd5(String password) {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] result = md5.digest(password.getBytes());
		return new String(result);
	}
	public static String toWord(String code) throws NoSuchAlgorithmException{
		md5 = MessageDigest.getInstance("MD5");
		byte[] result = md5.digest(code.getBytes());
		return new String(result);
	}
}

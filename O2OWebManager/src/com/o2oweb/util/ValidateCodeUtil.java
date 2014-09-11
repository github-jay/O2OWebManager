package com.o2oweb.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ValidateCodeUtil {

	public enum SecurityCodeLevel {Simple,Medium,Hard};
	
	public static String getValidateCode(){
		return getValidateCode(4,SecurityCodeLevel.Medium,false);
	}

	private static String getValidateCode(int length, SecurityCodeLevel level,
			boolean isRepeat) {
		char[] codes={'1','2','3','4','5','6','7','8','9',
				'a','b','c','d','e','f','g','h','i',
				'j','k','m','n','p','q','r','s','t',
				'u','v','w','x','y','z','A','B','C',
				'D','E','F','G','H','I','J','K','L',
				'M','N','P','Q','R','S','T','U','V',
				'W','X','Y','Z'};
		if(level==SecurityCodeLevel.Simple){
			codes = Arrays.copyOfRange(codes, 0, 9);
		}else if(level == SecurityCodeLevel.Medium){
			codes = Arrays.copyOfRange(codes, 0, 33);
		}
		int n = codes.length;
		if(length > n &&isRepeat == false){
			throw new RuntimeException("验证码生成异常");
		}
		char[] result = new char[length];
		if(isRepeat){
			for(int i = 0;i < result.length;i++){
				int r = (int) (Math.random() * n);
				result[i] = codes[r];
			}
		}else {
			for(int i = 0;i < result.length;i++){
				int r = (int) (Math.random() * n);
				result[i] = codes[r];
				codes[r] = codes[n-1];
				n--;
			}
		}
		return String.valueOf(result);
	}
	
	public static BufferedImage creatImage(String validCode){
		int codeLength = validCode.length();
		//字体大小
		int fSize = 20;
		int fWidth = fSize + 1;
		//图片宽度
//		int width = codeLength * fWidth + 10;
		int width = 110;
		
		int height = fSize * 2 +1;
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.createGraphics();
		//填充背景
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//绘制边框
		g.setColor(Color.LIGHT_GRAY);
		//边框字体样式
		g.setFont(new Font("Arial", Font.BOLD, height-2));
		g.drawRect(0, 0, width-1, height-1);
		
		//绘制干扰
		Random rand = new Random();
		g.setColor(Color.GREEN);
		for(int i = 0;i < codeLength *6;i++){
			int startx = rand.nextInt(width);
			int starty = rand.nextInt(height);
			int endx = rand.nextInt(width);
			int endy = rand.nextInt(height);
			g.drawLine(startx, starty, endx, endy);
		}
		//绘制验证码
		int codeY = height - 10;
		g.setColor(new Color(19, 148, 246));
		g.setFont(new Font("Georgia",Font.BOLD,25));
		for(int i = 0;i < codeLength;i++){
			g.drawString(String.valueOf(validCode.charAt(i)), i * 20 + 8, codeY);
		}
		g.dispose();
		return image;
	}
	
	public static ByteArrayInputStream getImageAsStream(String validCode){
		BufferedImage image = creatImage(validCode);
		return converImageToStream(image);
	}

	private static ByteArrayInputStream converImageToStream(BufferedImage image) {
		ByteArrayInputStream inputStream = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(bos);
		try {
			jpeg.encode(image);
			byte[] bts = bos.toByteArray();
			inputStream  = new ByteArrayInputStream(bts);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return inputStream;
	}
}

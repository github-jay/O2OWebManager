package com.o2oweb.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class StringUtil extends StringUtils {
	private static final Log log = LogFactory.getLog(StringUtil.class);

	public static String json2Jsons(String jsonName, String json) {
		String result = "{" + jsonName + "��" + json + "}";
		return result;
	}

	@SuppressWarnings("unchecked")
	public static String[] inSourceNotInTarget(String[] source, String[] target) {
		List resultList = new ArrayList();
		List sourceList = Arrays.asList(source);
		List targetList = Arrays.asList(target);
		for (Iterator it = sourceList.iterator(); it.hasNext();) {
			Object candidate = it.next();
			if (!targetList.contains(candidate)) {
				resultList.add(candidate);
			}
		}
		return (String[]) resultList.toArray(new String[resultList.size()]);
	}

	public static String[] reverse(String[] source) {
		String[] result = new String[source.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = source[(result.length - i - 1)];
		}
		return result;
	}



	public static boolean isNotNullOrEmpty(String str) {
		return !isNullOrEmpty(str);
	}

	public static boolean isNullOrEmpty(String str) {
		return (str == null) || StringUtils.isEmpty(str);
	}

	public static String readFromFile(File filename, String encode) {
		StringBuilder result = new StringBuilder("");
		try {
			FileInputStream fis = new FileInputStream(filename);
			InputStream is = fis;
			if (encode.toUpperCase().contains("UTF")) {
				UnicodeInputStream uin = new UnicodeInputStream(fis, encode);
				encode = uin.getEncoding();
				is = uin;
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					encode));
			String buffer = "";
			while ((buffer = br.readLine()) != null)
				result.append(buffer).append("\n");
			br.close();
		} catch (IOException ex) {
			log.error(ex.getMessage(), ex);
			return null;
		}
		return result.toString();
	}


	public static void writeToFile(File fout, String value, String encode) {
		BufferedWriter bw = null;
		try {
			createNewFile(fout, false);
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fout), encode));
			bw.write(value);
			bw.flush();
			bw.close();
			log.info("д���ļ���" + fout.getAbsolutePath());
		} catch (IOException ex) {
			log.error(null, ex);
		}
	}

	public static boolean pkiLogin(String path) {
		boolean state = false;
		if ((isNotNullOrEmpty(path)) && (path.indexOf(":") != -1)) {
			state = new File(path).exists();
		}
		return state;
	}

	public static void createNewFile(File filename, boolean delete) {
		filename = filename.getAbsoluteFile();
		try {
			if (filename.exists()) {
				if ((delete) || (filename.length() == 0L)) {
					if (filename.delete()) {
						if (!filename.createNewFile())
							log.info("create new file failed.");
					} else {
						log.info("delete file failed.");
					}
				} else
					return;
			} else {
				File path = filename.getParentFile();
				if ((!path.exists()) && (!path.mkdirs())) {
					log.info("create path failed.");
				}

				if ((path.exists()) && (!filename.createNewFile()))
					log.info("create new file failed.");
			}
		} catch (IOException ex) {
			log.error("File: " + filename.toString() + " create failed.", ex);
		}
	}

	public static class UnicodeInputStream extends InputStream {
		PushbackInputStream internalIn;
		boolean isInited = false;
		String defaultEnc;
		String encoding;

		UnicodeInputStream(InputStream in, String defaultEnc) {
			this.internalIn = new PushbackInputStream(in, 4);
			this.defaultEnc = defaultEnc;
		}

		public String getDefaultEncoding() {
			return this.defaultEnc;
		}

		public String getEncoding() {
			if (!this.isInited) {
				try {
					init();
				} catch (IOException ex) {
					IllegalStateException ise = new IllegalStateException(
							"Init method failed.");
					ise.initCause(ise);
					throw ise;
				}
			}
			return this.encoding;
		}

		protected void init() throws IOException {
			if (this.isInited) {
				return;
			}
			byte[] bom = new byte[4];

			int n = this.internalIn.read(bom, 0, bom.length);
			int unread;
			if ((bom[0] == 0) && (bom[1] == 0) && (bom[2] == -2)
					&& (bom[3] == -1)) {
				this.encoding = "UTF-32BE";
				unread = n - 4;
			} else {
				// int unread;
				if ((bom[0] == -1) && (bom[1] == -2) && (bom[2] == 0)
						&& (bom[3] == 0)) {
					this.encoding = "UTF-32LE";
					unread = n - 4;
				} else {
					// int unread;
					if ((bom[0] == -17) && (bom[1] == -69) && (bom[2] == -65)) {
						this.encoding = "UTF-8";
						unread = n - 3;
					} else {
						// int unread;
						if ((bom[0] == -2) && (bom[1] == -1)) {
							this.encoding = "UTF-16BE";
							unread = n - 2;
						} else {
							// int unread;
							if ((bom[0] == -1) && (bom[1] == -2)) {
								this.encoding = "UTF-16LE";
								unread = n - 2;
							} else {
								this.encoding = this.defaultEnc;
								unread = n;
							}
						}
					}
				}
			}
			if (unread > 0) {
				this.internalIn.unread(bom, n - unread, unread);
			}
			this.isInited = true;
		}

		public void close() throws IOException {
			this.isInited = true;
			this.internalIn.close();
		}

		public int read() throws IOException {
			this.isInited = true;
			return this.internalIn.read();
		}
	}
	/**
	* ���ܣ��ж�һ���ַ��Ƿ�������ַ�
	* @param string Ҫ�жϵ��ַ�
	* @return true �ṩ�Ĳ���string���������ַ�
	* @return false �ṩ�Ĳ���string�������ַ�
	*/
	public static boolean isConSpeCharacters(String string) {
	   // TODO Auto-generated method stub
	   if(string.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length()==0){
	    //���������ַ�
	    return true;
	   }
	   return false;
	}
	
	public static boolean isNotConSpeCharacters(String string) {
	   
	   return !isConSpeCharacters(string);
	}
	
	/**
	 * �Ƿ�������
	 * @param str
	 * @return  true Ϊ��������
	 * @return  false ��Ϊ��������
	 */
	public static boolean isIncludeChinese(String str){
		  
	    char[] chars=str.toCharArray(); 
	    boolean isGB2312=false; 
	    for(int i=0;i<chars.length;i++){
	                byte[] bytes=(""+chars[i]).getBytes(); 
	                if(bytes.length==2){ 
	                            int[] ints=new int[2]; 
	                            ints[0]=bytes[0]& 0xff; 
	                            ints[1]=bytes[1]& 0xff; 
	                            if(ints[0]>=0x81 && ints[0]<=0xFE && ints[1]>=0x40 && ints[1]<=0xFE){ 
	                                        isGB2312=true; 
	                                        break; 
	                            } 
	                } 
	    } 
	    return isGB2312; 
	}
	/**
	 * �Ƿ�������
	 * @param str
	 * @return  true ������
	 * @return  false ���з�����
	 */
	public static boolean isChinese(String str){
		  
	    char[] chars=str.toCharArray(); 
	    boolean isGB2312=true; 
	    for(int i=0;i<chars.length;i++){
	                byte[] bytes=(""+chars[i]).getBytes(); 
	                if(bytes.length==2){ 
	                            int[] ints=new int[2]; 
	                            ints[0]=bytes[0]& 0xff; 
	                            ints[1]=bytes[1]& 0xff; 
	                            if(ints[0]>=0x81 && ints[0]<=0xFE && ints[1]>=0x40 && ints[1]<=0xFE){ 
	                                   continue; 
	                            } 
	                        	isGB2312 = false;
	                        	break;
	                }else {
	                	isGB2312 = false;
	                	break;
					}
	    } 
	    return isGB2312; 
	}
	
	/**
	 * �Ƿ�Ϊ�ֻ�� �� ����
	 * @param str
	 * @return  true ��ʽ���
	 * @return  false ��ʽ����
	 */
	public static boolean isMobile(String str)
	{
		String mobile = "(^(([0\\+]\\d{2,3})?(0\\d{2,3}))?(\\d{7,8})((\\d{3,}))?$)|(^1[3|5|8][0-9]\\d{8}$)";
        Pattern pattern = Pattern.compile(mobile);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
		
	}
	
	/**
	 * �ж��ַ� �Ƿ�Ϊ����
	 * @param args
	 * @return
	 */
	public static boolean isNum(String args){
		Pattern p=Pattern.compile("^[\\d]*");  //������ʽ
		Matcher m=p.matcher(args);
		if(m.matches())
		return true;
		else
		return false;
	}
	/**
	 * �ж��ַ� �Ƿ�Ϊ����
	 * @param args
	 * @return
	 */
	public static boolean isNotNum(String args){
		return !isNum(args);
	}
	
	public static void main(String[] args) {
//		String[] a = { "1", "2", "3", "4" };
//		String[] b = { "1", "2", "7", "8" };
//		String[] r = inSourceNotInTarget(b, a);
//		for (int i = 0; i < r.length; i++)
//			log.debug(r[i]);
		System.out.println(isMobile("03162084888"));
	}
}
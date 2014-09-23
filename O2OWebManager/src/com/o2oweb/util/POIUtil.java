package com.o2oweb.util;

/**
 * @author �������� zj
 * ��˵��
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIUtil {

	public static Workbook create(InputStream in) throws IOException,
			InvalidFormatException {
		if (!in.markSupported()) {
			in = new PushbackInputStream(in, 8);
		}
		if (POIFSFileSystem.hasPOIFSHeader(in)) {
			return new HSSFWorkbook(in);
		}
		if (POIXMLDocument.hasOOXMLHeader(in)) {
			return new XSSFWorkbook(OPCPackage.open(in));
		}
		throw new IllegalArgumentException("���excel�汾Ŀǰpoi��������");
	}

	/**
	 * ��ȡ�ļ����·��
	 * 
	 * @param realPath
	 *            ���·��
	 * @param name
	 *            �ļ���
	 * @return
	 */
	public static String getOutputPath(String realPath, String name) {
		String outputPath = realPath + "excel/" + name + "_"
				+ DateTimeUtil.getCurrentDate("yyMMddHHmmss") + ".xls";
		return outputPath;
	}

	/**
	 * ����Excel�ļ� ������List<Map<String K,String V>>�ķ�ʽ���
	 * 
	 * @param excelName
	 *            : �ļ�·��
	 * @param strKeys
	 *            : Map��Key�б?ValueΪ��Ӧ��sheetһ���и��е�ֵ
	 * @return
	 */
	public static List<Map<String, String>> importExcelToMap(String excelName,
			String strKeys) {
		File excelFile = new File(excelName);
		FileInputStream excelFileInput = null;
		String[] strKey = strKeys.split(",");
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		int i = 1;
		Workbook workbook;
		try {
			excelFileInput = new FileInputStream(excelFile);
			workbook = create(excelFileInput);
			Sheet sheet = workbook.getSheetAt(0);
			while (true) {
				Row row = sheet.getRow(i);
				if (row == null)
					break;

				Map<String, String> map = new HashMap<String, String>();
				Boolean flag = false;
				for (int keyIndex = 0; keyIndex < strKey.length; keyIndex++) {
					// System.out.println(keyIndex+" "+row.getCell(keyIndex));
					Cell cell = row.getCell(keyIndex);
					// null ������ ���ø�ʽΪcell_type_string
					if (null != row.getCell(keyIndex))
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					String cellValue = "";
					if (cell != null) {
						cellValue = row.getCell(keyIndex).getStringCellValue();
					}
					// �������ݴ��ڲ�Ϊ�� �� null����ݣ�����Ϊ��Ч���
					if (cellValue != null && !cellValue.isEmpty())
						flag = true;
					map.put(strKey[keyIndex], cellValue);
				}
				// ֻ�����Ч���
				if (flag)
					listMap.add(map);

				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("�����жϣ�����λ�ã���" + i + "����ݣ�");
		} finally {
			try {
				excelFileInput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listMap;
	}

	/**
	 * ����Excel�ļ� ������List<Map<String K,String V>>�ķ�ʽ���
	 * 
	 * @param excelFile
	 *            : Excel�ļ�����
	 * @param strKeys
	 *            : Map��Key�б?ValueΪ��Ӧ��sheetһ���и��е�ֵ
	 * @return
	 */
	public static List<Map<String, String>> importExcelToMap(File excelFile,
			String strKeys) {
		String[] strKey = strKeys.split(",");
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();

		int i = 1;
		try {
			Workbook workbook = create(new FileInputStream(excelFile));
			Sheet sheet = workbook.getSheetAt(0);
			while (true) {
				Row row = sheet.getRow(i);
				if (row == null)
					break;

				Map<String, String> map = new HashMap<String, String>();
				Boolean flag = false;
				for (int keyIndex = 0; keyIndex < strKey.length; keyIndex++) {
					// System.out.println(keyIndex+" "+row.getCell(keyIndex));
					Cell cell = row.getCell(keyIndex);
					// null ������ ���ø�ʽΪcell_type_string
					if (null != row.getCell(keyIndex))
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					String cellValue = "";
					if (cell != null) {
						cellValue = row.getCell(keyIndex).getStringCellValue();
					}
					// �������ݴ��ڲ�Ϊ�� �� null����ݣ�����Ϊ��Ч���
					if (cellValue != null && !cellValue.isEmpty())
						flag = true;
					map.put(strKey[keyIndex], cellValue);
				}
				// ֻ�����Ч���
				if (flag)
					listMap.add(map);

				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("�����жϣ�����λ�ã���" + i + "����ݣ�");
		}

		return listMap;
	}

	/**
	 * ����Excel�ļ� ���Դ����ݸ�ʽΪList<Map<String K,String V>>
	 * 
	 * @param objList
	 *            : Excel���Դ
	 * @param title
	 *            : �½�Sheet�����
	 * @param strTitle
	 *            : Sheet���еı��⣨��һ�и��е���ƣ�
	 * @param strBody
	 *            : Sheet���е�ȡֵ��������е�ֵ��objClass��get������ƣ�
	 * @param outputPath
	 *            : Excel�ĵ�����·��
	 */
	public static void exportExcelByMap(List<Map<String, String>> objList,
			String title, String strTitle, String strBody, String outputPath) {
		// ������������Excel�ļ���
		HSSFWorkbook workbook = new HSSFWorkbook();

		// ����Excel�������ĵ�һ��Sheetҳ
		HSSFSheet sheet = workbook.createSheet(title);

		// ����Sheetҳ���ļ�ͷ����һ�У�
		createTitle(sheet, strTitle);

		// ����Sheetҳ���ļ��壨�����У�
		String[] strArray = strBody.split(",");
		for (int objIndex = 0; objIndex < objList.size(); objIndex++) {
			Map map = objList.get(objIndex);
			HSSFRow row = sheet.createRow(objIndex + 1);
			for (int i = 0; i < strArray.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(map.get(strArray[i]).toString());
			}
		}

		// ����Excel�ļ�
		saveExcelFile(workbook, outputPath);
	}

	/**
	 * ����Excle�ĵ�
	 * 
	 * @param objList
	 *            : Excel���Դ
	 * @param objClass
	 *            : Excel���Դ�е��������
	 * @param title
	 *            : �½�Sheet����� ex: title = "Ա����";
	 * @param strTitle
	 *            : Sheet���еı��⣨��һ�и��е���ƣ� ex: strTitle =
	 *            "Ա������,Ա������,�Ա�,��������,����,������,��ϵ�绰,�����ʼ�,�����"
	 *            ;
	 * @param strBody
	 *            : Sheet���е�ȡֵ��������е�ֵ��objClass��get������ƣ� ex: strBody =
	 *            "getCode,getName,getSex,getBirthday,getHomeplace.getName,getOrg.getShortName,getContactTel,getEmail,getZjm"
	 *            ;
	 * @param outputPath
	 *            : Excel�ĵ�����·��
	 */
	public static void exportExcelByObject(List objList, Class objClass,
			String title, String strTitle, String strBody, String outputPath) {
		// ��ʼ��������
		HSSFWorkbook workbook = initWorkbook(objList, objClass, title,
				strTitle, strBody);
		// ����Excel�ļ�
		saveExcelFile(workbook, outputPath);
	}

	/**
	 * ��ʼ��������
	 * 
	 * @param objList
	 *            : Excel���Դ
	 * @param objClass
	 *            : Excel���Դ�е��������
	 * @param title
	 *            : �½�Sheet�����
	 * @param strTitle
	 *            : Sheet���еı��⣨��һ�и��е���ƣ�
	 * @param strBody
	 *            : Sheet���е�ȡֵ��������е�ֵ��objClass��get������ƣ�
	 */
	private static HSSFWorkbook initWorkbook(List objList, Class objClass,
			String title, String strTitle, String strBody) {
		// ������������Excel�ļ���
		HSSFWorkbook workbook = new HSSFWorkbook();

		// ����Excel�������ĵ�һ��Sheetҳ
		HSSFSheet sheet = workbook.createSheet(title);

		// ����Sheetҳ���ļ�ͷ����һ�У�
		createTitle(sheet, strTitle);

		// ����Sheetҳ���ļ��壨�����У�
		createBody(objList, objClass, sheet, strBody);

		return workbook;
	}

	/**
	 * ����Excel��ǰsheetҳ��ͷ��Ϣ
	 * 
	 * @param sheet
	 *            : Excel��������һ��sheet
	 * @param strTitle
	 *            : sheetͷ��Ϣ�б�(sheet��һ�и���ֵ)
	 */
	private static void createTitle(HSSFSheet sheet, String strTitle) {
		HSSFRow row = sheet.createRow(0); // ������ҳ��һ��
		HSSFCell cell = null;

		String[] strArray = strTitle.split(",");

		for (int i = 0; i < strArray.length; i++) {
			cell = row.createCell(i); // �������е�һ��
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(strArray[i]);
		}

	}

	/**
	 * ����Excel��ǰsheetҳ������Ϣ
	 * 
	 * @param objList
	 *            : Excel���Դ
	 * @param objClass
	 *            : Excel���Դ�е��������
	 * @param sheet
	 *            : Excel��������sheetҳ
	 * @param strBody
	 *            : Sheet���е�ȡֵ��������е�ֵ��objClass��get������ƣ�
	 */
	private static void createBody(List objList, Class objClass,
			HSSFSheet sheet, String strBody) {
		String[] targetMethod = strBody.split(",");
		Method[] ms = objClass.getMethods();

		// ѭ��objList�����б?���sheet���У�
		for (int objIndex = 0; objIndex < objList.size(); objIndex++) {
			Object obj = objList.get(objIndex);
			HSSFRow row = sheet.createRow(objIndex + 1);
			// ѭ��strBodyĿ�귽�����飨���sheet���У�
			for (int strIndex = 0; strIndex < targetMethod.length; strIndex++) {
				String targetMethodName = targetMethod[strIndex];
				// ѭ��ms�������飬�ҵ�Ŀ�귽����strBody��ָ���ķ�����������
				for (int i = 0; i < ms.length; i++) {
					Method srcMethod = ms[i];
					int len = targetMethodName.indexOf(".") < 0 ? targetMethodName
							.length() : targetMethodName.indexOf(".");
					if (srcMethod.getName().equals(
							targetMethodName.substring(0, len))) {
						HSSFCell cell = row.createCell(strIndex);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						try {
							// �������һ���������͵�ֵ
							if (targetMethodName.contains(".")) {
								cell.setCellValue(referenceInvoke(
										targetMethodName, obj));
								// �������һ����ͨ����
							} else {
								Object result = srcMethod.invoke(obj);
								// �Է���Ϊ�յķ������й���
								if (result != null)
									cell.setCellValue((result).toString());
								else
									cell.setCellValue("");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

	}

	/**
	 * �������ص���һ����������ã��磺getHomeplace.getName���͵ķ������У�
	 * ����������������ֱ�����Żػ����͵�ֵ
	 * 
	 * @param targetMethod
	 *            : obj�������ķ�����
	 * @param obj
	 *            : ����Ķ���
	 * @return
	 */
	// getHomeplace.getName emp(obj)
	private static String referenceInvoke(String targetMethod, Object obj) {
		// ��ȡ�������еĵ�һ������(����ȡ����obj����ķ�����getHomeplace())
		String refMethod = targetMethod.substring(0, targetMethod.indexOf("."));
		// ��ú�������(getName())
		targetMethod = targetMethod.substring(targetMethod.indexOf(".") + 1);
		try {
			// ��õ�һ��������ִ�н��(��obj����ִ�еĽ��obj.getHomeplace())
			obj = obj.getClass().getMethod(refMethod).invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �������û�����һ��
		if (targetMethod.contains(".")) {
			return referenceInvoke(targetMethod, obj);
			// ������е������һ��
		} else {
			try {
				// ͨ��obj�����ø÷����������һ������������
				Method tarMethod = obj.getClass().getMethod(targetMethod);
				return tarMethod.invoke(obj).toString();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	/**
	 * ����Excel�ļ�
	 * 
	 * @param workbook
	 *            : Excel������
	 * @param outputPath
	 *            : Excel�ļ�����·��
	 */
	private static void saveExcelFile(HSSFWorkbook workbook, String outputPath) {
		try {
			FileOutputStream fos = new FileOutputStream(outputPath);
			workbook.write(fos);

			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��������
	 */
	public static void downLoadData(HttpServletResponse response, String path,
			String uploadedFileName) {
		try {
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(URLEncoder.encode(uploadedFileName, "utf-8")));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setHeader("Content-Type", "application/octet-stream");

		File file = new File(path);
		BufferedInputStream bis = null;// ��excel
		BufferedOutputStream bos = null;// ���

		try {
			// ��ȡexcel�ļ�
			bis = new BufferedInputStream(new FileInputStream(file));
			// д��response���������
			bos = new java.io.BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];/* ���û��� */
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
package com.o2oweb.util;

/**
 * @author 作者姓名 zj
 * 类说明
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
		throw new IllegalArgumentException("你的excel版本目前poi解析不了");
	}

	/**
	 * 获取文件输出路径
	 * 
	 * @param realPath
	 *            相对路径
	 * @param name
	 *            文件名
	 * @return
	 */
	public static String getOutputPath(String realPath, String name) {
		String outputPath = realPath + "excel/" + name + "_"
				+ DateTimeUtil.getCurrentDate("yyMMddHHmmss") + ".xls";
		return outputPath;
	}

	/**
	 * 导入Excel文件 内容以List<Map<String K,String V>>的方式存放
	 * 
	 * @param excelName
	 *            : 文件路径
	 * @param strKeys
	 *            : Map的Key列表，Value为相应的sheet一行中各列的值
	 * @return
	 */
	public static List<Map<String, String>> importExcelToMap(String excelName,
			String strKeys) {
		File excelFile = new File(excelName);
		FileInputStream excelFileInput=null;
		String[] strKey = strKeys.split(",");
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		int i = 1;
		Workbook workbook;
		try {
			excelFileInput= new FileInputStream(excelFile);
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
					// null 不可以 设置格式为cell_type_string
					if (null != row.getCell(keyIndex))
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					String cellValue = "";
					if (cell != null) {
						cellValue = row.getCell(keyIndex).getStringCellValue();
					}
					// 如果行数据存在不为空 或 null的数据，则视为有效数据
					if (cellValue != null && !cellValue.isEmpty())
						flag = true;
					map.put(strKey[keyIndex], cellValue);
				}
				// 只添加有效数据
				if (flag)
					listMap.add(map);

				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("导入中断，错误位置：第" + i + "行数据！");
		}finally{
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
	 * 导入Excel文件 内容以List<Map<String K,String V>>的方式存放
	 * 
	 * @param excelFile
	 *            : Excel文件对象
	 * @param strKeys
	 *            : Map的Key列表，Value为相应的sheet一行中各列的值
	 * @return
	 */
	public static List<Map<String, String>> importExcelToMap(File excelFile,
			String strKeys) {
		String[] strKey = strKeys.split(",");
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();

		int i = 1;
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
					excelFile));
			HSSFSheet sheet = workbook.getSheetAt(0);
			while (true) {
				HSSFRow row = sheet.getRow(i);
				if (row == null)
					break;

				Map<String, String> map = new HashMap<String, String>();
				Boolean flag = false;
				for (int keyIndex = 0; keyIndex < strKey.length; keyIndex++) {
					// System.out.println(keyIndex+" "+row.getCell(keyIndex));
					HSSFCell cell = row.getCell(keyIndex);
					// null 不可以 设置格式为cell_type_string
					if (null != row.getCell(keyIndex))
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					String cellValue = "";
					if (cell != null) {
						cellValue = row.getCell(keyIndex).getStringCellValue();
					}
					// 如果行数据存在不为空 或 null的数据，则视为有效数据
					if (cellValue != null && !cellValue.isEmpty())
						flag = true;
					map.put(strKey[keyIndex], cellValue);
				}
				// 只添加有效数据
				if (flag)
					listMap.add(map);

				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("导入中断，错误位置：第" + i + "行数据！");
		}

		return listMap;
	}

	/**
	 * 导出Excel文件 数据源的数据格式为List<Map<String K,String V>>
	 * 
	 * @param objList
	 *            : Excel数据源
	 * @param title
	 *            : 新建Sheet的名称
	 * @param strTitle
	 *            : Sheet各列的标题（第一行各列的名称）
	 * @param strBody
	 *            : Sheet各列的取值方法名（各列的值在objClass中get方法名称）
	 * @param outputPath
	 *            : Excel文档保存路径
	 */
	public static void exportExcelByMap(List<Map<String, String>> objList,
			String title, String strTitle, String strBody, String outputPath) {
		// 创建工作簿（Excel文件）
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 创建Excel工作簿的第一个Sheet页
		HSSFSheet sheet = workbook.createSheet(title);

		// 创建Sheet页的文件头（第一行）
		createTitle(sheet, strTitle);

		// 创建Sheet页的文件体（后续行）
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

		// 保存Excel文件
		saveExcelFile(workbook, outputPath);
	}

	/**
	 * 导出Excle文档
	 * 
	 * @param objList
	 *            : Excel数据源
	 * @param objClass
	 *            : Excel数据源中的数据类型
	 * @param title
	 *            : 新建Sheet的名称 ex: title = "员工表";
	 * @param strTitle
	 *            : Sheet各列的标题（第一行各列的名称） ex: strTitle =
	 *            "员工代码,员工姓名,性别,出生日期,籍贯,所属机构,联系电话,电子邮件,助记码";
	 * @param strBody
	 *            : Sheet各列的取值方法名（各列的值在objClass中get方法名称） ex: strBody =
	 *            "getCode,getName,getSex,getBirthday,getHomeplace.getName,getOrg.getShortName,getContactTel,getEmail,getZjm"
	 *            ;
	 * @param outputPath
	 *            : Excel文档保存路径
	 */
	public static void exportExcelByObject(List objList, Class objClass,
			String title, String strTitle, String strBody, String outputPath) {
		// 初始化工作簿
		HSSFWorkbook workbook = initWorkbook(objList, objClass, title,
				strTitle, strBody);
		// 保存Excel文件
		saveExcelFile(workbook, outputPath);
	}

	/**
	 * 初始化工作簿
	 * 
	 * @param objList
	 *            : Excel数据源
	 * @param objClass
	 *            : Excel数据源中的数据类型
	 * @param title
	 *            : 新建Sheet的名称
	 * @param strTitle
	 *            : Sheet各列的标题（第一行各列的名称）
	 * @param strBody
	 *            : Sheet各列的取值方法名（各列的值在objClass中get方法名称）
	 */
	private static HSSFWorkbook initWorkbook(List objList, Class objClass,
			String title, String strTitle, String strBody) {
		// 创建工作簿（Excel文件）
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 创建Excel工作簿的第一个Sheet页
		HSSFSheet sheet = workbook.createSheet(title);

		// 创建Sheet页的文件头（第一行）
		createTitle(sheet, strTitle);

		// 创建Sheet页的文件体（后续行）
		createBody(objList, objClass, sheet, strBody);

		return workbook;
	}

	/**
	 * 创建Excel当前sheet页的头信息
	 * 
	 * @param sheet
	 *            : Excel工作簿的一个sheet
	 * @param strTitle
	 *            : sheet头信息列表(sheet第一行各列值)
	 */
	private static void createTitle(HSSFSheet sheet, String strTitle) {
		HSSFRow row = sheet.createRow(0); // 创建该页的一行
		HSSFCell cell = null;

		String[] strArray = strTitle.split(",");

		for (int i = 0; i < strArray.length; i++) {
			cell = row.createCell(i); // 创建该行的一列
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(strArray[i]);
		}

	}

	/**
	 * 创建Excel当前sheet页的体信息
	 * 
	 * @param objList
	 *            : Excel数据源
	 * @param objClass
	 *            : Excel数据源中的数据类型
	 * @param sheet
	 *            : Excel工作簿的sheet页
	 * @param strBody
	 *            : Sheet各列的取值方法名（各列的值在objClass中get方法名称）
	 */
	private static void createBody(List objList, Class objClass,
			HSSFSheet sheet, String strBody) {
		String[] targetMethod = strBody.split(",");
		Method[] ms = objClass.getMethods();

		// 循环objList对象列表（生成sheet的行）
		for (int objIndex = 0; objIndex < objList.size(); objIndex++) {
			Object obj = objList.get(objIndex);
			HSSFRow row = sheet.createRow(objIndex + 1);
			// 循环strBody目标方法数组（生成sheet的列）
			for (int strIndex = 0; strIndex < targetMethod.length; strIndex++) {
				String targetMethodName = targetMethod[strIndex];
				// 循环ms方法数组，找到目标方法（strBody中指定的方法）并调用
				for (int i = 0; i < ms.length; i++) {
					Method srcMethod = ms[i];
					int len = targetMethodName.indexOf(".") < 0 ? targetMethodName
							.length() : targetMethodName.indexOf(".");
					if (srcMethod.getName().equals(
							targetMethodName.substring(0, len))) {
						HSSFCell cell = row.createCell(strIndex);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						try {
							// 如果方法返回一个引用类型的值
							if (targetMethodName.contains(".")) {
								cell.setCellValue(referenceInvoke(
										targetMethodName, obj));
								// 如果方法返回一个普通属性
							} else {
								Object result = srcMethod.invoke(obj);
								// 对返回为空的方法进行过滤
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
	 * 方法返回的是一个对象的引用（如：getHomeplace.getName类型的方法序列） 按方法序列逐层调用直到最后放回基本类型的值
	 * 
	 * @param targetMethod
	 *            : obj对象所包含的方法列
	 * @param obj
	 *            : 待处理的对象
	 * @return
	 */
	// getHomeplace.getName emp(obj)
	private static String referenceInvoke(String targetMethod, Object obj) {
		// 截取方法序列的第一个方法(即截取属于obj对象的方法：getHomeplace())
		String refMethod = targetMethod.substring(0, targetMethod.indexOf("."));
		// 获得后续方法序列(getName())
		targetMethod = targetMethod.substring(targetMethod.indexOf(".") + 1);
		try {
			// 获得第一个方法的执行结果(即obj方法执行的结果：obj.getHomeplace())
			obj = obj.getClass().getMethod(refMethod).invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 如果方法序列没到最后一节
		if (targetMethod.contains(".")) {
			return referenceInvoke(targetMethod, obj);
			// 如果方法序列到达最后一节
		} else {
			try {
				// 通过obj对象获得该方法链的最后一个方法并调用
				Method tarMethod = obj.getClass().getMethod(targetMethod);
				return tarMethod.invoke(obj).toString();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	/**
	 * 保存Excel文件
	 * 
	 * @param workbook
	 *            : Excel工作簿
	 * @param outputPath
	 *            : Excel文件保存路径
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
	 * 下载设置
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
		BufferedInputStream bis = null;// 读excel
		BufferedOutputStream bos = null;// 输出

		try {
			// 读取excel文件
			bis = new BufferedInputStream(new FileInputStream(file));
			// 写入response的输出流中
			bos = new java.io.BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];/* 设置缓存 */
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
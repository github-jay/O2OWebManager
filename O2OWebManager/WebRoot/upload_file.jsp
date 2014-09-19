<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'upload_file.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<center>
		<font color="red"><s:fielderror />
		</font>
		Excel<br>
		<s:form action="/file/fileAction!importExcel.action" method="post" enctype="multipart/form-data">
			<s:file name="file" label="文件1"></s:file>
			<s:file name="file" label="文件2"></s:file>
			<s:file name="file" label="文件3"></s:file>
			<s:file name="file" label="文件4"></s:file>
			<s:submit label="上传" />
		</s:form>
		<br>
		Image<br>
		<s:form action="/file/fileAction!importPicture.action" method="post" enctype="multipart/form-data">
			<s:file name="file" label="文件1"></s:file>
			<s:file name="file" label="文件2"></s:file>
			<s:file name="file" label="文件3"></s:file>
			<s:file name="file" label="文件4"></s:file>
			<s:submit label="上传" />
		</s:form>
	</center>
</body>
</html>

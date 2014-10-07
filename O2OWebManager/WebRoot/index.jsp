<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网站管理入口</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css">
	
    <script language="javascript" src="js/jquery-2.1.0.min.js"></script>
    
    <script language="javascript" src="js/jquery.easyui.min.js"></script>
  </head>
  
  <body>
  <a  href="/O2OWebManager/pages/Items.html" target="_blank" class="easyui-linkbutton" data-options="">商品库存管理</a>
  <a  href="/O2OWebManager/pages/Orders.html" target="_blank" class="easyui-linkbutton" data-options="">订单管理</a>
  <a  href="/O2OWebManager/pages/Index3.html" target="_blank" class="easyui-linkbutton" data-options="">首页编辑</a>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
	<style type="text/css">
		table
		  {
		  border-collapse:collapse;
		  }
		
		table, td, th
		  {
		  border:1px solid black;
		  }
	</style>
  </head>
  	
  <body>
  	<div>
  		<c:if test="${empty users}">
  	<span style="color: red;">没有相关信息</span>
  	</c:if>
  	<table>
  		<tr><td>序号</td><td>用户名</td><td>用户密码</td></tr>
  		<c:forEach items="${users}" var="user" varStatus="vs">
  			<tr><td>${vs.index+1}</td><td>${user.username}</td><td>${user.password}</td></tr>
  		</c:forEach>
  	</table>
  	</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	<script>
	$(function(){
		$('#bu1').click(function(){
			$.ajax({
				type:"get",
				url:"user.do",
				data:$("#userid").serialize(),
				success: function(data) {  
					  alert("success");  
					$('#div1').load("user.jsp");
	            },  
	            error: function(data) {  
	                alert("error");  
	            }  
			});
		});
	});
	</script>
  </head>
  
  <body>
  	<form id="userid" action="" method="get">
  		<input type="hidden" name="method" value="listUsers"><br>
  		<input type="text" name="name" value="">
  		<input id="bu1" type="button" value="查询" />
  	</form>
  
    <div id="div1">
    	
 </div>
  </body>
</html>


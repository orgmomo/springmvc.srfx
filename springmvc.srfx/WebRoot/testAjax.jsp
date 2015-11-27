<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
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
	<script>
		function createAjaxObj(){
			var xmlHttpRequest = null;
		     if ((typeof XMLHttpRequest) != 'undefined') 
		     {
		     	//非ie浏览器
		      xmlHttpRequest = new XMLHttpRequest();
		     }else {
		     //ie浏览器
		     xmlHttpRequest = 
					new ActiveXObject('Microsoft.XMLHttp');
		     }
		     return xmlHttpRequest;
		}
		
		
		
		function sendAjaxReq(){
			var req = createAjaxObj();
			req.open("get","myajax.do?method=test1&uname=张三&a="+Math.random());
			req.setRequestHeader("accept","application/json"); 
			req.onreadystatechange  = function(){
				alert(req.responseText);
				eval("var result="+req.responseText);
				
				document.getElementById("div1").innerHTML=result[0].username;
			};
			req.send(null);
		}
	</script>
  </head>
  
  <body>
    <a href="javascript:void(0);" onclick="sendAjaxReq();">测试</a>
    <div id="div1">
 </div>
  </body>
</html>


<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>货票信息查询</title>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">-->
<style type="text/css">
td {
	text-align: right;
}

.list {
	background-color: #EFFEEE;
}

#table2 td {
	border: 1px solid black;
}

#table2 {
	border-collapse: collapse;
	empty-cells: show;
}
</style>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	function check() {

		var xmlHttpRequest = null;
		if ((typeof XMLHttpRequest) != 'undefined') {
			//非ie浏览器
			xmlHttpRequest = new XMLHttpRequest();
		} else {
			//ie浏览器
			xmlHttpRequest = new ActiveXObject('Microsoft.XMLHttp');
		}
		xmlHttpRequest.open("get", $('#formid').submit(), false);
		xmlHttpRequest.send(null);
	}

</script>
</head>

<body>

		<form id="formid" action="hppj.do" method="get">
		<input type="hidden" name="method" value="listHppj"><br>
			<table>
				<tr>
					<td>日期:</td>
					<td>
						<input type="date" name="starttime" value="2015-09-20">
						<input type="date" name="endtime" value="2015-10-20">
					</td>
					<td>
						<input type="button" value="查询" onclick="check()">
					</td>
				</tr>
			</table>
		</form>
</html>

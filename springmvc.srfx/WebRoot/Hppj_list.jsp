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

</style>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery.base64.js"></script>
<script type="text/javascript" src="js/tableExport.js"></script>
<script type="text/javascript" src="js/sprintf.js"></script>
<script type="text/javascript" src="js/jspdf.js"></script>
<script type="text/javascript" src="js/base64.js"></script>
<script type="text/javascript">
	$(function(){
		$('#hppjlistbt').click(function(){
			 if($("#ckfz").is(":checked") || $("#ckdz").is(":checked") || $("#ckpl").is(":checked") 
						|| $("#ckpb").is(":checked") || $("#ckdjm").is(":checked") || $("#ckxmh").is(":checked")
						|| $("#ckyjh").is(":checked") || $("#ckywzl").is(":checked") || $("#ckfhrmc").is(":checked")){
				 var starttime = $("#starttime").attr("value");
				 var endtime = $("#endtime").attr("value");
				 if(starttime <= endtime){
					 $.ajax({
							type:"get",
							url:"hppj.do?method=listHppj",
							data:$('#formid').serialize(),
							success: function(data,textStatus) { 
								alert(textStatus);
								 document.getElementById("hppjlistdiv").innerHTML='';
								$('#hppjlistdiv').load("hppj.jsp");
				            },  
				            error: function() {  
				                alert("error");  
				            }  
						});
				 }else {
					 alert("请选择正确的时间！！！");
				}
			 }else{ 	 
		    	 alert("请选择一列为查询列！！！");
		     }
		});
		
			//var str = $('#hppjlistdiv').attr("value");
			//alert(str);
			//if(str == null){
			//	alert("ddd");
			//}
		$("#excelExport").click(function(){
			if($("#ckfz").is(":checked") || $("#ckdz").is(":checked") || $("#ckpl").is(":checked") 
					|| $("#ckpb").is(":checked") || $("#ckdjm").is(":checked") || $("#ckxmh").is(":checked")
					|| $("#ckyjh").is(":checked") || $("#ckywzl").is(":checked") || $("#ckfhrmc").is(":checked")){
				 var starttime = $("#starttime").attr("value");
				 var endtime = $("#endtime").attr("value");
				 if(starttime <= endtime){
					 $.ajax({
							type:"get",
							url:"hppj.do?method=exportListHppj",
							data:$('#formid').serialize(),
							success: function(data,textStatus) { 
								alert(textStatus);
								 document.getElementById("hppjlistdiv").innerHTML='';
								$('#hppjlistdiv').load("hppj.jsp");
				            },  
				            error: function() {  
				                alert("error");  
				            }  
						});
				 }else {
					 alert("请选择正确的时间！！！");
				}
			 }else{ 	 
		    	 alert("请选择一列为查询列！！！");
		     }
		});
	});
	
</script>
</head>

<body>
	<div style="background-color:#EEEEEE">

		<form id="formid" action="" method="get">
			<table id="table1">
				<tr>
					<td>日期:</td>
					<td>
						<input type="date" id="starttime" name="starttime" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime())%>">
						<input type="date" id="endtime" name="endtime" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()+86400000) %>">
					</td>
					<td>到局:</td>
					<td><select name="djmc" style="width:100%">
							<option value="0" selected="selected">全部</option>
							<option value="哈">哈尔滨局</option>
							<option value="沈">沈阳局</option>
							<option value="京">北京局</option>
							<option value="太">太原局</option>
							<option value="呼">呼和浩特局</option>
							<option value="郑">郑州局</option>
							<option value="武">武汉局</option>
							<option value="西">西安局</option>
							<option value="济">济南局</option>
							<option value="上">上海局</option>
							<option value="南">南宁局</option>
							<option value="广">广州集团</option>
							<option value="南">南宁局</option>
							<option value="成">成都局</option>
							<option value="昆">昆明局</option>
							<option value="兰">兰州局</option>
							<option value="乌">乌鲁木齐局</option>
							<option value="青">青藏铁路公司</option>
					</select></td>
					<td>票别:</td>
					<td><select name="pb" style="width:100%">
							<option value="0" selected="selected"></option>
							<option value="1">整车</option>
							<option value="2">零担</option>
							<option value="3">集装箱</option>
					</select></td>
					<td>类别:</td>
					<td><select name="lb">
							<option value="-1" selected="selected"></option>
							<option value="0">普通</option>
							<option value="1">零散快运</option>
							<option value="2">批量快运</option>
							<option value="3">新一口价</option>
							</select>
					</td>
					<td>项目:</td>
					<td>
						<input type="text" name="xmh" value="">
					</td>
				</tr>
				<tr>
					<td>发站:</td>
					<td>
						<input type="text" name="fz" style="width:100%"value=''> 
					</td>
					<td>到站:</td>
					<td colspan="5">
						<input type="text" name="dz" style="width:100%" value=''> 
					</td>
					<td>
						<input type="button" value="查询" id="hppjlistbt">
					</td>
					<td>
						<input type="button" value="Excel Export" id="excelExport">
					</td>
				</tr>
				<tr>
					<td>P2品类:</td>
					<td>
						<input type="text" name="P2" style="width:100%" value="">
					</td>
					<td>P4品类:</td>
					<td colspan="5">
						<input type="text" name="P4" style="width:100%">
					</td>
				</tr>
				<tr>
					<td>P7品类:</td>
					<td> 
						<input type="text" name="P7" style="width:100%">
					</td>
					<td colspan="10">
						<input id="ckfz" type="checkbox" name="ckfz" value="ckfz">发站 
						<input id="ckdz" type="checkbox" name="ckdz" value="ckdz">到站 
						<input id="ckpl" type="checkbox" name="ckpl" value="ckpl">品类 
						<input id="ckpb" type="checkbox" name="ckpb" value="ckpb">票别 
						<input id="ckdjm" type="checkbox" name="ckdjm" value="ckdjm">到局码
						<input id="ckxmh" type="checkbox" name="ckxmh" value="ckxmh">项目号
						<input id="ckyjh" type="checkbox" name="ckyjh" value="ckyjh">运价号
						<input id="ckywzl" type="checkbox" name="ckywzl" value="ckywzl">业务种类
						<input id="ckfhrmc" type="checkbox" name="ckfhrmc" value="ckfhrmc">发货人名称
					</td>
				</tr>
			</table>
		</form>
	</div>

	<div id="hppjlistdiv">
		
	</div>
</body>
</html>

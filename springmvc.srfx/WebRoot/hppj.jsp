<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		#table2 td{
				border: 1px solid black;
		}
		#table2{
			border-collapse: collapse;
			empty-cells: show;
		}
	</style>
  </head>
  	
  <body>
  	<div  style="width:100%;overflow-x:scroll;">
	  	<c:choose>
	  		<c:when test="${empty hppjs}">
	  			<span style="color: red;">没有相关信息</span>
	  		</c:when>
	  		<c:otherwise>
			  	<table id="table2"> 
			  		<tr>
			  			<td align="center">序号</td>
				  		<c:forEach items="${tbList}" var="tb" varStatus="vs">			  		
				  			<td align="center">${tb}</td>
				  		</c:forEach>
			  		</tr>
			  		<c:set var="count" scope="session" value="${count}"></c:set>
			  		<c:if test="${count == 8}">
				  		<c:forEach items="${hppjs}" var="hp" varStatus="vs">
				  			<tr>
				  				<td style="width:40px" align="center">${vs.index+1}</td>
				  				<td>${hp[0]}</td>
				  				<td style="width:80px;"  align="right">${hp[1]}</td>
				  				<td style="width:80px;"  align="right">${hp[2]}</td>
				  				<td style="width:80px;"  align="right">${hp[3]}</td>
				  				<td style="width:80px;"  align="right">${hp[4]}</td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[5]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[6]}"  type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[7]}"  type="number"/></td>
				  			</tr>
				  		</c:forEach>				  					
			  		</c:if>
			  		<c:if test="${count == 9}">
				  		<c:forEach items="${hppjs}" var="hp" varStatus="vs">
				  			<tr>
				  				<td  style="width:40px" align="center">${vs.index+1}</td>
				  				<td>${hp[0]}</td><td>${hp[1]}</td>
				  				<td style="width:80px;"  align="right">${hp[2]}</td>
				  				<td style="width:80px;"  align="right">${hp[3]}</td>
				  				<td style="width:80px;"  align="right">${hp[4]}</td>
				  				<td style="width:80px;"  align="right">${hp[5]}</td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[6]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[7]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[8]}" type="number"/></td>
				  			</tr>
				  		</c:forEach>				  					
			  		</c:if>
			  		<c:if test="${count == 10}">
				  		<c:forEach items="${hppjs}" var="hp" varStatus="vs">
				  			<tr>
				  				<td style="width:40px" align="center">${vs.index+1}</td>
				  				<td>${hp[0]}</td><td>${hp[1]}</td><td>${hp[2]}</td>
				  				<td style="width:80px;"  align="right">${hp[3]}</td>
				  				<td style="width:80px;"  align="right">${hp[4]}</td>
				  				<td style="width:80px;"  align="right">${hp[5]}</td>
				  				<td style="width:80px;"  align="right">${hp[6]}</td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[7]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[8]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[9]}" type="number"/></td>
				  			</tr>
				  		</c:forEach>				  					
			  		</c:if>
			  		<c:if test="${count == 11}">
				  		<c:forEach items="${hppjs}" var="hp" varStatus="vs">
				  			<tr>
				  				<td style="width:40px" align="center">${vs.index+1}</td>
				  				<td>${hp[0]}</td><td>${hp[1]}</td><td>${hp[2]}</td><td>${hp[3]}</td>
				  				<td style="width:80px;"  align="right">${hp[4]}</td>
				  				<td style="width:80px;"  align="right">${hp[5]}</td>
				  				<td style="width:80px;"  align="right">${hp[6]}</td>
				  				<td style="width:80px;"  align="right">${hp[7]}</td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[8]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[9]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[10]}" type="number"/></td>
				  			</tr>
				  		</c:forEach>				  					
			  		</c:if>
			  		<c:if test="${count == 12}">
				  		<c:forEach items="${hppjs}" var="hp" varStatus="vs">
				  			<tr>
				  				<td style="width:40px" align="center">${vs.index+1}</td>
				  				<td>${hp[0]}</td><td>${hp[1]}</td><td>${hp[2]}</td><td>${hp[3]}</td><td>${hp[4]}</td>
				  				<td style="width:80px;"  align="right">${hp[5]}</td>
				  				<td style="width:80px;"  align="right">${hp[6]}</td>
				  				<td style="width:80px;"  align="right">${hp[7]}</td>
				  				<td style="width:80px;"  align="right">${hp[8]}</td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[9]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[10]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[11]}" type="number"/></td>
				  			</tr>
				  		</c:forEach>				  					
			  		</c:if>
			  		<c:if test="${count == 13}">
				  		<c:forEach items="${hppjs}" var="hp" varStatus="vs">
				  			<tr>
				  				<td style="width:40px" align="center">${vs.index+1}</td>
				  				<td>${hp[0]}</td><td>${hp[1]}</td><td>${hp[2]}</td><td>${hp[3]}</td><td>${hp[4]}</td>
				  				<td>${hp[5]}</td>
				  				<td style="width:80px;"  align="right">${hp[6]}</td>
				  				<td style="width:80px;"  align="right">${hp[7]}</td>
				  				<td style="width:80px;"  align="right">${hp[8]}</td>
				  				<td style="width:80px;"  align="right">${hp[9]}</td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[10]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[11]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[12]}" type="number"/></td>
				  			</tr>
				  		</c:forEach>				  					
			  		</c:if>
			  		<c:if test="${count == 14}">
				  		<c:forEach items="${hppjs}" var="hp" varStatus="vs">
				  			<tr>
				  				<td style="width:40px" align="center">${vs.index+1}</td>
				  				<td>${hp[0]}</td><td>${hp[1]}</td><td>${hp[2]}</td><td>${hp[3]}</td><td>${hp[4]}</td>
				  				<td>${hp[5]}</td><td>${hp[6]}</td>
				  				<td style="width:80px;"  align="right">${hp[7]}</td>
				  				<td style="width:80px;"  align="right">${hp[8]}</td>
				  				<td style="width:80px;"  align="right">${hp[9]}</td>
				  				<td style="width:80px;"  align="right">${hp[10]}</td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[11]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[12]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[13]}" type="number"/></td>
				  			</tr>
				  		</c:forEach>				  					
			  		</c:if>
			  		<c:if test="${count == 15}">
				  		<c:forEach items="${hppjs}" var="hp" varStatus="vs">
				  			<tr>
				  				<td style="width:40px" align="center">${vs.index+1}</td>
				  				<td>${hp[0]}</td><td>${hp[1]}</td><td>${hp[2]}</td><td>${hp[3]}</td><td>${hp[4]}</td>
				  				<td>${hp[5]}</td><td>${hp[6]}</td><td>${hp[7]}</td>
				  				<td style="width:80px;"  align="right">${hp[8]}</td>
				  				<td style="width:80px;"  align="right">${hp[9]}</td>
				  				<td style="width:80px;"  align="right">${hp[10]}</td>
				  				<td style="width:80px;"  align="right">${hp[11]}</td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[12]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[13]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[14]}" type="number"/></td>
				  			</tr>
				  		</c:forEach>				  					
			  		</c:if>
			  		<c:if test="${count == 16}">
				  		<c:forEach items="${hppjs}" var="hp" varStatus="vs">
				  			<tr>
				  				<td style="width:40px" align="center">${vs.index+1}</td>
				  				<td>${hp[0]}</td><td>${hp[1]}</td><td>${hp[2]}</td><td>${hp[3]}</td><td>${hp[4]}</td>
				  				<td>${hp[5]}</td><td>${hp[6]}</td><td>${hp[7]}</td><td>${hp[8]}</td>
				  				<td style="width:80px;"  align="right">${hp[9]}</td>
				  				<td style="width:80px;"  align="right">${hp[10]}</td>
				  				<td style="width:80px;"  align="right">${hp[11]}</td>
				  				<td style="width:80px;"  align="right">${hp[12]}</td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[13]}" type="number"/></td>
				  				<td style="width:80px;"  align="right"><fmt:formatNumber value="${hp[14]}" type="number"/></td>
				  				<td style="width:80px;" align="right"><fmt:formatNumber value="${hp[15]}" type="number"/></td>
				  			</tr>
				  		</c:forEach>				  					
			  		</c:if>
			  	</table>
	  		</c:otherwise>
	  	</c:choose>
  	</div>
</body>
</html>

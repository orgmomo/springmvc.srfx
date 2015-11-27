<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>测试springmvc中上传的实现</title>
		<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
		
			<style type="text/css">
				body{ font-size:14px;}
				input{ vertical-align:middle; margin:0; padding:0}
				.file-box{ position:relative;width:340px}
				.txt{ height:22px; border:1px solid #cdcdcd; width:180px;}
				.btn{ background-color:#FFF; border:1px solid #CDCDCD;height:24px; width:70px;}
				.file{ position:absolute; top:0; right:80px; height:24px; filter:alpha(opacity:0);opacity: 0;width:70px}
			</style>
	</head>
	<body>
		<div class="file-box">
		  <form action="upload.do" method="post" enctype="multipart/form-data">
			 <input type='text' name='textfield' id='textfield' class='txt' />  
			 <input type="file" name="fileField" class="file" id="fileField" size="28" onchange="document.getElementById('textfield').value=this.value" />
			 <input type='button' class='btn' value='浏览...' />
			 <input type="submit" name="submit" class="btn" value="上传" />
		  </form>
		</div>
	</body>
</html>

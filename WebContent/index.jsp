<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Book Administration System</title>
<link rel="stylesheet" type="text/css" href="main.css" />
<link rel="stylesheet" href="css/bootstrap.min.css">  
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style type="text/css">



body
  { 
    background-image:url('images/t.png');
    
    background-position:center;
  }

.headfont {
	font-family: Arial, Helvetica, sans-serif;
	margin-left:auto;
margin-right:auto;
width:100%;
	position: absolute;
	left: 0px;
	top: 145px;
	color: #FFF;
	font-size: 36px;
	height :400px;
}
.headfont div a {
	color: #CCC;
	font-size: 28px;
}
</style>

</head>
<body>
<!-- <img src="images/t.png" class="img-responsive" alt="Cinque Terre">   -->
<div class = "headfont">
	<h2 align="center">Welcome to Book Administration System	</h2>
	<div align="center">
	  <p>&nbsp;</p>
	  <p><a href='<s:url action="display"></s:url>'>Enter the System </a></p>
	</div>
</div>

</body>
</html>
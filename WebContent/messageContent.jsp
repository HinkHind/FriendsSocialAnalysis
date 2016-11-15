<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>content1</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/zsq.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#">最新动态</a></li>
    <li role="presentation"><a href="displayAnalysis.action" style="color: #000">兴趣分析</a></li>
</ul>

<a href = '<s:url action="enterIndexWithSelectedPlatform"><s:param name="selectedPlatform" value="'zhihu'" /></s:url>'>
    	zhihu
    	</a>
	<a href = '<s:url action="enterIndexWithSelectedPlatform"><s:param name="selectedPlatform" value="'weibo'" /></s:url>'>
    	weibo
    	</a>
    	<a href = '<s:url action="enterIndexWithSelectedPlatform"><s:param name="selectedPlatform" value="'csdn'" /></s:url>'>
    	csdn
    	</a>
    	<br/>
    	<s:debug></s:debug>
	<s:iterator value="selectedEntries">
		
	    	<div class="panel-body" id="card1">
				<div style="margin-top: -15px"> <h3><img src="img/weibo.png" class="smallpic"><img src="img/original.png" class="smallpic">韩寒</h3></div>
				<div style="margin-left: 10px">
					<h6><s:property value = "publishedTime" /></h6>
					<h5>
						<s:if test = "#session.selectedPlatform == \"weibo\"">
							<s:property value="text" escape= "false"/>
						</s:if>
						<s:else>
						<s:property value="contentHolder" />
						</s:else>
					</h5>
				</div>
				<div class="col-sm-offset-8 row">
					<div class="col-md-3"><img src="img/share.png" class="smallpic1">32122</div>
					<div class="col-md-3"><img src="img/reply.png" class="smallpic1 col-sm-offset-1">622</div>
					<div class="col-md-3"><img src="img/like.png" class="smallpic1">1974</div>
					<div class="col-md-3"><a href="http://zhaoshiqi.top"  target="_blank" >阅读原文</a></div>
				</div>
	    	</div>
		
	</s:iterator>
	
	<h3>下面的表单是为了测试用来加条目的，只支持微博，zhihu,注意一定再Control页面加入了对应的微博url，zhihuurl之后再来这里加条目看显示效果。。不然会出错</h3>
    <form action = "addEntry">
		<input type = "text" name = "entryStr" >
		<input type="hidden" name="selectedPlat" value='<s:property value="#session.selectedPlatform" />'> 
		<input type = "submit">
	</form>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>

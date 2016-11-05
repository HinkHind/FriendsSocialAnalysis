<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>好友社交分析系统</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .embed-responsive{
            background-color: silver;
            float:right;
            width:80%;
            height:60%;
            margin:5px;
        }
        .list-group{
            background-color: silver;
            float:left;
            width:15%;
            height:60%;
            margin:10px;
        }
    </style>
    <script type="text/javascript">
        function fun1()
        {
            var mymessage=confirm("确定退出？");
            if(mymessage==true)
            {
                window.location.href='signin.html';
            }
        }
    </script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">社交好友分析</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">个人主页<span class="sr-only">(current)</span></a></li>
                <li><a href="control.html">控制面板</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其它功能 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="new.html">新增关注</a></li>
                        <li><a href="#">备用功能1</a></li>
                        <li><a href="#">备用功能2</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">网站介绍</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">这个按钮不能点</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <input type="button" class="btn btn-default navbar-btn" onclick="fun1()" value="退出"/>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!--左侧菜单-->
<div class="list-group">
    <a href="#" class="list-group-item disabled">
        全部动态
    </a>
    
    <s:iterator value="friends">
    <!--  <a href="control.html" class="list-group-item"><span class="badge">1</span>韩 寒</a>
    <a href="#" class="list-group-item"><span class="badge">5</span>关注用户1</a>
    <a href="#" class="list-group-item"><span class="badge">3</span>关注用户1</a>
    <a href="#" class="list-group-item"><span class="badge">0</span>关注用户1</a>
    <a href="#" class="list-group-item"><span class="badge">1</span>关注用户1</a>
    <a href="#" class="list-group-item"><span class="badge">5</span>关注用户1</a>
    <a href="#" class="list-group-item"><span class="badge">3</span>关注用户1</a>
    <a href="#" class="list-group-item"><span class="badge">0</span>关注用户1</a>
   <a href='<s:url action="QueryByTitle"><s:param name="title" value="title" /></s:url>'>
                   
                   		<s:property value="title" />
                   </a>
                   -->
    	<a href = '<s:url action="enterIndexWithSelectedFriend"><s:param name="friendId" value="friendId" /></s:url>'
    	class="list-group-item"><span class="badge">5</span>
    	<s:property value="friendName" />
    	</a>
    </s:iterator>
</div>

<!-- 4:3 aspect ratio 右侧动态 -->

<div class="embed-responsive embed-responsive-4by3">
    <!--<iframe class="embed-responsive-item" src="content.jsp"></iframe>  -->
    <h1>最新更新</h1>

	<s:iterator value="weiboEntrys">
		<div class="panel panel-default">
	    	<div class="panel-body">
				<s:property value="contentHolder" />
	    	</div>
		</div>
	</s:iterator>
</div>
<!--
<ul class="nav nav-tabs" role="tablist" id="main">
    <li role="presentation" class="active"><a href="#">Home</a></li>
    <li role="presentation"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
</ul>
-->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
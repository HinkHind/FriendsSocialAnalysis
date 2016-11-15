<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>控制面板</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/zsq.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/h.ico" type="image/x-icon" />
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        function fun1()
        {
            var mymessage=confirm("确定退出？");
            if(mymessage==true)
            {
                window.location.href='signin.html';
            }
        }
        function removeFriend()
        {
			alert("fff");
        	document.f.action='<s:url action="removeFriend"><s:param name="friendId" value="friend.friendId" /></s:url>';
        	document.f.submit();
        }
    </script>
</head>
<body>
<!--顶部边栏-->
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
            <a class="navbar-brand" style="color: #FFFFFF" href="welcome.html">社交好友分析</a>

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href='<s:url action="enterIndex"></s:url>'>个人主页</a></li>
                <li><a href='<s:url action="enterControl"></s:url>'>控制面板</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其它功能<span class="sr-only">(current)</span> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="new.html">新增关注</a></li>
                        <li><a href="control.html">备用控制面板</a></li>

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
<div class="list-group" >
            <a href="#" class="list-group-item disabled text-center" style="color: #FFFFFF; background-color: #3399ff">
                 控制面板
            </a>
            <li class="list-group-item"><h4 style="font-family: '宋体';font-weight: 900">当前用户：马一丰</h4></li>
            <a href="control2.html" class="list-group-item text-center" target="right">用户管理</a>
            <a href="new1.html" class="list-group-item text-center" target="right">新增关注</a>
            <a href="modify.html" class="list-group-item text-center" target="right">修改密码</a>
</div>

<div class="embed-responsive embed-responsive-4by3">
    <iframe class="embed-responsive-item" name="right" src="displayFriends.action"></iframe>
</div>

<div class="col-sm-12 text-center copy-right">
    <span>Copyright © 2016  <a href="zhaoshiqi.top">ShiQI </a> , All Rights Reserved&nbsp;</span>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
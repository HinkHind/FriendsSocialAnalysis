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
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        #form1{
            margin-top: 20px;
            margin-left: 0;
            margin-right: auto;
        }
        .embed-responsive{
            background-color: silver;
            float:right;
            width:80%;
            height:60%;
            margin:5px;
        }
        .panel-default{
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
                window.location.href='logOut.action';
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
                <li><a href='<s:url action="enterIndex"></s:url>'>个人主页</a></li>
                <li class="active"><a href="#">控制面板<span class="sr-only">(current)</span></a></li>
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
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title"><span class="glyphicon glyphicon-user">当前关注</span></h3>
    </div>
    <div class="panel-body">
        韩寒：CSDN Weibo

        <form class="form-horizontal" id="form1" role="form">
            <div class="form-group">
                <label for="inputText2" class="col-sm-3  control-label">Weibo</label>
                <div class="col-sm-10 col-lg-12">
                    <input type="text" class="form-control" id="inputText2" placeholder="Text">
                </div>
            </div>
            <div class="form-group">
                <label for="inputText3" class="col-sm-3 control-label">CSDN</label>
                <div class="col-sm-10 col-lg-12">
                    <input type="password" class="form-control" id="inputText3" placeholder="Text">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-10" id="button1">
                    <button type="submit" class="btn btn-default">保存</button>
                    <button type="submit" class="btn btn-default col-sm-offset-2">删除</button>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- 4:3 aspect ratio 右侧动态 -->

<form action = "addFriend">
		<input type = "text" name = "friendName" placeholder = "friendName">
		<input type = "submit">
</form>
	
	
	


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
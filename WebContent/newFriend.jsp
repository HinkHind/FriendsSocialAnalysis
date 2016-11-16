<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新增关注</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .box{
            margin: 100px 20% 20%;
            padding: 80px;
            float: none;
            width: 60%;
            box-shadow: 0 0 6px 2px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            background: rgba(255, 255, 255, 0.65);
        }
        .inline-input input[type="text"],
        .inline-input input[type="password"],
        input[type="text"].inline-input,
        input[type="password"].inline-input {
            background: #fff;
            border-top: 0 none;
            border-left: 0 none;
            border-right: 0 none;
            border-bottom: 1px solid #d0dde9;
            border-radius: 0;
            box-shadow: none;
            border-color: #dee3ea;
        }
        .inline-input input[type="text"]:focus,
        .inline-input input[type="password"]:focus,
        input[type="text"].inline-input:focus,
        input[type="password"].inline-input:focus {
            box-shadow: none;
            border-color: #5d6a80;
        }
        .inline-input input[type="text"]:hover,
        .inline-input input[type="password"]:hover,
        input[type="text"].inline-input:hover,
        input[type="password"].inline-input:hover {
            border-color: #959fb0;
        }
    </style>
    <script type="text/javascript">
        function fun1() {
            var mymessage=confirm("确定退出？");
            if(mymessage==true)
            {
                window.location.href='logOut.action';
            }
        }
        <!--判断空提交-->
        function fun2(){
            var d1 = document.getElementById("inputText1").value;
            var d2 = document.getElementById("inputText2").value;
            var d3 = document.getElementById("inputText3").value;

            if(d1 == "") {
                alert("姓名不能为空");
                return;
                }
                if(d2=="" && d3==""){
                    alert("至少填写一个网址");
                    return;
                }

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
            <a class="navbar-brand" href="#">社交好友分析</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <!--<li class="active"><a href="index.html">个人主页<span class="sr-only">(current)</span></a></li>-->
                <li><a href="index.html">个人主页</a></li>
                <li><a href="control.html">控制面板</a></li>
                <li class="dropdown active">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其它功能<span class="sr-only">(current)</span> <span class="caret"></span></a>
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
<!--新增-->
<div class="panel panel-default box">
    <div class="panel-heading">
        <h1 class="panel-title text-center"><span class="glyphicon glyphicon-heart"></span>偷偷的关注TA！</h1>
    </div>
    <div class="panel-body">

        <form class="form-horizontal inline-input" id="form1" role="form" action = "addFriend">

            <div class="form-group field-box">
                <label for="inputText1" class="col-sm-2  control-label">Name</label>
                <div class="col-sm-8 col-lg-8">
                    <input type="text" class="form-control" name = "friendName" id="inputText1" placeholder="关注的用户名称">
                </div>
            </div>

            <div class="form-group">
                <label for="inputText2" class="col-sm-2 control-label">Weibo</label>
                <div class="col-sm-8 col-lg-8">
                    <input type="text" class="form-control" name = "weiboUrl" id="inputText2" placeholder="请输入微博主页地址">
                </div>
            </div>

            <div class="form-group">
                <label for="inputText3" class="col-sm-2 control-label">CSDN</label>
                <div class="col-sm-8 col-lg-8">
                    <input type="text" class="form-control" name = "csdnUrl" id="inputText3" placeholder="请输入CSDN主页地址">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9" id="button1">
                    <button type="submit"  class="btn btn-default" onclick="fun2()">保存</button>
                    <input type="button" class="btn btn-default col-sm-offset-5" onclick="history.go(-1)" value ="返回"/>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
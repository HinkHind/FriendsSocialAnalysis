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
    <link href="css/zsq.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/h.ico" type="image/x-icon" />
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
            border-color: #6699ff;
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
                window.location.href='signin.html';
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

<div class="panel panel-default box">
    <div class="panel-heading" style="color: #FFFFFF; background-color: #3399ff">
        <h1 class="panel-title text-center" >偷偷的关注TA！</h1>
    </div>
    <div class="panel-body" >

        <form class="form-horizontal inline-input" id="form1" role="form" action = "addFriend">

            <div class="form-group field-box">
                <label for="inputText1" class="col-sm-2  control-label">Name</label>
                <div class="col-sm-8 col-lg-8">
                    <input type="text" name = "friendName" class="form-control" id="inputText1" placeholder="关注的用户名称">
                </div>
            </div>

            <div class="form-group">
                <label for="inputText2" class="col-sm-2 control-label">Weibo</label>
                <div class="col-sm-8 col-lg-8">
                    <input type="text" class="form-control" id="inputText2" placeholder="请输入微博主页地址">
                </div>
            </div>

            <div class="form-group">
                <label for="inputText3" class="col-sm-2 control-label">CSDN</label>
                <div class="col-sm-8 col-lg-8">
                    <input type="text" class="form-control" id="inputText3" placeholder="请输入CSDN主页地址">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9" id="button1">
                    <button type="submit"  class="btn btn-default" >保存</button><!-- onclick="fun2()" -->
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
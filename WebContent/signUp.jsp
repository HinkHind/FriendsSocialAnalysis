<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #FFFFFF;
        }
        .box{
            margin: 0 auto;
            padding: 35px 0 30px;
            float: none;
            width: 400px;
            box-shadow: 0 0 6px 2px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            background: rgba(255, 255, 255, 0.65);
        }
        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin .checkbox {
            font-weight: normal;
        }
        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
    <script type="text/javascript">

        function validate(){
            var d1 = document.getElementById("zh").value;
            var d2 = document.getElementById("p1").value;
            var d3 = document.getElementById("p2").value;
            if(d1 == "") {
                alert("账号不能为空");
                return false;
            }

			if()
			
            
            if(d2=="" && d3==""){
                alert("密码不能为空");
                return false;
            }
            
            if(d2!= d3){
                alert("两次密码不一样");
                return false;
            }

			if(d2.length < 10 || d2.length > 24){
				alert("密码过长或过短,密码大于等于10位，小于等于24位");
				return false;
			}
			return true;
            
        }

		

        
    </script>
</head>
<body>

<div class="container box">
    <s:debug></s:debug>
    <form class="form-signin" role="form" id = "signUpForm" onsubmit = "return validate();" action = "signUp" method = "POST">
        <h2 class="form-signin-heading text-center">欢迎注册</h2>
        <div class="form-group"><input class="form-control" name = "userName" id="zh" type="text" placeholder="请输入账号" /></div>
        <div class="form-group"><input class="form-control" name = "password" id="p1" type="password" placeholder="请输入密码" /></div>
        <div class="form-group"><input class="form-control" id="p2" type="password" placeholder="重复上一密码" /></div>
        <div class="action">
            <button class="btn btn-lg btn-default btn-block">注册</button>
        </div>
    </form>


    <div class="container-fluid">
        <div class="row footerbox">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <footer class="text-center">
                    <a href="signIn.action"><i class="fa fa-external-link"></i> 已经有账号了，立即登录！</a>
                </footer>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
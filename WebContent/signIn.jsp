<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
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
        function fun1(){
            var d1 = document.getElementById("exampleInputEmail1").value;
            var d2 = document.getElementById("exampleInputPassword1").value;

            if(d1 == "") {
                alert("账号不能为空");
                return;
            }
            if(d2==""){
                alert("密码不能为空");
                return;
            }

        }
    </script>
</head>


<div class="container box">

    <form class="form-signin" role="form" action = "signIn" method = "POST">
        <h2 class="form-signin-heading text-center">登录界面</h2>
        </br>
        <div class="form-group">
            <input type="text" class="form-control" name = "userName" id="exampleInputEmail1" placeholder="请输入账号：">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name = "password" id="exampleInputPassword1" placeholder="请输入密码：">
        </div>
        <div class="checkbox">
            <label>
                <input value="remember-me" type="checkbox">记住密码
            </label>
        </div>
        <button class="btn btn-lg btn-default btn-block" type="submit" onclick="fun1()">登 录</button>
    </form>

    <div class="container-fluid">
        <div class="row footerbox">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <footer class="text-center">
                    <a href="signup.html"><i class="fa fa-external-link"></i> 没有账号？立即注册一个！</a>
                </footer>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div> <!-- /container -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body></html>
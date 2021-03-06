<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>欢迎</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/zsq.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/h.ico" type="image/x-icon" />
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
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
    <![endif]-->
</head>
<body>
<!--顶部-->
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
            <a class="navbar-brand" style="color: #FFFFFF" href="welcome.jsp">社交好友分析</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href='<s:url action="enterIndex"></s:url>'>个人主页<span class="sr-only">(current)</span></a></li>
                <li><a href='<s:url action="enterControl"></s:url>'>控制面板</a></li>
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
                <input type="button" class="btn btn-default navbar-btn"  onclick="fun1()" value="退出"/>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!--滚动广告-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="margin-top: -21px;margin-left: 1px;margin-right: 1px;">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <!--<li data-target="#carousel-example-generic" data-slide-to="2"></li>-->
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="img/2.png" alt="欢迎">
        </div>
        <div class="item">
            <img src="img/1.png" alt="快去体验下吧">
       </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<div class="container" style="margin-left: 12%;margin-top: 5%;">
    <div class="row">
        <div class="col-md-3 text-center" >
            <img src="img/f1.svg" height="200" width="200">

            <p style="margin: 10px">互联网关注</p>
            <h6>我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明</h6>
        </div>
        <div class="col-md-3 text-center" >
            <img src="img/f2.svg"height="200" width="200">
            <p style="margin: 10px">图形化显示</p>
            <h6>我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明</h6>
        </div>
        <div class="col-md-3 text-center" >
            <img src="img/f3.svg"height="200" width="200">
            <p style="margin: 10px">精确地算法</p>
            <h6>我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，但是没写说明</h6>
        </div>
        <div class="col-md-3 text-center" >
            <img src="img/f4.svg"height="200" width="200">
            <p style="margin: 10px">提升友谊</p>
            <h6>我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，我就假装这里有很多说明，但是没写说明，总感觉第一轮迭代要炸</h6>
        </div>
    </div>
</div>
<div class="col-sm-12 text-center copy-right">
    <span>Copyright © 2016  <a href="zhaoshiqi.top">ShiQI </a> , All Rights Reserved&nbsp;</span>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
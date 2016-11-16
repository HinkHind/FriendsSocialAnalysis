<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/zsq.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/h.ico" type="image/x-icon" />
  <style type="text/css">
      .form-horizontal{
          margin: 20%;
          margin-top: 5%;
      }
  </style>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<s:debug></s:debug>
<form class="form-horizontal" role="form" action = "updateZhihuUrl">
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="formGroupInputLarge">知乎</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name = "zhihuUrlStr" id="formGroupInputLarge" value ='<s:property value = "selectedUrl"/>'>
            <input type="hidden" name="friendId" value='<s:property value = "friendId"/>'> 
        </div>
        <div class="col-sm-offset-4 col-sm-9" id="button1" style="margin-top: 20px">
            <button type="submit"  class="btn btn-default" onclick="fun2()">保存</button>
            <!--<button   class="btn btn-default" onclick="location='<s:url action="removeWeiboUrl"> <s:param name="friendId" value="friendId" /></s:url>'">保存</button>  -->
            <input type="button" class="btn btn-default col-sm-offset-5" onclick="location='<s:url action="removeZhihuUrl"> <s:param name="friendId" value="friendId" /></s:url>'" value ="删除"/>
            <input type="button" class="btn btn-default col-sm-offset-5" onclick="history.go(-1)" value ="返回"/>
        </div>
        
    </div>
</form>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
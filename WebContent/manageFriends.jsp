<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>控制面板</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/zsq.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/h.ico" type="image/x-icon" />
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        #addicon{
            margin: 20px;
            width:  70px;
            height: 70px;
        }
        .panel-default{

            width:20%;
            height:60%;
            margin:5px;
        }
        .suojin{
            text-indent: 1em;
        }
        .card {
            float: right;
            width: 70%;
            margin: 10px;
            border: 2px;
            border-color: silver;
            margin-right: 15%;
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
        .panel-body{padding:15px;
            border-top:1px solid #ddd;
            border-bottom:1px solid #ddd;
            border-left:1px solid #ddd;
            border-right:1px solid #ddd;
        }
    </style>
</head>
<body>

<s:iterator value = "friendsWithData">
<div class="panel panel-default card">
    <div class="panel-body">
         <button type="button" class="close" onclick ="location='<s:url action="removeFriend"><s:param name="friendId" value="friend.friendId" /></s:url>'"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h3 class="suojin"><s:property value="friend.friendName" /></h3>
        <p class="col-sm-offset-1">
        	<s:if test="friend.hasWeibo == true">
				假装这里有被关注对象的微博签名或者验证信息~ has weiboUrl
				<s:property value = "weiboUrl"/>
			</s:if>
			<s:else>
				点击右侧按钮更改网址,点击右上角删除该关注！ not have weiboUrl
			</s:else> 
		</p>
        <div class="col-sm-offset-9">
            <!-- Button trigger modal -->
            
            <s:if test="friend.hasWeibo == true">
				<img src="img\weiboColor.svg"  class="img-circle btn-default"  onclick="location='<s:url action="editWeiboUrl"><s:param name="friendId" value="friend.friendId" /><s:param name="selectedUrl" value="weiboUrl" /></s:url>'">
				
			</s:if>
			<s:else>
				<img src="img\weiboGrey.svg"  class="img-circle btn-default"  onclick="location='<s:url action="editWeiboUrl"><s:param name="friendId" value="friend.friendId" /><s:param name="selectedUrl" value="weiboUrl" /></s:url>'">

			</s:else> 
            
            <img src="img\csdnGrey.svg"  class="img-circle btn-default"  onclick="location='csdn.html'">
			
			<s:if test="friend.hasZhihu == true">
				<img src="img\zhihuColor.svg"  class="img-circle btn-default"  
				onclick="location='<s:url action="editZhihuUrl"><s:param name="friendId" value="friend.friendId" /><s:param name="selectedUrl" value="zhihuUrl" /></s:url>'">

			</s:if>
			<s:else>
				<img src="img\zhihuGrey.svg"  class="img-circle btn-default"  
				onclick="location='<s:url action="editZhihuUrl"><s:param name="friendId" value="friend.friendId" /><s:param name="selectedUrl" value="zhihuUrl" /></s:url>'">
			</s:else>
            
        </div>
    </div>
</div>
</s:iterator>

<div  class="col-sm-offset-2">

    <img src="img\add.svg"  id="addicon" class="img-circle btn-default"  onclick="location='addNewFriend.jsp'">
	<s:if test="friends.isEmpty()">
				点击+按钮添加新朋友~
	</s:if>
</div>

<!--
☆如果是本页显示可以直接用location,方法如下：
①onclick="javascript:window.location.href='URL'"
②onclick="location='URL'"
③onclick="window.location.href='URL?id=11'"
☆如果页面中有frame可以将在location前面添加top.mainframe.frames['right_frame'].location
-->


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:property value = "selectedUrl"/>
	tttt
	<form action = "updateWeiboUrl">
					<input type = "text" name = "weiboUrlStr" placeholder = "tt">
					<input type="hidden" name="friendId" value='<s:property value = "friendId"/>'> 
					<input type = "submit">
				</form>
	<a href='<s:url action="removeWeiboUrl"><s:param name="friendId" value="friendId" /></s:url>'>
                                remove Weibo Url
                            </a>
</body>
</html>
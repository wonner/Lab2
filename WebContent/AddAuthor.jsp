<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加作者</title>
</head>
<body>

	
	<s:form action="AddAuthorAction">
		<h>无该作者，请添加作者信息</h><br>
		<s:textfield name="authorid" label="AuthorID" readonly="true"></s:textfield>
		<s:textfield name="name" label="Name"></s:textfield>
		<s:textfield name="age" label="Age"></s:textfield>
		<s:textfield name="country" label="Country"></s:textfield>
		<s:submit value="添加"></s:submit>
	</s:form>

</body>
</html>
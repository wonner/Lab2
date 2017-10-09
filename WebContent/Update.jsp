<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%   
String name = request.getParameter("upisbn");  
%> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>更新图书信息</title>
</head>
<body>
	
	
	<s:form action="UpdateBookAction">
		
		ISBN:<input type="text" name="upisbn" value="<%=name%>" readonly="readonly">
		<s:textfield name="uppublisher" label="Publisher"></s:textfield>
		<s:textfield name="uppublishdate" label="PublishDate(例：1998-01-16)"></s:textfield>
		<s:textfield name="upprice" label="Price"></s:textfield>
		<s:textfield name="upname" label="Name"></s:textfield>
		<s:textfield name="upage" label="Age"></s:textfield>
		<s:textfield name="upcountry" label="Country"></s:textfield>
		<s:submit value="更新"></s:submit>
	</s:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>搜索结果</title>
</head>
<body>
	<a href="Index.jsp">返回</a>
	
	<table border="1">
		<tr>
			<th width="100">序号 </th>
			<th width="500">书名</th>
			<th width="100">删除选项</th>
			<th width="100">更新选项</th>
		</tr>
		<s:iterator value="titleList" id="b" status="st">
		
		<tr>
			<td align="center">${st.index+1}</td>
			<td><a href="DetailAction.action?bookISBN=${b.ISBN }">${b.title}</a> </td>
			<td align="center"><a href="DeleteAction.action?bookISBN=${b.ISBN }">删除</a></td>
			<td align="center"><a href="Update.jsp?upisbn=${b.ISBN }">更新</a></td>
		</tr>	

		</s:iterator>	
	</table>

</body>
</html>
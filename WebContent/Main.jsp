<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	
	<s:form action="SearchAction">
	<s:textfield name="authorname" label="作者姓名"></s:textfield><s:submit value="搜索"></s:submit>
	</s:form>
	
	<s:form action="AddBookAction">
		<s:textfield name="isbn" label="ISBN"></s:textfield>
		<s:textfield name="title" label="Title"></s:textfield>
		<s:textfield name="authorid" label="AuthorID"></s:textfield>
		<s:textfield name="publisher" label="Publisher"></s:textfield>
		<s:textfield name="publishdate" label="PublishDate(例：1998-01-16)"></s:textfield>
		<s:textfield name="price" label="Price"></s:textfield>
		<s:submit value="添加"></s:submit>
	</s:form>
	
	<s:form action="UpdateBookAction">
		<s:textfield name="upisbn" label="所要修改图书的ISBN"></s:textfield>
		<s:textfield name="uppublisher" label="Publisher"></s:textfield>
		<s:textfield name="uppublishdate" label="PublishDate(例：1998-01-16)"></s:textfield>
		<s:textfield name="upprice" label="Price"></s:textfield>
		<s:textfield name="upname" label="Name"></s:textfield>
		<s:textfield name="upage" label="Age"></s:textfield>
		<s:textfield name="upcountry" label="Country"></s:textfield>
		<s:submit value="更新"></s:submit>
	</s:form>

	<table border="1">
		<tr>
			<th width="100">序号 </th>
			<th width="500">书名</th>
			<th width="100">选项</th>
		</tr>
		<s:iterator value="totalList" id="b" status="st">
		
		<tr>
			<td align="center">${st.index+1}</td>
			<td><a href="DetailAction.action?bookISBN=${b.ISBN }">${b.title}</a> </td>
			<td align="center"><a href="DeleteAction.action?bookISBN=${b.ISBN }">删除</a></td>
		</tr>	

		</s:iterator>	
	</table>

</body>
</html>
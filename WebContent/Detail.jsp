<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细</title>
</head>
<body>

		<li>ISBN: ${bookdetail.ISBN } </li>
		<li>Title: ${bookdetail.title } </li>
		<li>Publisher: ${bookdetail.publisher } </li>
		<li>PublishDate: ${bookdetail.publishDate } </li>
		<li>AuthorName: ${bookdetail.name }</li>
		<li>AuthorAge: ${bookdetail.age } </li>
		<li>AuthorCountry: ${bookdetail.country } </li>
		<li>Price: ${bookdetail.price } </li>

</body>
</html>
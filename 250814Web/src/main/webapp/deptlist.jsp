<%@page import="dto.deptDTO"%>
<%@page import="dao.deptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "navbar.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
border: 1px solid #ccc;
border-collapse: collapse;
}
th, td {padding: 10px 20px;}
</style>
</head>
<body>
<table>
<tr>
	<th>Deptno</th>
	<th>Dname</th>
	<th>Loc</th>
	<th>Delete</th>
</tr>
<c:forEach var="dto" items="${deptlist}">
	<tr>
	<td><a href="deptupdateForm?deptno=${dto.deptno}">${dto.deptno}</a></td>
	<td>${dto.dname}</td>
	<td>${dto.loc}</td><td>
	<button type="button" onclick="location.href='deptdelete?deptno=${dto.deptno}' ">삭제</button></td>
	</tr>
</c:forEach>
</table>
<button type="button" onclick="location.href='deptinsertForm' ">추가</button>
</body>
</html>



<%@page import="dto.empDTO"%>
<%@page import="dao.empDAO"%>
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
	<th>Empno</th>
	<th>Ename</th>
	<th>Job</th>
	<th>Mgr</th>
	<th>Hiredate</th>
	<th>Sal</th>
	<th>Comm</th>
	<th>Deptno</th>
	<th>Dname</th>
	<th>Loc</th>
</tr>
<c:forEach var="dto" items="${joinlist}">
	<tr>
	<td>${dto.empno}</td>
	<td>${dto.ename}</td>
	<td>${dto.job}</td>
	<td>${dto.mgr}</td>
	<td>${dto.hiredate}</td>
	<td>${dto.sal}</td>
	<td>${dto.comm}</td>
	<td>${dto.deptno}</td>
	<td>${dto.dname}</td>
	<td>${dto.loc}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>



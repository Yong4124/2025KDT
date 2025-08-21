<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<c:forEach var="dto" items="${list}">
	<tr>
	<td>${dto.empno}</td>
	<td>${dto.ename}</td>
	<td>${dto.sal}</td>
	<td>${dto.deptno}</td>
	<td>${dto.dname}</td>
	<td>${dto.loc}</td>
	</tr>
</c:forEach>
</table>
<button type="button" onclick="location.href='insertForm' ">글쓰기</button>
</body>
</html>
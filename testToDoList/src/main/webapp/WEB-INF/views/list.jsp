<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDo List</title>
<style>
	.completed {
		text-decoration: line-through;
		color: gray;
	}
</style>
</head>
<body>

<c:choose>
    <c:when test="${not empty username}">
        <p>안녕하세요, ${username}님! <a href="<c:url value='/logout' />">로그아웃</a></p>
    </c:when>
    <c:otherwise>
        <p><a href="<c:url value='/login' />">로그인</a></p>
    </c:otherwise>
</c:choose>

<h2>할 일 목록</h2>

<c:if test="${not empty username}">
    <a href="<c:url value='/add' />">할 일 추가</a>
</c:if>

<ul>
	<c:forEach var="todo" items="${todos}">
		<li>
			<a href="<c:url value='/toggle/${todo.id}' />">
				<span class="${todo.completed ? 'completed' : ''}">
					${todo.title}
				</span>
				[${todo.completed ? '완료됨' : '미완료'}]
			</a>
			<a href="<c:url value='/delete/${todo.id}' />">[삭제]</a>
		</li>
	</c:forEach>	
</ul>

</body>
</html>

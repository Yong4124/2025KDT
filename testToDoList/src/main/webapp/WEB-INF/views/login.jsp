<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head><meta charset="UTF-8" /><title>로그인</title></head>
<body>
<h2>로그인</h2>

<c:if test="${not empty param.error}">
    <p style="color:red;">로그인 실패: 아이디 혹은 비밀번호를 확인하세요.</p>
</c:if>

<form action="<c:url value='/login' />" method="post">
    <label>아이디: <input type="text" name="username" required></label><br>
    <label>비밀번호: <input type="password" name="password" required></label><br>
    <input type="submit" value="로그인">
</form>
<a href="<c:url value='/register' />">회원가입</a>
<a href="<c:url value='/' />">뒤로가기</a>
</body>
</html>

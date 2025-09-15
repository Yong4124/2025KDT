<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>회원가입</title></head>
<body>
<h2>회원가입</h2>

<form action="<c:url value='/register' />" method="post">
    사용자 이름: <input type="text" name="username" required /><br/>
    비밀번호: <input type="password" name="password" required /><br/>
    <button type="submit">가입하기</button>
</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<a href="<c:url value='/login' />">로그인 페이지로</a>
</body>
</html>

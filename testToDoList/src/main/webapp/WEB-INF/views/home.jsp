<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>홈</title>
</head>
<body>
    <h1>환영합니다, ${username}님!</h1>

    <ul>
        <li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
        <li><a href="${pageContext.request.contextPath}/list">할 일 목록 보기</a></li>
    </ul>
</body>
</html>

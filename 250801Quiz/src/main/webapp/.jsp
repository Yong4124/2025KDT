<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
</head>
<body>
    <h2>회원 가입</h2>
    <form action="signUp.jsp" method="post">
        <label for="username">아이디:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="email">이메일:</label>
        <input type="email" id="email" name="email" required><br><br>

        <input type="submit" value="회원 가입">
    </form>
</body>
</html>

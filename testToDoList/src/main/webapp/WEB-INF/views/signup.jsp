<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>
<form action="signup" method="post">
    <label>아이디: <input type="text" name="username" required></label><br>
    <label>비밀번호: <input type="password" name="password" required></label><br>
    <input type="submit" value="가입하기">
</form>
<a href="/">뒤로가기</a>
</body>
</html>

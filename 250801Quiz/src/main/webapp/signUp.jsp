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
    <form action="registerUser.jsp" method="post" accept-charset="UTF-8">

        <label for="username">이름:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="address">주소:</label>
        <input type="text" id="address" name="address" required><br><br>

        <label for="email">email:</label>
        <input type="text" id="email" name="email" required><br><br>
        
        <label for="cel">전화번호:</label>
        <input type="tel" id="cel" name="cel" required><br><br>

        <input type="submit" value="회원 가입">
    </form>
</body>
</html>

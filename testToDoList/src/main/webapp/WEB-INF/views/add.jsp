<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>할 일 추가</title></head>
<body>
<h2>할 일 추가</h2>

<form action="<c:url value='/add' />" method="post">
    <label for="title">할 일 제목:</label>
    <input type="text" id="title" name="title" required />
    <button type="submit">추가</button>
</form>

<a href="<c:url value='/list' />">목록으로 돌아가기</a>
</body>
</html>

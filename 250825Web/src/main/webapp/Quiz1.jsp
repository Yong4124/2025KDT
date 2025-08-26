<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p id="demo">원래 텍스트입니다.</p>
	<button onclick="changeText()">텍스트 변경</button>
	
	<script>
	 function changeText(){
		 document.getElementById("demo").innerHTML = "<h1>변경된 텍스트입니다!</h1>";
	 }
	</script>

</body>
</html>
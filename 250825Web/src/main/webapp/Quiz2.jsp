<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="nameInput" placeholder="이름을 입력하세요">
	<button onclick="printName()">출력</button>
	<p id="output"></p>
	
	<script>
	 function printName(){
		 const name = document.getElementById("nameInput").value;
		 document.getElementById("output").innerText = "안녕하세요, " + name + "님!";
	 }
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

	<p id="demo">원래 텍스트입니다.</p>
	<button id="changeBtn">텍스트 변경</button>
	
	<script>
	$(document).ready(function(){
		$('#changeBtn').click(function(){
			const demo = document.getElementById('#demo');
			demo.innerText = '가나다';
			$('#demo').text('변경된 텍스트입니다!');
		});
	
	});
	</script>
</body>
</html>
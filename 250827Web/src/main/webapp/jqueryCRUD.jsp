<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Json-server 연동</title>
</head>
<body>
<h2>아이템 입력</h2>
<input type="text" id="itemName" />
<button id="createItem">Add</button>

<h2>아이템 목록</h2>
<ul id="itemList"></ul>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	loadItems2();	
});

$('#createItem').on('click', function() {
	let item = $('#itemName').val();
	$.ajax({url:'http://localhost:3000/todos', 
		type:'post',
		data:JSON.stringify({title : item}),
		contentType:'application/json',
		success:function(){
			alert('데이터 입력!');
			loadItems2();
		}
	});
});


function loadItems2() { 	// 함수 선언
	$.ajax({url:'http://localhost:3000/todos', 
		type:'GET',
		success: function (data) {	// data는 정해진 변수 이름이 아니다
			$('#itemList').empty(); // 목록을 한번 지운다
			for (let i = 0; i < data.length; i++) {  // data에서 반복해서 자료를 꺼내온다
				let item = data[i];
				
				let listItem = '<li data-id="'+ item.id +  '">' +
							   item.title +
							   ' <button class="editBtn">Edit</button>' +
							   ' <button class="deleteBtn">delete</button>' +
							   '</li>';
							   
				$('#itemList').append(listItem); // 리스트에 붙인다
			}
		}
	})
}


</script>
</body>
</html>
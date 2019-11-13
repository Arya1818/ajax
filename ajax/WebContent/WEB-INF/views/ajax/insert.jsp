<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<div class="container">
<h3>게시물작성</h3>
	<table class="table table-bordered">
		<tr>
			<th>제목</th>
			<td><input type="text" id="biTitle" placeholder="제목을 작성해 주세요"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea id="biContent" rows="10" cols="50"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="number" id="uiNum"></td>
		</tr>
		<tr>
			<th colspan="2"><button onclick="save()">저장</button></th>
		</tr>
	</table>
</div>

<script>
	function save(){
		var xhr = new XMLHttpRequest();
		xhr.open('POST','/ajax/board/insert');
		xhr.setRequestHeader('Content-Type','application/json'); //해주기
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					var res = JSON.parse(xhr.responseText);
					alert(res.msg)
					console.log(xhr.responseText);
				}
			}
		}
		var param = {
				biTitle : document.getElementById('biTitle').value,
				biContent : document.getElementById('biContent').value,
				uiNum : document.getElementById('uiNum').value
		}
		console.log(param);
//		alert(JSON.stringify(param));
		param = JSON.stringify(param) //스트링이 됨!! (보낼준비다됨)
//		return;
		xhr.send(param);
	}
</script>
</body>
</html>
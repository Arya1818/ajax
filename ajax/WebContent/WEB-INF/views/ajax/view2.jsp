<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<table class="table" id="table">

		<tr>
			<th>번호</th>
			<td></td>
		</tr>
		<tr>
			<th>제목</th>
			<td></td>
		</tr>
		<tr>
			<th>내용</th>
			<td></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td></td>
		</tr>
		<tr>
			<th>작성시간</th>
			<td></td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="goPage('/ajax/update?biNum=${param.biNum}')">수정</button>
				<button onclick="goPage('/ajax/list')">리스트가기</button>
			</th>	
		</tr>
	</table>


	<script>
		window.onload = function() {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/ajax/board/view?cmd=view&biNum=${param.biNum}');
			xhr.onreadystatechange = function(e) {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						
						var board = JSON.parse(xhr.responseText);//parse:분석<--json형태의 스트링을 분석해서 넘겨준다. -->자바스크립트에서 쓸수있다. 
						console.log(board); 
						
						var table = document.getElementById('table');
						var html = '';
						
						for (var i = 0; i < board.length; i++) {
							html += '<tr>';
							html += '<td>' + board.biNum + '</td>';
							html += '</tr>';
							html += '<tr>';
							html += '<td>' + board.biTitle + '</td>';
							html += '</tr>';
							html += '<tr>';
							html += '<td>' + board.biContent + '</td>';
							html += '</tr>';
							html += '<tr>';
							html += '<td>' + board.uiNum + '</td>';
							html += '</tr>';
							html += '<tr>';
							html += '<td>' + board.credat + '</td>';
							html += '</tr>';
							html += '<tr>';
							html += '<td>' + board.cretim + '</td>';
							
							html += '</tr>'; 
						}
						td.innerHTML = html;
						document.write(xhr.responseText);
					}
				}
			}
			xhr.send();
		}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
이곳에서는 view를 가져오고 저장도 해야됨.!! 
	<div class="containaer">
		<h3>게시물 수정</h3>
		<table class="table table-bordered">
			<tr>
				<th>게시물 번호</th>
				<td>${param.biNum}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" id="biTitle" ></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea id="biContent" rows="10" cols="50" ></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="number" id="uiNum" ></td>
			</tr>
			<tr>
				<th colspan="2"><button onclick="update()">수정</button></th>
			</tr>
		</table>
		<!-- <input type="hidden" name="bi_num" value="${board.biNum }"> -->
	</div>


<script>

/* 
var strs = ["태백산","북한산","남산"];
for(var idx in strs){
	console.log(idx); //0,1,2 - 순서중요할때
}
for(var str of strs){
	vonsolt.log(str); //태백산,북한산,남산 - value중요할때
} 
*/


//var inputs = document.querySelector('#biTitle'); //document.getElementById('biTitle') 과 같음
//var inputs = document.querySelector('[id]'); //대괄호 안에 쓴걸 가져옴 그중에서 제일먼저인걸 가져옴
//console.log(inputs); 

/* 
var inputs = document.querySelectorAll('[id]'); // 속성 id인것을 가져옴

for(var idx in inputs){
	var input = inputs[idx];
	console.log(input.id);
	if(input.id=='biTitle'){
		input.value='제목이다';
		
	}
}

var a;
if(!a){  //true. var a= null,0,'' 다 true
	alert(1);
}
 */
 
//console.log(inputs);
//console.log(inputs[0]);
//console.log(inputs[1]);
//console.log(inputs[2]);
function update(){
	var inputs = document.
}

function ajax(conf){
	var xhr = new XMLHttpRequest();
	xhr.open(conf.method, conf.url);
	if(conf.method!='GET'){ //get이 아닐때 param으로 보냄.
		xhr.setRequestHeader('Content-Type','application/json');
	}
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				conf.callback(xhr.responseText);
			}
		}
	}
	var param = (conf.param)?conf.param:''; //false ? '' 
	xhr.send(param);
}


var conf = {
		method : 'GET',
		url : '/ajax/board/view?cmd=view&biNum=${param.biNum}',
		callback : function(res){
			console.log(res);
			var board = JSON.parse(res);//js가 알게끔  String-->객체로 바꿔줌.
			var inputs = document.querySelectorAll('[id]');
			for(var idx in inputs){
				var input = inputs[idx];
				if(input.id){ //true
					input.value = board[input.id];
				}
			}
		}
}
ajax(conf);

</script>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/mem.css?after">
<!-- <script type="text/javascript" src="script/mem.js"></script> -->
</head>
<body>

	<hr>
	<div class="divBox">
		<div>${mVO.name }님 반갑습니다</div>
		<div>레벨 : ${mVO.lev }</div>
		<div>
			<div><a href='MemServlet?command=logout'>로그아웃</a></div>
		</div>
		<div>
			<a href='MemServlet?command=insert_form' onclick="return levCheck()">사원등록</a> <br> (관리자로 로그인
			후 사용가능)
		</div>
		<div>
			<a href='MemServlet?command=update_form'>마이페이지</a>
		</div>
	</div>
<div class="con">
	<h3>회원 정보 입력</h3>
	<form name="frm" id="reg_frm" method="POST" action="MemServlet">
		<input type="hidden" name="command" value="insert"> 
		<label for="id"> 아이디 </label><span> * </span> 
		<input type="text" id="id" name="id" minlength="4" maxlength="20" required><br> <br>

		<label for="pwd"> 비밀번호 </label><span> * </span> 
		<input type="password" id="pwd" name="pwd" minlength="4" maxlength="20" required><br>

		<label for="name">이름</label><span> * </span> 
		<input type="text" name="name" required minlength="2" maxlength="20"><br>
		<label for="phone"> 전화번호 </label><span> * </span> 
		<input type="tel" id="phone" name="phone" placeholder="010-1234-1234" required minlength="4" maxlength="30"><br> 
		<label for="lev"> 레벨 </label><span> * </span> 
		<input type="radio" name="lev" value="B" checked>일반사원
		<input type="radio" name="lev" value="A" >관리자<br>

		<label for="gender"> 성별 </label><span> * </span> 
		<input type="radio" name="gender" value="M" checked>남성 
		<input type="radio" name="gender" value="F" >여성<br> 
		<input type="submit" value="등록" onclick="return idCheck()"> 
			<input type="reset" value="취소">
	</form>
	<p>${message }</p>
	</div>
	<script type="text/javascript">
	function idCheck() {
	    var id = document.getElementById("id").value;
	    if (id.trim() === "") {
	        alert("아이디를 입력하시오");
	        return false; // 사용자 입력이 없을 경우 함수를 종료하고 false 반환
	    }

	    var xhr = new XMLHttpRequest();
	    // 동기적으로 요청하기 위해 open 메소드의 세 번째 인자를 false로 설정
	    xhr.open("POST", "MemServlet", false); // 동기 방식으로 설정
	    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    
	    var formData = "command=check_id&id=" + encodeURIComponent(id);
	    xhr.send(formData);

	    if (xhr.status === 200) {
	        var response = xhr.responseText;
	        if (response === "false") {
	            alert("아이디가 중복됩니다. 다른 아이디를 입력하시오");
	            return false; // 아이디가 중복됨
	        } else if (response === "true") {
	            return true; // 아이디가 중복되지 않음
	        }
	    } else {
	        // 네트워크 에러 또는 서버 에러 처리
	        console.error("서버 오류 발생");
	        return false; // 오류 발생 시 false 반환
	    }
	}
/* 		function idCheck() {
			// event.preventDefault();
			//입력된 아이디 가져오기
			var id = document.getElementById("id").value;
			var result = null;
			// 비밀번호가 비어 있는지 확인
			if (id.trim() === "") {
				alert("아이디를 입력하시오");
				return;
			}

			var xhr = new XMLHttpRequest();

			xhr.open("POST", "MemServlet", false);
			xhr.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");

			// 서버에 전송할 데이터 설정
			var formData = "command=check_id&id=" + encodeURIComponent(id);

			xhr.send(formData);

			xhr.onreadystatechange = function() {
		        if (xhr.readyState === 4 && xhr.status === 200) {
		            var response = xhr.responseText;

		            if (response === "false") {
		            	alert("아이디가 중복됩니다. 다른 아이디를 입력하시오");
					       return false;
		            } else if(response === "true") {
		             //   document.getElementById("reg_frm").submit(); 
		            	return true;
		            }
		        }
		    };
		}  */

		function levCheck() {

			var lev = "${mVO.lev }";
			    if (lev === 'B') {
			        alert("관리자만 등록 가능");
			        return false;
			    } else if (lev === 'A') {
			        return true;
			    }
			    
			}
	</script>
</body>
</html>
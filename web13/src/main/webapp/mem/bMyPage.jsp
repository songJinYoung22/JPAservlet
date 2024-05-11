<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/mem.css?after">
<script type="text/javascript" src="script/mem.js"></script>
</head>
<body>

	<hr>
	<div class="divBox">
	<div>${mVO.name } 님 반갑습니다</div>
	<div>레벨 : ${mVO.lev } </div>
	<div><div><a href='MemServlet?command=logout'>로그아웃</a></div></div>
	<div><a href='MemServlet?command=insert_form' onclick="return levCheck()" >사원등록</a> <br> (관리자로 로그인 후 사용가능)</div>
	<div><a href='MemServlet?command=update_form'>마이페이지</a></div>
	</div>

<div id="container">
		<h3 class="center" >회원 정보 변경</h3>
		<form name="frm" id="reg_frm"  method="POST" action="MemServlet">
			<input type="hidden" name="command" value="update" >
			
			
			<label for="id"> 아이디 (변경x) </label><span> * </span>
		   <input type="text" id="id" name="id" value="${mVO.id }" readonly>
		   <br>
		 
		    
		  <label for="name">이름</label><span> * </span>
		  <input type="text" name="name" value="${mVO.name }" required><br>
		
		    <label for="phone"> 전화번호 </label><span> * </span>
		    <input type="tel" id="phone" name="phone" 
		           value="${mVO.phone }" required><br>
			<label for="lev"> 레벨 (변경x)</label>
			    <select name="lev" id="levSelect" disabled>
								<option value="A">운영자</option>
								<option value="B">일반사원</option>
				</select><br>
		    <label for="gender"> 성별 </label>
		    				<select name="gender" id="genderSelect">
							<option value="M">남자</option>
							<option value="F">여자</option>
						</select>
		    <br><br>
		    <label for="pwd"> 비밀번호 </label><span> * </span> 
		    <input type="password" id="pwd" name="pwd" required><br>
		            <div class="center">
		                <input type="submit" value="수정"> 
		                <input type="reset" value="취소">
		                <a href="MemServlet?command=go_main">메인 페이지로 이동</a>
		            </div>
		
		        </form>
		       	<p>${message }</p>
		</div>
<script type="text/javascript">
var phoneValue = "${mVO.gender}";

// 가져온 값에 따라 옵션을 선택합니다.
if (phoneValue === "M") {
  document.getElementById('genderSelect').value = 'M';
} else if (phoneValue === "F") {
  document.getElementById('genderSelect').value = 'F';
}

var levValue = "${mVO.lev}";

if (levValue === "A" ) {
	    document.getElementById('levSelect').value = 'A';
	  } else {
		  document.getElementById('levSelect').value = 'B';
	  }
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
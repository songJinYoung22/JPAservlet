<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 로그인 페이지</title>
<link rel="stylesheet" href="css/mem.css?after">
<script type="text/javascript" src="script/mem.js"></script>
</head>
<body>
	
	<hr>
	<div class="divBox">
	<div>${mVO.name } 님 반갑습니다</div>
	<div>레벨 : ${mVO.lev } </div>
	<div><a href='MemServlet?command=logout'>로그아웃</a></div>
	<div><a href='MemServlet?command=insert_form' onclick="return levCheck()">사원등록</a><br> (관리자로 로그인 후 사용가능)</div>
	<div><a href='MemServlet?command=update_form'>마이페이지</a></div>
	</div>
	<div class="con">
		<h1>회원 전용 페이지</h1><br>
		<img alt="" src="https://dimg.donga.com/wps/NEWS/IMAGE/2014/02/20/61044900.3.jpg">
	</div>
<script type="text/javascript">
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
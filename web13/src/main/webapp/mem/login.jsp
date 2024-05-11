<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 로그인 페이지</title>
<link rel="stylesheet" href="css/mem.css?after">
<script type="text/javascript" ></script>

</head>
<body>
	
	<hr>
	<div class="divBox">
	<div></div>
	<div></div>
	<div>로그인</div>
	<div>사원등록 <br> (관리자로 로그인 후 사용가능)</div>
	<div>마이페이지 <br> (로그인 후 사용 가능)</div>
	</div>
	<div class="con">
		<form action="MemServlet" name="frm" method="post">
			<input type="hidden" name="command" value="login_check">
			<label>id</label> 
			<input type="text" name="id" id="id" minlength="5" required > <br>
			<label>pwd</label>
			<input type="password" name="pwd" id="pwd" required> <br>
			<label>레벨</label>
			<select name="lev">
				<option value="B">일반사원</option>
				<option value="A">운영자</option>
			</select><br>
			<input type="submit" value="로그인" onclick=""> 
		</form>
		<p>${message }</p>
		</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
fieldset{
        width: 200px;
}
fieldset ol{
        list-style: none;
        padding: 0;
        margin: 2px;
}
feildset ol li{
        margin: 0 0 9px 0;
        padding: 0;
}
</style>
</head>
<body>

<fieldset>
<legend>로그인</legend>
<form action="loginPro.do" name="frm" method="post">
	<ol>
		<li> <label>아이디</label><br>
			<input type="text" id="id" name="id" required="required"
				autofocus="autofocus">
		</li>
		<li><label>암호</label><br>
			<input type="password" id="pass" name="pass" required="required">
		</li>
		<li><input type="submit" value="확인">
		</li>
	</ol>
	
</form>
</fieldset>
<a href="joinForm.do">회원가입   </a><a href="idForm.do">아이디</a> <a>/비밀번호 찾기</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="sessionChk.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
fieldset{
        width: 300px;
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
<form action="deletePro.do">
<fieldset>
<legend>회원 탈퇴</legend>
	<ol>
		<li>(<b>${id }님</b>)
		<li>탈퇴를 위해서 비밀번호를 입력하십시오
		<li> <input type="password" id="pass" name="pass">
			<input type="submit" value="핵탈퇴">
	</ol>
</fieldset>
</form>
%탈퇴하시면 30일간 동일 아이디로 회원가입을 하실수 없습니다.
</body>
</html>
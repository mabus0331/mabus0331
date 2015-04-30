<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="sessionChk.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
fieldset{
        width: 280px;
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
<form action="updatePro.do">
<fieldset>
<legend>비밀번호 확인</legend>
	<ol>
		<li>(<b>${id }님</b>)의 비밀번호를 확인합니다.
		<li> <input type="password" id="pass" name="pass">
			<input type="submit" value="확인">
	</ol>
</fieldset>
</form>
</body>
</html>
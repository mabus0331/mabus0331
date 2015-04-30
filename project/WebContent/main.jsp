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
<fieldset>
<legend>등급 : <a href="membership.do">${grade}</a></legend>
	<ol>
		<!-- 세션에 저장된 id값을 가져옴 -->
		<li><a href="updateForm.do">(<b>${id }님</b>)</a>환영합니다
		 <button onclick="location.href='logout.do'">로그아웃</button></li>
			<li>사용가능한 쿠폰 : </li>
			
	</ol>
</fieldset>
</body>
</html>
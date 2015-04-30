<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${result==1 }">
	<script type="text/javascript">
		alert("로그인 성공!");
		location.href="main.do";
	</script>
</c:if>
<c:if test="${result ==0}">
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.");
		location.href="loginForm.jsp";
	</script>
</c:if>
<c:if test="${result ==-1}">
	<script type="text/javascript">
		alert("아이디가 존재하지 않습니다.");
		location.href="loginForm.jsp";
	</script>
</c:if>
</body>
</html>
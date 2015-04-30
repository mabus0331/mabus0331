<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${result==1 }">
	<script type="text/javascript">
		alert("정상적으로 회원이 탈퇴 되었습니다. 잘먹고 잘살아...");
		location.href="loginForm.do";
	</script>
</c:if>
<c:if test="${result==0 }">
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다. 다시한번 확인하세요");
		location.href="deleteForm.do";
	</script>
</c:if>
</body>
</html>
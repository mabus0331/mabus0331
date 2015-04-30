<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h2>공지사항</h2>
<table >
	<tr>
		<th>NO</th><th>제목</th><th>작성 날짜</th>
	</tr>
<c:forEach var="i" items="${list}" begin="0" end="${list.size() }" >
		<tr>
		<td>NO.${i.getBoard_num() }</td>
		<td><a href="contentsFrom.do?board_num=${i.getBoard_num() }">${i.getBoard_sub() }</a></td>
		<td>${i.getBoard_date() }</td>
		</tr>
</c:forEach>
</table>
</body>
</html>
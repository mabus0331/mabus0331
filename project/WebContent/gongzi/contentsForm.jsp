<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<table>
	<tr>
		<th>No.${board_num } <b>${board_sub }</b></th>
	</tr>
	<tr>
		<td>작성일 : ${board_date }</td>
	</tr>
	<tr>
		<td><div>${board_content }</div><br></td>
	</tr>
	<tr>
		<td>
			<button onclick="location.href='updateForm.do?board_num=${board_num}'">수정</button> 
			<button onclick="location.href='deleteFrom.do?board_num=${board_num}'">글삭제</button> 
		</td>
	</tr>
</table>
</body>
</html>
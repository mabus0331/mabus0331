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
<form action="updatePro.do">
<table>
	<tr>
		<th><input type="hidden" value="${board_num }"
		name="board_num"> No.${board_num }
		<textarea rows="1" cols="80" name="board_sub">
			${board_sub }</textarea></th>
	</tr>
	<tr>
		<td>작성일 : ${board_date }</td>
	</tr>
	<tr>
		<td><div>
			<textarea rows="3" cols="90" name="board_content"> 
				${board_content }</textarea></div><br></td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="수정완료"><input type="reset" value="재입력">
		</td>
	</tr>
</table>
</form>
</body>
</html>
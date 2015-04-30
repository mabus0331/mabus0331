<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
	
</head>
<body>
<form action="writePro.do">
<table >
	<tr>
		<th class="th" >제목 : <textarea rows="1" cols="60" 
			id="board_sub" name="board_sub"></textarea> </th> 
	</tr>
	<tr>	
		<td class="td" >내용 : <textarea rows="10" cols="60"
			 id="board_content" name="board_content"></textarea></td>
	
		<td><button id="button" type="submit">입력</button>
			<button id="button" type="reset">취소</button></td>	
	</tr>
	
</table>
		
</form>
</body>
</html>
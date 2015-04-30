<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
div{
	text-align: center;
}

</style>
</head>
<body>
<form action="idPro.do">
<fieldset>
<legend>아이디 찾기(이름/전화번호/이메일/성별)</legend>
	<ol>
		<li>
		<label>이  름</label> <br>
			<input type="text" id="name" name="name" required="required"
				placeholder="이름">
		</li>
		<li>
		<label>이메일 </label> <br>
		<input type="email" id="email" name="email" required="required"
			 placeholder="user@example.com"><p>
		</li>
		<li>
		<label>전화번호 </label><br>
		<input type="tel" id="phone" name="phone" required="required" 
			pattern="\d{2,3}-\d{3,4}-\d{4}" placeholder="010-111-1111" 
			title="숫자 2,3,4자리-3,4자리-4자리 형식을 맞춰서 입력하세요"><br>
		</li>
		<li>
 		<label>성 별</label><br>
 			<input type="radio" name="gen" value="남" id="mail">남
 			<input type="radio" name="gen" value="여" id="femail">여
 		</li>
 		<li><div>
			<input type="submit" value="아이디 찾기"><input type="reset" value="재입력">
		</div></li>
	</ol>
</fieldset>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="sessionChk.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
 <script>
     function openDaumPostcode() {
         new daum.Postcode({
             oncomplete: function(data) {
                 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                 // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                 // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                 var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                 if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                 } else { // 사용자가 지번 주소를 선택했을 경우(J)
                     fullAddr = data.jibunAddress;
                 }

                 // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                 if(data.userSelectedType === 'R'){
                     //법정동명이 있을 경우 추가한다.
                     if(data.bname !== ''){
                         extraAddr += data.bname;
                     }
                     // 건물명이 있을 경우 추가한다.
                     if(data.buildingName !== ''){
                         extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                     }
                     // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                     fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                 }
                 
                 // 우편번호와 주소 정보를 해당 필드에 넣는다.
                 document.getElementById("postcode1").value = data.postcode1;
                 document.getElementById("postcode2").value = data.postcode2;
                 document.getElementById("addr1").value = fullAddr;

                 // 커서를 상세주소 필드로 이동한다.
                 document.getElementById("addr2").focus();
             }
         }).open();
     }
    function passChck() {
    	var pass = document.getElementById("pass");
    	var pass2 = document.getElementById("pass2");
		if(pass.value != pass2.value){
			alert("달라");
			pass2.focus();
			return false;
		}
    	
    	/* if(frm.pass.value !=frm.pass2.value){
			alert("입력하신 두개 암호가 다릅니다.");
			frm.pass2.focus();
			return false;
		} */
		alert("통과");
		return true;
	}
 </script>
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
<h2>회원 정보수정</h2>
	<fieldset>	
	<form action="updatePro1.do" name="frm" method="post" >
	<ol>
		<li>
		<label>아이디</label> <br>
			<input type="text" id="id" name="id" required="required"
				placeholder="${member.getId() }" title="문자 숫자 조합을 추천합니다" disabled="disabled">
			
		</li>
		<li>
		<label>이  름</label> <br>
			<input type="text" id="name" name="name" required="required"
				value="${member.getName() }" disabled="disabled">
		</li>
		<li>
 		<label>생년월일</label><br>
 			<input type="text" name="birthday" required="required" 
 				value="${member.getBirthday() }" disabled="disabled">
 		</li>
		<li>
		<label>변경할 주소</label><br>
			<input type="text" name="zip1" value="${member.getZip1() }" id="postcode1" title="우편번호 앞자리" class="frm_input readonly" size="3" maxlength="3"> -
 			<input type="text" name="zip2" value="${member.getZip2() }" id="postcode2" title="우편번호 뒷자리" class="frm_input readonly" size="3" maxlength="3">
 			<input type="button" onclick="openDaumPostcode()" value="우편번호 찾기" style="width:100px; height:25px; font-size:11px; background-color:#ECECEC"><br>
			<input type="text" name="addr1" value="${member.getAddr1() }" id="addr1" placeholder="주소" class="frm_input readonly" style="width:60%">
 			<input type="text" name="addr2" value="${member.getAddr2() }" id="addr2" placeholder="상세주소" class="frm_input" style="width:38%">
 		</li> 		
 		<li>
		<label>전화번호 </label><br>
		<input type="tel" id="phone" name="phone" required="required" 
			pattern="\d{2,3}-\d{3,4}-\d{4}" placeholder="010-111-1111" 
			title="숫자 2,3,4자리-3,4자리-4자리 형식을 맞춰서 입력하세요"
			value="${member.getPhone() }"><br>
		</li>
		<li>
		<label>이메일 </label> <br>
		<input type="email" id="email" name="email" required="required"
			 placeholder="user@example.com" value="${member.getEmail() }"><p>
		</li>
		<li><div>
			<input type="submit" value="정보수정"><input type="reset" value="재입력">
		</div></li>
			
		

	</ol>
</form>
</fieldset>
<fieldset>
	<legend>회원탈퇴</legend>
	<ol>
		<li>정말로 탈퇴를 하시겠습니까? <p><a href="deleteForm.do">예.탈퇴하겠습니다.</a>
	</ol>
</fieldset>
</body>
</html>
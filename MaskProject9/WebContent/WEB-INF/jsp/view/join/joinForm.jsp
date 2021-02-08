<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!--css start -->
<meta charset="utf-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content=""> -->

<title>마 스 크</title>

<!-- Bootstrap core CSS -->
<!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
 -->
<!-- Custom styles for this template -->
<!-- <link href="css/small-business.css" rel="stylesheet">
 -->
<link rel="stylesheet" href="css/style.css">
<!--css end -->

<!-- jsp -->
<jsp:include page="../main/menu.jsp"></jsp:include>

<!-- script -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>  <!-- 우편번호 api -->
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script> <!-- 우편번호 api -->
<script type="text/javascript">
	function formCheck() {
		if (frm.memberPassword.value != frm.memberPassword1.value) {
			alert("패스워드가 일치하지 않습니다.");
			frm.memberPassword1.value = null;
			frm.memberPassword1.focus();
			return false;
		}
		return true;
	}

	function idCheck(str) {
		var url = "idCheck.do?memberId=" + str;
		if (str == "") {
			alert("아이디를 입력하세요.");
			frm.memberId.focus();
		} else {
			window.open(url, "아이디 중복확인",
					"width=600, height=200, top=100, left=100");
		}
	}
	function openZipSearch() {
		new daum.Postcode({
			oncomplete : function(data) {
				$('[name=memberZipcode]').val(data.zonecode); // 우편번호 (5자리)
				$('[name=memberAddress]').val(data.address);
			}
		}).open();
	}
</script>


</head>
<body>
	<div class="main-container">
		<div class="main-wrap">

			<header>
				<div class="logo-wrap">
					<img src="#">
				</div>
			</header>

			<form id="frm" name="frm" onsubmit="return formCheck()"
				action="join.do" method="post">
				<section class="login-input-section-wrap">


					<div class="login-input-wrap">
						<input type="text" id="memberId" name="memberId" placeholder="아이디"
							required="required">
					</div>
					<div class="login-button-wrap">
						<button type="button" onclick="idCheck(memberId.value)">중복체크</button>
					</div>

					<div class="login-input-wrap password-wrap">
						<input type="password" id="memberPassword" name="memberPassword"
							placeholder="비밀번호" required="required">
					</div>


					<div class="login-input-wrap password-wrap">
						<input type="password" id="memberPassword1" name="memberPassword1"
							placeholder="비밀번호 재확인" required="required">
					</div>


					<div class="login-input-wrap password-wrap">
						<input type="text" id="memberName" name="memberName"
							placeholder="이름" required="required">
					</div>


					<div class="login-input-wrap password-wrap">
						<input type="text" id="memberPhone" name="memberPhone"
							placeholder="휴대전화" required="required">
					</div>
					<div>
						<input type="radio" id="memberAuth" name="memberAuth" value="USER"
							checked="checked">개인회원 <input type="radio"
							id="memberAuth" name="memberAuth" value="SELLER">판매자
					</div>

					<div class="login-button-wrap">
						<button type="button" onclick="openZipSearch()">우편번호 검색</button>
					</div>
					
					<div class="login-input-wrap password-wrap">
						<input type="text" id="memberZipcode" name="memberZipcode"
							placeholder="우편번호" />
					</div>

					<div class="login-input-wrap password-wrap">
						<input type="text" id="memberAddress" name="memberAddress"
							placeholder="주소" style="width: 300px;" required="required">
					</div>

					<div class="login-input-wrap password-wrap">
						<input type="text" id="memberEmail" name="memberEmail"
							placeholder="이메일" required="required">
					</div>


					<div class="login-button-wrap">
						<button type="submit">sign up</button>
					</div>
					<!-- <div>
					<table border="1">
						<tr>
							<th>아이디</th>
							<td><input type="text" id="memberId" name="memberId"
								required="required">
								<button type="button" onclick="idCheck(memberId.value)">중복체크</button></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" id="memberPassword" name="memberPassword" required="required"></td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td><input type="password" id="memberPassword1" name="memberPassword1" required="required"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" id="memberName" name="memberName"
								required="required"></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="text" id="memberPhone" name="memberPhone"
								required="required"></td>
						</tr>
						<tr>
							<th>우편번호</th>
							<td><input type="text" id="memberZipcode" name="memberZipcode"/>
							<button type="button" onclick="openZipSearch()">검색</button><br></td>
						</tr>
						<tr>
							<th>회원주소</th>
							<td><input type="text" id="memberAddress"
								name="memberAddress" style="width:300px;" required="required"></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" id="memberEmail" name="memberEmail"
								required="required"></td>
						</tr>
						<tr>
							<th>회원구분</th>
							<td><input type="radio" id="memberAuth" name="memberAuth"
								value="USER" checked="checked">개인회원 <input type="radio"
								id="memberAuth" name="memberAuth" value="SELLER">판매자</td>
						</tr>
					</table>
				</div> -->
					<!-- <br /> <input type="submit" value="회원가입">&nbsp; -->
				</section>
			</form>

			<br /> &nbsp;&nbsp;&nbsp;

		</div>
	</div>
<div class="jumbotron text-center" style="margin-bottom:0">
		<p>
			COMPANY : 주식회사 YD / OWNER : 김예담<br> 📞CALL CENTER : 053-421-2460<br>
		</p>
		<p>대구광역시 중구 상서동 22-2 BANK ACCOUNT 💳예담은행 100-010100-01-011 예금주 :
			주식회사 예담</p>
		<a href="#" target="_black" title="인스타그램으로 이동"><img
			src="img/insta.jpg"></a> <a href="#" target="_blank" title="페이스북으로 이동"><img
			src="img/fb.jpg"></a> <a href="#" target="_blank"><img
			src="img/ka.jpg"></a>
	</div>



</body>
</html>
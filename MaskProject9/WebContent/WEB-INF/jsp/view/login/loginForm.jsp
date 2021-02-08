<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!--css start -->
<meta charset="UTF-8">

<title>로 그 인</title>

<!-- Custom styles for this template -->
<link rel="stylesheet" href="css/style.css">

<!--css end -->

<!-- jsp -->
<jsp:include page="../main/menu.jsp"></jsp:include>

<!-- script -->
<script src="https://kit.fontawesome.com/51db22a717.js"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<!-- 네이버 로그인 api -->
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<!-- 카카오 로그인 api -->
</head>
<body>
	<div class="main-container">
		<div class="main-wrap">

			<header>
				<div class="logo-wrap">
					<img src="#">
				</div>
			</header>


			<form id="frm" name="frm" action="login.do" method="post">
				<section class="login-input-section-wrap">
					<div class="login-input-wrap">
						<input type="text" id="memberId" name="memberId" placeholder="아이디"
							size="30">
					</div>
					<div class="login-input-wrap password-wrap">
						<input type="password" id="memberPassword" name="memberPassword"
							placeholder="비밀번호" size="30">
					</div>
					<div class="login-button-wrap">
						<button type="submit" onclick="location.href='joinForm.do'">sign
							in</button>
					</div>
					<div class="login-button-wrap">
						<button type="button" onclick="location.href='joinForm.do'">sign
							up</button>
					</div><br/>
					<div class="login-stay-sign-in">
						<div id="naver_id_login" style="float: left;"></div>
						<script type="text/javascript">
							var clientId = "vTPtk6phaCtJT__4rW3Z";
							var callbackUrl = "http://localhost:85/MaskProject/login.do";
							var naver_id_login = new naver_id_login(clientId,
									callbackUrl);
							var state = naver_id_login.getUniqState();
							naver_id_login.setButton("white", 3, 40);
							naver_id_login
									.setDomain("localhost:85/MaskProject");
							naver_id_login.setState(state);
							naver_id_login.setPopup();
							naver_id_login.init_naver_id_login();
						</script>
	&nbsp;
						<div id="kakao-login-btn" style="float: left;"></div>
						<a href="http://developers.kakao.com/logout"></a>
						<script type='text/javascript'>
							Kakao.init('85d26ba23c515a0b8724721dfc5764d3');
							Kakao.Auth.createLoginButton({
								container : '#kakao-login-btn',
								success : function(authObj) {
									alert(JSON.stringify(authObj));
								},
								fail : function(err) {
									alert(JSON.stringify(err));
								}
							});
						</script><br/>
							&nbsp;
						<i class="far fa-check-circle"></i> <span>Stay Signed in</span>
					</div>

				</section>
			</form>
			<br />
		</div>
	</div>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>
			COMPANY : 주식회사 YD / OWNER : 김예담<br> 📞CALL CENTER : 053-421-2460<br>
		</p>
		<p>대구광역시 중구 상서동 22-2 BANK ACCOUNT 💳예담은행 100-010100-01-011 예금주 :
			주식회사 예담</p>
		<a href="#" target="_black" title="인스타그램으로 이동"><img
			src="img/insta.jpg"></a> <a href="#" target="_blank"
			title="페이스북으로 이동"><img src="img/fb.jpg"></a> <a href="#"
			target="_blank"><img src="img/ka.jpg"></a>
	</div>
</body>
</html>
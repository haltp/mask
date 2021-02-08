<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>상단</title>

<style type="text/css">
	#wrap{
		text-align: center;
		width: 800px;
		height: 150px
	}
</style>

<script type="text/javascript">
	
	function changeView(value) {
		if(value == "0") // 홈버튼 클릭 첫화면 이동
		{
			location.href="main.do";
		}
		else if(value == "1")// 로그인 버튼 로그인이동
		{
			location.href="Login.do";
		}
		else if(value == "2")//회원가입 이동
		{
			location.href="boardWirteForm.do";
		}
		else if(value == "3") // 로그아웃
		{
			location.href="Logout.do";
		}
		else if(value == "4") // 마이페이지?
		{
			location.href="#";
		}
		else if(value == "5") // 구매? 장바구니?
			{
			 location.href="#"
			}
		else if(value == "6")// 게시판
		{
			location.href="BoardListForm.do";
		}
	}
</script>

</head>
<body>
	<div id = "wrap">
		<p>
			<button class="btn btn-success" onclick="changeView(0)">Home</button>
			
			<!-- 로그인 안된경우 로그인 회원가입 확인 -->
			<c:if test="${sessionScope.sessionID == null }">
				<button id="loginBtn" class="btn btn-primary" onclick="changeView(1)">로그인</button>
				<button id="joinBtn" class="btn btn-primary" onclick="changeView(2)">회원가입</button>
			</c:if>
			
			<!-- 로그인 안된경우 로그인 회원가입 확인 -->
			<c:if test="${sessionScope.sessionID != null }">
				<button id="logoutBtn" class="btn btn-primary" onclick="changeView(3)">로그아웃</button>
				<button id="joinBtn" class="btn btn-primary" onclick="changeView(4)">내정보</button>
			</c:if>
			
			<button id="joinBtn" class="btn btn-info" onclick="changeView(6)">게시판</button>
			
			<!-- 관리자 -->
			<c:if test="${sessionScope.sessionID != null && sessionScope.sessionID == 'admin' }">
				<button id="#" class="btn btn-warning" onclick="changeView(5)">회원 목록보기</button>
			</c:if>
		</p>
	</div>
</body>
</html>
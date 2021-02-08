<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">


<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
	height: 100%;
}

.contents-wrap {
	min-height: 100%;
	position: relative;
	padding-bottom: 100px; /* footer height */
}

.footer {
	width: 100%;
	height: 100px;
	position: absolute;
	bottom: 0;
	background: #5eaeff;
	text-align: center;
	color: white;
}
</style>

<head>


<title>마 스 크</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/small-business.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="main.do">Our Mask</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">

            <a class="nav-link" href="showProduct.do">마스크 구매하기

              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="loginForm.do">로그인</a>
          </li>

           <c:if test="${memberId eq null}">
			</c:if>

					<li class="nav-item active"><a class="nav-link"
						href="showProduct.do">마스크 구매하기 <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link"	href="cartView.do">장바구니</a></li>
					<li class="nav-item active"><a class="nav-link" href="boardListForm.do">문의페이지</a></li>
					<li class="nav-item active"><a class="nav-link" href="sellerView.do">구매내역</a></li>
					<li class="nav-item active"><a class="nav-link" href="showProduct.do">상품조회</a></li>

					<c:if test="${memberId eq null}">
						<li class="nav-item active"><a class="nav-link" href="loginForm.do">로그인</a></li>

						<li class="nav-item active"><a class="nav-link" href="joinForm.do">회원가입</a></li>
					</c:if>
					<c:if test="${memberId != null and memberAuth != null}">
						<li class="nav-item active"><a class="nav-link" href="myPageForm.do">내정보</a></li>
					</c:if>
					<c:if test="${memberAuth == 'ADMIN'}">
						<li class="nav-item active"><a class="nav-link" href="adminForm.do">관리자</a></li>
						<li class="nav-item active"><a class="nav-link" href="showProductSeller.do">상품관리</a></li>
					</c:if>
					
					<c:if test="${memberAuth == 'SELLER'}">
						<li class="nav-item active"><a class="nav-link"
							href="sellerView.do">판매내역</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="showProductSeller.do">상품관리</a></li>
					</c:if>
					
					<c:if test="${memberId ne null }">
						<li class="nav-item active"><a class="nav-link" href="logout.do">로그아웃</a></li>
					</c:if>
					
					<!-- Dropdown -->
					<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">test</a>
						<div class="dropdown-menu">
							<a class="dropdwon-item" href="showProductTest.do">상품조회</a> 
							<a class="dropdwon-item" href="showBoardTest.do">문의게시판</a> 
							<a class="dropdwon-item" href="adminUserFormTest.do">회원관리</a> 
							<a class="dropdwon-item" href="adminSellerForm.do">거래처관리</a>
						</div></li>
				</ul>
			</div>
		</div>
	</nav>


	<!-- Bootstrap core JavaScript -->
	<!--  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
 -->


</body>


</html>
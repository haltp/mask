<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jsp -->
<jsp:include page="../main/menu.jsp"></jsp:include>


<style type="text/css">
	input{
		border: none;
	}
</style>
<script type="text/javascript">
	function buyProduct(str) {
		var win = window.open("", "PopupWin", "width=680,height=800");
		frm.target = "PopupWin";
		frm.cartProduct.value = str;
		frm.action = "bootPay.do";
		frm.submit();
	}
	function DeleteProduct(str) {
		var yn = confirm("삭제하시겠습니까?")
		if(yn) {
			frm.cartNumber.value = str;
			frm.action = "cartDelete.do";
			frm.submit();
		}
	}
</script>
</head>
<body>
	<div align="center">
		<h1>회원 장바구니</h1>
		<div>
			<form action="" id="frm" name="frm" method="post">
			<input type="hidden" name="cartProduct" id="cartProduct">
			<input type="hidden" name="cartNumber" id="cartNumber">
				<table border="1">
					<tr>
						<th>장바구니 번호</th>
						<th>구 매 자</th>
						<th>상품 번호</th>
						<th>상 품 명</th>
						<th>상품 가격</th>
						<th>구매 수량</th>
						<th>판 매 자</th>
						<th>구 매</th>
						<th>삭 제</th>
					</tr>
					<c:if test="${empty cartList }">
						<tr align="center">
							<th colspan="9">장바구니에 등록된 상품이 없습니다.</th>
						</tr>
					</c:if>
					<c:if test="${not empty cartList }">
						<c:forEach var="vo" items="${cartList }">
							<tr>
								<td>${vo.cartNumber }</td>
								<td>${vo.cartUser }</td>
								<td>${vo.cartProduct }</td>
								<td>${vo.productName }</td>
								<td>${vo.productPrice }</td>
								<td>${vo.cartSelect }</td>
								<td>${vo.productSeller }</td>
								<td><button type="button" onclick="buyProduct(${vo.cartProduct})">구 매</button></td>
								<td>
									<button type="button" onclick="DeleteProduct(${vo.cartNumber})">삭 제</button>
									<input type="hidden" name="cartUser" id="cartUser" value=${vo.cartUser }>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</table><br/>
				<button type="button" onclick="location.href = 'main.do'">홈으로</button>
			</form>
		</div>
	</div>
</body>
</html>
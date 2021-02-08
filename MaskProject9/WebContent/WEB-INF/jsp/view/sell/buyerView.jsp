<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div align="center">
		<h1>구매 내역 페이지</h1>
		<div>
			<form action="" id="frm" name="frm" method="post">
				<table border="1">
					<tr>
						<th>판매 번호</th>
						<th>상품 번호</th>
						<th>상 품 명</th>
						<th>상품 가격</th>
						<th>구매 갯수</th>						
						<th>판 매 자</th>
						<th>구 매 일</th>
					</tr>
					<c:if test="${empty buyList}">
						<tr><td colspan="7" align="center">구매 내역이 없습니다.</td></tr>
					</c:if>
					<c:if test="${not empty buyList}">
						<c:forEach var="vo" items="${buyList }">
							<tr>
								<td>${vo.sellNumber }</td>
								<td>${vo.sellProductNumber }</td>
								<td>${vo.productName }</td>
								<td>${vo.productPrice }</td>
								<td>${vo.sellQunt }</td>
								<td>${vo.productSeller }</td>
								<td>${vo.sellDate }</td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<style>
table {
	width: 70%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	padding: 15px;
	text-align: left;
}

th {
	padding: 15px;
	text-align: center;
}

#t01 tr:nth-child(even) {
	background-color: #eee;
}

#t01 tr:nth-child(odd) {
	background-color: #fff;
}

#t01 th {
	background-color: black;
	color: white;
}

.insertBtn {
	border: none;
	font-size: 16px;
	cursor: pointer;
	color: black;
	justify-content: center;
	display: flex;
}

.updateBtn {
	border: none;
	font-size: 16px;
	cursor: pointer;
	color: black;
	justify-content: center;
	display: flex;
}
</style>
<script>
function adminDelete(str) {
	var deletee = confirm("정말 삭제하시겠습니까?");
	console.log(str);
	if (deletee) {
		frm.action ="deleteAdminExec.do?row="+str;
		frm.submit();
	}else{
		alert("취소하였습니다");
	}
}

</script>
</head>
<body>


	<jsp:include page="../main/menu.jsp"></jsp:include>
	<div align="center">
		<div>
			<h2>상품 목록</h2>
		</div>
		<form id="frm" name="frm" method="post">
			<table border="1" id="t01">
				<tr>
					<th width="70">상품 번호</th>
					<th width="100">상품 이름</th>
					<th width="70">상품 수량</th>
					<th width="70">상품 판매가격</th>
					<th width="70">해당 판매자</th>
					<c:if test="${memberAuth eq 'ADMIN'}">
						<th width="70">삭제</th>
					</c:if>
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td width="70">${vo.productNum}</td>
						<td width="70">${vo.productName}</td>
						<td width="70">${vo.productQunt}</td>
						<td width="70">${vo.productPrice}</td>
						<td width="70">${vo.productSeller}</td>

						<c:if test="${memberAuth eq 'ADMIN'}">
							<td>
								<button type="button" onclick="adminDelete(${vo.productNum})">삭제</button>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</form>
		<br />

	</div>

	<div align="center">
		<button type="button" onclick="location.href = 'main.do'">홈으로</button>
	</div>


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>
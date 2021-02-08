<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>

	<jsp:include page="../main/menu.jsp" />
	<div class="container">
		<div align="center">
			<div>
				<h2>공지 목록</h2>
			</div>
			<table border="1" id="t01">
				<tr>
					<th width="100">게시글 번호</th>
					<th width="70">제목</th>
					<th width="70">내용</th>
					<th width="70">날짜</th>
				</tr>
				<c:forEach var="vo" items="${list }">

					<tr>

						<td width="70">${vo.boardNumber}</td>
						<td width="70">${vo.boardTitle}</td>
						<td width="70">${vo.boardContent}</td>
						<td width="70">${vo.boardDate}</td>
					</tr>
				</c:forEach>
			</table>
			<br />
		</div>

		<div align="center">
			<button type="button" onclick="location.href = 'main.do'">홈으로</button>
		</div>
	</div>
</body>

</html>
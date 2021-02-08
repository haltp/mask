<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateUser(str) {
		frm.action = "myPageUpdateForm.do";
		frm.submit();
	}
	function deleteUser(str) {
		var yn = confirm("정말 탈퇴하시겠습니까?");
		if (yn) {
			frm.action = "myPageDelete.do?row=" + str;
			frm.submit();
		}
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>마이페이지</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<c:forEach var="vo" items="${list }">
				<table border="1">
					<tr>
						<th>회원 아이디</th>
						<td align="center">${vo.memberId }</td>
					</tr>
					<tr>
						<th>회원 이름</th>
						<td align="center">${vo.memberName }</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td align="center">${vo.memberPassword }</td>
					</tr>
					<tr>
						<th>전화 번호</th>
						<td align="center">${vo.memberPhone }</td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td align="center">${vo.memberZipcode }</td>
					</tr>
					<tr>
						<th>주소</th>
						<td align="center">${vo.memberAddress }</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td align="center">${vo.memberEmail }</td>
					</tr>
					<tr>
						<th>권한</th>
						<td align="center">${vo.memberAuth }</td>
					</tr>
				</table><br/>
				<button type="button" onclick="updateUser('${vo.memberId}')">회원 수정</button>
				<button type="submit" onclick="deleteUser('${vo.memberId}')">회원 탈퇴</button>
				<button type="button" onclick="location.href='main.do'">홈으로</button>
			</c:forEach>
		</form>
	</div>
</body>
</html>
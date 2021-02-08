<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>  <!-- 우편번호 api -->
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script> <!-- 우편번호 api -->
<script type="text/javascript">
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
	<div align="center">
		<div>
			<h1>${vo.memberId } 회원 수정</h1>
		</div>
		<form id="frm" name="frm" action="userUpdate.do?memberId=${vo.memberId }" method="post">				
				<table border="1" class="row">
					<tr>
						<th>회원 아이디</th>
						<td align="center">${vo.memberId }</td>
					</tr>
					<tr>
						<th>회원 이름</th>
						<td align="center"><input type="text" id="memberName"
							name="memberName" value="${vo.memberName }"></td>
					</tr>
					<tr>
						<th>전화 번호</th>
						<td align="center"><input type="text" id="memberPhone"
							name="memberPhone" value="${vo.memberPhone }"></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td align="center"><input type="text" id="memberZipcode"
							name="memberZipcode" value="${vo.memberZipcode }">
							<button type="button" onclick="openZipSearch()">우편번호 검색</button></td>
					</tr>
					<tr>
						<th>주소</th>
						<td align="center"><input type="text" id="memberAddress"
							name="memberAddress" value="${vo.memberAddress }"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td align="center"><input type="text" id="memberEmail"
							name="memberEmail" value="${vo.memberEmail }"></td>
					</tr>
					<tr>
						<th>권한</th>
						<td align="center">${vo.memberAuth }</td>
					</tr>
				</table>
				<br />
			<button type="submit">수정</button>
			&nbsp;&nbsp;
			<button type="reset">취소</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='adminUserForm.do'">목록</button>
		</form>
	</div>
</body>
</html>
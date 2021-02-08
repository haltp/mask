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


<script type="text/javascript">
	function updateSeller(str){
		frm.action = "sellerUpForm.do?row="+str;
		frm.submit();
	}
	function deleteSeller(str){
		var yn = confirm("정말 삭제하시겠습니까?");
		if (yn) {
			frm.action = "sellerDelete.do?row="+str;
			frm.submit();
		}
	}
</script>    
</head>
<body>
	<div align="center">
		<div>
			<h1>거래처 리스트</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<table border="1">
				<tr style="background-color: silver">
					<th width="100">회원 아이디</th>
					<th width="100">회원명</th>
					<th width="200">전화번호</th>
					<th width="100">우편번호</th>
					<th width="300">주소</th>
					<th width="200">이메일</th>
					<th width="100">권한</th>
					<th width="100">수정</th>
					<th width="100">삭제</th>
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td align="center">${vo.memberId }</td>
						<td align="center">${vo.memberName }</td>
						<td align="center">${vo.memberPhone }</td>
						<td align="center">${vo.memberZipcode }</td>
						<td align="center">${vo.memberAddress }</td>
						<td align="center">${vo.memberEmail }</td>
						<td align="center">${vo.memberAuth }</td>
						<td align="center"><button type="button" onclick="updateSeller('${vo.memberId}')">수정</button></td>
						<td align="center"><button type="submit" onclick="deleteSeller('${vo.memberId}')">삭제</button></td>
					</tr>
				</c:forEach>
			</table>
		</form><br/>
		<button type="button" onclick="location.href='adminForm.do'">관리자 창</button>
	</div>
</body>
</html>
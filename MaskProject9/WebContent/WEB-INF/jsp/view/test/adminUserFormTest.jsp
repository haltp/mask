<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css" rel="stylesheet">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src=https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js></script>
 <script type="text/javascript">


	$(document).ready(function () {
		$('#example').DataTable({
			ajax: {
				'url': '/MaskProject/AdminUserGetTest',
				'datatype': 'json',
				'dataSrc': ''
			},
			columns: [
				{ "data": "memberId" },
				{ "data": "memberName" },
				{ "data": "memberPhone" },
				{ "data": "memberAddress" },
				{ "data": "memberEmail" },
				{ "data": "memberAuth" },

				

			]
		});
	});//end of ready


</script>
<jsp:include page="../main/menu.jsp"></jsp:include>

<script type="text/javascript">
	function updateUser(str){
		frm.action = "userUpForm.do?row="+str;
		frm.submit();
	}
	function deleteUser(str){
		var yn = confirm("정말 삭제하시겠습니까?");
		if (yn) {
			frm.action = "userDelete.do?row="+str;
			frm.submit();
		}
	}
</script>    
</head>
<body>
<div style="width:1280px; margin:0 auto;">
	<div align="center">
	<br>
	<br>
	<br>
	<br>
		<div>
			<h1>회원 리스트</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<table id="example" class="table table-striped table-bordered" cellspacing="0" style="width: 100%">
				<tr>
					<th>회원 아이디</th>
					<th>회원명</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>이메일</th>
					<th>권한</th>
				</tr>

			</table>
		</form><br/>
	
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>메인 페이지</title>
<link href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css" rel="stylesheet">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src=https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js></script>
 <script type="text/javascript">


	$(document).ready(function () {
		$('#example').DataTable({
			ajax: {
				'url': '/MaskProject/GetBoardListTest',
				'datatype': 'json',
				'dataSrc': ''
			},
			columns: [
				{ "data": "boardNumber" },
				{ "data": "boardTitle" },
				{ "data": "boardWriter" },
				{ "data": "boardDate" },
				{ "data": "boardHit" },

				

			]
		});
	});//end of ready


</script>
<style type="text/css">

.cateTit_v2.join {
    margin: 88px 0 20px;
    padding: 14px 0;
    border-bottom: 1px solid #77828C;
    color: #000;
}

.cateTit_v2 .title {
	
    font-size: 24px;
    color:#314759;
    line-height: 1;
    font-weight: bold;
    display: inline-block;
    *float: left;
    *line-height: 20px;
}

em {
    font-style: normal;
}



</style>
<jsp:include page="../main/menu.jsp"></jsp:include>

</head>

<body>
<div style="width:1280px; margin:0 auto;">
<div class="cateTit_v2 join">
<br>
	<br>
<div class="cateTit_v2 title">
	<em class="title">문의게시판</em>
</div>


</div>
<br>
	<br>
<div align="center">



<table id="example" class="table " cellspacing="0" style="width: 100%">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>

		</tr>
	</thead>

</table>

</div>

</div>

</body>

</html>
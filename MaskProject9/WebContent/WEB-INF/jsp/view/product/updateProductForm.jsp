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
  width:50%;
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

</style>
<script>
/*세션아이디가 같으면 상품수정 가능  */
</script>
</head>
<body>
<div align="center">
	<div><h1>상품 수정</h1></div>
	
		<form id="frm" name="frm" action="updateExec.do?productNum=${vo.productNum }" method="post"> 
			<table border="1" id="t01" class="row">
				<tr >
					<th width="150">상품 번호</th>
				    <th width="150">상품 이름</th> 
				    <th width="150">상품 수량</th>
				    <th width="150">상품 판매가격</th>
				    <th width="150">판매자</th>
				</tr>
				<tr >
					<td width="150"><input type="text" name="productNum" value="${vo.productNum}" readonly="readonly" size="20" style="width:100%; border:0.5;"></td>
					<td width="150"><input type="text" name="productName" value="${vo.productName}" size="20" style="width:100%; border:0.5;"></td>
					<td width="150"><input type="text" name="productQunt" value="${vo.productQunt}" size="20" style="width:100%; border:0.5;"></td>
					<td width="150"><input type="text" name="productPrice" value="${vo.productPrice}" size="20" style="width:100%; border:0.5;" ></td>
					<td width="150"><input type="text" name="productSeller" value="${vo.productSeller}"readonly="readonly" size="20" style="width:100%; border:0.5;"></td>
				</tr>
			</table><br/>
			<div>
				<button type="submit">수정</button>&nbsp;&nbsp;
				<input type="reset" id="cancle" name="cancle" value="취소">&nbsp;&nbsp;
				<button type="button" onclick="location.href = 'showProduct.do'">상품목록 가기</button>
				
			</div>
		</form>

	</div>
</body>
</html>
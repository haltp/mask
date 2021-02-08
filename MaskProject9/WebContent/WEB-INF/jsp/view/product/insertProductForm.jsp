<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 function productInsert() {
	 var form = document.frm;
	 var name = form.productName;
	 var qt = form.productQunt;
	 var price = form.productPrice;
	 var seller = form.ProductSeller;
	 
	 if (name.value == "") {
		 alert("상품명을 입력하세요!");
		 name.focus();
		 return;
	 }
	 
	 else if (qt.value == "") {
		 alert("상품 수량을 입력하세요!");
		 qt.focus();
		 return;
	 }
	 
	 else if (price.value == "") {
		 alert("상품 가격을 입력하세요!");
		 price.focus();
		 return;
	 }
	 
	 else if (seller.value == "") {
		 alert("판매자 이름을 입력하세요!");
		 seller.focus();
		 return;
	 }
	 
	  form.submit();
 }

</script>
</head>
<body>
	<div align="center" class="inputt">
	<div><h1>상품 등록</h1></div>
		<form id="frm" name="frm" action="insertExec.do" method="post">
			<table border="1" class="t01">
				<tr >
					<th width="80">상품 이름</th> 
				    <th width="45">상품 수량</th>
				    <th width="50">상품 판매가격</th>
				    <th width="80">판매자</th>
				</tr>
				<tr>
					<td width="80"><input type="text" id="productName" name="productName" size="20" style="width:100%; border:0.5;" ></td>
					<td width="45"><input type="number" id="productQunt" name="productQunt" size="20" style="width:100%; border:0.5;" ></td>
					<td width="50"><input type="number" id="productPrice" name="productPrice" size="20" style="width:100%; border:0.5;"></td>
					<td width="80"><input type="text" id="ProductSeller" name="ProductSeller" size="20" style="width:100%; border:0.5;"></td>
				</tr>	
			</table><br/>
			<div>
				<button type="button" onclick="productInsert()" >상품 등록</button>&nbsp;&nbsp;
				<input type="reset" id="cancle" name="cancle" value="취소">&nbsp;&nbsp;
				<button type="button" onclick="location.href = 'showProduct.do'">상품목록 가기</button>
			</div>
		</form>	

	</div>
</body>
</html>
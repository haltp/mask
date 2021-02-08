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
  width:70%;
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

.updateBtn{
  border: none;
  font-size: 16px;
  cursor: pointer;
  color: black;
  justify-content: center;
  display: flex;

}
.deleteBtn{
  border: none;
  font-size: 16px;
  cursor: pointer;
  color: black;
  justify-content: center;
  display: flex;
}

</style>
<script>
function updateproduct(str) {
	 var form = document.frm;
	 var msg = confirm("정말 수정하시겠습니까?");
	 if(msg){
		 form.action="toUpdateProduct.do?row="+str;
		 form.submit();	 
	 }
	 
	 
}

function PdDelete(){
	let deletee = confirm("정말 삭제하시겠습니까?");
	if(deletee){
		
		location.href="deleteExec.do";
	}
	else{
		alert("삭제 하였습니다.");
	}
	
}
function elertDelete(){
	
		alert("해당 상품은 출고중이므로 삭제 불가합니다.");
	}
	

</script>

</head>
<body>
<%-- <jsp:include page="../main/menu.jsp"></jsp:include> --%>
  <div align="center">
  	<div><h2>상품 목록</h2></div>
  	<form id="frm" name="frm" method="post">
	<table border="1" id="t01">
	<%-- <c:if test= "${MemberVo.memberId eq ${vo.memberId}}"> --%>
		  <tr>
		    <th width="70" >상품 번호</th>
		    <th width="100">상품 이름</th> 
		    <th width="70">상품 수량</th>
		    <th width="70">상품 판매가격</th>
		    <th width="70">해당 판매자</th>
		    <th width="70">상품 수정</th>
		    <th width="70">상품 삭제</th>
		  </tr>
			  <c:forEach var="vo" items="${list }">
				 <tr >
				 
				    <td width="70">${vo.productNum}</td>
				    <td width="70">${vo.productName}</td>
				    <td width="70">${vo.productQunt}</td>
				    <td width="70">${vo.productPrice}</td>
				    <td width="70">${vo.productSeller}</td>
			        <td>
						<button type="button" onclick = "updateproduct('${vo.productNum}')" >수  정</button></td>
			  	 	<td>
						<button type="button" onclick="PdDelete()" >삭  제</button>
			  	 		<button type="button" onclick="elertDelete()">삭  제</button>
			  	 		
		  	  </tr>
		  	  </c:forEach>
		  	  <%-- </c:if> --%>
		  	  
	</table>
	<br/>
	</form>
</div>

			<div align="center">
		  	  <button type="button" onclick="location.href = 'main.do'">홈으로</button>&nbsp;&nbsp;
		  	  <button type="button" onclick="location.href = 'showProduct.do'">상품목록 가기</button>&nbsp;&nbsp;
			  <button type="button" onclick="location.href ='toInsertProduct.do'" >등  록</button>
		    </div>  
		    
</body>

</html>
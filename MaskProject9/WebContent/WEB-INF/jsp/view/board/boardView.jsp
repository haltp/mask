<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 내용 보기</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>문의글 내용보기</h1>
		</div>
		<table border="1">
			<tr>
				<th>게시글번호</th>
				<th>글쓴이</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<tr>
				<td align="center">${vo.boardNumber }</td>
				<td align="center">${vo.boardWriter }</td>
				<td align="center">${vo.boardTitle }</td>
				<td align="center">${vo.boardContent }</td>
				<td align="center">${vo.boardDate }</td>
				<td align="center">${vo.boardHit }</td>
			</tr>
		</table>
		<br><button type="button">수정</button>&nbsp;&nbsp;&nbsp; 
		<button type="button">삭제</button>&nbsp;&nbsp;&nbsp; 
		<input type="button" onclick="location.href = 'boardListForm.do'" value="목록">
	</div>

</body>
</html>
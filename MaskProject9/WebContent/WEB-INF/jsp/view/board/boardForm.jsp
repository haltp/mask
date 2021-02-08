	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>게시글 쓰기</title>
</head>
<body>
	<div align="center">
		<h2>작성 하기</h2>

		<form action="#" method="post">

			<table border="1">
				<tr>
					<th width="150">작성자</th>
					<td><input type="text" id="" name="" size="20"></td>
				</tr>
				<tr>
					<th width="150">제목</th>
					<td><input type="text" id="" name="" size="40"></td>
				</tr>
				<tr>
					<th width="150">비밀번호</th>
					<td><input type="password" id="" name="" size="20"></td>
				</tr>
				<tr>
					<th width="150">이메일</th>
					<td><input type="text" id="" name="" size="20"></td>
				</tr>
				<tr>
					<th width="150">내용</th>
					<td><textarea rows="10" cols="50" id="" name=""></textarea></td>
				</tr>
				<tr height="40">
					<th align="center" colspan="2">
						<input type="submit"value="글쓰기">&nbsp;&nbsp;
					 	<input type="reset" value="다시 쓰기">&nbsp;&nbsp;
						<button onclick="">전체 글보기</button>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
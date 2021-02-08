<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록하기</title>

<style type="text/css">
#title {
	height: 16;
	font-family: '돋움';
	font-size: 12;
	text-align: center;
}
</style>

</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 등록</h1>

		<form action="boardWirte.do"  method="post" 
			enctype="multipart/form-data">
			<table width="600"  border="1">
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="boardTitle"  /></td>
				</tr>
				<tr>
					<td id="title">내용</td>
					<td><textarea name="#" rows="10" cols="40" ></textarea></td>
				</tr>
				<tr>
					<td id="title">파일첨부</td>
					<td><input type="file" name="boardFile" /></td>
				</tr>

				<tr align="center" valign="middle"> <td colspan="2">
					<input type="submit" value="등록"> 
					<input type="reset" value="작성취소"> 
					<input type="button" onclick="location.href = 'boardListForm.do'" value="목록">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>
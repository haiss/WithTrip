<!--작성일 : 2017. 3. 15. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가이드 신청</title>
<script src="//cdn.ckeditor.com/4.6.2/full/ckeditor.js"></script>
</head>
<body>
	<form action="GuideModifyOK.gu" method="post" enctype="multipart/form-data">
	<table width="80%" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="name" size = "50" value="${GuideModify.name}"> </td>
			</tr>
			<tr>
				<td style="width:18%"> 패스워드 </td>
				<td> <input type="password" name="pw" size = "50" value="${GuideModify.pw}"> </td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="title" size = "50" value="${GuideModify.title}"> </td>
			</tr>
			<tr>
				<td> 리스트 이미지 </td>
				<td> <input type="file" name="listimg"> </td>
			</tr>
			<tr>
				<td> 지역 </td>
				<td> <input type="text" name="country" size = "50" value="${GuideModify.country}"> </td>
			</tr>
			<tr>
				<td> 도시 </td>
				<td> <input type="text" name="city" size = "50" value="${GuideModify.city}"> </td>
			</tr>
			<tr>
				<td> 가능언어 </td>
				<td> <input type="text" name="language" size = "50" value="${GuideModify.language}"> </td>
			</tr>
			<tr>
				<td> 가격 </td>
				<td> <input type="text" name="cost" size = "10" value="${GuideModify.cost}">원 </td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea name="content" id="editor1" rows="10" cols="80">${GuideModify.content}</textarea> 
					<script>CKEDITOR.replace('editor1');</script>
				</td> 
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="신청하기"> &nbsp;&nbsp; <a href="list.do"><input type="button" value="신청취소"></a></td>
			</tr>
	</table>
		</form>
</body>
</html>
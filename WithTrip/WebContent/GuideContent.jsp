<!--작성일 : 2017. 3. 7. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		
			
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="title" size = "50"> </td>
			</tr>
			
			<tr>
				<td> 이름 </td>
				<td>  </td>
			</tr>
			
			<tr>
				<td> 지역 </td>
				<td>  </td>
			</tr>
			
			<tr>
				<td> 가능언어 </td>
				<td>  </td>
			</tr>
			
			<tr>
				<td> 가격 </td>
				<td>원/day </td>
			</tr>
			
			<tr>
				<td> 내용 </td>
				<td> </td> 
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="list.do">목록보기</a> &nbsp;&nbsp; <a href="delete.do?bId=${content_view.bId}">삭제</a> &nbsp;&nbsp; <a href="reply_view.do?bId=${content_view.bId}">답변</a></td>
			</tr>
		</form>
	</table>
	
</body>
</html>
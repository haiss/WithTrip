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
				<td> ${ContentView.title} </td>
			</tr>
			
			<tr>
				<td> 이름 </td>
				<td> ${ContentView.name} </td>
			</tr>
			
			<tr>
				<td> 지역 </td>
				<td> ${ContentView.city}. ${ContentView.country} </td>
			</tr>
			
			<tr>
				<td> 가능언어 </td>
				<td>  ${ContentView.language}</td>
			</tr>
			
			<tr>
				<td> 가격 </td>
				<td>${ContentView.cost}원/day </td>
			</tr>
			
			<tr>
				<td> 내용 </td>
				<td> ${ContentView.content}</td> 
			</tr>
			
	</table>
	
</body>
</html>
<!--작성일 : 2017. 2. 27. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
</head>
<body>

	<% String name = (String)session.getAttribute("name");
	   String email = (String)session.getAttribute("email");
	   String pw = (String)session.getAttribute("pw");
	%>
	환영합니다 <%= name %> 님
	
	
	
	
	<a href="guidelist.gu">가이드검색</a>
	
	
</body>
</html>
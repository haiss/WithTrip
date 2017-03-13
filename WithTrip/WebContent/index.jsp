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
	<%
	if(name!=null){
	%>
	환영합니다 <%= name %> 님
	
	<a href="write.gu">가이드작성</a>
	<a href="guidelist.gu">가이드검색</a>
	<a href="MemModify.mem?email=${email}&pw=${pw}">회원정보수정</a>
	
	<%}else{
	%>
	<a href="Join.mem">회원가입</a>
	<a href="Login.jsp">로그인</a>
	<%} %>	
	
	
</body>
</html>
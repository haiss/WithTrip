<!--작성일 : 2017. 2. 21. -->
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
	<form action = "LoginOK.mem" method="post">
	아이디(E-mail) : <input type="email" name="email"> <br/>
	패스워드 : <input type="password" name="pw"><br/>
	<input type = "submit" value="로그인"> <a href="Join.mem"><input type="button" value="회원가입"></a>
	<a href="guidelist.gu"><input type="button" value="가이드리스트"></a>
	</form>
</body>
</html>
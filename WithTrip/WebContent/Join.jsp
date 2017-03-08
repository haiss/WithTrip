<!--작성일 : 2017. 2. 22. -->
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
	<form action = "JoinOK.mem" method = "post">
		아이디(E-mail) : <input type="email" name="email"><br/>
		패스워드 : <input type="password" name="pw"><br/>
		이름 : <input type="text" name="name"><br/>
		사는 지역명 : <input type="text" name="country"><br/>
		사는 도시명 : <input type="text" name="city"><br/>
		성별 : <select name="sex">
				<option  value="man">남자</option>
				<option  value="woman">여자</option>		
			</select>
		<br/>
		취미 <br/>
			
			<input type="checkbox" name="hobby" value="movie">영화<br/>
			<input type="checkbox" name="hobby" value="game">게임<br/>
			<input type="checkbox" name="hobby" value="book">독서<br/>
			<input type="checkbox" name="hobby" value="sport">스포츠<br/>
			
		<input type = "submit" value = "가입 신청"> <a href="main.html"><input type="button" value="신청 취소"></a>
		
	</form>
</body>
</html>
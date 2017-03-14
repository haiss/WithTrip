<!--작성일 : 2017. 3. 13. -->
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
<% String name = (String)session.getAttribute("name");
	   String email = (String)session.getAttribute("email");
	   String pw = (String)session.getAttribute("pw");
	   String country = (String)session.getAttribute("country");
	   String city = (String)session.getAttribute("city");
	   String sex = (String)session.getAttribute("sex");
	   String hb = (String)session.getAttribute("hobby");
	   
	   System.out.print(country+city);

	%>
<form action = "MemModifyOK.mem" method = "post">
	<input type="hidden" name="email" value="<%=email%>">
		아이디(E-mail) : <%=email %> <br/>
		패스워드 : <input type="password" name="pw" value="<%=pw %>"><br/>
		이름 : <input type="text" name="name" value="<%=name%>"><br/>
		사는 지역명 : <input type="text" name="country" value="<%=country %>"><br/>
		사는 도시명 : <input type="text" name="city" value="<%=city%>"><br/>
		성별 : <select name="sex" >
				<option  value="man">남자</option>
				<option  value="woman">여자</option>		
			</select>
		<br/>
		취미 <br/>
			<% 
			String hobbys[]=new String[4];
			
			for (int i = 0; i < hobbys.length; i++) {
				hobbys[i] = hb.substring(i, i+1);
				
			}
			
			 String hobby[] = {"movie","game","book","sport"};
			 
			 for(int i = 0;i < hobby.length;i++){
				 out.print("<input type=checkbox name=hobby ");
				 out.print("value="+hobby[i]+" "+(hobbys[i].equals("1") ? "checked" : "")+">"+hobby[i] + "<br/>");
			 }
			 
			%>
			<!-- <!-- <input type="checkbox" name="hobby" value="movie">영화<br/>
			<input type="checkbox" name="hobby" value="game">게임<br/>
			<input type="checkbox" name="hobby" value="book">독서<br/>
			<input type="checkbox" name="hobby" value="sport">스포츠<br/> --> 
			
		<input type = "submit" value = "수정완료"> <a href="index.jsp"><input type="button" value="수정 취소"></a>
		
	</form>
</body>
</html>
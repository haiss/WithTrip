<!--작성일 : 2017. 3. 6. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  
	request.setCharacterEncoding("utf-8");
	String context = request.getContextPath();
	System.out.print(context);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table {
    border: 1px solid gray;
    border-collapse: collapse;
}
img{width:180px;}
</style>
<title>가이드 검색</title>
</head>
<body>
<h1>검색된 여행지</h1>
<c:forEach items="${GuideList}" var="dto">

 <table style="width:80%; cursor:pointer;" onClick="location.href='guidecontent.gu?id=${dto.id}'" >
  <tr>
   	<td rowspan="3"><img src="<%=context%>/listimgfile/${dto.listimg}"></td>
    <td style="width:60%">${dto.city}. ${dto.country}</td>
 	<td> ${dto.id} </td>    
  </tr>
  
  <tr>
    <td>${dto.title}</td>
    <td></td>
  </tr>
  
  <tr>  	
    <td>With. ${dto.name}</td>
    <td>${dto.cost}원/day</td>
  </tr>
  
</table>
</br>
</c:forEach>
</body>
</html>
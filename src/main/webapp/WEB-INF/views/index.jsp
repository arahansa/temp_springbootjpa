<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hello world

<form method="post" action="/create">
	이름 : <input type="text" name="name" value="강용" /><br>
	주소 : <input type="text" name="address" value="인천" /><br>
	소개 : <input type="text" name="desc" value="설명" /><br>
	<input type="submit" value="확인"/>
</form>


<c:forEach items="${list.content}" var="item">
	이름 : ${item.name } , 주소 : ${item.address } , 소개 : ${item.desc } <br>
</c:forEach>

<ul class="pagination pagination-lg pull-right">
	<c:if test="${list.previous}"><li><a href="/page/${list.beginPage-1 }">«</li></c:if>
	<c:forEach var="numPage" items="${list.pages }">
		<li><a href="/page/${numPage }">${numPage}</a></li>
	</c:forEach>
	<c:if test="${list.next}"><li><a href="/page/${list.endPage+1 }">»</a></li></c:if>
</ul>



</body>
</html>
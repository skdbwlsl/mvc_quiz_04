<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>index.jsp<br>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var ="contextPath" value = "${pageContext.request.contextPath }"/>
<img src = "resources/밀양-가을여행.jpg" width="100px" height="100px">
<img src = "${contextPath }/resources/밀양-가을여행.jpg" width="100px" height="100px">
<img src = "<c:url value='/resources/밀양-가을여행.jpg'/>" width="100px" height="100px"> <!-- 절대경로 만들어줌 --><hr><img src="resources/test/sim.jpg" width="100px" height="100px">
<img src="css/밀양-가을여행.jpg" width="100px" height="100px">
	<form action="result">
		<input type="text" name= "id"><br>
		<input type="submit" value = "전송"><br>
	</form>

</body>
</html>
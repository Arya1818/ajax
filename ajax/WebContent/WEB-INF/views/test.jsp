<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="name" value="나는 request scope소속" scope ="request"/>

<% 
RequestDispatcher rd = request.getRequestDispatcher("/views/test111");
rd.forward(request,response);
%>

<a href="/views/test111">test111페이지가기</a>

</body>
</html>
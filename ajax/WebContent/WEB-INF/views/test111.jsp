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

name of req scope : ${requestScope.name} <br> 
name of req scope : <%=request.getAttribute("name") %> <br> 
name of parameter : ${param.name}		

</body>
</html>
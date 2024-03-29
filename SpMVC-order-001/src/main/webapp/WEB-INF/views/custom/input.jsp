<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>


<link href="rootPath/static/css/main.css?001" rel="stylesheet">
</head>
<body>
	<h1>고객정보 등록</h1>
	<h3>${MSG}</h3>
	<form method="POST">
		<div><input placeholder="고객코드" name="c_code" value="${CUST.c_code }"/></div>
		<div><input placeholder="고객이름" name="c_name" value="${CUST.c_name }"/></div>
		<div><input placeholder="전화번호" name="c_tel" value="${CUST.c_tel }"/></div>
		<div><input type="submit" value="저장" /></div>
		
	</form>
	
</body>
</html>
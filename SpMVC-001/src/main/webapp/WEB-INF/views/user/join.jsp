<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="${rootPath}/static/css/main.css?001" rel="stylesheet">
</head>
<body>
	<h1>회원가입페이지</h1>

	<form method="POST">
		<div><input placeholder="USERNAME" name="username"/></div>
		<div><input placeholder="비밀번호" name="password"/></div>
		<div><input placeholder="비밀번호 확인" name="re_password"/></div>
		<div><input placeholder="이름" name="name"/></div>
		<div><input placeholder="이메일" name="email"/></div>
		<div><input placeholder="전화번호" name="tel"/></div>
		<div><input type="submit" value="회원가입"/></div>
	</form>
	<p>${USER.username}
	<p>${USER.password}
	<p>${USER.name}
	<p>${USER.email}
	<p>${USER.tel}
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<!-- ${pageContext.request.contextPath } 전역변수 -->
<!-- ?001 ?002
	링크는 ?뒤에를 무시하지만
	tomcat은 무시하지않는데,
	?002라는 파일이 없기때문에 무시
	css파일을 수정하고 변경되었다는걸 알려주기위한 하나의 속임수
-->
<!-- <link href="${pageContext.request.contextPath }/static/css/main.css?002" rel="stylesheet"> -->
<link href="${rootPath}/static/css/main.css?001" rel="stylesheet">
</head>
<body>
	<header class="main">
		<h1>반갑습니다</h1>
	</header>
	<nav class="main">
		<ul>
			<li><a href="/">Home</a></li>
			<li><a href="/notice">공지사항</a></li>
			<li><a href="bbs">자유게시판</a></li>
			<li><a href="${rootPath}/user/login">로그인</a></li>
			<li><a href="${rootPath}/user/join">회원가입</a></li>
				
			
				
		</ul>
	</nav>
	
</body>
</html>

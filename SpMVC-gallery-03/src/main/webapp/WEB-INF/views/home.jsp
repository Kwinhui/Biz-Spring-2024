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



<link href="${ rootPath}/static/css/main.css" rel="stylesheet">
</head>
<body>
	<section class="main">
		<article class="image list">
		
		</article>
		<div class="image button">
		<a href="${rootPath }/insert" class="insert">갤러리 작성</a>
		</div>
	</section>
</body>
</html>
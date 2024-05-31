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
	<div><img src="${rootPath }/upload/${GALLERY.g_image}" width="200px" /></div>
	<div>
	<c:forEach items ="${GALLERY.g_images }" var="IMG" >
		<img src="${rootPath }/upload/${IMG.i_up_image}" width="100px" />
	</c:forEach>
	</div>
	<a href="${rootPath }/delete/${GALLERY.g_id}">삭제</a>
</body>
</html>
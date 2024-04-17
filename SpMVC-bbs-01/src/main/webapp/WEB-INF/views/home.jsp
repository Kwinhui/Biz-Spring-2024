<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />



<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    
<link href="${rootPath }/static/css/main.css?2024-04-17-007" rel="stylesheet">
<script src="${rootPath }/static/js/main.js?2024-04-17-001"></script>

  </head>
  <body>
  	<div class="header">
    <h1>이미지 갤러리 2024</h1>
    <ul>
    	<li>로그인</li>
    	<li>회원가입</li>
    </ul>
  	</div>
  	<nav>
  		<ul>
  			<li>Home</li>
  			<li>공지사항</li>
  			<li>자유게시판</li>
  		</ul>
  	</nav>
  	<button>이미지 업로드</button>
    
  </body>
</html>

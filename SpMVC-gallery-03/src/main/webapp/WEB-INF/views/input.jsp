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


</head>
<body>
	<link href="${rootPath}/css/input.css?001" rel="stylesheet" >
	<script src="${rootPath }/js/input.js"></script>
	<form method="post" class="image input" enctype="multipart/form-data">
		<div><input placeholder="제목" name="g_subject" /></div>
		<div><textarea placeholder="내용" rows="10" name="g_content" ></textarea></div>
		<div><input placeholder="작성자" name="g_writer" /></div>
		<div><input placeholder="비밀번호" name="g_password" type="password" /></div>
		<%-- accept : 이미지 파일만 선택해 type="file" 에 name은 VO에 있는 name과 다름 --%>
		<div><input type="file" multiple="multiple" accept="image/*" name="files" id="files"/></div>
		<div class="represent"><img src="${rootPath }/images/noImage.png" class="represent" /></div>
		<div class="thumnail"></div>
		<div><input type="submit" value="저장" /></div>
	</form>

</body>
</html>
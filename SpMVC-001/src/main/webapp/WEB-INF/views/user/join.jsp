<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath ��� ������ �����ؼ� value�� ���� ��ڴ� -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="${rootPath}/static/css/main.css?001" rel="stylesheet">
</head>
<body>
	<h1>ȸ������������</h1>

	<form method="POST">
		<div><input placeholder="USERNAME" name="username"/></div>
		<div><input placeholder="��й�ȣ" name="password"/></div>
		<div><input placeholder="��й�ȣ Ȯ��" name="re_password"/></div>
		<div><input placeholder="�̸�" name="name"/></div>
		<div><input placeholder="�̸���" name="email"/></div>
		<div><input placeholder="��ȭ��ȣ" name="tel"/></div>
		<div><input type="submit" value="ȸ������"/></div>
	</form>
	<p>${USER.username}
	<p>${USER.password}
	<p>${USER.name}
	<p>${USER.email}
	<p>${USER.tel}
	
</body>
</html>
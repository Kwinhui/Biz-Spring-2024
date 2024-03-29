<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/WEB-INF/views/includes/head.jspf"%>

<body>
<%@ include file="/WEB-INF/views/includes/header.jspf"%>
	
	<h1>${not empty PD_LIST ? "상품정보 수정" : "상품정보 등록" }</h1>
	
	
	<form method="POST">
		<div><input placeholder="상품코드" name="p_code" value="${PD_LIST.p_code}"/></div>
		<div><input placeholder="상품이름" name="p_name" value="${PD_LIST.p_name}"/></div>
		<div><input placeholder="상품종류" name="p_item" value="${PD_LIST.p_item}"/></div>
		<div><input placeholder="상품가격" name="p_price" value="${PD_LIST.p_price}"/></div>
		<div><input type="submit" value="저장" /></div>

</body>
</html>
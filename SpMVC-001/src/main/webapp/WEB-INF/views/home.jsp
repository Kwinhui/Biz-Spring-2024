<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/WEB-INF/views/includes/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jspf"%>
	

	<section class="w3-container w3-cell-row w3-padding-16">
		<article class="w3-container w3-cell w3-purple">상품정보</article>
		<article class="w3-container w3-cell w3-teal">주문정보</article>
		<article class="w3-container w3-cell w3-yellow">거래처정보</article>

	</section>



</body>
</html>

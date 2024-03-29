<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>

<html lang="ko">
<%@ include file="/WEB-INF/views/includes/head.jspf"%>
<style>
	table.w3-table-all {
		width: 80%;
		margin: 10px auto;
		
	}
	div.btn_box {
		display: block;
		width:80%;
		margin: 5px auto;
		text-align: right;
		padding: 0; 
		
		
	}
</style>
<script>const rootPath = "${rootPath}"</script>

<script src="${rootPath }/static/js/product.js?001"></script>

<body>
<%@ include file="/WEB-INF/views/includes/header.jspf"%>
<div class="w3-container btn_box">
			<a href="${rootPath}/product/insert" class="w3-button w3-blue w3-round">상품 추가</a>
	<table class="w3-table-all w3-hoverable">
		<thead>
		<tr>
			<th>상품코드</th>
			<th>상품이름</th>
			<th>상품종류</th>
			<th>상품가격</th>
		</tr>
		</thead>
		
			<tbody class="tbody">
			<c:forEach items="${PD_LIST }" var="PRODUCT">
			<tr data-pcode="${PRODUCT.p_code}">
				<td>${PRODUCT.p_code}</td>
				<td>${PRODUCT.p_name}</td>
				<td>${PRODUCT.p_item}</td>
				<td>${PRODUCT.p_price}</td>
			</tr>
		</c:forEach>
		</tbody>
		
	
	</table>

		
			
		</div>



</body>
</html>
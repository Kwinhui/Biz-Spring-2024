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
		width: 70%;
		margin: 10px auto;
		
	}
	div.btn_box {
		display: block;
		width:70%;
		margin: 5px auto;
		text-align: right;
		padding: 0; 
		
		
	}
</style>
<body>
<%@ include file="/WEB-INF/views/includes/header.jspf"%>
	<table class="w3-table-all w3-hoverable">
		<tr>
			<th>주문코드</th>
			<th>주문일자</th>
			<th>주문고객코드</th>
			<th>고객이름</th>
			<th>고객번호</th>
		</tr>
		
		<c:forEach items="${OD_LIST }" var="ORDER">
			<tr>
				<td>${ORDER.o_num }</td>
				<td>${ORDER.o_date }</td>
				<td>${ORDER.o_ccode }</td>
				<td>${ORDER.c_name}</td>
				<td>${ORDER.c_tel}</td>
			</tr>
		
		</c:forEach>
		
	
	
	</table>




</body>
</html>
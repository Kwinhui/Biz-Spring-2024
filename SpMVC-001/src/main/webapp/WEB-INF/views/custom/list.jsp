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
	<div class="w3-container w3-padding-24 w3-center">
		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>SEQ</th>
				<th>고객코드</th>
				<th>고객이름</th>
				<th>전화번호</th>
			</tr>
			
			<c:forEach items="${CUST_LIST }" var="CUST" varStatus="VAR">
				<tr>
				<!-- c_code 와 같은 변수명은 CustomVO 와 같음 -->
					<td>${VAR.index}, ${VAR.count}</td>
					<td>${CUST.c_code }</td>
					<td>${CUST.c_name}</td>
					<td>${CUST.c_tel }</td>
				</tr>
			</c:forEach>
		</table>
		<div class="w3-container btn_box">
			<a href="${rootPath}/customer/insert" class="w3-button w3-blue w3-round">고객 추가</a>
			
		</div>
		
		<ul>		
		
		
		
		<% /*
		이 주석은 소스에서 안보이고 오류가 적음 
		for(int VAR = 1; VAR <=100; i += 2){
			print(VAR);
		}
		*/ %>
		<!-- 이 주석은 소스에서 보임 -->
		<c:forEach begin="1" end="100" step="2" var="VAR">
		
			<li>${VAR }</li>
		
		</c:forEach>
		
		</ul>
		
			
			
	</div>
</html>
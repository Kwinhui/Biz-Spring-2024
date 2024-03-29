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
		tr:hover {
			cursor:pointer;
		}
		
	}
	div.btn_box {
		display: block;
		width:70%;
		margin: 5px auto;
		text-align: right;
		padding: 0; 
		
		
	}
</style>
<script>
	// js 파일을 Link 하여 사용할 경우
	// JSP 에서 선언된 ${rootPath} 는 사용할 수 없다.
	// JS 파일을 Link 하기 전에 var 키워드를 사용하여
	// 모든 JS 에서 사용할 수 있도록 변수를 선언해 둔다.
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/customer.js?2024-03-29-002"></script>
<!-- script는 절대로 셀프클로징 X  -->

<body>
	<%@ include file="/WEB-INF/views/includes/header.jspf"%>
	<div class="w3-container w3-padding-24 w3-center">
		<table class="w3-table-all w3-hoverable">
			<thead>
			<tr>
				<th>SEQ</th>
				<th>고객코드</th>
				<th>고객이름</th>
				<th>전화번호</th>
			</tr>
			</thead>
			<tbody class="cust_body">
			<c:forEach items="${CUST_LIST }" var="CUST" varStatus="VAR">
				<tr data-ccode="${CUST.c_code }">
				<!-- c_code 와 같은 변수명은 CustomVO 와 같음 -->
					<td>${VAR.index}, ${VAR.count}</td>
					<td>${CUST.c_code }</td>
					<td>${CUST.c_name}</td>
					<td>${CUST.c_tel }</td>
				</tr>
			</c:forEach>
			</tbody>
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
		<% /*<c:forEach begin="1" end="100" step="2" var="VAR">
		
			<li>${VAR }</li>
		
		</c:forEach>*/ %>
		
		</ul>
		
			
			
	</div>
</html>
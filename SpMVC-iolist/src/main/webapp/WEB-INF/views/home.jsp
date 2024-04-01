<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/includes/head.jspf"%>
<script>
const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/home.js?001" ></script> 
<link href="rootPath/static/css/main.css?001" rel="stylesheet">
<body>
<%@ include file="/WEB-INF/views/includes/header.jspf"%>
<a href="${rootPath}/insert" class="w3-button w3-blue w3-round">상품 추가</a>
	<table class="w3-table-all w3-hoverable">
		<thead>
			<tr>
				<th>SEQ</th>
				<th>일자</th>
				<th>시각</th>
				<th>상품명</th>
				<th>구분</th>
				<th>매입단가</th>
				<th>판매단가</th>
				<th>수량</th>
				<th>매입합계</th>
				<th>판매합계</th>
			
			</tr>
			
		</thead>
			<tbody class="tbody">
			<c:set var="totalPurchase" value ="0" />
			<c:set var="totalSales" value ="0" />
			<c:forEach items="${ioList }" var="IOLIST">
			<c:set var="totalPurchase" value="${totalPurchase + (IOLIST.io_iprice * IOLIST.io_quan)}" />
			<c:set var="totalSales" value="${totalSales + (IOLIST.io_oprice * IOLIST.io_quan)}" />
			
			<tr data-io_seq = "${IOLIST.io_seq }">
				<td>${IOLIST.io_seq }</td>
				<td>${ IOLIST.io_date }</td>
				<td>${IOLIST.io_time}</td>
				<td>${IOLIST.io_pname }</td>
				<td>${IOLIST.io_input}</td>
				<td>${IOLIST.io_iprice}</td>
				<td>${IOLIST.io_oprice}</td>
				<td>${IOLIST.io_quan}</td>
				<td>${IOLIST.io_quan * IOLIST.io_iprice}</td>
				<td>${IOLIST.io_quan * IOLIST.io_oprice}</td>
				
				

			</tr>
</c:forEach>	
    <tr>
    	<td></td>
        <td colspan="7">합계</td>
    	
        <td>${totalPurchase}</td>
        <td>${totalSales}</td>

    </tr>		
			
			</tbody>
		
			
			
		
		
	</table>



</body>
</html>
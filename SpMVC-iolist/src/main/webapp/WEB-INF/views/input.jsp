<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/includes/head.jspf"%>
<style>
	form.product {
		width:60%;
		margin:20px auto;
		div {
			display : flex;
			label {
			flex:1;
			text-align: right;
			
			}
			input {
			margin : 8px;
			flex:3;
			}
		}
		
	}
</style>





<body>
<%@ include file="/WEB-INF/views/includes/header.jspf"%>


	<h1>상품추가</h1>
	
	<form method="POST" class="product">
	<div><label>현재날짜</label><input name="io_date" class="toDate" value="${ioList.io_date != null ? ioList.io_date : currentDate}" readonly="readonly"></div>
	<div><label>현재시간</label><input name="io_time" class="toTime" value="${ioList.io_time != null ? ioList.io_time : currentTime }" readonly="readonly"></div>
	<div><label>상품명</label><input name="io_pname" value="${ioList.io_pname}"></div>
	<div><label>구분</label><input name="io_input" value="${ioList.io_input}"></div>
	
	<div><label>매입단가</label><input name="io_iprice" value="${ioList.io_iprice }"></div>
	<div><label>매출단가</label><input name="io_oprice" type="text" value="${ioList.io_oprice }"></div>
	<div><label>수량</label><input name="io_quan" value="${ioList.io_quan}"></div>
	<div><label></label><input type="submit" value ="저장"/></div>		
	</form>
</body>
</html>
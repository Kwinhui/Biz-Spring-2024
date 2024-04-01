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
<script src="${rootPath }/static/js/detail.js?003"></script>


<body>
<%@ include file="/WEB-INF/views/includes/header.jspf"%>


<main class="w3-container">
		<div class="w3-card-4 w3-dark-gray" >
			<div class="w3-container w3-center">
				<h3>${ioList.io_pname}</h3>
				
				<h5><span>매입단가 </span>${ioList.io_iprice}</h5>
				<h5><span>매출단가 </span>${ioList.io_oprice}</h5>
				
				
			<div class="w3-section">
				<input type="button" value="수정" class="btn_update w3-button w3-green " data-io_seq = "${ioList.io_seq }"/>
				<input type="button" value="삭제" class="btn_delete w3-button w3-red " data-io_seq = "${ioList.io_seq }"/>
				
			</div>
			</div>
			
			
		</div>
	
	
	</main>
</body>
</html>
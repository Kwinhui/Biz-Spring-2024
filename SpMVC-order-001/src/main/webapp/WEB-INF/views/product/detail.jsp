<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html>

<%@ include file="/WEB-INF/views/includes/head.jspf"  %>
<style>
	div.w3-card-4 {
		width:50%;
		margin:20px auto;
		
	}
</style>




<script>


	const rootPath = "${rootPath}"
</script>
<script src="${rootPath }/static/js/product.js?2024-03-29-001"></script>


<body>
<%@ include file="/WEB-INF/views/includes/header.jspf"  %>	
	<main class="w3-container">
		<div class="w3-card-4 w3-dark-gray" >
			<div class="w3-container w3-center">
				<h3>${PD_LIST.p_name}</h3>
				
				<h5>${PD_LIST.p_code }</h5>
				<h5>${PD_LIST.p_item }</h5>
				<h5>${PD_LIST.p_price}</h5>
				
			<div class="w3-section">
				<input type="button" value="수정" class="btn_update w3-button w3-green "/>
				<input type="button" value="삭제" class="btn_delete w3-button w3-red " />
				
			</div>
			</div>
			
			
		</div>
	
	
	</main>

</body>
</html>
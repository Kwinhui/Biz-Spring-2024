<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html lang="ko">
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
	
	<form method="POST" class="product">
		<fieldset>
		<legend>상품등록</legend>
		<div><label>상품코드</label><input name="p_code"/></div>
		<div><label>상품명</label><input name="p_name"/></div>
		<div><label>품목</label><input name="p_item"/></div>
		<div><label>가격</label><input name="p_price" /></div>
		<div><label></label><input type="submit" value ="저장"/></div>
</fieldset>		

	</form>
</body>
</html>
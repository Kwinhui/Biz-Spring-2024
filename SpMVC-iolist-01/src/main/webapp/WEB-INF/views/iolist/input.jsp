<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->

<form class="iolist input" method="POST">
	<fieldset>
	<legend>매입매출등록</legend>
	<div><label>거래일자</label><input name="io_date" type="date" value="${IO.io_date}" /></div>
	<div><label>거래시각</label><input name="io_time" type="time" value="${IO.io_time}" /></div>
	<div><label>상품명</label><input name="io_pname"/></div>
	<div><label>거래구분</label>
	<select name="io_input">
	<!-- 매입을 선택히면 1이 io_input에 담김 -->
		<option value="1">매입</option>
		<option value="2">매출</option>
	</select>
	</div>
	<div><label>단가</label><input name="io_price" /></div>
	<div><label>수량</label><input name="io_quan" /></div>
	<div><label>합계</label><input name="io_total" /></div>
	<div><label></label><input type="submit" value="저장"/></div>
</fieldset>
</form>


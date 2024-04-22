<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<section class="gallery">
	<article class="gallery">
		<f:form>
			<fieldset>
				<legend>이미지 업로드</legend>
				<div><input placeholder="작성일자" /></div>
				<div><input placeholder="작성시각" /></div>
				<div><input placeholder="작성자" /></div>
				<div><input placeholder="제목" /></div>
				<div><textarea rows="5" placeholder="이미지 설명"></textarea></div>
				<div><input type="submit" value="저장"/></div>
			</fieldset>
		
		</f:form>	
	</article>

</section>
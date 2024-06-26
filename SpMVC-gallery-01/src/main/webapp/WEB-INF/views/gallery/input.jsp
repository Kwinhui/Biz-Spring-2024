<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<link rel="stylesheet" href="${rootPath }/static/css/gallery.css?04-22-001">
<script src="${rootPath }/static/js/gallery_input.js?04-22-003"></script>
<section class="gallery">
	<article class="gallery">
		<f:form>
			<fieldset>
				<legend>이미지 업로드</legend>

				<div><input placeholder="제목" name="g_subject"/></div>
				<div><textarea rows="5" placeholder="이미지 설명" name="g_content"></textarea></div>
				<div class="image"><img class="gallery" src="${rootPath}/static/images/3.jpg" width="100px"/></div>
				<!-- image파일만 허용 -->
				<input type="file" class="file" accept="image/*"/>
				<div><input type="submit" value="저장"/></div>
				<textarea rows="10" class="base64" name="g_image"></textarea>
			</fieldset>
		
		</f:form>	
	</article>

</section>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>

<style>
	form.login {
		margin:10px auto;
		width: 50%;	
	}
	form.login div {
		display:flex;
	}
	form.login label {
		flex:1;
	}
	
	form.login input {
		flex:2;
	}
	form.login button {
		flex:2;
	}
</style>



</head>
<body>
	<!-- spring form tag 는 method 기본값이 POST  -->
	<f:form class="form login">
		<!-- spring security는 post로 보낼때 반드시 token을 가지고오게 함 -->
		<!-- 주소에 login?error 가 있으면 -->
		<c:if test="${param.error != null }" >Invalid User.</c:if>
		<!-- Exception 메세지가 나타남 -->
		<!-- c:remove 저 변수를 삭제해라 세션을 지워줘야함
			그렇지 않으면 해커에 의해 서버가 터질수있음 
		 -->
		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION  != null}">
			${SPRING_SECURITY_LAST_EXCEPTION.message }
			<c:remove var="SPRING_SECURITY_LAST_EXCEPTION"/>
		</c:if>	
	
		<div><label>UserName</label><input name="u_name" /></div>
		<div><label>Password</label><input name="u_password" /></div>
		<div><label></label><button type="submit">Log in</button></div>
	</f:form>
	
	
</body>
</html>
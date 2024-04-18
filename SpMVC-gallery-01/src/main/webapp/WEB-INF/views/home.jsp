<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
  
  <tiles:insertAttribute name="head" /> <!-- 이 위치에 head attribute를 include 해라 -->
  
  <body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="nav" />
    <tiles:insertAttribute name="content" />
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
	<title>nLoo</title>
	<link rel="stylesheet" type="text/css" href="/static/css/nloo.css?3" media="all">
</head>
<body>
<div id="ct">
	<div class="spot">
		<a href="/building/<c:out value="${ viewInfo.buildingSequence }"/>"><h1><c:out value="${ viewInfo.buildingName }"/></h1></a>
		<h2><c:out value="${ viewInfo.floor }"/> : <c:out value="${ viewInfo.sex }"/></h2>
	</div>
	<div class="section1">
		<c:forEach items="${viewInfo.rooms}" var="room" varStatus="i">
		<div class="sr">
			<div><c:out value="${ room.nickName }"/> : <c:out value="${ room.status }"/></div>
			<c:if test="${room.status == 'USE'}">
				<a href="#">사용아님 상태로 변경하기</a>
			</c:if>
			<c:if test="${room.status == 'UNUSE'}">
				<a href="#">사용중 상태로 변경하기</a>
			</c:if>
			<c:if test="${room.status == 'FIX'}">
				<span>현재 사용불가능</span>
			</c:if>
		</div>
		</c:forEach>
	</div>
	<div class="section2">
	</div>
</div>	
</body>
</html>
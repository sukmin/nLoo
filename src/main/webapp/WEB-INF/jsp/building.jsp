<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>nLoo</title>

<link href="/static/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/nloo.css?1" rel="stylesheet">
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
    <div class="container">
        <div class="page-header">
            <a href="/index"><h1>
                    <c:out value="${ viewInfo.buildingName }" />
                </h1></a>
        </div>

        <div class="list-group">
            <c:forEach items="${viewInfo.sections}" var="section" varStatus="i">
                <a href="/section/${section.sectionSequence}" class="list-group-item">
                    <h4 class="list-group-item-heading">
                        <c:out value="${section.floor}" />
                        :
                        <c:out value="${section.nickName}" />
                    </h4>
                    <p class="list-group-item-text">
                    <ul class="list-group">
                        <li class="list-group-item"><span class="badge">노크수 ${section.currentKnockCount}</span> 사용/전체 : ${section.useRoomCount}/${section.roomCount}</li>
                    </ul>
                    </p>
                </a>
            </c:forEach>
        </div>
    </div>

    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>
</html>
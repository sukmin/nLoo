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
            <a href="tables"><h1>
                    Tables
<%--                     ${tables} --%>
                </h1></a>
        </div>
<div class="panel panel-default">

  <div class="panel-heading">Tables : <span class="badge">${fn:length(tables)}</span> row(s) returned</div>

	<!-- Table -->
	<table class="table">
		<thead>
			<tr>
			<th>TABLE_NAME</th>
			<th>TABLE_ROWS</th>
			<th>AUTO_INCREMENT</th>
			<th>Model And Query Link</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tables}" var="map">
			<tr>
			<td><a href="table-info/${map['TABLE_NAME']}">${map['TABLE_NAME']}</a></td>
			<td>${map["TABLE_ROWS"]}</td>
			<td>${map["AUTO_INCREMENT"]}</td>
			<td><a href="model-and-query/${map['TABLE_NAME']}">View</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">

    </script>
</body>
</html>
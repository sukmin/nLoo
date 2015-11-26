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
            <a href="/tables"><h1>
                    Table : ${tableName}
<%--                     ${tables} --%>
                </h1></a>
        </div>


		<div class="panel panel-default">
		  <div class="panel-heading">Columns : <span class="badge">${fn:length(tableInfo)}</span> row(s) returned</div>

			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
					<th>ORDINAL_POSITION</th>
					<th>DATA_TYPE</th>
					<th>COLUMN_NAME</th>
					<th>CHARACTER_MAXIMUM_LENGTH</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tableInfo}" var="map">
					<tr>
					<td>${map["ORDINAL_POSITION"]}</td>
					<td>${map["DATA_TYPE"]}</td>
					<td>${map["COLUMN_NAME"]}</td>
					<td>${map["CHARACTER_MAXIMUM_LENGTH"]}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
    	</div>
    </div>
    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">

    </script>
</body>
</html>
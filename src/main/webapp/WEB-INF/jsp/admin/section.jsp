<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>U.R.Gent 1</title>

<link href="/static/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/nloo.css?1" rel="stylesheet">
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
    <div class="container">
        <div class="page-header"><a href="/admin/sections">
            <h1>Section</h1></a>
        </div>

        <div class="panel panel-default well well-lg">
            <div class="panel-body">
				<form:form commandName="section" action="/admin/section/add" name="form1">

				<form:hidden path="sequence"/>
					<div class="input-group">
					  <form:input type="text" class="form-control" path="buildingSequence" placeholder="building sequence" aria-describedby="sizing-addon2" />
					  <form:input type="text" class="form-control" path="floor" placeholder="4F" aria-describedby="sizing-addon2" />
					  <form:input type="text" class="form-control" path="sex" placeholder="M or F" aria-describedby="sizing-addon2" />
					  <form:input type="text" class="form-control" path="nickName" placeholder="nickName" aria-describedby="sizing-addon2" />
					</div>
					<div class="panel-body">
					<button type="submit" class="btn btn-default">Save Changes</button>
					<button type="reset" name="newSection" class="btn btn-info" onclick="setAddForm();" disabled="disabled">Reset</button>
					<button type="submit" name="deleteSection" class="btn btn-danger" onclick="setDeleteForm();" disabled="disabled">Delete</button>
					</div>
				</form:form>
			</div>
		</div>


		<div class="panel panel-default">

		  <div class="panel-heading">Result : <span class="badge">${fn:length(sections)}</span> row(s) returned</div>

			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
					<th>sequence</th>
					<th>buildingSequence</th>
					<th>floor</th>
					<th>sex</th>
					<th>nickName</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${sections}" var="section">
						<tr id="${section.sequence}" onclick="setUpdateForm('${section.sequence}');">
							<td><c:out value="${section.sequence}"/></td>
							<td><c:out value="${section.buildingSequence}"/></td>
							<td><c:out value="${section.floor}"/></td>
							<td><c:out value="${section.sex}"/></td>
							<td><c:out value="${section.nickName}"/></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>


    </div>
    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
	var projectUrl = '<c:url value="/"/>';
	if(projectUrl.indexOf(";", 0) != -1){
		projectUrl = projectUrl.substring(0, projectUrl.indexOf(";", 0));
	}

    var sequence;
    var addUrl = "admin/section/add";
    var deleteUrl = "admin/section/delete";
    var updateUrl = "admin/section/update";

    function setUpdateForm(element){
    	sequence = document.form1.sequence.value;
    	trElement = document.getElementById(element);
    	document.form1.sequence.value = element;
    	document.form1.buildingSequence.value = trElement.children[1].innerHTML;
    	document.form1.floor.value = trElement.children[2].innerHTML;
    	document.form1.sex.value = trElement.children[3].innerHTML;
    	document.form1.nickName.value = trElement.children[4].innerHTML;
    	document.form1.newSection.disabled = false;
    	document.form1.deleteSection.disabled = false;
    	document.form1.action = projectUrl + updateUrl;
    }

    function setAddForm(){
    	document.form1.sequence.value = sequence;
    	document.form1.name.value = "";
    	document.form1.newSection.disabled = true;
    	document.form1.deleteSection.disabled = true;
    	document.form1.action = projectUrl + addUrl;
    }

    function setDeleteForm() {
    	document.form1.action = projectUrl + deleteUrl;
    	return true;
    }


    </script>
</body>
</html>
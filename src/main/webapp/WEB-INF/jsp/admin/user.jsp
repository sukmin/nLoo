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
            <h1>User</h1></a>
        </div>

        <div class="panel panel-default well well-lg">
            <div class="panel-body">
				<form:form commandName="user" action="/admin/user/add" name="userForm">

				<form:hidden path="id"/>
				<table>
					<tr><td colspan="2" align="left"><form:errors path="*" cssStyle="color : red;"/></td></tr>
					<tr><td>Name : </td><td><form:input path="name" /></td></tr>
					<tr><td>Standard : </td><td><form:input path="standard" /></td></tr>
					<tr><td>Age : </td><td><form:input path="age" /></td></tr>
					<tr><td>Sex : </td><td><form:select path="sex">
							<form:option value="Male"/>
							<form:option value="Female"/>
					</form:select></td></tr>
					<tr><td colspan="2"><input type="submit" value="Save Changes"/>
					&nbsp;<input type="reset" name="newUser" value="New User" onclick="setAddForm();" disabled="disabled"/>
					&nbsp;<input type="submit" name="deleteUser" value="Delete User" onclick="setDeleteForm();" disabled="disabled"/></td></tr>
				</table>
				</form:form>
			</div>
		</div>



		<div class="panel panel-default">

		  <div class="panel-heading">Tables : <span class="badge">${fn:length(users)}</span> row(s) returned</div>

			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
					<th>name</th>
					<th>standard</th>
					<th>age</th>
					<th>sex</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${users}" var="user">
						<tr id="${user.id}" onclick="setUpdateForm('${user.id}');">
							<td><c:out value="${user.name}"/></td>
							<td><c:out value="${user.standard}"/></td>
							<td><c:out value="${user.age}"/></td>
							<td><c:out value="${user.sex}"/></td>
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

    function changeSelectValue(selectNode, value){
    	for(var index=0;index<selectNode.length;index++){
    		if(selectNode[index].value == value)
    			selectNode.selectedIndex = index;
    	}
    }

    var newUserId;
    var addUrl = "admin/user/add";
    var deleteUrl = "admin/user/delete";
    var updateUrl = "admin/user/update";

    function setUpdateForm(element){
    	newUserId = document.userForm.id.value;
    	trElement = document.getElementById(element);
    	document.userForm.id.value = element;
    	document.userForm.name.value = trElement.children[0].innerHTML;
    	document.userForm.standard.value = trElement.children[1].innerHTML;
    	document.userForm.age.value = trElement.children[2].innerHTML;
    	changeSelectValue(document.userForm.sex, trElement.children[3].innerHTML);
    	document.userForm.newUser.disabled = false;
    	document.userForm.deleteUser.disabled = false;
    	document.userForm.action = projectUrl + updateUrl;
    }

    function setAddForm(){
    	document.userForm.id.value = newUserId;
    	document.userForm.name.value = "";
    	document.userForm.standard.value = "";
    	document.userForm.age.value = "";
    	changeSelectValue(document.userForm.sex, "Male");
    	document.userForm.newUser.disabled = true;
    	document.userForm.deleteUser.disabled = true;
    	document.userForm.action = projectUrl + addUrl;
    }

    function setDeleteForm() {
    	document.userForm.action = projectUrl + deleteUrl;
    	return true;
    }


    </script>
</body>
</html>
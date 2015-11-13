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
		<div class="sr-group">
			<div class="sr-info" data-seq="<c:out value="${ room.secretRoomSequence }"/>"><c:out value="${ room.nickName }"/> : <c:out value="${ room.status }"/></div>
			<c:if test="${room.status == 'USE'}">
				<a href="#" class="sr a_use" data-seq="<c:out value="${ room.secretRoomSequence }"/>">사용아님 상태로 변경하기</a>
			</c:if>
			<c:if test="${room.status == 'UNUSE'}">
				<a href="#" class="sr a_unuse" data-seq="<c:out value="${ room.secretRoomSequence }"/>">사용중 상태로 변경하기</a>
			</c:if>
			<c:if test="${room.status == 'FIX'}">
				<span >현재 사용불가능</span>
			</c:if>
		</div>
		</c:forEach>
	</div>
	<div class="section2">
	</div>
</div>
<form>
	<input type="hidden" id="sectionSequence" value="<c:out value="${ viewInfo.sectionSequence }"/>">
</form>
<script type="text/javascript" src="/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

var oDataManager = {
		
		/*멤버*/
		sUseClassName : "a_use",
		sUseSelector : null,
		sUnuseClassName : "a_unuse",
		sUnuseSelector : null,
		nSectionSequence : jQuery("#sectionSequence").val(),
		nCallDelay : 1000,
		
		/*메소드*/
		use : function(nSeq){
			var oSelf = this;
			
			jQuery.ajax({
				url: "/secret-room/use",
				async: true,
				dataType : "json",
				data : { "secretRoomSequence" : nSeq },
				type: 'post',
				success : function(oResponse){
					if( oResponse.code != "SR001"){
						alert(oResponse.message);
					}
				}
			});
			
		},
		unuse : function(nSeq){
			var oSelf = this;
			
			jQuery.ajax({
				url: "/secret-room/unuse",
				async: true,
				dataType : "json",
				data : { "secretRoomSequence" : nSeq },
				type: 'post',
				success : function(oResponse){
					if( oResponse.code != "SR001"){
						alert(oResponse.message);
					}
				}
			});
		},
		start : function(){
			var oSelf = this;
			jQuery.ajax({
				url: "/section/info",
				async: true,
				dataType : "json",
				type: 'get',
				data : { "sectionSequence" : oDataManager.nSectionSequence },
				success : function(oResponse){
					if( oResponse.code == "S001"){
						jQuery.each(oResponse.rooms,function(index,obj){
							jQuery(".sr-info[data-seq='"+ obj.secretRoomSequence +"']").html(obj.nickName + ":" + obj.status);
							var $sr = jQuery(".sr[data-seq='"+ obj.secretRoomSequence +"']");
							$sr.removeClass(oDataManager.sUseClassName + " , " + oDataManager.sUnuseClassName);
							if (obj.status == "USE"){
								$sr.addClass(oDataManager.sUseClassName);
								$sr.html("사용아님 상태로 변경하기");
							} else if (obj.status =="UNUSE"){
								$sr.addClass(oDataManager.sUnuseClassName);
								$sr.html("사용중 상태로 변경하기");
							}
						});
					}
					setTimeout(oDataManager.start,oDataManager.nCallDelay);
				},
				error : function(){
					setTimeout(oDataManager.start,oDataManager.nCallDelay);
				}
				
			});
			
		},
		init : function(){
			
			var oSelf = this;
			
			oSelf.sUseSelector = "." + oSelf.sUseClassName;
			oSelf.sUnuseSelector = "." + oSelf.sUnuseClassName;
			jQuery(document).on("click",oSelf.sUseSelector,function(event){
				
				event.preventDefault();
				var nSeq = jQuery(this).data("seq");
				oSelf.unuse(nSeq);
				
			});
			
			jQuery(document).on("click",oSelf.sUnuseSelector,function(event){
				
				event.preventDefault();
				var nSeq = jQuery(this).data("seq");
				oSelf.use(nSeq);
				
			});
			
			oSelf.start();
			
		}
};

jQuery(document).ready(function(){
	oDataManager.init();
});

</script>
</body>
</html>
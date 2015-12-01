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
            <a href="/${ viewInfo.sequence }"><h1>
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

        <div class="panel panel-default">
            <div class="panel-heading text-center" id="div_refresh_text">20초 후 자동 새로고침..</div>
            <div class="panel-body">
                <div class="progress">
                    <div id="div_refresh_progressbar" class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="20" style="width: 0%">
                        <span id="span_refresh_progressbar_sr" class="sr-only">0%</span>
                    </div>
                </div>
                <div>
                    <button type="button" class="btn btn-default btn-lg btn-block" id="button_refresh">지금 새로고침!</button>
                </div>
            </div>
        </div>


    </div>
    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    		var oRefreshManager = {
    				/*멤버*/
    				sRefreshUrl : "/index",
    				sButtonSelector : "#button_refresh",
    				sTextSelector : "#div_refresh_text",
    				sProgressbarSelector : "#div_refresh_progressbar",
    				sProgressbarSrSelector : "#span_refresh_progressbar_sr",
    				nMax : 20,
    				nValue : 0,
    				nPercent : 0,
    				nIntervalTime : 1000,
    				oInterval : null,
    				/*메소드*/
    				refresh : function(){
    					var oSelf = this;
					location.href = oSelf.sRefreshUrl;
    				},
    				calcurate : function(){
    					var oSelf = this;
    					return oSelf.nValue / oSelf.nMax * 100;
    				},
    				drawText : function(nWaitTime){
    					var oSelf = this;
    					jQuery(oSelf.sTextSelector).html(nWaitTime + "초 후 자동 새로고침..");
    				},
    				drawSr : function(nPercent){
    					var oSelf = this;
    					jQuery(oSelf.sProgressbarSrSelector).html(nPercent+"%");
    				},
    				drawProgress : function(nPercent,nValue){
    					var oSelf = this;
    					jQuery(oSelf.sProgressbarSelector).attr("aria-valuenow",nValue);
    					jQuery(oSelf.sProgressbarSelector).css("width", nPercent + "%");
    				},
    				start: function(){
    					var oSelf = this;
    					setInterval(function(){
    						oSelf.nValue++;
    						if(oSelf.nMax <= oSelf.nValue){
    							oSelf.refresh();
    							return false;
    						}
    						var nPercent = oSelf.calcurate();
    						oSelf.drawText(oSelf.nMax - oSelf.nValue);
    						oSelf.drawSr(nPercent);
    						oSelf.drawProgress(nPercent,oSelf.nValue);
    					},oSelf.nIntervalTime)
    				},
    				init : function(){

    					var oSelf = this;

    					jQuery(oSelf.sButtonSelector).click(function(event){

    						event.preventDefault();
    						oSelf.refresh();

    					});

    					oSelf.start();
    				}
    		};

    		jQuery(document).ready(function(){
    			oRefreshManager.init();
    		});
    </script>
</body>
</html>
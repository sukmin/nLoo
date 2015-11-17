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
            <a href="/index/${ viewInfo.buildingSequence }"><h1>
                    <c:out value="${ viewInfo.buildingName }" />
                </h1></a> <a href="/section/${ viewInfo.sectionSequence }">
                <h3>
                    <c:out value="${ viewInfo.floor }" />
                    :
                    <c:out value="${ viewInfo.nickName }" /> [쾌적하군요]<!-- [청소가필요해요] --> <span onClick="alert('꽤적하다+한표')" class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
                    <span onClick="alert('청소해주세요+한표')" class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>
                </h3>
            </a>
        </div>

        <div class="list-group">
            <c:forEach items="${viewInfo.rooms}" var="room" varStatus="i">
                <div class="list-group-item">
                    <div class="row">
                        <div class="col-xs-6">
                            <h4 class="list-group-item-heading">
                                <c:out value="${room.nickName}" />
                            </h4>
                            <p class="list-group-item-text">
                                <c:if test="${room.status == 'USE'}">
                                    <span class="glyphicon glyphicon-flash"> 현재 사용중!</span>
                                </c:if>
                                <c:if test="${room.status == 'UNUSE'}">
                                    <span class="glyphicon glyphicon-heart-empty"> 비어있습니다!</span>
                                </c:if>
                                <c:if test="${room.status == 'FIX'}">
                                    <span class="glyphicon glyphicon-exclamation-sign"> 이용불가!</span>
                                </c:if>
                            </p>
                        </div>
                        <div class="col-xs-6">
                            <c:if test="${room.status == 'USE'}">
                                <button type="button" class="btn btn-success button_use" data-seq="${room.secretRoomSequence}">나갑니다! <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></button>
                            </c:if>
                            <c:if test="${room.status == 'UNUSE'}">
                                <button type="button" class="btn btn-warning button_unuse" data-seq="${room.secretRoomSequence}">들어가요! <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span></button>
                            </c:if>
                            <c:if test="${room.status == 'FIX'}">
                                <button type="button" class="btn btn-info" disabled="disabled">이용불가! <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span></button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="panel panel-default well well-lg">
            <div class="panel-body">
                <p>최근 15분사이에 ${ viewInfo.currentKnockCount } 명이 노크하였습니다.</p>
                <a class="btn btn-danger btn-lg" href="#" role="button" id="a_knock">나도 노크하기!</a>
            </div>
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
                    <button type="button" class="btn btn-default btn-lg btn-block" id="button_refresh"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></button>
                </div>
            </div>
        </div>

    </div>
<!--     <div class="embed-responsive embed-responsive-16by9">
  		<iframe class="embed-responsive-item" src="//www.youtube.com/embed/zpOULjyy-n8?rel=0" allowfullscreen=""></iframe>
	</div> -->

    <input type="hidden" id="sectionSequence" value="<c:out value="${ viewInfo.sectionSequence }"/>">
    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    var oDataManager = {

        /*멤버*/
        sUseClassName : "button_use",
        sUseSelector : null,
        sUnuseClassName : "button_unuse",
        sUnuseSelector : null,
        nSectionSequence : jQuery("#sectionSequence").val(),

        /*메소드*/
        use : function(nSeq) {
            var oSelf = this;

            jQuery.ajax({
                url : "/secret-room/use",
                async : true,
                dataType : "json",
                data : {
                    "secretRoomSequence" : nSeq
                },
                type : 'post',
                success : function(oResponse) {
                    if (oResponse.code != "SR001") {
                        alert(oResponse.message);
                    }
                    location.href = "/section/" + oSelf.nSectionSequence;
                }
            });

        },
        unuse : function(nSeq) {
            var oSelf = this;

            jQuery.ajax({
                url : "/secret-room/unuse",
                async : true,
                dataType : "json",
                data : {
                    "secretRoomSequence" : nSeq
                },
                type : 'post',
                success : function(oResponse) {
                    if (oResponse.code != "SR001") {
                        alert(oResponse.message);
                    }
                    location.href = "/section/" + oSelf.nSectionSequence;
                }
            });
        },
        init : function() {

            var oSelf = this;

            oSelf.sUseSelector = "." + oSelf.sUseClassName;
            oSelf.sUnuseSelector = "." + oSelf.sUnuseClassName;

            jQuery(document).on("click", oSelf.sUseSelector, function(event) {

                event.preventDefault();
                var nSeq = jQuery(this).data("seq");
                oSelf.unuse(nSeq);

            });

            jQuery(document).on("click", oSelf.sUnuseSelector, function(event) {

                event.preventDefault();
                var nSeq = jQuery(this).data("seq");
                oSelf.use(nSeq);

            });

        }
    };

    var oKnockManager = {
    		/*멤버*/
    		sKncokButtonSelector : "#a_knock",
    		nSectionSequence : jQuery("#sectionSequence").val(),
    		/*메소드*/
    		knock : function(){
    			var oSelf = this;
    			jQuery.ajax({
                    url : "/section/knock",
                    async : true,
                    dataType : "json",
                    data : {
                        "sectionSequence" : oSelf.nSectionSequence
                    },
                    type : 'post',
                    success : function(oResponse) {
                        if (oResponse.code != "S001") {
                            alert(oResponse.message);
                        }
                        location.href = "/section/" + oSelf.nSectionSequence;
                    }
                });
    		},
    		init : function(){
    			var oSelf = this;

    			jQuery(oSelf.sKncokButtonSelector).click(function(event){

    				event.preventDefault();
    				oSelf.knock();

    			});
    		}
    };

    var oRefreshManager = {
			/*멤버*/
			sRefreshUrl : "/section/" + jQuery("#sectionSequence").val(),
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

    jQuery(document).ready(function() {
        oDataManager.init();
        oKnockManager.init();
        //oRefreshManager.init();
    });
</script>
</body>
</html>
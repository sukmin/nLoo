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
        <div class="page-header">
<%--
            <a href="/index/${ viewInfo.buildingSequence }">
            	<h1><c:out value="${ viewInfo.buildingName }" /></h1>
            </a>

 --%>       <a href="/section/${ viewInfo.sectionSequence }">
                <h3>
                    <c:out value="${ viewInfo.floor }" />
                    :
                    <c:out value="${ viewInfo.nickName }" /> <!--[쾌적하군요] [청소가필요해요]  <span onClick="alert('꽤적하다+한표')" class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
                    <span onClick="alert('청소해주세요+한표')" class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span> -->
                	<a href="/index/${ viewInfo.buildingSequence }">
                		<small>[<c:out value="${ viewInfo.buildingName }" />]</small>
                	</a>
                </h3>
            </a>
        </div>

        <div class="list-group">
            <c:forEach items="${viewInfo.rooms}" var="room" varStatus="i">
                <div class="list-group-item">
                    <div class="row">
                        <div class="col-xs-7">
                            <h5 class="list-group-item-heading">
                                <c:out value="${room.nickName}" />

                                <c:if test="${room.status == 'USE'}">
                                    <span class="glyphicon glyphicon-flash"></span>사용중!
                                </c:if>
                                <c:if test="${room.status == 'UNUSE'}">
                                    <span class="glyphicon glyphicon-heart-empty"></span>비어있습니다!
                                </c:if>
                                <c:if test="${room.status == 'FIX'}">
                                    <span class="glyphicon glyphicon-exclamation-sign"></span>이용불가!
                                </c:if>
                            </h5>
                        </div>
                        <div class="col-xs-5">
                            <c:if test="${room.status == 'USE'}">
                                <button type="button" class="btn btn-success button_use" data-seq="${room.secretRoomSequence}">나갑니다! <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></button>
                            </c:if>
                            <c:if test="${room.status == 'UNUSE'}">
                                <button type="button" class="btn btn-warning btn-xs button_unuse" data-seq="${room.secretRoomSequence}">들어가요! <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span></button>
                            </c:if>
                            <c:if test="${room.status == 'FIX'}">
                                <button type="button" class="btn btn-info btn-xs" disabled="disabled">이용불가! <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span></button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="panel panel-default">
            <div class="panel-body">
                <p>최근 15분  <span class="badge">${ viewInfo.currentKnockCount }</span> 명이 급해요.</p>
                <a class="btn btn-danger btn-lg" href="#" role="button" id="a_knock">Urgent !! BANG!! BANG!!</a>
            </div>
        </div>

		<div class="alert alert-danger" role="alert">
			<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>
			<span class="sr-only">Error:</span>
			unlike 많은 낙서는 <span class="glyphicon glyphicon-scissors"></span> 지웁니다.&nbsp;화장실도 청결하게, 감정배설도 청결하게.
		</div>

		<div class="panel panel-default">
			<form name="graffitiForm" onsubmit="oGraffitiManager.add()">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="graffiti : very fine" id="comment" aria-describedby="basic-addon2">
				<span type="submit" class="input-group-addon button_graffiti_add" id="basic-addon2">좋은낙서&nbsp;<span class="badge">${fn:length(graffitis)}</span></span>
			</div>
			</form>
			<!-- Table -->
			<table class="table">
				<tbody>

					<c:forEach items="${graffitis}" var="graffiti">
						<tr>
							<td>
								<span id="comments"><c:out value="${graffiti.comment}"/></span>
								<button class="btn btn-success btn-xs glyphicon glyphicon-thumbs-up button_graffiti_like" data-seq="${graffiti.sequence}" type="button"></button>
							</td>
							<td align="right">
								<button class="btn btn-warning btn-xs button_graffiti_unlike right" data-seq="${graffiti.sequence}" type="button">
								<span class="glyphicon glyphicon-thumbs-down"></span>&nbsp;<span class="badge">${graffiti.unlikeCount}</span></button>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>
    </div>


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

    var oGraffitiManager = {

            /*멤버*/
            sAddClassName : "button_graffiti_add",
            sLikeClassName : "button_graffiti_like",
            sUnlikeClassName : "button_graffiti_unlike",
    		nSectionSequence : jQuery("#sectionSequence").val(),

            add : function() {
                var oSelf = this;
                var graffiti = jQuery("#comment").val();
                if(graffiti.trim().length == 0) {
                	graffiti = "very fine";
                }

                jQuery.ajax({
                    url : "/graffiti/user-add",
                    async : true,
                    dataType : "json",
                    data : {
                        "sectionSequence" : oSelf.nSectionSequence,
                        "comment" : graffiti
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
            like : function(nCommentSeq) {
                var oSelf = this;

                jQuery.ajax({
                    url : "/graffiti/user-like",
                    async : true,
                    dataType : "json",
                    data : {
                        "sequence" : nCommentSeq
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
            unlike : function(nCommentSeq) {
                var oSelf = this;

                jQuery.ajax({
                    url : "/graffiti/user-unlike",
                    async : true,
                    dataType : "json",
                    data : {
                        "sequence" : nCommentSeq
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
            init : function() {

                var oSelf = this;

                oSelf.sAddSelector = "." + oSelf.sAddClassName;
                oSelf.sLikeSelector = "." + oSelf.sLikeClassName;
                oSelf.sUnlikeSelector = "." + oSelf.sUnlikeClassName;

                jQuery(document).on("click", oSelf.sAddSelector, function(event) {
                    event.preventDefault();
                    oSelf.add();
                });

                jQuery(document).on("click", oSelf.sLikeSelector, function(event) {
                    event.preventDefault();
                    var nSeq = jQuery(this).data("seq");
                    oSelf.like(nSeq);
                });

                jQuery(document).on("click", oSelf.sUnlikeSelector, function(event) {
                    event.preventDefault();
                    var nSeq = jQuery(this).data("seq");
                    oSelf.unlike(nSeq);
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
        /* oRefreshManager.init(); */
        oGraffitiManager.init();

    });
</script>
</body>
</html>
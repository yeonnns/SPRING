<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jennie Project Main</title>
<link rel="icon" type="image/png" sizes="32x32" href="/www/img/favicon/favicon-32x32.png">
<link rel="stylesheet" type="text/css" href="/www/css/w3.css">
<link rel="stylesheet" type="text/css" href="/www/css/base.css">
<script type="text/javascript" src="/www/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/www/js/main.js"></script>
<style>
	h5, span {
		height: 20px;
		line-height: 30%;
	}
	.pdh10 > h5 {
		font-size: 10.5pt;
	}
	.pdb3 {
		padding-bottom: 3px;
	}
	
	.mt10 h5 {
		margin-top: 0px;
		margin-bottom: 2px;
	}
	.mt10 {
		margin-top: 30px;
	}
	
	#msgWin {
		display: block;
	}
</style>
<script type="text/javascript">
	var sessionId = '${SID}';
</script>
</head>
<body>
	<form method="POST" action="" id="frm" name="frm">
		<input type="hidden" id="id" name="id" value="${SID}">
	</form>
	
	<div class="w3-content w3-center mw700">
		<h1 class="w3-blue w3-padding w3-card-4" style="margin-bottom: 5px;">GITHRD Project</h1>
		<div class="w3-col">
<c:if test="${empty SID}">
				<div class="w3-col w3-border-bottom pdb3">
					<span class="w3-col m2 w3-button w3-small w3-lime w3-hover-green w3-left" id="jbtn">Join</span>
					<span class="w3-col m2 w3-button w3-small w3-blue w3-hover-light-blue w3-right" id="lbtn">Login</span>
				</div>
</c:if>
				<div class="w3-col" id="btnfr">
<c:if test="${not empty SID}">
					<div class="w3-col w3-border-bottom pdb3">
						<span class="w3-cell m2 w3-button w3-small w3-red w3-hover-light-green w3-right mt0" id="obtn">LogOut</span>
						<span class="w3-cell m2 w3-button w3-small w3-red w3-hover-light-green w3-left mt0" id="ibtn">내정보 보기</span>
					</div>
</c:if>
<c:if test="${not empty SID and SCOUNT ne 0}">
				<div class="w3-col">
					<p class="w3-right-align"><small>* 현재 진행중인 설문중 참여하지 않은 설문이 [ <span class="w3-text-blue">${SCOUNT}</span> ]개 있습니다.</small></p>
				</div>
</c:if>

					<div class="w3-col mt10">
						<div class="w3-col m3 pdh10">
							<h5 class="w3-col w3-button w3-purple w3-hover-amber" id="mlbtn">회원목록</h5>
						</div>
						<div class="w3-col m3 pdh10">
							<h5 class="w3-col w3-button w3-pink w3-hover-light-green" id="gbtn">방명록</h5>
						</div>
<c:if test="${not empty SID}">
						<div class="w3-col m3 pdh10">
							<h5 class="w3-col w3-button w3-red w3-hover-light-green" id="sbtn">설문조사</h5>
						</div>
</c:if>
						<div class="w3-col m3 pdh10">
							<h5 class="w3-col w3-button w3-deep-orange w3-hover-light-green" id="rbtn">댓글게시판</h5>
						</div>

						<div class="w3-col m3 pdh10">
							<h5 class="w3-col w3-button w3-orange w3-hover-light-green" id="fbtn">파일게시판</h5>
						</div>
					</div>
				</div>
		</div>
	</div>

<c:if test="${(not empty SID) and (MSG_CHECK eq 'OK')}">
	<div id="msgWin" class="w3-modal">
	    <div class="w3-modal-content w3-animate-top w3-card-4">
			<header class="w3-container w3-blue"> 
		        <span class="w3-button w3-display-topright" id="msgClose">&times;</span>
		        <h2>알림 메세지</h2>
			</header>
	    	<div class="w3-container">
	        	<h3 class="w3-center w3-margin-top w3-margin-bottom" id="msg">${SID} 님 로그인 하셨습니다.</h3>
	    	</div>
	    </div>
 	</div>
</c:if>
</body>
</html>
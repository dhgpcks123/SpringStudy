<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/cls/js/survey.js"></script>
</head>
<body>
	<div class="w3-content w3-center mw700">
		<h1 class="w3-padding w3-blue w3-card-4">진행중인 설문 조사</h1>
		<div class="w3-col w3-padding w3-margin-top w3-card-4">
			<form class="w3-col w3-padding" method="POST" action="/cls/survey/survey.cls" id="frm">
				<input type="hidden" name="sno" id="sno">
				<c:forEach var="data" items="${LIST}">
					<div class="w3-col m9 w3-text-blue txt14"><b>${data.sbody}</b></div>
					<div class="w3-col m2 w3-right pdh10">
					<c:if test="${data.cnt eq 0}">
						<div class="w3-button w3-indigo w3-hover-blue sibtn h20 lineH30" id="${data.sno}">참 여</div>
					</c:if>
					<c:if test="${data.cnt ne 0}">
						<div class="w3-button w3-deep-orange w3-hover-pink srbtn h20 lineH30" id="r${data.sno}">결과보기</div>
					</c:if>
					</div>
				</c:forEach>
			</form>
		</div>
	</div>
</body>
</html>
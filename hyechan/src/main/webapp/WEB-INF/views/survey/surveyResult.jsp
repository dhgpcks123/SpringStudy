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
		<h1 class="w3-padding w3-blue">설 문 결 과</h1>
		<div class="w3-col w3-padding w3-card-4">
			<h4 class="w3-col w3-border-bottom w3-text-blue">${LIST.get(0).sbody}</h4>
			<div class="w3-col w3-padding w3-left-align w3-border-bottom">
				<!-- 문항추가 -->
<!-- 문항번호 변수 만들기 -->
<c:set var="no" value="${0}" />
<c:forEach var="data" items="${LIST}" varStatus="st">
	<c:if test="${data.upno == 0}">
		<c:set var="no" value="${no + 1}" />
		<!-- 보기번호 변수 만들기 -->
		<c:set var="subno" value="${0}" />
				
		<c:if test="${st.index == 0}">
				<div class="w3-col w3-margin-bottom">
					<div class="w3-col txt14">${no}. ${data.qbody}</div>
		</c:if>
		<c:if test="${st.index != 0}">
				</div>
				<div class="w3-col w3-margin-bottom">
					<div class="w3-col txt14">${no}. ${data.qbody}</div>
		</c:if>
	</c:if><!-- 문제 닫고 -->
	
	<!-- 보기 만들고 -->
	<c:if test="${data.upno != 0}">
		<c:set var="subno" value="${subno + 1}" />
					<div class="w3-col pdl30">
						<div class="w3-col txt11">${subno}) ${data.qbody}</div>
						<div class="w3-col m10 l10 pdr10 pdl23" style="height: 7px;">
							<div class="w3-col ${COLOR.list[(no+1)*3]}" style="width: ${data.per}%; height: 7px;"></div>
						</div>
						<div class="w3-col m2 l2 ${COLOR.textList[(no+1)*3]} w3-right ptxt">${data.per}%</div>
					</div>
	</c:if>
</c:forEach>
				</div>
			</div>
			<div class="w3-col w3-margin-top">
				<div class="w3-half w3-button w3-green w3-hover-lime" id="hbtn">HOME</div>
				<div class="w3-half w3-button w3-blue w3-hover-aqua" id="sibtn">설문조사메인</div>
			</div>
		</div>
	</div>
</body>
</html>
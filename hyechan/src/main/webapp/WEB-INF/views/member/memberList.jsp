<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.mw600 > div').css('height', '50px');
		$('.mw600 > div').removeClass('w3-margin-top');
		$('.mw600 > div').addClass('w3-input');
		
		$('.member').click(function(){
			var sno = $(this).attr('id');
			$('#mno').val(sno);
			
			//form태그 전송
			$('#frm').submit();
			
		})
	});
</script>
</head>
<body>
	<form action="/cls/member/memberInfo.cls" id="frm" method="POST">
		<input type="hidden" name="mno" id="mno">
	</form>
	<div class="w3-content w3-center mw600">
		<h1 class="w3-center w3-padding w3-deep-purple">회원리스트</h1>
	<c:forEach var="data" items="${LIST}" varStatus="st">
		<div class="w3-col m2 w3-button ${COLOR[st.index]} w3-margin-bottom w3-margin-top member"
				id="${data.mno}">${data.name}</div>
	</c:forEach>
	</div>
</body>
</html>
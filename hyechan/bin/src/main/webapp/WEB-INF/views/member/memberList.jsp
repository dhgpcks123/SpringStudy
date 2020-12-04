<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.mw600 > div').css('height', '50px');
		$('.mw600 > div').removeClass('w3-margin-top');
		$('.mw600 > div').addClass('w3-input');

		$('.member').click(function() {

			/*
			// 동기처리방식
			var sno = $(this).attr('id');
			$('#mno1').val(sno);
			$('#frm').submit();
			//form태그 전송
			$('#frm').submit();
			*/
			
			var sno = $(this).attr('id');
			$('#infoContainer').stop().slideUp(200, function(){
				$('.indata').text('');
				//비동기처리방식
				$.ajax({
					url: '/cls/member/memberInfo2.cls',
					type: 'POST',
					dataType: 'json',
					data: {
						mno: sno
					},
					success: function(obj){
						$('#sname').text(obj.name);
						$('#name').text(obj.name);
						$('#tno').text(obj.mno);
						$('#mno2').val(obj.mno);
						$('#id').text(obj.id);
						$('#mail').text(obj.mail);
						var gender = (obj.gen == 'M' ? '남자' : '여자');
						$('#gen').text(gender);
						$('#jdate').text(obj.sdate);
						$('#avt').attr('src', '/cls/avatar/' + obj.avatar);
						$('#infoContainer').stop().slideDown(500);
					},
					error: function(){
						alert('### 서버연결 실패 ###');
					}
				});
			});
		})
	});
</script>
</head>
<body>
	<form action="/cls/member/memberInfo.cls" id="frm" method="POST">
		<input type="hidden" name="mno" id="mno1">
	</form>
	<div class="w3-content w3-center mw800">
		<div class="w3-col">
		<h1 class="w3-center w3-padding w3-deep-purple">회원리스트</h1>
		<c:forEach var="data" items="${LIST}" varStatus="st">
			<div
				class="w3-col m2 w3-button ${COLOR[st.index]} w3-margin-bottom w3-margin-top member"
				id="${data.mno}">${data.name}</div>
		</c:forEach>
		</div>
	</div>
	<div class="w3-col margin-top" id="infoContainer" style="display: none;">
		<h1 class="w3-teal w3-card-4">
			[ <span id="sname" class="indata"></span> ] 님 회원 정보
		</h1>
		<div class="w3-col w3-border-bottom pdb10">
			<span
				class="w3-cell m2 w3-button w3-small w3-green w3-hover-lime w3-left mt0 btnBox"
				id="hbtn">Home</span> <span
				class="w3-cell m2 w3-button w3-small w3-orange w3-hover-deep-orange w3-right mt0 btnBox"
				id="iebtn">정보수정</span> <span
				class="w3-cell m2 w3-button w3-small w3-red w3-hover-pale-red w3-right mt0 btnBox"
				id="dbtn">탈 퇴</span>
		</div>
		<form method="POST" action="/cls/member/memberDel.cls" id="dfrm"
			name="dfrm" style="display: none;"
			class="w3-col w3-card-4 w3-padding w3-margin-bottom">
			<input type="hidden" name="mno" id="mno2"> <label for="pw"
				class="w3-col m3 w3-text-grey ft18px">비밀번호 : </label> <input
				type="password" id="pw" name="pw"
				class="w3-col m7 w3-input w3-border">
			<div class="w3-col m2 pdh10">
				<div
					class="w3-col w3-button w3-medium w3-red w3-hover-orange w3-left mt0"
					id="del">탈퇴처리</div>
			</div>
		</form>
		<div class="w3-col w3-card-4 w3-margin-top w3-padding">
			<div class="w3-col">
				<div class="w3-col w250 pd10">
					<div class="w3-border infoAvtBox">
						<img class="infoAvtBox" id="avt">
					</div>
				</div>
				<div class="w3-rest pdr10">
					<div class="w3-col w3-display-container contBox">
						<div class="w3-col w3-display-middle">
							<div class="w3-col w3-text-grey ft18px mh3">
								<span class="w3-third w3-right-align">회원번호 : </span>
								<span class="w3-twothird w3-center indata" id="tno"></span>
							</div>
							<div class="w3-col w3-text-grey ft18px mh3">
								<span class="w3-third w3-right-align">회원이름 : </span>
								<span class="w3-twothird w3-center indata" id="name"></span>
							</div>
							<div class="w3-col w3-text-grey ft18px mh3">
								<span class="w3-third w3-right-align">아 이 디 : </span>
								<span class="w3-twothird w3-center indata" id="id"></span>
							</div>
							<div class="w3-col w3-text-grey ft18px mh3">
								<span class="w3-third w3-right-align">회원메일 : </span>
								<span class="w3-twothird w3-center indata" id="mail"></span>
							</div>
							<div class="w3-col w3-text-grey ft18px mh3">
								<span class="w3-third w3-right-align">회원성별 : </span>
								 <span class="w3-twothird w3-center indata" id="gen"></span>
							</div>
							<div class="w3-col w3-text-grey ft18px mh3">
								<span class="w3-third w3-right-align">가 입 일 : </span>
								<span class="w3-twothird w3-center indata" id="jdate"></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
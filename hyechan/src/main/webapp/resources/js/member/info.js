$(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href', '/cls/main.cls');
	});
	$('#iebtn').click(function(){
		$('#frm').stop().slideToggle(300);
	});
	
	$('#ebtn').click(function(){
		// 할일
		// 데이터 읽어오고
		// 회원번호
		var sno = $('#no').text();
		// 원데이터
		var omail = $('#cMail').text();
		var oavt = $('.infoAvtBox > img').eq(0).attr('id');
		var reid = oavt;
		var tsrc = $('.infoAvtBox > img').eq(0).attr('src');
		var imgsrc = tsrc.substring(tsrc.lastIndexOf('/'));
		// 수정데이터
		var tmail = $('#mail').val();
		var tavt = $('.avt:checked').val();
		
		if(!tavt){
			tavt = oavt;
		} else {
			var tmp = $('.avt:checked').next().children().eq(0).attr('src');
			imgsrc = tmp.substring(tmp.lastIndexOf('/'));
			reid = $('.avt:checked').next().children().eq(0).attr('id');
		}
		
		$.ajax({
			url: '/cls/member/memberEdit.cls',
			type: 'POST',
			dataType: 'text',
			data: {
//				mno: sno,
				mail: tmail,
				avt: tavt
			},
			success: function(obj){
				// obj 는 텍스트 문서이고 우리는 이 문서에 변경된 데이터갯수를 입력해두기로 하자.
				// 따라서 회원정보가 변경이 되면 "1" 이 문서에 기록되고 반대의 경우는 "0"이 기록될 것이다.
				if(obj == 1){
					// 이 경우는 수정에 성공한 경우
					$('#cMail').text(tmail);
					$('.infoAvtBox > img').eq(0).attr('src', '/cls/img/avatar' + imgsrc);
					$('.infoAvtBox > img').eq(0).attr('id', reid);
					
					// 수정창 안보이게 처리하고
					$('#frm').stop().slideUp(500);
				} else {
					// 문제 있는 경우
					// 함수실행을 즉시 종료하고 수정작업을 다시 해야된다.
					return;
				}
			},
			error: function(){
				alert('### 통신 실패 ###');
			}
		});
	});
	
	// 회원 탈퇴 처리
	$('#dbtn').click(function(){
		// 비밀번호 입력창 보이게 하고
		$('#dfrm').stop().slideDown(300);
	});
	
	$('#del').click(function(){
		var spw = $('#pw').val();
		
		if(!spw){
			$('#pw').focus();
			return;
		}
		/*
		// 동기 방식 처리
		
		$('#dfrm').submit();
		*/
		
		// 비동기 방식 처리
		var sno = $('#no').val();
		$.ajax({
			url: '/cls/member/ajaxDel.cls',
			type: 'POST',
			dataType: 'json',
			data: {
				no: sno,
				pw: spw
			},
			success: function(obj){
				// obj = { 'result': 'OK'};
				if(obj.result == 'OK'){
					// 탈퇴처리 완료된 경우
					$(location).attr('href', '/cls/main.cls');
				} else {
					// 탈퇴처리가 안된 경우
					$(location).attr('href', '/cls/member/memberInfo.cls');
				}
			},
			error: function(){
				alert('*** 통신 실패 ***');
			}
		});
	});
});




















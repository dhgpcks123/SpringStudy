$(document).ready(function(){
	$('.btnBox').click(function(){
		var tid = $(this).attr('id');
		var target = '';
		switch(tid){
		case 'hbtn':
			// 따로 해줄일 없음
			target = '/cls/main.cls';
			break;
		case 'lbtn':
			// 로그인버튼
			target = '/cls/member/login.cls';
			break;
		case 'jbtn':
			// 회원가입버튼
			target = '/cls/member/join.cls';
			break;
		case 'obtn':
			// 로그아웃버튼
			target = '/cls/member/logout.cls';
			break;
		case 'rbtn':
			// 리셋버튼
			$('#body').val('');
			return;
			break;
		case 'wbtn':
			// 글등록버튼
			$('#frm').attr('method', 'POST');
			$('#frm').attr('action', '/cls/guestBoard/gBoardWrite.cls');
			// 입력데이터 읽어오고
			var txt = $('#body').val();
			if(!txt){
				$('#body').focus();
				return;
			}
			
			$('#frm').submit();
			return;
			break;
		}
		
		$(location).attr('href', target);
	});
	
	$('.pagebtn').click(function(){
		var str = $(this).text();
		
		var sPage = $(this).attr('id');
		if(!sPage){
			sPage = str;
		}
		
		/*
		var pcode = str.charCodeAt(str);
		var sPage = '';
		if(pcode == 171){ // <<
			sPage = $(this).attr('id');
		} else if(pcode == 187){ // >>
			sPage = $(this).attr('id');
		} else {
			sPage = str;
		}
		*/
		/*
		// 1. GET 방식 전송
		$(location).attr('href', '/cls/guestBoard/gBoardList.cls?nowPage=' + sPage);
		*/
		
		// 2. POST 방식 전송
		// 파라미터 셋팅 부터 하고
		$('#nowPage').val(sPage);
		// form 태그 전송하고
		$('#gfrm').submit();
	});
});


















$(document).ready(function(){
	/*
	$('#lbtn').click(function(){
		$(location).attr('href', '/cls/member/login.cls');
	});
	$('#obtn').click(function(){
		$(location).attr('href', '/cls/member/logout.cls');
	});
	
	document.getElementById('jbtn').onclick = function(){
		location.href = '/cls/member/join.cls';
	};
	*/
	$('.w3-button').click(function(){
		var tmp = $(this).attr('id');
		var spath = '';
		switch(tmp){
			case 'lbtn':
				spath = '/cls/member/login.cls';
				break;
			case 'obtn':
				spath = '/cls/member/logout.cls';
				break;
			case 'jbtn':
				spath = '/cls/member/join.cls';
				break;
			case 'ibtn':
				$('#frm').submit();
				return;
				break;
			case 'gbtn':
				spath = '/cls/guestBoard/guestBoard.cls';
				break;
			case 'irbtn':
				spath = '/cls/reBoard/initRBD.cls';
				break;
			case 'rbtn':
				spath = '/cls/reBoard/reBoardList.cls';
				break;
			case 'fbtn':
				spath = '/cls/board/boardList.cls';
				break;
			case 'sbtn':
				spath = '/cls/survey/surveyInfo.cls';
				break;
		}
		
		$(location).attr('href', spath);
	});
	
});

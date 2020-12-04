$(document).ready(function(){
	$('#btn1').click(function(){
		$(location).attr('href', '/cls/main.cls');
	});
	$('#btn2').click(function(){
		// 할일
		// 1. 입력한 데이터 읽고
		var sid = $('#id').val();
		var spw = $('#pw').val();
		
		if(!(sid && spw)){
			return;
		}
		
		$('#frm').submit();
	});
});
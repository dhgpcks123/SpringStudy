$(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href','/cls/reBoard/reBoard.cls');
	});
	
	$('#wrbtn').click(function(){
		if(		$('#body').val() == null ){
			alert('본문의 내용을 입력하세요')
			return;
		}
		$('#frm').submit();
	});
	$('#rbtn').click(function(){
		$('#body').val('');
	})
});
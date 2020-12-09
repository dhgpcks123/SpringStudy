$(document).ready(function(){
	$('#cbtn').click(function(){
		$('#frm').attr('action', '/cls/reBoard1/reBoardList.cls');
		$('#frm').submit();
	});
	$('#rbtn').click(function(){
		$('#body').val('');
	});
	$('#wrbtn').click(function(){
		var str = $('#body').val('');
		if(!str) return;
		
		$('#frm').submit();
	});
	
});
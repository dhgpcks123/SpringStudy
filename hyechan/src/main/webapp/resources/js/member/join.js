$(document).ready(function(){
	// 아이디체크버튼 처리
	$('#idck').click(function(){
		// 할일
		// 1. 아이디 입력값을 알아낸다.
		var sid = $('#id').val();
		
		if(!sid){
			return;
		}
		
		// 데이터를 서버에 보내서 응답을 받는다. 비동기통신으로
		$.ajax({
			url: '/cls/member/idCheck.cls',
			type: 'POST',
			dataType: 'json',
			data: {
				id: sid
			},
			success: function(data){
				if(data.result == 'OK'){
					// 사용가능한 아이디인 경우
					$('#idmsg').html('*** 사용가능한 아이디 입니다! ***');
					$('#idmsg').removeClass('w3-text-red');
					$('#idmsg').addClass('w3-text-blue');
					$('#idmsg').stop().slideDown(500);
				} else {
					// 사용 불가능한 아이디인 경우
					$('#idmsg').html('### 사용가능할 수 없는 아이디 입니다! ###');
					$('#idmsg').removeClass('w3-text-blue');
					$('#idmsg').addClass('w3-text-red');
					$('#idmsg').stop().slideDown(500);
				}
			},
			error: function(){
				alert('### 통신 에러 ###');
			}
		});
	});
	
	// 성별 선택하면 성별맞는 아바타 선택창 보여주는 기능 처리
	$('.gen').click(function(){
		// 할일
		// 1. 무슨 성별이 선택됬는지 알아낸다.
		var sgen = $(this).val();
		
		if(sgen == 'M'){
			$('.avtFfr').stop().slideUp(100);
			$('.avtMfr').stop().slideDown(300);
		} else if(sgen == 'F'){
			$('.avtMfr').stop().slideUp(100);
			$('.avtFfr').stop().slideDown(300);
		}
	});
	
	// 비밀번호 확인 기능
	$('#repw').keyup(function(){
		// 할일
		// 1. 비밀번호 읽어오고
		var spw = $('#pw').val();
		// 2. 확인번호 읽어오고
		var srepw = $(this).val();
		// 3. 비교하고
		if(spw == srepw){
			// 4. 결과 처리하고
			$('#pwmsg').css('color', 'green');
			$('#pwmsg').html('*** 비밀번호가 일치합니다! ***');
			$('#pwmsg').stop().show();
			setTimeout(hidePwTag, 1500);
		} else {
			$('#pwmsg').css('color', 'red');
			$('#pwmsg').html('### 비밀번호가 다릅니다! ###');
			$('#pwmsg').stop().show();
		}
	});
	
	function hidePwTag(){
		$('#repw').parent().parent().stop().slideUp(300);
	}
	
	// 회원이름 정규식 검사
	$('#name').change(function(){
		var sname = $(this).val();
		
		var pattern = /^[가-힣]{2,10}$/;
		
		var result = pattern.test(sname);
		if(!result){
			$('#name').removeClass('w3-pale-blue');
			$('#name').addClass('w3-pale-red');
			$('#name').focus();
		} else {
			$('#name').removeClass('w3-pale-red');
			$('#name').addClass('w3-pale-blue');
		}
	});
	
	// 비밀번호 정규식 검사
	$('#pw').keyup(function(){
		// 비밀번호는 영문대소문자 각 1개씩 숫자 1개 특수문자(#@!$%&-_) 1개
		// 가 반드시 한개씩 포함되는 형식을 사용하기로 한다.
		
		// 입력내용 알아내고
		var spw = $(this).val();
		
		// 정규식 패턴 만들고
		var pattern = /^[0-9]{3,}$/;
//		var pattern = /^.*(?=^[a-zA-Z0-9#@!$%&-_*]{8,})(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#@!$%&-_*]).*$/;
		// 검사하고
		var result = pattern.test(spw);
		// 결과로 처리하고
		if(result){
			$(this).removeClass('w3-pale-red');
			$(this).addClass('w3-teal');
		} else {
			$(this).removeClass('w3-teal');
			$(this).addClass('w3-pale-red');
		}
	});
	
	// 버튼 이벤트 처리
	// 홈버튼
	$('#hbtn').click(function(){
		$(location).attr('href', '/cls/main.cls');
	});
	
	// 회원가입처리 버튼
	$('#jbtn').click(function(){
		
	/*
	//(동기 방식 처리)
		// 할일
		// 데이터 유효성 검사하고
		var sid = $('#id').val();
		var spw = $('#pw').val();
		var sname = $('#name').val();
		var smail = $('#mail').val();
		var tel = $('#tel').val();
		var sgen = $('.gen:checked').val();
		var savt = $('.avt:checked').val();
		
		if(!(sid && spw && sname && smail && tel && sgen && savt)){
			// 입력하지 않은 태그가 적어도 한개가 존재하므로
			return;
		}
		
		$('#frm').attr('method', 'POST'); 
		$('#frm').attr('action', '/cls/member/joinProc.cls'); 
		
		$('#frm').submit();
		
	*/
	//(비동기 방식 처리)
		// 할일
		// form 태그 객체를 읽어와서 formData 를 만들어준다.
		// 비동기 통신에서 form태그를 전송할 경우
		// 해당 form 태그의 encType 속성이 반드시 기술되어야 한다.
		// 이거 공부한 이유??? 비동기통신으로 파일도 전송하기 위함
		var el = $('#frm');
//		multipart cls-context에 설정하고 이거는 잠궈놨음.
//		$(el).attr('encType', 'multipart/form-data');
//		$(el).append('<input type="hidden" name="aProc value="OK">');
		var formData = new FormData($(el)[0]);

		$.ajax({
			url: '/cls/member/joinProc.cls',
			type: 'POST',
			dataType: 'text',
			processData: false,
			contentType: false,
			data:formData,
			success: function(obj){
				alert('*** 성공 메세지 : ' + obj);
				if(obj =='OK'){
					$(location).attr('href', '/cls/main.cls');
				} else{
					alert('*** 회원가입 실패 ***');
				}
			},
			error: function(){
				alert('### 통신 실패 ###')				
			}
		});
	});
});











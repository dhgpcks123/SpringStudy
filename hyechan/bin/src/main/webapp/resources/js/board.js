var resize = function(el){
	let w = el.naturalWidth;
	let h = el.naturalHeight;
	$(el).addClass((w >= h) ? 'imgsrc2w' : 'imgsrc2h');
};
$(document).ready(function(){
	$('.brow').click(function(){
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		$('#bfrm').attr('action', '/cls/board/boardDetail.cls');
		$('#bfrm').submit();
	});
	
	$('.pagebtn').click(function(){
		// 버튼 내용 알아내고
		var strPage = $(this).attr('id');
		
		if(!strPage){
			strPage = $(this).html();
		}
		
		$('#nowPage').val(strPage);
		// 전송주소 설정하고
		$('#bfrm').attr('action', '/cls/board/boardList.cls');
		// 폼태그 전송하고
		$('#bfrm').submit();
	});
	
	$('#rbtn').click(function(){
		$(location).attr('href', '/cls/board/boardWrite.cls');
	});
	
	$('#lbtn').click(function(){
		$(location).attr('href', '/cls/member/login.cls');
	});
	
	$('#jbtn').click(function(){
		$(location).attr('href', '/cls/member/join.cls');
	});
	
	$('#hbtn').click(function(){
		$(location).attr('href', '/cls/main.cls');
	});
	
/* 게시글 작성 페이지 이벤트 처리*/
	$('#wbtn').click(function(){
		var shead = $('#title').val();
		var sbody = $('#body').val();
		
		// 데이터가 입력되었는지 확인하고...
		if((!shead) || (!sbody)){
			return;
		};
		
		// 파일 선택이 안된 태그 비활성 처리
		$('.upfile').last().prop('disabled', true);
		
		// 이곳을 실행하는 경우는 모든 입력태그에(파일태그제외) 데이터가 입력된 경우..
		$('#wfrm').submit();
	});
	
	$('#ebtn').click(function(){
		$('#frm').submit();
	});
	
	// 문서가 완성이 되면 태그에 입력된 값을 기억해 놓는다.
	var stitle = $('#title').val();
	var body = $('#body').val();
	
	$('#edit').click(function(){
		var tTitle = $('#title').val();
		var tBody = $('#body').val();
		
		if(stitle == tTitle && tBody == body){
			return;
		}
		if(stitle == tTitle){
			$('#title').prop('readonly', true);
		}
		if(tBody == body){
			$('#body').prop('readonly', true);
		}
		
		$('#efrm').submit();
	});
	
	var ino = 0;
	function getIno(){
		ino += 1;
		return ino;
	}
	
	/* 이미지 추가 함수 */
	function addImg(i, n){
		let timg = $(document.createElement('img'));
		$(timg).attr('src', i);
		$(timg).attr('id', 'addImg' + n);
		$(timg).attr('class', 'inblock w3-display-middle addImg');
		
		let fr = $(document.createElement('div'));
		$(fr).attr('class', 'addFr inblock pd10 margin-h5 mb5 w3-card-2 w3-border w3-display-container');
		$(fr).attr('id', 'addFr' + n);
		$(fr).append(timg);
		
		$('#fileimg').append(fr);
		setCno(getCno() + 1);
		
		let cls = '#addImg' + n;
		
		$(cls).on('load', function(){
			let w = this.naturalWidth;
			let h = this.naturalHeight;
			$(cls).addClass((w >= h) ? 'addImgW' : 'addImgH');
		});
	}
	
	function addTag(){
		let no = getIno();
		
		var tag = $(document.createElement('input'));
		$(tag).addClass('w3-col w3-input w3-border pdl10 mb5 upfile');
		$(tag).attr('type', 'file');
		$(tag).attr('name', 'file' + no);
		$(tag).attr('id', 'file' + no);
		$(tag).attr('placeholder', '파일을 선택하세요!');
		
		$(tag).change(function(e){
			let src = $(tag).val();
			if(src.length == 0){
				$(tag).remove();
				var tno = $(tag).attr('id').substring(4);
				$('#addFr' + tno).remove();
				
			} else {
				let tfile = URL.createObjectURL(e.target.files[0]);
				
				// img 태그 추가
				addImg(tfile, no);
				
				// input 태그 추가
				addTag();			
			}
		});
		
		$('#filefr').append($(tag));
	}
	addTag();
});

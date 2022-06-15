$(document).ready(function(){
	// .yet 클릭이벤트
	$('.yet').click(function(){
		var sno = $(this).attr('id');
		var txt = $(this).html();
		txt = txt.substring(txt.indexOf('.') + 2);
		
		$('#title').val(txt);
		$('#sino').val(sno);
		
		alert($('#title').val() + ' - ' + $('#sino').val());
		
		$('#frm').submit();
	});
	
	$('.done').click(function(){
	// 넘겨줄 데이터 읽어오기
	var sno = $(this).attr('id');
	var txt = $(this).text();
	txt = txt.substring(txt.indexOf('.') + 2);
	
	// 입력태그에 데이터 채우고(val)
	$('#title').val(txt);
	$('#sino').val(sno);
	
	
	$('#frm').attr('action', '/www/survey/surveyResult.blp')
	$('#frm').submit();
	});
	
	$('#lbtn').click(function(){
		$('#frm').attr('action', '/www/survey/surveyInfo.blp');
		$('#frm').submit();
	});
	
	$('#hbtn').click(function(){
		$(location).attr('href','/www/');
		
	});
	
	
	$('#rbtn').click(function(){
		document.frm1.reset();
	});
	
	$('#sbtn').click(function(){
		var el1 = $('.quest');
		var len1 = el1.length;
		var dap = $('[type="radio"]:checked');
		var len2 = dap.length;
		
		if(len1 != len2){
			// 선택하지 않은 문항이 존재한다.
			return;
		}
		
		for(i = 0; i < len2 ; i++){
			var tmp = $(dap).eq(i).val();
			
//			$('#frm').append('<input type="hidden" name="dap" value="' + tmp + '">');
			
			var el = document.createElement('input');
			$(el).attr('type', 'hidden');
			$(el).attr('name', 'dap');
			$(el).val(tmp);
			$('#frm').append(el);
		}
		$('#frm').attr('action', '/www/survey/surveyProc.blp');
		$('#frm').submit();
	});
});
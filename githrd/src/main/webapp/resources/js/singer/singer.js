$(document).ready(function(){
	$('#gselect, #mselect, #photobox').css('display', 'none');
	
	$('#stype').change(function(){
		var sgn = $('#gn').val();
		var sgen = $('#gen').val();
		var sstype = $('#stype').val();
		
		
	
	$.ajax({
			url: '/www/singer/singList.blp',
			type: 'post',
			dataType: 'json',
			data: {
				gn : sgn,
				gen : sgen,
				stype: sstype
			},	
			success: function(arr){
				$('#gselect').css('display', 'none').html('<option disabled selected>::: 타입 선택 :::</option>');
						for(var i = 0 ; i < arr.length ; i++ ){
							var str = '<option class="w3-center" value=' + arr[i].num + '>' + arr[i].name + '</option>';
							$('#gselect').append(str);
						}
				// gselect 태그 노출
				$('#gselect').css('display', 'block');
					
				
			},
			error: function(){
				alert('### 통신오류 ###');
			}
		});
	});
	
	$('#gselect').change(function(){
		var txt = $(this).val();
		var prevSel = $('#stype').val();
	
		$.ajax({
			url: '/www/singer/singMemb.blp',
			type: 'post',
			dataType: 'json',
			data: {
				num  : txt,
				scode: prevSel
			},
			success: function(arr){
				$('#mselect').css('display', 'none').html('<option disabled selected>::: 타입 선택 :::</option>');
						for(var i = 0 ; i < arr.length ; i++ ){
							var str = '<option class="w3-center" value=' + arr[i].num + '>' + arr[i].name + '</option>';
							$('#mselect').append(str);
						}
				// mselect 태그 노출
				$('#mselect').css('display', 'block');
				
			},
			error: function(){
			alert('### 통신오류 ###');
			
			}
		});	
	});
	
	
	$('#mselect').change(function(){
		var txt = $(this).val();
		
		$.ajax({
			url: '/www/singer/singImg.blp',
			type: 'post',
			dataType: 'json',
			data: {
			num: txt
			},
			success: function(data){
				$('.infoAvtBox').attr('src', '/www/img/photo/'+ data.sname)
				$('#photobox').css('display', 'block');
				
			},
				error: function(){
				alert('### 통신오류 ###');
				
				}
		
		});
	});	
});
	
$(document).ready(function(){
	//$('#gselect, #mselect').css('display', 'none');
	
	$('#gn, #gen, #stype').change(function(){
		var sgn = $('#gn').val();
		var sgen = $('#gen').val();
		var sstype = $('#stype').val();
	
	$.ajax({
			url: '/www/singer/singList.blp',
			type: 'post',
			dataType: 'json',
			data: {
				gn : sgn,
				sgen : sgen,
				stype: sstype
			},	
			success: function(arr){
			$('#gselect, #mselect').css('display', 'none').html('<option disabled selected>::: 타입 선택 :::</option>');
				if(txt == 'dept'){
					for(var i = 0 ; i < arr.length ; i++ ){
						var str = '<option class="w3-center" value=' + arr[i].dno + '>' + arr[i].dname + '</option>';
						$('#selList').append(str);
					}
				} else {
					for(var i = 0 ; i < arr.length ; i++ ){
						var str = '<option class="w3-center" value=' + arr[i].job + '>' + arr[i].job + '</option>';
						$('#selList').append(str);
					}
				}
				
				// selList 태그 보이게...
				$('#selList').css('display', 'block');
			},
			error: function(){
				alert('### 준영씨에게 문의하세요! ###');
			}
		});
	
	});
});
	
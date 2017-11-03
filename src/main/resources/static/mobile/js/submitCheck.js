function check(form){
	if(form.file.value==''&&form.text.value==''){
		  $("#content").html("至少添加一项反馈内容");
		  $('#my-alert').modal({
		        relatedTarget: this,
		        
		    });
		 return false;
	}
	
	return true;

}
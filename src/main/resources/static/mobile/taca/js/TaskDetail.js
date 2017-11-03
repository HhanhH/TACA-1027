function receiveTaskById(taskId,username,count) {
	if(username=="session"){
    	
        $('#my-confirm').modal({
  	      relatedTarget: this,
  	      onConfirm: function() {
  	    	window.location.href='../../mobile/login';
  	        
  	      },
  	      onCancel: function() {
  	       return;
  	      }
  	    });
        return;
    }
    if(count<=0){
    	 $("#content").html("库存不足");
    	 return;
    }
    $.ajax({
        type:'GET',
        url:'../../mobile/resttask/receiveTask',
        dataType:"json",
        data:{
        "id":taskId
    },
    success:function (data) {
    	 if(data.code=='000000'){
             $("#content").html("领取成功");
   		  $('#my-alert').modal({
   		        relatedTarget: this,
   		      onConfirm: function() {
   		    	 window.location.href='../../mobile/mytask/list';
   		      }
   		    });
   		  
         }
       
        else{
            $("#content").html(data.message);
            $('#my-alert').modal({
   		        relatedTarget: this,
   		      onConfirm: function() {
   		      }
   		    });
   		  
        }
    }
});
}


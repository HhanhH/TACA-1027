/**
 * Created by 芳华 on 2017/9/27.
 */
function exchangeGoods(goodsId,count,username) {
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
 		  $('#my-alert').modal({
 		        relatedTarget: this,
 		        
 		    });
 		 
 		  return;
    }
    $.ajax({
        type:'GET',
        url:'../../mobile/restgoods/exchangeGoods',
        dataType:"json",
        data:{
            "id":goodsId
        },
        success:function (data) {
            if(data.code=='000000'){
                $("#content").html("兑换申请成功，审核中...");
      		  $('#my-alert').modal({
      		        relatedTarget: this,
      		      onConfirm: function() {
        		    	window.location.href="../../mobile/mygoods/"+username;
      		      }
      		    });
      		  
            }
        
        else{
                $("#content").html(data.message);
                $('#my-alert').modal({
      		        relatedTarget: this,
      		      onConfirm: function() {
      		    	window.location.reload;
      	  	        
      	  	      }
      		    });
        	}
            
        }
    });
}


/*function exchangeGoods(goodsId,count,username) {
    if(username=="session"){
    	 $("#content").html("未登录，快去登录吧");
		  $('#my-alert').modal({
		        relatedTarget: this,
		        
		    });
        setTimeout("window.location.href='../../mobile/login'",2000);
    }
    if(count==0){
    	 $("#content").html("库存不足");
 		  $('#my-alert').modal({
 		        relatedTarget: this,
 		        
 		    });
 		 
 		  return;
    }
    $.ajax({
        type:'GET',
        url:'../../mobile/restgoods/exchangeGoods',
        dataType:"json",
        data:{
            "id":goodsId
        },
        success:function (data) {
            if(data.code=='000000'){
                $("#content").html("兑换申请成功，审核中...");
      		  $('#my-alert').modal({
      		        relatedTarget: this,
      		        
      		    });
      		  window.location.reload;
            }
            else{
                $("#content").html(data.message);
                $('#my-alert').modal({
      		        relatedTarget: this,
      		        
      		    });
            }
        }
    });
}
*/
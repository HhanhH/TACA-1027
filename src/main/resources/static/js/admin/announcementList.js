window.onload=function(){
	 $("#ul-announcement-manage").css('display','block');
	 $("#ul-announcement-manage").prev().addClass('active');
	 $("#a-announcement-list").addClass('active');
	
};

$(function(){
    $(".tpl-left-nav-menu li a").click(function() {
    		$(".tpl-left-nav-menu li a").removeClass('active');
    		$(this).addClass('active'); // 添加当前元素的样式
    		
    		var display=$(this).next().css('display');
    		if(display=='none'){
    			$(".tpl-left-nav-sub-menu").css('display','none');
    			$(this).next().css('display','block');
    		}else{
    			$(this).next().css('display','none');
    		}
    		if($("#a-announcement-list").hasClass('active')){}
    		else{$("#a-announcement-list").addClass('active');}
    		
    });
}); 

function active(id,status){
	
	$.ajax({
		 type: "POST",
        url:"../notice/ajax/active",
        data:{
       	 "id":id,
       	 "status":status,
       	 },
        success: function(result) {
       	 alert(result.message);
       	 window.location.reload();
        }
	 })
}

window.onload=function(){
	 $("#ul-user-manage").css('display','block');
	 $("#ul-user-manage").prev().addClass('active');
	 $("#a-user-group").addClass('active');
	
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
    		if($("#a-user-group").hasClass('active')){}
    		else{$("#a-user-group").addClass('active');}
    		
    });
}); 

function active(id){
	 $.ajax({
		 type: "POST",
         url:"../user/ajax/active",
         data:{"id":id},
         dataType:'json',
         async:true,
         success: function(result) {
        	 alert(result.message);
        	 window.location.reload();
         }
	 });
	
}


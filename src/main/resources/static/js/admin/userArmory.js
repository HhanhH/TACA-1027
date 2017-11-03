window.onload=function(){
	 $("#ul-armory-manage").css('display','block');
	 $("#ul-armory-manage").prev().addClass('active');
	 $("#a-user-armory").addClass('active');
	
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
    		if($("#a-user-armory").hasClass('active')){}
    		else{$("#a-user-armory").addClass('active');}
    		
    });
}); 

function openAndClose()
{
	
	
		
}
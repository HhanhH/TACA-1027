window.onload=function(){
	 $("#ul-audit-manage").css('display','block');
	 $("#ul-audit-manage").prev().addClass('active');
	 $("#a-audit-award-history").addClass('active');
	
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
    		if($("#a-audit-award-history").hasClass('active')){}
    		else{ $("#a-audit-award-history").addClass('active');}
    		
    });
}); 

function exportExcel(){
	var name = $('#name').val();
	var username = $('#username').val();
	var createTime1 = $('#createTime1').val();
	var createTime2 = $('#createTime2').val();
	
	
	
	window.location.href = "export?name="+name+"&username="+username+"&createTime1="+createTime1+"&createTime2="+createTime2;
	return false;
}
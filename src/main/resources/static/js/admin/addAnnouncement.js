window.onload=function(){
	 $("#ul-announcement-manage").css('display','block');
	 $("#ul-announcement-manage").prev().addClass('active');
	 $("#a-announcement-add").addClass('active');
	
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
    		if($("#a-announcement-add").hasClass('active')){}
    		else{$("#a-announcement-add").addClass('active');}
    		
    });
}); 


function check(form){
	if(form.title.value==''){
		alert("公告Title不能为空");
		return false;
	}
	if(form.content.value==''){
		alert("公告内容不能为空");
		return false;
	}
	return true;

}
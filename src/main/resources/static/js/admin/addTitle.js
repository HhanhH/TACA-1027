window.onload=function(){
	 $("#ul-armory-manage").css('display','block');
	 $("#ul-armory-manage").prev().addClass('active');
	 $("#a-add-title").addClass('active');
	
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
    		if($("#a-add-title").hasClass('active')){}
    		else{$("#a-add-title").addClass('active');}
    		
    });
}); 

function add(){
	var title=$("#title").val();
	var starNumber = $("#starNumber").val();
	
	
	if(title== '' || starNumber == '')
	{
		alert("请填写所有参数");
		return;
	}
	
	 $.ajax({
		 type: "POST",
         url:"../title/ajax/add",
         data:{
        	 "title":title,
        	 "starNumber":starNumber,
        	 },
         success: function(result) {
        	 alert(result.message);
        	 window.location.href="../title/list";
         }
	 })
	
}

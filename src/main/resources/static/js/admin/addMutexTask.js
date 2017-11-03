window.onload=function(){
	 $("#ul-task-manage").css('display','block');
	 $("#ul-task-manage").prev().addClass('active');
	 $("#a-task-mutex").addClass('active');
	
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
    		if($("#a-task-mutex").hasClass('active')){}
    		else{ $("#a-task-mutex").addClass('active');}
    		
    });
}); 

var firstId;
$(function(){
    $("input").click(function(){
        if($(this).is(":checked")){
        	 var tr = $(this).closest('tr');
            var tds=tr.find('td');
            firstId=tds.eq(0).text();
        }
    });
});

function addMutex(id){
	if(firstId==null){
		alert("请选择任务一");
		return ;
	}

	$.ajax({
		 type: "POST",
        url:"../task/ajax/addTaskMutex",
        data:{
        	"taskFirstId":firstId,
        	"taskSecondId":id
        	},
        dataType:'json',
        async:true,
        success: function(result) {
       	 alert(result.message);
       	 window.location.reload();
        }
	 });
	
	
	
}
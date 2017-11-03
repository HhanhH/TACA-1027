window.onload=function(){
	 $("#ul-task-manage").css('display','block');
	 $("#ul-task-manage").prev().addClass('active');
	 $("#a-task-list").addClass('active');
	
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
    		if($("#a-task-list").hasClass('active')){}
    		else{$("#a-task-list").addClass('active');}
    		
    });
}); 

function queryInfo(id){
	 var $modal = $('#task_info');
	 $.ajax({
		 type: "POST",
         url:"taskInfo",
         data:{"id":id},
         success: function(result) {
        	 alert(result.data.id);
        	
         }
	 })
	window.showModalDialog("taskInfo.ftl");    
	
}


function addNewTask(){
	var formData=new FormData(document.getElementById('form'));
	 $.ajax({
		 type: "POST",
         url:"addNewTask",
         data:{formData,"id":"1"},
        
         success: function(result) {
        	 alert(result.memo);
         }
	 });
}

function changOffAndOn(id){
	 $.ajax({
		 type: "POST",
         url:"../task/ajax/changOffAndOn",
         data:{"id":id},
         dataType:'json',
         async:true,
         success: function(result) {
        	 alert(result.message);
        	 window.location.reload();
         }
	 });
	
}


function update(id){
	var name=$("#name").val();
	var content=$("#content").val();
	var typeval=$("#type").val();
	var status=$("#status").val();
	var starLevel=$("#starLevel").val();
	var starProfit=$("#starProfit").val();
	var availableStock=$("#availableStock").val();
	var count=$("#count").val();
	var personAvailableStock=$("#personAvailableStock").val();
	var timeLength=$("#timeLength").val();
	var feedBackWay=$("#feedBackWay").val();
    var category= $("#category").val();
    
    $.ajax({
		type: "POST",
        url:"../ajax/updateTaskInfo",
        data:{
        	"id":id,
        	"name":name,
        	"content":content,
        	"type":typeval,
        	"status":status,
        	"starLevel":starLevel,
        	"starProfit":starProfit,
        	"availableStock":availableStock,
        	"count":count,
        	"personAvailableStock":personAvailableStock,
        	"timeLength":timeLength,
        	"feedBackWay":feedBackWay,
        	"category":category,
        	},
        dataType:'json',
        async:true,
        success: function(result) {
       	 alert(result.message);
       	 window.location.href="../taskList";
        }
	 });
	
}


function check(form){
	if(form.name.value==''){
		alert("任务名不能为空");
		return false;
	}
	if(form.content.value==''){
		alert("内容不能为空");
		return false;
	}
	if(form.feedbackWay.value==''){
		alert("任务反馈方式不能为空");
		return false;
	}
	if(form.starLevel.value==''){
		alert("任务星级不能为空");
		return false;
	}
	if(form.starProfit.value==''){
		alert("可获得星点不能为空");
		return false;
	}
	if(form.availableStock.value==''){
		alert("可领取数不能为空");
		return false;
	}
	
	if(form.timeLength.value==''){
		alert("任务周期不能为空");
		return false;
	}
	
	return true;

}


function remove(taskId,mutexTaskId){
	$.ajax({
		type: "POST",
        url:"../ajax/removeMutex",
        data:{
        	"taskId":taskId,
        	"mutexTaskId":mutexTaskId        	
        	},
        dataType:'json',
        async:true,
        success: function(result) {
       	 alert(result.message);
       	 window.location.href="../taskList";
        }
	 });
}


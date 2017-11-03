window.onload=function(){
	 $("#ul-user-manage").css('display','block');
	 $("#ul-user-manage").prev().addClass('active');
	 $("#a-user-import").addClass('active');
	
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
    		if($("#a-user-import").hasClass('active')){}
    		else{ $("#a-user-import").addClass('active');}
    		
    });
});

$(document).ready(function () {

    $("#submitButton").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    // Get form
    var form = $('#form')[0];

    var data = new FormData(form);



    $("#submitButton").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "../user/ajax/upload",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //http://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
            if(data.code=="000000"){
                alert(data.message);
                window.location.href="../user/groupUser";
            }else{
                alert(data.message);
                window.location.href="../user/goImportUser";
            }


        },
        error: function (e) {

            alert("您的请求出错了！！！！");
            window.location.href="../user/goImportUser";
        }
    });

}
$(document).ready(function () {

    $("#btn").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        addOne();

    });

});
function addOne() {
    var um = $("#um").val();
    var userNameCn = $("#userNameCn").val();
    var groupId = $("#groupId").val();
    var groupName = $("#groupName").val();
    if(um==''){
		alert("UM不能为空");
		return;
	}
	if(groupName==''){
		alert("groupName不能为空");
		return;
	}
	if(groupId==''){
		alert("groupId不能为空");
		return;
	}
    $.ajax({
        type: "POST",
        enctype: "application/x-www-form-urlencoded",
        url: "../user/ajax/addOne",
        data: {
            "um": um,
            "userNameCn": userNameCn,
            "groupId": groupId,
            "groupName": groupName,
        },

        success: function (data) {
            if (data.code == "000000") {
                alert(data.message);
                window.location.href = "../user/groupUser";
            } else {
                alert(data.message);
            }


        },
        error: function (e) {

            alert("您的请求出错了！！！！");
            window.location.href = "../user/goImportUser";
        }
    });
}
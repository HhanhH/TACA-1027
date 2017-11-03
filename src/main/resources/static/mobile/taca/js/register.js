/**
 * Created by 芳华 on 2017/10/10.
 */


var countdown = 60;
function settime(val) {
	if (countdown == 0) {
		val.removeAttribute("disabled");
		val.value = "重新发送";
		$("#code").html("");
		countdown = 60;
		return;
	} else {
		val.setAttribute("disabled", true);
		val.value = "重新发送(" + countdown + ")";
		countdown--;
	}
	setTimeout(function() {
		settime(val)
	}, 1000)
} 

function getRandom(val) {
	val.setAttribute("disabled", true);
    var username=document.getElementById("username").value;
    if(username==''){
    	$("#code").html("请填写UM账号");
		return false;
	}
    $.ajax({
        type:'POST',
        url:'../../mobile/rest/randomCode',
        dataType:"json",
        data:{
            "username":username
        },
        success:function (data) {
            if(data.code=='000000'){
                $("#code").html("获取成功");
                settime(val);
            }
            else{
            	
                $("#code").html(data.message);
                val.removeAttribute("disabled");
        		val.value = "重新发送";
            }
        }
    });
    
}
function register() {
    var nickname=document.getElementById("nickname").value;
    var username=document.getElementById("username").value;
    var randonCode=document.getElementById("randomCode").value;
    var password=document.getElementById("password").value;
    var confirmpsd=document.getElementById("confirmpsd").value;
    
    if(username==''){
    	$("#result").html("请填写UM账号");
		return false;
	}
	if(randonCode==''){
		$("#result").html("请填写验证码");
		return false;
	}
	if(password==''){
		$("#result").html("请设置密码");
		return false;
	}
	if(password != confirmpsd){
		$("#result").html("两次密码不一致");
		return false;
	}
    $.ajax({
        type:'POST',
        url:'../../mobile/rest/register/vertify',
        dataType:"json",
        data:{
            "nickname":nickname,
            "username":username,
            "randomCode":randonCode,
            "password":password,
            "confirmPassword":confirmpsd
        },
        success:function (data) {
            if(data.code=='000000'){
            	 $('#my-alert').modal({
             	      relatedTarget: this,
             	      onConfirm: function() {
             	    	 window.location.href='../mobile/login';
             	        
             	      },
             	      onCancel: function() {
             	       return;
             	      }
             	    });
               
            }
            else{
                $("#result").html(data.message);
            }
        }
    });
}
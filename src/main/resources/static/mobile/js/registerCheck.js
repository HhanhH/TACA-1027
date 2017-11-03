function check(form){
	if(form.username.value==''){
		alert("请填写UM账号");
		return false;
	}
	if(form.randomCode.value==''){
		alert("请填写验证码");
		return false;
	}
	if(form.pssword.value==''){
		alert("请设置密码");
		return false;
	}
	if(form.pssword.value!=form.confirmpsd.value){
		alert("两次密码不一致");
		return false;
	}
	
	return true;

}
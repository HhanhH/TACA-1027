<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>修改密码</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp"/>
  <link rel="stylesheet" href="../../static/mobile/css/amazeui.min.css">
  <link rel="stylesheet" href="../../static/mobile/css/app.css">
</head>
<body>
<div class="am-g">
	<div class="am-u-sm-12 am-text-center" >
    <img src="../../static/mobile/img/logo.png" style="width: 130px;height: 184px;">
</div>
	<div class="am-u-sm-11 am-u-sm-centered">
	<form class="am-form">
	  <fieldset class="myapp-login-form am-form-set">
       <input type="hidden" >
	    <div class="am-form-group am-form-icon">
			<i class="am-icon-lock"></i>
			<input type="password" id="pwd" class="myapp-login-input-text am-form-field" placeholder="旧密码" required>
		</div>
		  <div class="am-form-group am-form-icon">
			<i class="am-icon-lock"></i>
			<input type="password" id="pwdnew" class="myapp-login-input-text am-form-field" placeholder="新密码" required>
		</div>
		  <div class="am-form-group am-form-icon">
			<i class="am-icon-lock"></i>
			<input type="password" id="pwdnew2" class="myapp-login-input-text am-form-field" placeholder="确认新密码" required>
		</div>
	  </fieldset>
	  <button onclick="changPwd('${userInfo.userName}')" type="button" class="myapp-login-form-submit-orange am-btn am-btn-primary am-btn-block ">确认</button>

	</form>
	</div>
	 <#include "/mobile/includes/footer.ftl" />
</div>

<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-bd" id="content">
      
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>
<script src="../../static/mobile/js/jquery.min.js"></script>
<script src="../../static/mobile/js/amazeui.min.js"></script>
<script src="../../static/mobile/js/app.js"></script>
<script src="../../static/mobile/taca/js/UserInfo.js"></script>
</body>
</html>
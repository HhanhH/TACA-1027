<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>登录</title>
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
		<div class="am-form-group am-form-icon">
			<i class="am-icon-user"></i>
			<input type="text" id="username" class="myapp-login-input-text am-form-field" placeholder="UM" required>
		</div>
	    <div class="am-form-group am-form-icon">
			<i class="am-icon-lock"></i>
			<input type="password" id="password" class="myapp-login-input-text am-form-field" placeholder="password" required>
		</div>
	  </fieldset>
	  <button onclick="javascript:login()" type="button" class="myapp-login-form-submit am-btn am-btn-primary am-btn-block ">登 陆</button>
		<div class="am-modal-bd" id="result" style="color: red;font-size: small;text-align: left;"></div>
	</form>
</div>
	<div style="text-align:center">	
	<a href="${base}/mobile/notice/list" style="text-align: right!important; ">TACA大厅</a>
	</div>
	<div style="text-align:center;color:#F00">	
	请注意：第一次登录请在"我的账户"点击修改密码。
	</div>
	 <#include "/mobile/includes/footer.ftl" />
</div>
<script src="../../static/mobile/js/jquery.min.js"></script>
<script src="../../static/mobile/js/amazeui.min.js"></script>
<script src="../../static/mobile/js/app.js"></script>
<script src="../../static/mobile/taca/js/login.js"></script>
</body>
</html>
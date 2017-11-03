
<!doctype html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>IM后台管理</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="../../static/css/admin/amazeui2.min.css" />
  <link rel="stylesheet" href="../../static/css/admin/admin2.css">
  <link rel="stylesheet" href="../../static/css/admin/app2.css">
</head>

<body data-type="login">

  <div class="am-g myapp-login">
	<div class="myapp-login-logo-block  tpl-login-max">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				IM 后台<span> Login</span> <i class="am-icon-skyatlas"></i>
				
			</div>
		</div>

		<div class="login-font">
			<i>Log In </i> 
		</div>
		<div class="am-u-sm-10 login-am-center">
			<form class="am-form" action="${base}/admin/login" method="post" >
				<fieldset>
					<div class="am-form-group">
						<input type="text" class="" id="doc-ipt-email-1" placeholder="账户" name="adminName" >
					</div>
					<div class="am-form-group">
						<input type="password" class="" id="doc-ipt-pwd-1" placeholder="密码" name="password">
					</div>
					<p><button type="submit" class="am-btn am-btn-default">登录</button></p>
					</br>
					<#if error ??>
					<span style="color:red;margin-left:170px">${error}</span>
					</#if>
					</br>
				</fieldset>
				
			</form>
		</div>
	</div>
</div>

  <script src="assets/js/jquery.min.js"></script>
  <script src="../../static/js/admin/amazeui2.min.js"></script>
  <script src="../../static/js/admin/app2.js"></script>
</body>

</html>

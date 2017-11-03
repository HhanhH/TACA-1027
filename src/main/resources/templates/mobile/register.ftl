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
                    <input type="text" id="nickname" class="myapp-login-input-text am-form-field" placeholder="昵称" required>
                </div>
                <div class="am-form-group am-form-icon">
                    <i class="am-icon-envelope"></i>
                    <input type="text" id="username" class="myapp-login-input-text am-form-field" name="username" placeholder="UM" required>
                </div>
                <input type="button"   id="mya" onclick="javascript:getRandom(this)" style="cursor:pointer;" value="获取验证码(发送到公司内部邮箱)"><span class="am-modal-bd" id="code" style="color: red;font-size: small;text-align: left;"></span>
                <div class="am-form-group am-form-icon">
                    <i class="am-icon-send"></i>
                    <input type="text" id="randomCode" name="randomCode" class="myapp-login-input-text am-form-field" placeholder="验证码" required>
                </div>
                <div class="am-form-group am-form-icon">
                    <i class="am-icon-lock"></i>
                    <input type="password" id="password"  name="password" class="myapp-login-input-text am-form-field" placeholder="密码" required>
                </div>
                <div class="am-form-group am-form-icon">
                    <i class="am-icon-lock"></i>
                    <input type="password" id="confirmpsd" name="confirmpsd" class="myapp-login-input-text am-form-field" placeholder="确认密码" required>
                </div>
            </fieldset>
            <div class="am-modal-bd" id="result" style="color: red;font-size: small;text-align: left;"></div>
            <button onclick="javascript:register()" type="button" class="myapp-login-form-submit am-btn am-btn-primary am-btn-block ">注册</button>
            <a href="${base}/mobile/login" style="text-align: right">登录</a>
        </form>
    </div>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
    <div class="am-modal-dialog">
        <div class="am-modal-hd" ></div>
        <div class="am-modal-bd" id="content">
            注册成功
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>
<script src="../../static/mobile/js/jquery.min.js"></script>
<script src="../../static/mobile/js/amazeui.min.js"></script>
<script src="../../static/mobile/js/app.js"></script>
<script src="../../static/mobile/taca/js/register.js"></script>
</body>
</html>
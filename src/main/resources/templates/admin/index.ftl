<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>IM后台管理</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="../../static/css/admin/amazeui1.min.css" />
<link rel="stylesheet" href="../../static/css/admin/admin1.css">
<script src="../../static/js/admin/jquery2.min.js"></script>
<script src="../../static/js/admin/amazeui2.min.js"></script>
<script src="../../static/js/admin/iscroll2.js"></script>
<script src="../../static/js/admin/app2.js"></script>
<script src="../../static/js/admin/index.js"></script>
<link rel="stylesheet" href="../../static/css/admin/amazeui2.min.css" />
<link rel="stylesheet" href="../../static/css/admin/admin2.css">
<link rel="stylesheet" href="../../static/css/admin/app2.css">
</head>

<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->
<body>

	<#include "admin/menu.ftl">
<!--menu end  -->


	 <div class="tpl-content-wrapper">
       
            <div class="tpl-portlet-components">

		<div class="admin-index">
			<dl data-am-scrollspy="{animation: 'slide-right', delay: 100}">
				<dt class="qs">
					<i class="am-icon-users"></i>
				</dt>
				<dd>${userCount }</dd>
				<dd class="f12">我的用户</dd>
			</dl>
			<dl data-am-scrollspy="{animation: 'slide-right', delay: 300}">
				<dt class="cs">
					<i class="am-icon-area-chart"></i>
				</dt>
				<dd>${reciveTaskCount}</dd>
				<dd class="f12">任务领取</dd>
			</dl>
			<dl data-am-scrollspy="{animation: 'slide-right', delay: 600}">
				<dt class="hs">
					<i class="am-icon-shopping-cart"></i>
				</dt>
				<dd>${shoppingCount}</dd>
				<dd class="f12">激励发放</dd>
			</dl>




		</div>
	</div>
	</div>
	<#include "admin/foot.ftl">


</body>
</html>
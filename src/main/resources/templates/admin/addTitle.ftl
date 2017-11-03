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
<link rel="stylesheet" href="../../static/css/admin/amazeui2.min.css" />
<link rel="stylesheet" href="../../static/css/admin/admin2.css">
<link rel="stylesheet" href="../../static/css/admin/app2.css">
<script src="../../static/js/admin/jquery2.min.js"></script>
<script src="../../static/js/admin/amazeui2.min.js"></script>
<script src="../../static/js/admin/iscroll2.js"></script>
<script src="../../static/js/admin/app2.js"></script>
<script src="../../static/js/admin/addTitle.js"></script>
</head>
<body>
	<#include "admin/menu.ftl">

	<!--menu end  -->
	<div class="tpl-portlet-components" style="height:474px;">
		<div class="portlet-title">
			<div class="caption font-green bold">添加称号</div>
		</div>

		<div class="tpl-block">
			<div class="am-g">
				<div class="tpl-form-body tpl-form-line">
					<form class="am-form tpl-form-line-form">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">称号
								<span class="tpl-form-line-small-title">Title</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="title" name="title"
									placeholder="请输入称号"> 
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">星点
								<span class="tpl-form-line-small-title">Star</span>
							</label>
							<div class="am-u-sm-9">
								<input type="number" class="am-form-field tpl-form-no-bg" id="starNumber" name="starNumber"
									placeholder="所需达到星点" /> 
							</div>
						</div>

						
						
						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<button type="button"
									class="am-btn am-btn-primary tpl-btn-bg-color-success " onclick="add()" >提交</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
</div>

	<#include "admin/foot.ftl">
</body>
</html>
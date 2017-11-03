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
<link rel="stylesheet" href="../../static/css/admin/amazeui2.min.css" />
<link rel="stylesheet" href="../../static/css/admin/admin2.css">
<link rel="stylesheet" href="../../static/css/admin/app2.css">
<script src="../../static/js/admin/jquery2.min.js"></script>
<script src="../../static/js/admin/amazeui2.min.js"></script>
<script src="../../static/js/admin/iscroll2.js"></script>
<script src="../../static/js/admin/app2.js"></script>
<script src="../../static/js/admin/addAnnouncement.js"></script>
</head>
<body>
	<#include "admin/menu.ftl">
	<!--menu end  -->
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">添加公告</div>
		</div>

		<div class="tpl-block">
			<div class="am-g">
				<div class="tpl-form-body tpl-form-line">
					<form class="am-form tpl-form-line-form" action="${base}/admin/notice/add" method="post" enctype="multipart/form-data" id="form">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">公告名称
								<span class="tpl-form-line-small-title">Title</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="title" name="title"
									placeholder="请输入名称"> 
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">内容
								<span class="tpl-form-line-small-title">Content</span>
							</label>
							<div class="am-u-sm-9">
								<textarea class="am-form-field tpl-form-no-bg" id="content" name="content"
									placeholder="任务描述" ></textarea> 
							</div>
						</div>

						
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">状态<span
								class="tpl-form-line-small-title">ACTIVE/INACTIVE</span></label>
							<div class="am-u-sm-9">
								<select name="status" id="status">
								<option>ACTIVE</option>
								<option>INACTIVE</option>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">展示图
								<span class="tpl-form-line-small-title">Images</span>
							</label>
							<div class="am-u-sm-9">
								<input id="doc-form-file" type="file" name="file">
							</div>
						</div>

						

						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<input type="submit"
									class="am-btn am-btn-primary tpl-btn-bg-color-success " value="提交" onclick="return check(this.form);" />
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
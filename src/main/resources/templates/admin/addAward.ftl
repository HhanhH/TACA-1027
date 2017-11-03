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
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="../../static/css/admin/amazeui2.min.css" />
<link rel="stylesheet" href="../../static/css/admin/admin2.css">
<link rel="stylesheet" href="../../static/css/admin/app2.css">
<script src="../../static/js/admin/jquery2.min.js"></script>
<script src="../../static/js/admin/amazeui2.min.js"></script>
<script src="../../static/js/admin/iscroll2.js"></script>
<script src="../../static/js/admin/app2.js"></script>
<script src="../../static/js/admin/addAward.js"></script>
</head>
<body>
<#include "admin/menu.ftl">
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">添加激励</div>
		</div>

		<div class="tpl-block">
			<div class="am-g">
				<div class="tpl-form-body tpl-form-line">
					<form action="${base}/admin/goods/add" method="post"  enctype="multipart/form-data" class="am-form tpl-form-line-form">
						<div class="am-form-group">
							<label for="name" class="am-u-sm-3 am-form-label">激励名称
								<span class="tpl-form-line-small-title">Title</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="name" name="name"
									>
							</div>
						</div>



						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">类型
								<span class="tpl-form-line-small-title">Type</span>
							</label>
							<div class="am-u-sm-9">

								<select name="type">
									<option value="普通">普通</option>
									<option value="爆款">爆款</option>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">消耗星点<span
								class="tpl-form-line-small-title">level</span></label>
							<div class="am-u-sm-9">
								<input type="number" name="starNumber">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">描述<span
								class="tpl-form-line-small-title">Description</span></label>
							<div class="am-u-sm-9">
								<input type="text" name="description">
							</div>
						</div>
						
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">可兑换总数<span
								class="tpl-form-line-small-title">Stock</span></label>
							<div class="am-u-sm-9">
								<input type="number" name="availableStock">
							</div>
						</div>
						
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">上下架<span
								class="tpl-form-line-small-title">OFF/ON</span></label>
							<div class="am-u-sm-9">
								<select name="status">
								    <option value="ON">ON</option>
									<option value="OFF">OFF</option>
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
							<label for="user-weibo" class="am-u-sm-3 am-form-label">添加分类
								<span class="tpl-form-line-small-title">Category</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" id="user-weibo" name="category">
								<div></div>
							</div>
						</div>

						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<input type="submit" onclick="return check(this.form);">
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
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
<script src="../../static/js/admin/taskList.js"></script>
</head>
<body>
	<#include "admin/menu.ftl">
	<!--menu end  -->

	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">
				 添加任务
			</div>
		</div>

		<div class="tpl-block">
			<div class="am-g">
				<div class="tpl-form-body tpl-form-line">
					<form action="addNewTask" method="post" class="am-form tpl-form-line-form" enctype="multipart/form-data" id="form">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">任务名称
								<span class="tpl-form-line-small-title">Title</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="name" name="name"
									> 
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">内容描述
								<span class="tpl-form-line-small-title">Description</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="am-form-field tpl-form-no-bg" id="content"
									name="content" /> 
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">类型
								<span class="tpl-form-line-small-title">Type</span>
							</label>
							<div class="am-u-sm-9">
							<!-- <input type="text" class="am-form-field tpl-form-no-bg"
									placeholder="任务类型" />  -->
								<select id="type" name="type">
									<option value="个人">个人</option>
									<option value="多人">多人</option>
								</select>
							</div>	
						</div>

						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">任务星级<span
								class="tpl-form-line-small-title">level</span></label>
							<div class="am-u-sm-9">
								<input type="number" id="starLevel" name="starLevel">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">可获得星点<span
								class="tpl-form-line-small-title">profit</span></label>
							<div class="am-u-sm-9">
								<input type="number" id="starProfit" name="starProfit">
							</div>
						</div>
						
							<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">可领数<span
								class="tpl-form-line-small-title">availableStock</span></label>
							<div class="am-u-sm-9">
								<input type="number"  id="availableStock"  name="availableStock">
							</div>
						</div>
							<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">每人最多领取数<span
								class="tpl-form-line-small-title"></span></label>
							<div class="am-u-sm-9">
								<input type="number" id="personAvailableStock" name="personAvailableStock">
							</div>
						</div>
							<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">周期（day）<span
								class="tpl-form-line-small-title">Length</span></label>
							<div class="am-u-sm-9">
								<input type="number"  id="timeLength" name="timeLength">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">反馈方式<span
								class="tpl-form-line-small-title">feedbackWay</span></label>
							<div class="am-u-sm-9">
								<input type="text" id="feedbackWay" name="feedbackWay">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">上下架<span
								class="tpl-form-line-small-title">OFF/ON</span></label>
							<div class="am-u-sm-9">
								<select id="status" name="status"><option value="ON">ON</option><option value="OFF">OFF</option>
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
								<input type="text" id="category"  name="category">
								<div></div>
							</div>
						</div>

                       <div align="center">
						<input type="submit"  value="提交" onclick="return check(this.form);">
						</div>
					</form>

				</div>
			</div>
		</div>
		</div>
<#include "admin/foot.ftl">
</body>
</html>
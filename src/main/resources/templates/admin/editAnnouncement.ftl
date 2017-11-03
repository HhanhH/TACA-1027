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
<link rel="stylesheet" href="${base}/static/css/admin/amazeui2.min.css" />
<link rel="stylesheet" href="${base}/static/css/admin/admin2.css">
<link rel="stylesheet" href="${base}/static/css/admin/app2.css">
<script src="${base}/static/js/admin/jquery2.min.js"></script>
<script src="${base}/static/js/admin/amazeui2.min.js"></script>
<script src="${base}/static/js/admin/iscroll2.js"></script>
<script src="${base}/static/js/admin/app2.js"></script>
<script src="${base}/static/js/admin/announcementList.js"></script>
</head>
<body>
	<#include "admin/menu.ftl">
	<!--menu end  -->
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">编辑公告</div>
		</div>

		<div class="tpl-block">
			<div class="am-g">
				<div class="tpl-form-body tpl-form-line">
					<form class="am-form tpl-form-line-form" action="${base}/admin/notice/edit" method="post" enctype="multipart/form-data" id="form">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">ID
								<span class="tpl-form-line-small-title">id</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="id" name="id" readonly="readonly"
									value="${notice.id}"> 
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">公告名称
								<span class="tpl-form-line-small-title">Title</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="title" name="title"
									value="${notice.title}"> 
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">内容
								<span class="tpl-form-line-small-title">Content</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="am-form-field tpl-form-no-bg" id="content" name="content"
									value="${notice.content}" /> 
							</div>
						</div>

						
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">状态<span
								class="tpl-form-line-small-title">active/inactive</span></label>
							<div class="am-u-sm-9">
								<select name="status">
								     <option value="${notice.status}">${notice.status}</option>
								     <#if '${notice.status}' == "ACTIVE">
								      <option value="INACTIVE">INACTIVE</option>
								     <#else>
								      <option value="ACTIVE">ACTIVE</option>
								     </#if>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">展示图
								<span class="tpl-form-line-small-title">Images</span>
							</label>
							<img alt="" src="${bsae}/icon/show?iconAddress=${notice.iconAddress}" height="120" width="200"/>
									
							<div class="am-u-sm-9" style="margin-left:265px;margin-top:20px">
								<input id="doc-form-file" type="file" name="file">

							</div>
						</div>


						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<input type="submit"
									class="am-btn am-btn-primary tpl-btn-bg-color-success " value="提交" />
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
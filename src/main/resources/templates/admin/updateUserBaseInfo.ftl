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
<link rel="stylesheet" href="../../../static/css/admin/amazeui2.min.css" />
<link rel="stylesheet" href="../../../static/css/admin/admin2.css">
<link rel="stylesheet" href="../../../static/css/admin/app2.css">
<script src="../../../static/js/admin/jquery2.min.js"></script>
<script src="../../../static/js/admin/amazeui2.min.js"></script>
<script src="../../../static/js/admin/iscroll2.js"></script>
<script src="../../../static/js/admin/app2.js"></script>
<script src="../../../static/js/admin/updateGroupUserInfo.js"></script>
</head>
<body>
	<#include "admin/menu.ftl">
	<!--menu end  -->

	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">
				 用户详情
			</div>
			
		</div>
			<div class="portlet-title">
			
			<div class="caption font-green bold">
				<input type="button"  onclick="javascript:history.go(-1)" value="返回"/>
			</div>
		</div>
		<div class="tpl-block">
			<div class="am-g">
				<div class="tpl-form-body tpl-form-line">
					<form action="" method="post" class="am-form tpl-form-line-form" enctype="multipart/form-data" id="form">
						<div class="am-form-group">
							
							<div class="am-u-sm-9">
								<input type="hidden" class="tpl-form-input" id="name" name="name"  value="${user.id}"> 
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">用户名
								<span class="tpl-form-line-small-title">name</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="userName" name="userName"  value="${user.userName}"> 
							</div>
						</div>
						
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">中文名
								<span class="tpl-form-line-small-title">NameCn</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="userNameCn" name="userNameCn"  value="${user.userNameCn}"> 
							</div>
						</div>
							
						
						
						
						
						
						
							<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">组ID
								<span class="tpl-form-line-small-title">groupId</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="groupId" name="groupId"  value="${user.groupId}"> 
							</div>
						</div>
						
							<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">组名
								<span class="tpl-form-line-small-title">groupName</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="groupName" name="groupName"  value="${user.groupName}"> 
							</div>
						</div>
						
						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<input type="button"
									class="am-btn am-btn-primary tpl-btn-bg-color-success " onclick="update(${user.id})" value="提交" />
							</div>
						</div>
						
					</form>

				</div>
			</div>
		</div>
	  </div>
	</div>
<#include "admin/foot.ftl">
</body>
</html>
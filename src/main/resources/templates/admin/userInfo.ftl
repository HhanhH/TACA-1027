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
<script src="../../../static/js/admin/userList.js"></script>
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
							<label for="user-name" class="am-u-sm-3 am-form-label">ID
								<span class="tpl-form-line-small-title">ID</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="name" name="name"  value="${user.id}"> 
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">用户名
								<span class="tpl-form-line-small-title">name</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="name" name="name"  value="${user.userName}"> 
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">昵称
								<span class="tpl-form-line-small-title">nickName</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="nickName" name="nickName"  value="${user.nickName}"> 
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
							<label for="user-name" class="am-u-sm-3 am-form-label">UM
								<span class="tpl-form-line-small-title">um</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="um" name="um"  value="${user.um}"> 
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">密码
								<span class="tpl-form-line-small-title">password</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="password" name="password"  value="${user.password}"> 
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">应用ID
								<span class="tpl-form-line-small-title">wxOpenId</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="wxOpenId" name="wxOpenId"  value="${user.wxOpenId}"> 
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">邮箱
								<span class="tpl-form-line-small-title">emailAddress</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="emailAddress" name="emailAddress"  value="${user.emailAddress}"> 
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">可用星点
								<span class="tpl-form-line-small-title">availableStar</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="availableStar" name="availableStar"  value="${user.availableStar}"> 
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">冻结星点
								<span class="tpl-form-line-small-title">freezeStar</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="freezeStar" name="freezeStar"  value="${user.freezeStar}"> 
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">历史累积星点
								<span class="tpl-form-line-small-title">historyStar</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="historyStar" name="historyStar"  value="${user.historyStar}"> 
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
							<label for="user-name" class="am-u-sm-3 am-form-label">称号
								<span class="tpl-form-line-small-title">honorTitle</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="honorTitle" name="honorTitle"  value="${user.honorTitle}"> 
							</div>
						</div>
						
					<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">状态
								<span class="tpl-form-line-small-title">status</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="status" name="status"  value="${user.status}"> 
							</div>
						</div>
						
							<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">注册时间
								<span class="tpl-form-line-small-title">createTime</span>
							</label>
							<div class="am-u-sm-9">
							<#if user.createTime ??>
								<input type="text" class="tpl-form-input" id="createTime" name="createTime"  value="${user.createTime?date}"> 
									<#else>
							<input type="text" class="tpl-form-input" id="updateTime" name="updateTime"  value=""> 
							</#if>
							</div>
						</div>
						
							<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">更新时间
								<span class="tpl-form-line-small-title">updateTime</span>
							</label>
							<div class="am-u-sm-9">
							<#if user.updateTime ??>
								<input type="text" class="tpl-form-input" id="updateTime" name="updateTime"  value="${user.updateTime?date}"> 
							<#else>
							<input type="text" class="tpl-form-input" id="updateTime" name="updateTime"  value=""> 
							</#if>
							
							</div>
						</div>
					 <div class="am-form-group">
					<label class="am-u-sm-3 am-form-label">头像<span
						class="tpl-form-line-small-title">icon</span></label>
							<div class="am-u-sm-9">
										<img
													src="${base}/icon/show?iconAddress=${user.iconAddress}"
													height="120" width="200" />
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
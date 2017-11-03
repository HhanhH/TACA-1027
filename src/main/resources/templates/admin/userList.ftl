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
<script src="../../static/js/admin/userList.js"></script>
<script src="../../static/js/admin/page.js"></script>
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
				<div class="portlet-title">
					<div class="caption font-green bold">用户列表</div>
					
					<form id="form" action="${base}/admin/user/list" method="post" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"/>
                    <input type="hidden" id="responseURL" name="responseURL" value="${base}/admin/user/list"/>
					 <table class="am-table am-table-striped am-table-hover table-main"
						id="table1">

						<tr>
							<td>用户名(UM):<input type="text" name="userName" value="${userInfo.userName}" style="width: 90px"></td>
							<td>团队:<select data-am-selected="{btnSize: 'sm'}"
								id="groupName" name="groupName">
									<option value="all">查询所有</option> 
									<#if "groupList"?exists>
									<#list groupList as group> <#if
									group=="${userInfo.groupName?default('')}">
									<option value="${group}" selected>${group}</option> <#else>
									<option value="${group}">${group}</option> </#if> </#list> </#if>
							</select></td>
							<td>注册时间：
							<input type="Date" name="createTime1"
								id="createTime1" style="width: 130px"
								value="${createTime1?default('')}"/>
								
								&nbsp;&nbsp;~&nbsp;&nbsp;
								<input type="Date" name="createTime2"
								id="createTime2" style="width: 130px"
								value="${createTime2?default('')}"/>
								
							<td>

								<button type="submit"
									class="am-btn am-btn-default am-btn-xs am-text-secondary"
									
									style="background-color: #63B8FF; color: white;">搜索</button>
							</td>
						</tr>
					</table>
					</form>


				</div>
		
				<div class="am-g">
					<div class="am-u-sm-12">

						<form class="am-form">
							<div style="height: 500px;">
								<table
									class="am-table am-table-striped am-table-hover table-main">
									<thead>
										<tr class="am-success">
											<th class="table-id">ID</th>
											<th class="table-title">Name</th>
											<th class="table-title">昵称</th>
											<th class="table-type">真实姓名</th>
											<th class="table-type">团队</th>
											<th class="table-author am-hide-sm-only">可用星点</th>
											<th class="table-author am-hide-sm-only">累计星点</th>
											<th class="table-date am-hide-sm-only">称号</th>
											<th width="185px" class="table-set">操作</th>
										</tr>
									</thead>
									<tbody>
									<#list list as user>
										<tr>
											<td>${user.id}</td>
											<td class="am-hide-sm-only">${user.userName}</a></td>
											<td class="am-hide-sm-only">${user.nickName}</td>
											<td class="am-hide-sm-only">${user.userNameCn}</td>
											<td class="am-hide-sm-only">${user.groupName}</td>
											<td class="am-hide-sm-only">${user.availableStar}</td>
											<td class="am-hide-sm-only">${user.historyStar}</td>
											<td class="am-hide-sm-only">${user.honorTitle}</td>
											<td>
												<div class="am-btn-toolbar">
													<div class="am-btn-group am-btn-group-xs">
													 <nobr>.
													  <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><a href="${base}/admin/user/info/${user.id}"> 详情</a></button>
														<button class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="active(${user.id})">
															注销</button>
														</nobr>

													</div>
												</div>
											</td>
										</tr>
										</#list>
									</tbody>
								</table>
								<hr />
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	<#include "admin/page.ftl">
	<#include "admin/foot.ftl">


</body>
</html>
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
<script src="../../static/js/admin/announcementList.js"></script>
<script src="${base}/static/js/admin/page.js"></script>
<link rel="stylesheet" href="../../static/css/admin/amazeui2.min.css" />
<link rel="stylesheet" href="../../static/css/admin/admin2.css">
<link rel="stylesheet" href="../../static/css/admin/app2.css">
</head>

	<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->


<body>
<#include "admin/menu.ftl">

<!--menu end  -->

    </style>
		<div class="tpl-content-wrapper" style="height:499px;">

			<div class="tpl-portlet-components">
				<div class="portlet-title">
					<div class="caption font-green bold">公告列表</div>
						<div class="tpl-block">
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
						<div class="am-btn-toolbar">
							<div class="am-btn-group am-btn-group-xs">
								<button type="button"
									class="am-btn am-btn-default am-btn-success">
									<span class="am-icon-plus"></span><a href="goAdd">
										添加公告</a>
								</button>

							</div>
						</div>
					</div>


				</div>
			</div>
					<form id="form" action="${base}/admin/notice/list" method="post" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"/>
                    <input type="hidden" id="responseURL" name="responseURL" value="${base}/admin/notice/list"/>
					 <table class="am-table am-table-striped am-table-hover table-main"
						id="table1">

						<tr>
							<td>公告名称:<input type="text" name="title" value="${noticeInfo.title}" style="width: 90px"></td>
							<td>创建时间：
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

				<form class="am-form am-g">
					<table width="100%"
						class="am-table am-table-striped am-table-hover table-main">
						<thead>
						
							<tr class="am-success">
								<th class="table-id">ID</th>
								<th class="table-title">公告名称</th>
								<th class="table-type">内容</th>
								<th class="table-type">展示图</th>
								<th class="table-type">状态</th>
								<th class="table-type">创建时间</th>
								<th class="table-type">更新时间</th>
								<th width="150px" class="table-set">操作</th>
							</tr>
						</thead>
						<tbody>
						<#list list as notice>
							<tr>
								<td table-id>${notice.id}</td>
								<td class="am-hide-sm-only">${notice.title}</td>
								<td class="am-hide-sm-only">${notice.content}</td>
								<td class="am-hide-sm-only">
								<#if notice.iconAddress??>
								<img src="${base}/icon/show?iconAddress=${notice.iconAddress}" height="35" width="50"></img>
								</#if>
								</td>
								
								<td class="am-hide-sm-only">
								<#if notice.status=="ACTIVE">
								已发布
								<#else>
								未发布
								</#if>
								
								</td>
								<#if notice.createTime ??>
									<td class="am-hide-sm-only">${notice.createTime?date}</td>
								<#else>
									<td class="am-hide-sm-only"></td>
								</#if>
											
								<#if notice.updateTime ??>
									<td class="am-hide-sm-only">${notice.updateTime?date}</td>
								<#else>
									<td class="am-hide-sm-only"></td>
								</#if>

								<td>
									<div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs">
											<nobr><button
												class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="active('${notice.id}','${notice.status}')">
												<#if notice.status == 'ACTIVE' >撤销<#else>发布</#if></button>
											<button
												class="am-btn am-btn-default am-btn-xs am-hide-sm-only" ><a href="${base}/admin/notice/goEdit/${notice.id}">编辑</a></button>
											
                                          </nobr>
										</div>
									</div>
								</td>
							</tr>
							</#list>

						</tbody>
					</table>


					<hr />

				</form>



			</div>

		</div>

<#include "admin/page.ftl">

	<#include "admin/foot.ftl">
</body>
</html>
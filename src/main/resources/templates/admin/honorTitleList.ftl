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
<script src="../../static/js/admin/honorTitleList.js"></script>
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
					<div class="caption font-green bold">称号列表</div>
					<div class="tpl-block">
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
						<div class="am-btn-toolbar">
							<div class="am-btn-group am-btn-group-xs">
								<button type="button"
									class="am-btn am-btn-default am-btn-success">
									<span class="am-icon-plus"></span><a href="${base}/admin/title/goAdd">
										添加称号</a>
								</button>

							</div>
						</div>
					</div>


				</div>
			</div>
					<form id="form" action="" method="post" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"/>
                    <input type="hidden" id="responseURL" name="responseURL" value="${base}/admin/title/list"/>
					<div class="tpl-portlet-input tpl-fz-ml">
						<div class="portlet-input input-small input-inline">
							<div class="input-icon right">
								<i class="am-icon-search"></i> <input type="text"
									class="form-control form-control-solid" placeholder="搜索...">
							</div>
						</div>
					</div>
					</form>


				</div>
		
				<div class="am-g">
					<div class="am-u-sm-12">

						<form class="am-form">
							<div style="height: 450px;">
								<table
									class="am-table am-table-striped am-table-hover table-main">
									<thead>
										<tr class="am-success">
											<th class="table-id">ID</th>
											<th class="table-title">称号</th>
                                            <th class="am-hide-sm-only">星点</th>
											<th class="table-type">创建时间</th>
											<th class="table-type">更新时间</th>
											<th width="140px" class="table-set">操作</th>
											
										</tr>
									</thead>
									<tbody>
									<#list list as title>
										<tr>
											<td table-id>${title.id}</td>
											<td class="am-hide-sm-only">${title.title}</td>
											<td class="am-hide-sm-only">${title.starNumber}</td>
											<#if title.createTime ??>
											<td class="am-hide-sm-only">${title.createTime?date}</td>
											<#else>
											<td class="am-hide-sm-only"></td>
											</#if>
											
											<#if title.updateTime ??>
											<td class="am-hide-sm-only">${title.updateTime?date}</td>
											<#else>
											<td class="am-hide-sm-only"></td>
											</#if>
											<td>
												<div class="am-btn-toolbar" >
													<div class="am-btn-group am-btn-group-xs">
														
														<button
															class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><a href="${base}/admin/title/goEdit/${title.id}">
															编辑</a></button>

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
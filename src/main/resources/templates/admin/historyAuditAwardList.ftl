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
<script src="../../static/js/admin/historyAuditAward.js"></script>
<script src="../../static/js/admin/page.js"></script>
<link rel="stylesheet" href="../../static/css/admin/amazeui2.min.css" />
<link rel="stylesheet" href="../../static/css/admin/admin2.css">
<link rel="stylesheet" href="../../static/css/admin/app2.css">
</head>

	<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->


<body>
	<#include "admin/menu.ftl">
<!--menu end  -->
	<div class="tpl-content-wrapper" style="height:500px;">

			<div class="tpl-portlet-components">
				<div class="portlet-title">
					<div class="caption font-green bold">历史激励审核列表</div>
					<form id="form" action="${base}/admin/shoppingAudit/goHistoryAudit" method="post" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"/>
                    <input type="hidden" id="responseURL" name="responseURL" value="${base}/admin/shoppingAudit/goHistoryAudit"/>
					<table class="am-table am-table-striped am-table-hover table-main"
						id="table1">

						<tr>
							<td>激励名称:<input type="text" name="name"  id="name" value="${shopping.name}" style="width: 90px"></td>
							<td>用户名称:<input type="text" name="username" id="username" value="${shopping.username}" style="width: 90px"></td>
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
									<button onclick="javascript:return exportExcel();"
									class="am-btn am-btn-default am-btn-xs am-text-secondary"
									
									style="background-color: #63B8FF; color: white;">导出</button>
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
								<th class="table-title">userName</th>
								<th class="table-type">兑换激励ID</th>
								<th class="table-type">兑换激励名称</th>
								<th class="table-type">消耗星点</th>
								<th class="table-type">审核意见</th>
								<th class="table-set">审核状态</th>
							</tr>
						</thead>
						<tbody>
						<#list list as shopping>
							<tr>
								<td table-id>${shopping.id} </td>
								<td class="am-hide-sm-only">${shopping.username} </td>
								<td class="am-hide-sm-only"><a href="${base}/admin/goods/info/${shopping.goodsId}">${shopping.goodsId}</a> </td>
								<td class="am-hide-sm-only"><a href="${base}/admin/goods/info/${shopping.goodsId}">${shopping.name}</a> </td>
								<td class="am-hide-sm-only">${shopping.starNumber} </td>
								<td class="am-hide-sm-only">${shopping.message} </td>
								<td class="am-hide-sm-only">
								 
								  <#if shopping.status =='FINISHED'>
                            通过
                            <#else>
                            拒绝</#if>
								
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
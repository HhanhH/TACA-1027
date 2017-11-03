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
<script src="../../static/js/admin/addMutexTask.js"></script>
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
					<div class="caption font-green bold">添加互斥任务</div>


				</div>

				<div class="am-g">
					<div class="am-u-sm-12" style="height:400px;">

						<form class="am-form">
							<div>
								<div id="wins"
									style="float: left; height: 350px; width: 45%; overflow: auto;">
									<table
										class="am-table am-table-striped am-table-hover table-main">
										<thead>
											<tr class="am-success">
												<th class="table-type" style="width: 80px;">任务一</th>
												<th class="table-id">ID</th>
												<th class="table-title">任务名称</th>
												<th class="table-type">类型</th>
												<th class="table-type">类别</th>
												<th class="table-type">互斥任务</th>
											</tr>
										</thead>
										<tbody>
										<#list taskList as task>
											<tr>
												<th class="table-check"><input type="radio" id="radio" id="radio"
													name="radio" class="tpl-table-fz-check"></th>
												<td title="${task.content}"><a href="${base}/admin/task/taskInfo/${task.id}" title="${task.content}">${task.id} </a></td>
												<td class="am-hide-sm-only" title="${task.content}">${task.name} </td>
                                                <td class="am-hide-sm-only" title="${task.content}">${task.type} </td>
												<td class="am-hide-sm-only" title="${task.content}">${task.category} </td>
												<td class="am-hide-sm-only"><#if task.mutexTaskList?
										exists > <#list task.mutexTaskList as mutexTask> <a
										href="../task/taskInfo/${mutexTask}">${mutexTask}</a>,
										</#list> </#if>

									</td>
											</tr>
											</#list>
											
										</tbody>
									</table>
								</div>

								<div
									style="float: right; height: 350px; width: 45%; overflow: auto;">
									<table
										class="am-table am-table-striped am-table-hover table-main">
										<thead>
											<tr class="am-success">
												<th class="table-type" style="width: 80px;">任务二</th>
												<th class="table-id">ID</th>
												<th class="table-title">任务名称</th>
												<th class="table-type">类型</th>
												<th class="table-type">类别</th>
												<th class="table-type">互斥任务</th>

											</tr>
										</thead>
										<tbody>
											<#list taskList as task>
											<tr>
												<th class="am-hide-sm-only"><input type="button"
													name="btn" id="btn" onclick="addMutex(${task.id})" value="添加"></th>
												<td><a href="${base}/admin/task/taskInfo/${task.id}" title="${task.content}">${task.id} </a></td>
												<td class="am-hide-sm-only" title="${task.content}">${task.name} </td>
                                                <td class="am-hide-sm-only" title="${task.content}">${task.type} </td>
												<td class="am-hide-sm-only" title="${task.content}">${task.category} </td>
												<td class="am-hide-sm-only"><#if task.mutexTaskList?
										exists > <#list task.mutexTaskList as mutexTask> <a
										href="../task/taskInfo/${mutexTask}">${mutexTask}</a>,
										</#list> </#if>

									</td>
											</tr>
											</#list>
											
										</tbody>
									</table>
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
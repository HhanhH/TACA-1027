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
<script src="../../static/js/admin/userTaskList.js"></script>
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
				<div class="caption font-green bold">用户任务列表</div>
				 <form id="form" action="${base}/admin/task/userTaskList" method="post" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"/>
                    <input type="hidden" id="responseURL" name="responseURL" value="${base}/admin/task/userTaskList"/>
				   <table class="am-table am-table-striped am-table-hover table-main"
						id="table1">

						<tr>
							<td>任务名称:<input type="text" name="name" value="${receiveTask.name}" style="width: 90px"></td>
							<td>用户名(UM):<input type="text" name="userName" value="${receiveTask.userName}" style="width: 90px"></td>
							<td>状态:<select style="width: 140px"
								data-am-selected="{btnSize: 'sm'}" id="status"
								name="status">
									 <#if receiveTask.status == "PROCEEDING">
                                    <option value="all">查询所有</option>
									<option value="PROCEEDING" selected>进行中</option>
									<option value="PENDING">审核中</option>
									<option value="FINISHED">已完成</option>
									<option value="EXPIRED">已过期</option>
									<#elseif  receiveTask.status == "PENDING">
									<option value="all">查询所有</option>
									<option value="PROCEEDING" >进行中</option>
									<option value="PENDING" selected>审核中</option>
									<option value="FINISHED">已完成</option>
									<option value="EXPIRED">已过期</option>
									<#elseif  receiveTask.status == "FINISHED">
									<option value="all">查询所有</option>
									<option value="PROCEEDING" >进行中</option>
									<option value="PENDING">审核中</option>
									<option value="FINISHED" selected>已完成</option>
									<option value="EXPIRED">已过期</option>
									<#elseif  receiveTask.status == "EXPIRED">
									<option value="all">查询所有</option>
									<option value="PROCEEDING" >进行中</option>
									<option value="PENDING">审核中</option>
									<option value="FINISHED" >已完成</option>
									<option value="EXPIRED" selected>已过期</option>
									<#else>
									<option value="all" selected>查询所有</option>
									<option value="PROCEEDING" >进行中</option>
									<option value="PENDING">审核中</option>
									<option value="FINISHED">已完成</option>
									<option value="EXPIRED">已过期</option>
									</#if>

							</select></td>
							
							</tr>
                              <tr>
							<td>起始领取时间：
							<input type="Date" name="createTime1"
								id="createTime1" style="width: 130px"
								value="${createTime1?default('')}"/></td>
								
								<td>截止领取时间：
								<input type="Date" name="createTime2"
								id="createTime2" style="width: 130px"
								value="${createTime2?default('')}"/>
								</td>
								
							<td>

								<button type="submit"
									class="am-btn am-btn-default am-btn-xs am-text-secondary"
									
									style="background-color: #63B8FF; color: white;">搜索</button>
							</td>
						</tr>
					</table>


			</form>

			</div>
			<div class="tpl-block">
				<div class="am-g"></div>
			</div>
			<div class="am-g">
				<div class="am-u-sm-12">

					<form class="am-form">
						<div >
							<table
								class="am-table am-table-striped am-table-hover table-main">
								<thead>
									<tr class="am-success">
										<th class="table-id">ID</th>
										<th class="table-type">任务名称</th>
										<th class="table-type">用户名</th>
										<th class="table-type">预获星点</th>
										<th class="table-type">实获星点</th>
										<th class="table-type">开始时间</th>
										<th class="table-type">预期完成时间</th>
										<th class="table-type">完成时间</th>
	                           			<th class="table-type">状态</th>
									</tr>
								</thead>
								<tbody>
									<#list reciveTaskList as reciveTask>
									<tr>
										<td class="am-hide-sm-only">${reciveTask.id}</td>
							
										<td class="am-hide-sm-only"><a
											href="taskInfo/${reciveTask.taskId}">${reciveTask.name}</a></td>
										<td class="am-hide-sm-only">${reciveTask.userName}</td>
										<td class="am-hide-sm-only">${reciveTask.preStarNumber}</td>
										<td class="am-hide-sm-only">${reciveTask.actStarNumber}</td>
										 <#if
										reciveTask.startTime??>
										<td class="am-hide-sm-only	">${reciveTask.startTime?date}</td>
										<#else>
										<td></td> </#if>
										<td class="am-hide-sm-only	">${reciveTask.expectedTime?date}</td>
										 <#if
										reciveTask.finishedTime??>
										<td class="am-hide-sm-only	">${reciveTask.finishedTime?date}</td>
										<#else>
										<td></td> </#if>
										<td class="am-hide-sm-only">
										<#if reciveTask.status=='PROCEEDING'>
										进行中
										<#elseif reciveTask.status=='PENDING'>
										审核中
										<#elseif reciveTask.status=='EXPIRED'>
										已过期
										<#else>
										已结束
										</#if>
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
		<div class="tpl-alert"></div>
	</div>

	
	</div>

<#include "admin/page.ftl">
	<#include "admin/foot.ftl">



</body>
</html>
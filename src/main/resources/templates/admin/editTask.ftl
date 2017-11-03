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
<script src="${base}/static/js/admin/taskList.js"></script>
</head>
<body>
	<#include "admin/menu.ftl">
	<!--menu end  -->

	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">
				 修改任务
			</div>
		</div>
		<div class="tpl-block">
			<div class="am-g">
				<div class="tpl-form-body tpl-form-line">
					<form action="${base}/admin/task/updateTaskInfo" method="post" class="am-form tpl-form-line-form" enctype="multipart/form-data" id="form">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">任务ID
								<span class="tpl-form-line-small-title">id</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="id" name="id" readonly="readonly" value="${task.id}"> 
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">任务名称
								<span class="tpl-form-line-small-title">name</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="name" name="name" value="${task.name}"> 
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">内容描述
								<span class="tpl-form-line-small-title">Description</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="am-form-field tpl-form-no-bg" id="content"
									name="content" value="${task.content}"/> 
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">类型
								<span class="tpl-form-line-small-title">Type</span>
							</label>
							<div class="am-u-sm-9">
						
								<select id="type" name="type" >
									<option value="${task.type}">${task.type}</option>
									<#if '${task.type}' == '个人'>
									<option value="多人">多人</option>
									<#else>
									<option value="个人">个人</option>
									</#if>
								</select>
							</div>	
						</div>

						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">任务星级<span
								class="tpl-form-line-small-title">level</span></label>
							<div class="am-u-sm-9">
								<input type="number" id="starLevel" name="starLevel" value="${task.starLevel}">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">可获得星点<span
								class="tpl-form-line-small-title">profit</span></label>
							<div class="am-u-sm-9">
								<input type="number" id="starProfit" name="starProfit" value="${task.starProfit}">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">可领取<span
								class="tpl-form-line-small-title">availableStock</span></label>
							<div class="am-u-sm-9">
								<input type="number"  id="availableStock"  name="availableStock" value="${task.availableStock}">
							</div>
						
							
							<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">每人最多领取数<span
								class="tpl-form-line-small-title"></span></label>
							<div class="am-u-sm-9">
								<input type="number" id="personAvailableStock" name="personAvailableStock" value="${task.personAvailableStock}">
							</div>
						</div>
							<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">周期（day）<span
								class="tpl-form-line-small-title">Length</span></label>
							<div class="am-u-sm-9">
								<input type="number"  id="timeLength" name="timeLength" value="${task.timeLength}">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">反馈方式<span
								class="tpl-form-line-small-title">feedBackWay</span></label>
							<div class="am-u-sm-9">
								<input type="text" id="feedbackWay" name="feedbackWay" value="${task.feedbackWay}">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">上下架<span
								class="tpl-form-line-small-title">OFF/ON</span></label>
							<div class="am-u-sm-9">
								<select id="status" name="status">
									<option value="${task.status}">${task.status}</option>
								<#if '${task.status}' == 'ON'>
									<option value="OFF">OFF</option>
								<#else>	
									<option value="ON">ON</option>
								</#if>
								</select>
							</div>
						</div>


						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">添加分类
								<span class="tpl-form-line-small-title">Category</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" id="category"  name="category" value="${task.category}">
								<div></div>
							</div>
						</div>
						
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">已领取<span
								class="tpl-form-line-small-title">count</span></label>
							<div class="am-u-sm-9">
								<input type="number"  id="count"  name="count" readonly="readonly" value="${task.count}">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">展示图
								<span class="tpl-form-line-small-title">Images</span>
							</label>
							<img alt="" src="${bsae}/icon/show?iconAddress=${task.iconAddress}" height="120" width="200"/>
									
							<div class="am-u-sm-9" style="margin-left:265px;margin-top:20px">
								<input id="doc-form-file" type="file" name="file">

							</div>
						</div>
						
						
						<div class="am-form-group">
								<label class="am-u-sm-3 am-form-label">互斥任务<span
									class="tpl-form-line-small-title">mutex</span></label>
								<div class="am-u-sm-9">
								<span>
                                <#if task.mutexTaskList? exists >
								    <#list task.mutexTaskList as mutexTask>
								    <a href="${base}/admin/task/taskInfo/${mutexTask}">${mutexTask}</a>&nbsp;&nbsp;
								    <button class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="remove(${task.id},${mutexTask})">取消互斥</button>
								    </#list>
							    </#if>
							    </span>
								</div>
								</div>
                      <div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<input type="submit">
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
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
<script src="../../../static/js/admin/taskList.js"></script>
</head>
<body>
	<#include "admin/menu.ftl">
	<!--menu end  -->
<div class="tpl-content-wrapper">
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">任务详情</div>

		</div>
		<div class="portlet-title">

			<div class="caption font-green bold">
				<input type="button" onclick="javascript:history.go(-1)" value="返回" />
			</div>
		</div>
		<div class="tpl-block">
			<div class="am-g">
				<div class="tpl-form-body tpl-form-line">
					<form action="" method="post" class="am-form tpl-form-line-form"
						enctype="multipart/form-data" id="form">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">任务ID
								<span class="tpl-form-line-small-title">ID</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="name" name="name"
									value="${taskInfo.id}">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">任务名称
								<span class="tpl-form-line-small-title">name</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="name" name="name"
									value="${taskInfo.name}">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">内容描述
								<span class="tpl-form-line-small-title">Description</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="am-form-field tpl-form-no-bg"
									id="content" name="content" value="${taskInfo.content}" />
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">类型
								<span class="tpl-form-line-small-title">Type</span>
							</label>
							<div class="am-u-sm-9">

								<select id="type" name="type">
									<option value="${taskInfo.type}">${taskInfo.type}</option>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">任务星级<span
								class="tpl-form-line-small-title">level</span></label>
							<div class="am-u-sm-9">
								<input type="number" id="starLevel" name="starLevel"
									value="${taskInfo.starLevel}">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">可获得星点<span
								class="tpl-form-line-small-title">profit</span></label>
							<div class="am-u-sm-9">
								<input type="number" id="starProfit" name="starProfit"
									value="${taskInfo.starProfit}">
							</div>
						</div>


						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">已领取<span
								class="tpl-form-line-small-title">count</span></label>
							<div class="am-u-sm-9">
								<input type="number" id="count" name="count"
									value="${taskInfo.count}">
							</div>

						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">每人最多领取数<span
								class="tpl-form-line-small-title"></span></label>
							<div class="am-u-sm-9">
								<input type="number" id="personAvailableStock"
									name="personAvailableStock"
									value="${taskInfo.personAvailableStock?c}">
							</div>
						</div>


						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">周期（day）<span
								class="tpl-form-line-small-title">Length</span></label>
							<div class="am-u-sm-9">
								<input type="number" id="timeLength" name="timeLength"
									value="${taskInfo.timeLength}">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">反馈方式<span
								class="tpl-form-line-small-title">feedBackWay</span></label>
							<div class="am-u-sm-9">
								<input type="text" id="feedbackWay" name="feedbackWay"
									value="${taskInfo.feedbackWay}">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">上下架<span
								class="tpl-form-line-small-title">OFF/ON</span></label>
							<div class="am-u-sm-9">
								<select id="status" name="status">
									<option value="${taskInfo.status}">${taskInfo.status}</option>

								</select>
							</div>
						</div>


						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">添加分类
								<span class="tpl-form-line-small-title">Category</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" id="category" name="category"
									value="${taskInfo.category}">
								<div></div>
							</div>
						</div>

						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">当前剩余可领取<span
								class="tpl-form-line-small-title">availableStock</span></label>
							<div class="am-u-sm-9">
								<input type="text" id="availableStock" name="availableStock"
									value="${taskInfo.availableStock?c}">
							</div>
							</div>

							<div class="am-form-group">
								<label class="am-u-sm-3 am-form-label">互斥任务<span
									class="tpl-form-line-small-title">mutex</span></label>
								<div class="am-u-sm-9">
								<span>
                                <#if taskInfo.mutexTaskList? exists >
								    <#list taskInfo.mutexTaskList as mutexTask>
								    <a href="${base}/admin/task/taskInfo/${mutexTask}">${mutexTask}</a>&nbsp;&nbsp;
								    </#list>
							    </#if>
							    </span>
								</div>
								</div>

								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">创建时间<span
										class="tpl-form-line-small-title">createTime</span></label>
									<div class="am-u-sm-9">
										<input type="text" id="createTime" name="createTime"
											value="${taskInfo.createTime?date}">
									</div>
									</div>

									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">更新时间<span
											class="tpl-form-line-small-title">updateTime</span></label>
										<div class="am-u-sm-9">
											<input type="text" id="updateTime" name="updateTime"
												value="${taskInfo.updateTime?date}">
										</div>
										</div>

										<div class="am-form-group">
											<label class="am-u-sm-3 am-form-label">图片展示<span
												class="tpl-form-line-small-title">icon</span></label>
											<div class="am-u-sm-9">
												<#if taskInfo.iconAddress ??>
												<img
													src="${base}/icon/show?iconAddress=${taskInfo.iconAddress}"
													height="120" width="200" />
													</#if>
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
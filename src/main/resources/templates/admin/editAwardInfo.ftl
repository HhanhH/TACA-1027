<!doctype html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>IM后台管理</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<script src="${base}/static/js/admin/awardList.js"></script>
</head>
<body>
<#include "admin/menu.ftl">
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">修改激励信息</div>
		</div>
          <div class="portlet-title">
			
			<div class="caption font-green bold">
				<input type="button"  onclick="javascript:history.go(-1)" value="返回"/>
			</div>
		</div>
		<div class="tpl-block">
			<div class="am-g">
				<div class="tpl-form-body tpl-form-line">
					<form action="${base}/admin/goods/edit" method="post"  enctype="multipart/form-data" class="am-form tpl-form-line-form">
						<div class="am-form-group">
							<label for="user-name"  class="am-u-sm-3 am-form-label">激励ID
								<span class="tpl-form-line-small-title">ID</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="id" name="id" readonly="readonly"
									value="${goods.id}">
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">激励名称
								<span class="tpl-form-line-small-title">Title</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="name" name="name"
									value="${goods.name}">
							</div>
						</div>



						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">类型
								<span class="tpl-form-line-small-title">Type</span>
							</label>
							<div class="am-u-sm-9">

								<select name="type" >
								    <option value="${goods.type}">${goods.type}</option>
								    <#if '${goods.type}' == "普通">
								      <option value="爆款">爆款</option>
								     <#else>
								      <option value="普通">普通</option>
								     </#if>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">消耗星点<span
								class="tpl-form-line-small-title">level</span></label>
							<div class="am-u-sm-9">
								<input type="number" name="starNumber" value="${goods.starNumber}">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">描述<span
								class="tpl-form-line-small-title">Description</span></label>
							<div class="am-u-sm-9">
								<input type="text" name="description" value="${goods.description}">
							</div>
						</div>
						
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">可兑换总数<span
								class="tpl-form-line-small-title">Stock</span></label>
							<div class="am-u-sm-9">
								<input type="number" name="availableStock" value="${goods.availableStock}">
							</div>
						</div>
						
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">上下架<span
								class="tpl-form-line-small-title">OFF/ON</span></label>
							<div class="am-u-sm-9">
								<select name="status">
								     <option value="${goods.status}">${goods.status}</option>
								     <#if '${goods.status}' == "ON">
								      <option value="OFF">OFF</option>
								     <#else>
								      <option value="ON">ON</option>
								     </#if>
								</select>
							</div>
						</div>

						
						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">分类
								<span class="tpl-form-line-small-title">Category</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" id="user-weibo" name="category" value="${goods.category}">
								<div></div>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">累计兑换数<span
								class="tpl-form-line-small-title">count</span></label>
							<div class="am-u-sm-9">
								<input type="number" readonly="readonly" name="count" value="${goods.count}" readonly="readonly">
							</div>
						</div>	
						
						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">添加时间
								<span class="tpl-form-line-small-title">CreateTime</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" id="user-weibo" name="create" value="${goods.createTime?date}" readonly="readonly">
								<div></div>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">更新时间
								<span class="tpl-form-line-small-title">UpdateTime</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" id="user-weibo" name="update" value="${goods.updateTime?date}" readonly="readonly">
								<div></div>
							</div>
						</div>
						
                           <div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">展示图
								<span class="tpl-form-line-small-title">Images</span>
							</label>
							<img alt="" src="${bsae}/icon/show?iconAddress=${goods.iconAddress}" height="120" width="200"/>
									
							<div class="am-u-sm-9" style="margin-left:265px;margin-top:20px">
								<input id="doc-form-file" type="file" name="file">
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

<#include "admin/foot.ftl">




</body>
</html>
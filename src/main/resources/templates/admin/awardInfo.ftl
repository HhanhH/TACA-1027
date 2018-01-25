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
<link rel="stylesheet" href="../../../static/css/admin/amazeui2.min.css" />
<link rel="stylesheet" href="../../../static/css/admin/admin2.css">
<link rel="stylesheet" href="../../../static/css/admin/app2.css">
<script src="../../../static/js/admin/jquery2.min.js"></script>
<script src="../../../static/js/admin/amazeui2.min.js"></script>
<script src="../../../static/js/admin/iscroll2.js"></script>
<script src="../../../static/js/admin/app2.js"></script>
<script src="../../../static/js/admin/awardList.js"></script>
</head>
<body>
<#include "admin/menu.ftl">
	<div class="tpl-portlet-components">
		<div class="portlet-title">
			<div class="caption font-green bold">激励详情</div>
		</div>
          <div class="portlet-title">
			
			<div class="caption font-green bold">
				<input type="button"  onclick="javascript:history.go(-1)" value="返回"/>
			</div>
		</div>
		<div class="tpl-block">
			<div class="am-g">
				<div class="tpl-form-body tpl-form-line">
					<form action="${base}/admin/goods/add" method="post"  enctype="multipart/form-data" class="am-form tpl-form-line-form">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">激励ID
								<span class="tpl-form-line-small-title">ID</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="user-name" name="ID"
									value="${goods.id}">
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">激励名称
								<span class="tpl-form-line-small-title">Title</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="tpl-form-input" id="user-name" name="name"
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
								<input type="number" name="count" value="${goods.count}">
							</div>
						</div>	
						
						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">添加时间
								<span class="tpl-form-line-small-title">CreateTime</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" id="user-weibo" name="createTime" value="${goods.createTime?date}">
								<div></div>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">更新时间
								<span class="tpl-form-line-small-title">UpdateTime</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" id="user-weibo" name="updateTime" value="${goods.updateTime?date}">
								<div></div>
							</div>
						</div>
						
                            <div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">展示图
								<span class="tpl-form-line-small-title">Images</span>
							</label>
							<#if goods.iconAddress ??>
									<img alt="" src="${bsae}/icon/show?iconAddress=${goods.iconAddress}" height="120" width="200"/>
						   </#if>
						</div>
						

						
					</form>

				</div>
			</div>
		</div>
	</div>

<#include "/admin/foot.ftl">




</body>
</html>
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
<script src="../../static/js/admin/awardList.js"></script>
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
					<div class="caption font-green bold">激励列表</div>
						<div class="tpl-block">
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
						<div class="am-btn-toolbar">
							<div class="am-btn-group am-btn-group-xs">
								<button type="button"
									class="am-btn am-btn-default am-btn-success">
									<span class="am-icon-plus"></span><a href="${base}/admin/goods/goAddGoods">
										添加激励</a>
								</button>

							</div>
						</div>
					</div>


				</div>
			</div>
					<form id="form" action="${base}/admin/goods/list" method="post" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"/>
                    <input type="hidden" id="responseURL" name="responseURL" value="${base}/admin/goods/list"/>
					<table class="am-table am-table-striped am-table-hover table-main"
						id="table1">

						<tr>
							<td>名称:<input type="text" name="name" value="${goodsInfo.name}" style="width: 90px"></td>
							<td>类型:<select style="width: 90px"
								data-am-selected="{btnSize: 'sm'}" id="type"
								name="type">
								
                                    <#if goodsInfo.type == "普通">
                                    <option value="all">查询所有</option>
									<option value="普通" selected>普通</option>
									<option value="爆款">爆款</option>
									<#elseif  goodsInfo.type == "爆款">
									<option value="all">查询所有</option>
									<option value="普通" >普通</option>
									<option value="爆款" selected>爆款</option>
									<#else>
									<option value="all" selected>查询所有</option>
									<option value="普通" >普通</option>
									<option value="爆款" >爆款</option>
									</#if>
							</select></td>
							<td>状态:<select style="width: 110px"
								data-am-selected="{btnSize: 'sm'}" id="status"
								name="status">
									 <#if goodsInfo.status == "ON">
                                    <option value="all">查询所有</option>
									<option value="ON" selected>上架</option>
									<option value="OFF">下架</option>
									<#elseif  goodsInfo.status == "OFF">
									<option value="all">查询所有</option>
									<option value="ON" >上架</option>
									<option value="OFF" selected>下架</option>
									<#else>
									<option value="all" selected>查询所有</option>
									<option value="ON" >上架</option>
									<option value="OFF" >下架</option>
									</#if>

							</select></td>
							</tr>
						<tr>
							<td>分类:<select data-am-selected="{btnSize: 'sm'}"
								id="category" name="category">
									<option value="all">查询所有</option> 
									<#if "categoryList"?exists>
									<#list categoryList as cate> <#if
									cate=="${goodsInfo.category?default('')}">
									<option value="${cate}" selected>${cate}</option> <#else>
									<option value="${cate}">${cate}</option> </#if> </#list> </#if>
							</select></td>

						
							<td>星点:<input type="number" name="starNumber1"
								id="starNumber1" style="width: 60px"
								value="${starNumber1}">&nbsp;&nbsp;~&nbsp;&nbsp;<input
								style="width: 60px" type="number" name="starNumber2"
								id="starNumber2" value="${starNumber2}"></td>

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
			
				<div class="am-g">
					<div class="am-u-sm-12">

						<form class="am-form">
							<div style="height: 500px;">
								<table style="border:1px solid #abc"
									class="am-table am-table-striped am-table-hover table-main">
									<thead>
										<tr class="am-success">
											<th class="table-id">ID</th>
											<th class="table-title">激励名称</th>
											
											<th class="table-type">类型</th>
											<th class="table-type">类别</th>
											<th class="table-type">消耗星点</th>
											<th class="table-author am-hide-sm-only">可用库存</th>
											<th class="table-author am-hide-sm-only">累计兑换</th>
											<th class="table-author am-hide-sm-only">状态</th>
											<th width="185px" class="table-set">操作</th>
										</tr>
									</thead>
									<tbody>
									<#list list as goods>
										<tr>
											<td>${goods.id}</td>
											<td class="am-hide-sm-only">${goods.name}</td>
											<td class="am-hide-sm-only">${goods.type}</td>
											<td class="am-hide-sm-only">${goods.category}</td>
											<td class="am-hide-sm-only">${goods.starNumber}</td>
											<td class="am-hide-sm-only">${goods.availableStock}</td>
											<td class="am-hide-sm-only">${goods.count}</td>
											<td class="am-hide-sm-only"><#if goods.status ==
										"ON">上架<#else>下架</#if></td>
											<td>
												<div class="am-btn-toolbar" >
													<div class="am-btn-group am-btn-group-xs">
														<nobr><button
															class="am-btn am-btn-default am-btn-xs am-text-secondary"><a href="${base}/admin/goods/info/${goods.id}">
															详情</a></button>
														<button
															class="am-btn am-btn-default am-btn-xs am-hide-sm-only"onclick="changOffAndOn(${goods.id})"><#if
													goods.status == "ON">下架<#else>上架</#if></button>
														<button
															class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><a href="${base}/admin/goods/goEdit/${goods.id}">
															编辑</a></button></nobr>

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
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
<script src="../../static/js/admin/auditAward.js"></script>
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
					<div class="caption font-green bold">激励审核列表</div>
					<form id="form" action="${base}/admin/shoppingAudit/goAudit" method="post" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"/>
                    <input type="hidden" id="responseURL" name="responseURL" value="${base}/admin/shoppingAudit/goAudit"/>
                   <table class="am-table am-table-striped am-table-hover table-main"
						id="table1">

						<tr>
							<td>激励名称:<input type="text" name="name" value="${shopping.name}" style="width: 90px"></td>
							<td>用户名称:<input type="text" name="username" value="${shopping.username}" style="width: 90px"></td>
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
								<th class="table-title">用户名</th>
								<th class="table-type">兑换激励ID</th>
								<th class="table-type">兑换激励名称</th>
								<th class="table-type">消耗星点</th>
								<th width="184px" class="table-set">审核</th>
							</tr>
						</thead>
						<tbody>
						<#list list as shopping>
							<tr>
								<td>${shopping.id}</td>
								<td class="am-hide-sm-only">${shopping.username}</td>
								<td class="am-hide-sm-only" title="${shopping.content}"><a href="${base}/admin/goods/info/${shopping.goodsId}">${shopping.goodsId}</a></td>
								<td class="am-hide-sm-only" title="${shopping.content}"><a href="${base}/admin/goods/info/${shopping.goodsId}">${shopping.name}</a></td>
								<td class="am-hide-sm-only">${shopping.starNumber}</td>
                                <td>
                               <div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
											<nobr><label
													class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
													<input type="radio" name="audit" id="auditAgree${shopping.id}"
													checked="checked" clicked="0" onclick="agree(${shopping.id})" />通过
												</label> <label 
													class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
													<input type="radio" onclick="myClick(${shopping.id})" name="audit" id="auditReject${shopping.id}" />拒绝
												</label></nobr>

											</div>
										</div>

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

	 
	 <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">填写拒绝原因</div>
    <div class="am-modal-bd">
     
      <input type="text" class="am-modal-prompt-input">
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>提交</span>
    </div>
  </div>
</div> 

<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
    <div class="am-modal-bd">
                    确定审核通过
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>
 <#include "admin/page.ftl">
      <#include "admin/foot.ftl">
</body>
</html>
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
<script src="../../static/js/admin/userImport.js"></script>
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
				<div class="caption font-green bold">部门人员录入</div>



				<div class="fbneirong">
					<div class="am-tabs am-margin" data-am-tabs>
						<ul class="am-tabs-nav am-nav am-nav-tabs">

							<li><a href="#tab4">批量添加</a></li>
							<li><a href="#tab5">单人录入</a></li>
						</ul>

						<div class="am-tabs-bd">
							<div class="am-tab-panel am-fade" id="tab4">
								<div class="am-form-group am-cf">
									<div class="zuo"></div>
									<div class="you" style="height: 45px;">

										<p class="am-form-help"></p>
									</div>
								</div>
								<form id="form" action="" method="post" enctype="multipart/form-data">
								<div class="am-form-group am-cf">
									<div class="zuo">选择文件：</div>
									<div class="you" style="height: 45px;">
										<input type="file" id="doc-ipt-file-1" name="file">
										<p class="am-form-help">请选择要上传excel文件...</p>
									</div>
								</div>

								<div class="am-form-group am-cf">
									<div class="zuo"><div style="float:center">
								
								<#if success ??><span >${success}</span></#if>
								</div></div>
									<div class="you" style="height: 45px;"></div>
								</div>

								<div class="am-form-group am-cf">
									<div class="you" style="margin-left: 11%;">
										<button  id="submitButton" type="submit" clicked="0"  style="width:70px">上&nbsp;&nbsp;&nbsp;&nbsp;传</button>
                                        <button   style="width:100px"><a href="${base}/admin/user/download">下载模板</a></button>
									</div>
								</div>
								</form>
								
							</div>



							<div class="am-tab-panel am-fade" id="tab5">
								<form class="am-form" id="form2" action=""  method="post" enctype="application/x-www-form-urlencoded">
									<div class="am-g am-margin-top-sm">
										<div class="am-u-sm-4 am-u-md-2 am-text-right">U&nbsp;&nbsp;M：</div>
										<div class="am-u-sm-8 am-u-md-4 am-u-end">
											<input type="text" class="am-input-sm-my"
												style="width: 100%; height: 30px;" name="um" id="um">
										</div>
									</div>

									<div class="am-g am-margin-top-sm">
										<div class="am-u-sm-4 am-u-md-2 am-text-right">姓名：</div>
										<div class="am-u-sm-8 am-u-md-4 am-u-end">
											<input type="text" class="am-input-sm-my"
												style="width: 100%; height: 30px;" name="userNameCn" id="userNameCn">
										</div>
									</div>
									
									<div class="am-g am-margin-top-sm">
										<div class="am-u-sm-4 am-u-md-2 am-text-right">部门ID：</div>
										<div class="am-u-sm-8 am-u-md-4 am-u-end">
											<input type="text" class="am-input-sm-my"
												style="width: 100%; height: 30px;" name="groupId" id="groupId">
										</div>
									</div>
									

									<div class="am-g am-margin-top-sm">
										<div class="am-u-sm-4 am-u-md-2 am-text-right">部门：</div>
										<div class="am-u-sm-8 am-u-md-4 am-u-end">
											<input type="text" class="am-input-sm-my"
												style="width: 100%; height: 30px;" name="groupName" id="groupName">
										</div>
									</div>

									<div class="am-form-group am-cf">
										<div class="you" style="margin-left: 11%;">
											<button type="submit" id="btn" class="am-btn am-btn-success am-radius"
												style="margin: 0 20%;">提&nbsp;&nbsp;&nbsp;&nbsp;交</button>

										</div>
									</div>
								</form>
							</div>


						</div>
					</div>
				</div>
			</div>

		</div>
	</div>


	<#include "admin/foot.ftl">
</body>
</html>
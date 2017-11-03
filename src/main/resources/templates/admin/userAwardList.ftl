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
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css">
<!-- <script src="assets/js/jquery.min.js"></script>
<script src="assets/js/app.js"></script> -->
<link rel="icon" type="image/png" href="assets/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/assets/css/admin.css">
<link rel="stylesheet" href="assets/assets/css/app.css">
<!-- <script src="assets/assets/js/echarts.min.js"></script> -->
</head>

<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->


<body>
	<header class="am-topbar am-topbar-inverse admin-header">
		<div class="am-topbar-brand">
			<a href="javascript:;" class="tpl-logo"> <img
				src="assets/assets/img/logo.png" alt="">
			</a>
		</div>

		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>


	</header>
	<div>
		<div class="tpl-page-container tpl-page-header-fixed">


			<div class="tpl-left-nav tpl-left-nav-hover">

				<div class="tpl-left-nav-title">
					<span>IM管理菜单</span>
				</div>
				<div class="tpl-left-nav-list">
					<ul class="tpl-left-nav-menu">
						<li class="tpl-left-nav-item"><a href="index.html"
							class="nav-link "> <i class="am-icon-home"></i> <span>首页</span>
						</a></li>


						<li class="tpl-left-nav-item"><a href="javascript:;"
							class="nav-link tpl-left-nav-link-list "> <i
								class="am-icon-table"></i> <span>任务管理</span> <i
								class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
							<ul class="tpl-left-nav-sub-menu">
								<li><a href="./taskList.html"> <i
										class="am-icon-angle-right "></i> <span>任务列表</span>
								</a> <a href="./mutexTaskList.html"> <i
										class="am-icon-angle-right"></i> <span>互斥任务</span>
								</a> <a href="./userTaskList.html"> <i
										class="am-icon-angle-right"></i> <span>用户任务</span>
								</a></li>
							</ul></li>

						<li class="tpl-left-nav-item"><a href="javascript:;"
							class="nav-link tpl-left-nav-link-list active"> <i
								class="am-icon-wpforms"></i> <span>激励管理</span> <i
								class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
						</a>
							<ul class="tpl-left-nav-sub-menu"  style="display: block">
								<li><a href="./awardList.html"> <i
										class="am-icon-angle-right"></i> <span>激励列表</span> <i
										class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
								</a> <a href="./userAwardList.html"  class="active"> <i class="am-icon-angle-right"></i>
										<span>兑换记录</span>
								</a></li>
							</ul></li>

						<li class="tpl-left-nav-item"><a href="javascript:;"
							class="nav-link tpl-left-nav-link-list"> <i
								class="am-icon-wpforms"></i> <span>会员管理</span> <i
								class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
						</a>
							<ul class="tpl-left-nav-sub-menu">
								<li><a href="./userList.html"> <i
										class="am-icon-angle-right"></i> <span>会员列表</span> <i
										class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
								</a> <a href="./import.html"> <i class="am-icon-angle-right"></i>
										<span>部门人员录入</span>
								</a></li>
							</ul></li>
						<li class="tpl-left-nav-item"><a href="javascript:;"
							class="nav-link tpl-left-nav-link-list"> <i
								class="am-icon-wpforms"></i> <span>审核管理</span> <i
								class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
						</a>
							<ul class="tpl-left-nav-sub-menu">
								<li><a href="./auditTask.html"> <i
										class="am-icon-angle-right"></i> <span>任务完成审核</span> <i
										class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
								</a> <a href="./auditTask.html"> <i class="am-icon-angle-right"></i>
										<span>历史任务审核</span> <i
										class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
								</a> <a href="./auditTask.html"> <i class="am-icon-angle-right"></i>
										<span>历史激励审核</span> <i
										class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
								</a> <a href="./auditAware.html"> <i class="am-icon-angle-right"></i>
										<span>激励兑换审核</span>
								</a></li>
							</ul></li>

						<li class="tpl-left-nav-item"><a href="javascript:;"
							class="nav-link tpl-left-nav-link-list"> <i
								class="am-icon-wpforms"></i> <span>公告</span> <i
								class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
						</a>
							<ul class="tpl-left-nav-sub-menu">
								<li><a href="./announcementList.html"> <i
										class="am-icon-angle-right"></i> <span>公告列表</span> <i
										class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
								</a> <a href="./addNewAnnoncement.html"> <i
										class="am-icon-angle-right"></i> <span>添加公告</span>
								</a></li>
							</ul></li>
						<li class="tpl-left-nav-item"><a href="javascript:;"
							class="nav-link tpl-left-nav-link-list"> <i
								class="am-icon-wpforms"></i> <span>风云榜</span> <i
								class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
						</a>
							<ul class="tpl-left-nav-sub-menu">
								<li><a href="./announcementList.html"> <i
										class="am-icon-angle-right"></i> <span>用户榜单</span> <i
										class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
								</a></li>
							</ul></li>

					</ul>
				</div>
			</div>
		</div>


		<!--menu end  -->
		<div class="tpl-content-wrapper">

			<div class="tpl-portlet-components">
				<div class="portlet-title">
					<div class="caption font-green bold">用户任务列表</div>
					<div class="tpl-portlet-input tpl-fz-ml">
						<div class="portlet-input input-small input-inline">
							<div class="input-icon right">
								<i class="am-icon-search"></i> <input type="text"
									class="form-control form-control-solid" placeholder="搜索...">
							</div>
						</div>
					</div>


				</div>
				<div class="tpl-block">
					<div class="am-g"></div>
				</div>
				<div class="am-g">
					<div class="am-u-sm-12">

						<form class="am-form">
						<div style="height:450px;overflow:auto;">
							<table
								class="am-table am-table-striped am-table-hover table-main">
								<thead>
									<tr class="am-success">
										<th class="table-id">ID</th>
										<th class="table-type">用户ID</th>
										<th class="table-title">UM</th>
										<th class="table-type">姓名</th>
										<th class="table-type">激励ID</th>
										<th class="table-type">激励名称</th>
										<th class="table-type">进度</th>
									</tr>
								</thead>
								<tbody>
									<tr>

										<td>14</td>
										<td>2</td>
										<td><a href="#">ZHANGSAN123</a></td>
										<td class="am-hide-sm-only">落落</td>
										<td class="am-hide-sm-only">1</td>
										<td class="am-hide-sm-only">购物券</td>
										<td class="am-hide-sm-only">审核中</td>

									</tr>
									<tr>

										<td>14</td>
										<td>2</td>
										<td><a href="#">ZHANGSAN123</a></td>

										<td class="am-hide-sm-only">落落</td>
										<td class="am-hide-sm-only">1</td>
										<td class="am-hide-sm-only">购物券</td>
										<td class="am-hide-sm-only">审核中</td>
									</tr>
									<tr>

										<td>14</td>
										<td>2</td>
										<td><a href="#">ZHANGSAN123</a></td>

										<td class="am-hide-sm-only">落落</td>
										<td class="am-hide-sm-only">1</td>
										<td class="am-hide-sm-only">购物券</td>
										<td class="am-hide-sm-only">审核中</td>

									</tr>
									<tr>

										<td>14</td>
										<td>2</td>
										<td><a href="#">ZHANGSAN123</a></td>

										<td class="am-hide-sm-only">落落</td>
										<td class="am-hide-sm-only">1</td>
										<td class="am-hide-sm-only">购物券</td>
										<td class="am-hide-sm-only">审核中</td>

									</tr>
									<tr>

										<td>14</td>
										<td>2</td>
										<td><a href="#">ZHANGSAN123</a></td>

										<td class="am-hide-sm-only">落落</td>
										<td class="am-hide-sm-only">1</td>
										<td class="am-hide-sm-only">购物券</td>
										<td class="am-hide-sm-only">审核中</td>

									</tr>
									<tr>

										<td>14</td>
										<td>2</td>
										<td><a href="#">ZHANGSAN123</a></td>

										<td class="am-hide-sm-only">落落</td>
										<td class="am-hide-sm-only">1</td>
										<td class="am-hide-sm-only">购物券</td>
										<td class="am-hide-sm-only">审核中</td>

									</tr>
									<tr>

										<td>14</td>
										<td>2</td>
										<td><a href="#">ZHANGSAN123</a></td>

										<td class="am-hide-sm-only">落落</td>
										<td class="am-hide-sm-only">1</td>
										<td class="am-hide-sm-only">购物券</td>
										<td class="am-hide-sm-only">审核中</td>

									</tr>
									<tr>

										<td>14</td>
										<td>2</td>
										<td><a href="#">ZHANGSAN123</a></td>

										<td class="am-hide-sm-only">落落</td>
										<td class="am-hide-sm-only">1</td>
										<td class="am-hide-sm-only">购物券</td>
										<td class="am-hide-sm-only">已兑换</td>

									</tr>

								</tbody>
							</table>
							<hr />
							</div>
						</form>


					</div>

				</div>
			</div>
			
		</div>

	</div>


	<div class="foods" style="position: relative; bottom: 0;">
		<ul>
			<li>版权所有@2017</li>
		</ul>

	</div>


	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<!-- <script src="assets/js/amazeui.min.js"></script> -->
	<script src="assets/assets/js/jquery.min.js"></script>
	<script src="assets/assets/js/amazeui.min.js"></script>
	<script src="assets/assets/js/iscroll.js"></script>
	<script src="assets/assets/js/app.js"></script>
	<!--<![endif]-->



</body>
</html>
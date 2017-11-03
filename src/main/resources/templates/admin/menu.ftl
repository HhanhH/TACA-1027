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
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
</head>

<body>
	<header class="am-topbar am-topbar-inverse admin-header">
		<div class="am-topbar-brand">
			<h2>IM后台管理 &nbsp; &nbsp; &nbsp;<small>${admin.adminName}</small></h2>
			
		</div>
		<div style="float:right;margin-right:30px;"><a href="${base}/admin/loginOut" style="color:black">退出</a></div>
	</header>


	<div class="tpl-page-container tpl-page-header-fixed" style="min-heigth:600px">

		<div class="tpl-left-nav tpl-left-nav-hover" style="min-height:600px">

			<div class="tpl-left-nav-title">
				<span>IM管理菜单</span>
			</div>
			<div class="tpl-left-nav-list">
				<ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item" ><a id="a-index" href="${base}/admin/index"
						class="nav-link "> <i></i> <span>首页</span>
					</a></li>
					<li class="tpl-left-nav-item "><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list" > <i
							></i> <span>任务管理</span> <i
						></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" id="ul-task-manage">	
							<li><a href="${base}/admin/task/taskList"  class="" id="a-task-list"> <i 
									class=""></i> <span>任务列表</span>
							</a> <a href="${base}/admin/task/goAddMutexTask" class="" id="a-task-mutex"> <i ></i> <span>添加互斥任务</span>
							</a> <a href="${base}/admin/task/userTaskList" class="" id="a-user-task"> <i ></i> <span>用户任务</span>
							</a></li>
						</ul></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							></i> <span>激励管理</span> <i
							></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" id="ul-award-manage">
							<li><a href="${base}/admin/goods/list" class="" id="a-award-list"> <i ></i> <span>激励列表</span>
									<i
									></i>
							</a> <a href="${base}/admin/goods/goAddGoods" class="" id="a-award-add"> <i></i> <span>添加激励</span>
							</a></li>
						</ul></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							></i> <span>会员管理</span> <i
							></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" id="ul-user-manage">
							<li><a href="${base}/admin/user/list" class="" id="a-user-list"> <i></i> <span>会员列表</span>
									<i
									></i>
							</a> <a href="${base}/admin/user/goImportUser" class="" id="a-user-import"> <i></i> <span>部门人员录入</span>
							</a>
							<a href="${base}/admin/user/groupUser" class="" id="a-user-group"> <i></i> <span>部门人员列表</span>
							</a></li>
						</ul></li>
					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							></i> <span>审核管理</span> <i
							></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" id="ul-audit-manage">
							<li><a href="${base}/admin/audit/goAudit" class="" id="a-audit-task"> <i ></i> <span>任务完成审核</span>
									<i
									></i>
							</a>
							<a href="${base}/admin/shoppingAudit/goAudit" class="" id="a-audit-award"> <i ></i> <span>激励兑换审核</span>
							</a>
							 <a href="${base}/admin/audit/goHistoryAudit" class="" id="a-audit-task-history"> <i ></i> <span>历史审核任务</span>
									<i
									></i>
							</a> <a href="${base}/admin/shoppingAudit/goHistoryAudit" class="" id="a-audit-award-history"> <i></i> <span>历史审核激励</span>
									<i
									></i>
							</a> </li>
						</ul></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list  "> <i
							></i> <span>公告</span> <i
							></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" id="ul-announcement-manage">
							<li><a href="${base}/admin/notice/list" class="" id="a-announcement-list"> <i></i> <span>公告列表</span>
									<i
									></i>
							</a> <a href="${base}/admin/notice/goAdd" class="" id="a-announcement-add"> <i ></i> <span>添加公告</span>
							</a></li>
						</ul></li>
					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							></i> <span>风云榜</span> <i
							></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" id="ul-armory-manage">
							<li><a href="${base}/admin/user/getArmory" class="" id="a-user-armory"><i ></i>  <span>用户榜单</span>
									<i
									></i>
							</a> <a href="${base}/admin/title/list" class="" id="a-title-list"> <i ></i> <span>称号列表</span>
									<i
									></i>
							</a>
							 <a href="${base}/admin/title/goAdd" class="" id="a-add-title"> <i ></i> <span>添加称号</span>
									<i
									></i>
							</a>
							</li>
						</ul></li>

				</ul>
			</div>
		</div>
	</div>
	
</body>

</html>
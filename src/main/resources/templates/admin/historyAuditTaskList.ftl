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
<script src="../../static/js/admin/historyAuditTask.js"></script>
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
                    <div class="caption font-green bold">
                                                                 历史任务审核列表
                    </div>
                    <form id="form" action="${base}/admin/audit/goHistoryAudit" method="post" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"/>
                    <input type="hidden" id="responseURL" name="responseURL" value="${base}/admin/audit/goHistoryAudit"/>
                   <table class="am-table am-table-striped am-table-hover table-main"
						id="table1">

						<tr>
							<td>任务名称:<input type="text" name="name" id="name" value="${auditTask.name}" style="width: 90px"></td>
							<td>用户名称:<input type="text" name="userName" id="userName" value="${auditTask.userName}" style="width: 90px"></td>
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
									<button onclick="javascript:return exportExcel();"
									class="am-btn am-btn-default am-btn-xs am-text-secondary"
									
									style="background-color: #63B8FF; color: white;">导出</button>
							</td>
						</tr>
					</table>
                    </form>

                </div>
                
                    <div class="am-g">
                        <div class="am-u-sm-12">
               
						 <form class="am-form">
						 <div style="height:450px;">
                            <table class="am-table am-table-striped am-table-hover table-main">
                              <thead>
                              <tr class="am-success">
                               <th class="table-id">ID</th>
								<th class="table-type">任务名称</th>
								<th class="table-title">用户名</th>
								<th class="table-type">预期星点</th>
								<th class="table-type">实际获得星点</th>
								<th class="table-type">领取时间</th>
								<th class="table-type">反馈内容</th>
								<th class="table-type">反馈文件</th>
								
								<th  width="100px" class="table-set">审核</th>
								<th class="table-set" width="100px">审核意见</th>
                                 </tr>
                                    </thead>
						<tbody>
							<tr>

								<#list list as auditTask>
						<tr>
							<td>${auditTask.id}</td>
							<td><a href="${base}/admin/task/taskInfo/${auditTask.taskId}">${auditTask.name}</a></td>
							<td class="am-hide-sm-only">${auditTask.userName}</td>
							<td class="am-hide-sm-only">${auditTask.preStarNumber}</td>
							<td class="am-hide-sm-only">${auditTask.actStarNumber}</td>
						
							<td class="am-hide-sm-only">${auditTask.startTime?date}</td>	
							<td class="am-hide-sm-only">${auditTask.receiveBook}</td>
							<td class="am-hide-sm-only"><#if auditTask.fileAddress ??><a
								href="${base}/admin/audit/download?fileAddress=${auditTask.fileAddress}">下载</a>
								<#else>
								无反馈文件</#if></td>
                            <td class="am-hide-sm-only">
                            <#if auditTask.status =='AGREE'>
                            通过
                            <#else>
                            拒绝</#if>
                          
                            
                            </td>
                            <td class="am-hide-sm-only" >${auditTask.message}</td>
							
							
									</#list>
							
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
		
     <#include "admin/page.ftl">
     <#include "admin/foot.ftl">
</body>
</html>
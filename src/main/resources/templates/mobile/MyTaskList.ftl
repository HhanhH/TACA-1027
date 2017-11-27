<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <link rel="stylesheet" href="../../../static/mobile/css/amazeui.min.css">
  <link rel="stylesheet" href="../../../static/mobile/css/wap.css">
  <link rel="stylesheet" href="../../../static/mobile/css/my.css">
  <script src="../../../static/mobile/js/jquery.min.js"></script>
  <script src="../../../static/mobile/js/amazeui.min.js"></script>
  <title>任务列表页</title>
</head>
<body style="background:#ececec">
  <div class="pet_mian" >
    <div class="pet_head">
      <header data-am-widget="header"
          class="am-header am-header-default pet_head_block">
        <div class="am-header-left am-header-nav ">
          <a href="${base}/mobile/notice/list" class="iconfont pet_head_jt_ico">&#xe601;</a>
        </div>
        <div class="pet_news_list_tag_name">我的任务</div>
        <div class="am-header-right am-header-nav">
          <a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
        </div>
      </header>
    </div>


    <div class="pet_content pet_content_list pet_hd" >
      <div class="pet_article_like" style="min-height:400px">
        <div class="pet_content_main pet_article_like_delete">
          <div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
            <div class="am-list-news-bd">

                 <#list myTaskList as myTaskList>
                 
                
                 <ul class="am-list">
                 <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_hd_list">
                    <a href="###" class="pet_hd_block">
                        <div class="pet_hd_block_title"><a href="${base}/mobile/mytask/detail/${userName}/${myTaskList_index}">
                        任务:&nbsp;&nbsp;${myTaskList.taskName}</a></div>
                       
                         <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>领取时间:&nbsp;${myTaskList.createTime?string("yyyy-MM-dd HH:mm:ss")}</div>
                       <#if myTaskList.status=='FINISHED'>
                        
                        <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>已结束:
                            <#if myTaskList.auditStatus=='AGREE'>审核通过
                            <#elseif myTaskList.auditStatus=='REJECT'>审核拒绝&nbsp;-&nbsp;原因：&nbsp;&nbsp;${myTaskList.rejectMessage}
                            <#else>
                            </#if>
                        </div>
                        <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>获得${myTaskList.actStarNumber}星点</div>
                        <#elseif myTaskList.status=='PENDING'>
                          <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>反馈审核中
                        </div>
                        <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>可获得${myTaskList.starNumber}星点</div>
                         <#elseif myTaskList.status=='EXPIRED'>
                          <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>已过期</div>
                        
                        
                       
                       <#else>
                        <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>可获得${myTaskList.starNumber}星点</div>
                        <#if (myTaskList.needFinish == -1)>
                        <div class="pet_hd_block_map" style="color:red"><i class="iconfont">&#xe632;</i><strong>即日逾期，速速提交反馈哦</strong></div>
                       
                        <#else>
	                        <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>已过去${myTaskList.hadFinished}天
	                            <div class="am-progress bar am-progress-striped am-active">
	                                <div class="am-progress-bar am-progress-bar-warning"  id="div${myTaskList.id}" >还剩下${myTaskList. needFinish}天</div>
	                            </div>
	                        </div>
                       
                         <script type="text/javascript">
		                    console.info("test:"+${myTaskList.id});
		                    var width${myTaskList.id} = ${myTaskList.needFinish}/(${myTaskList.needFinish}+${myTaskList.hadFinished});
		                    width${myTaskList.id}=(width${myTaskList.id}*100)+"%";
		                    console.info("width${myTaskList.id}: "+width${myTaskList.id});
		                    $('#div${myTaskList.id}').css("width",width${myTaskList.id});
		                   $('#div${myTaskList.id}').css("width",width${myTaskList.id});
		                 </script>
                        
                        <div class="pet_hd_block_tag">还剩下<span class="hd_tag_jh">${myTaskList. needFinish}天</span></div>
                         </#if>
                        </#if>
                    </a>
                </li>
                 </ul>
            </#list>

              </div>

            </div>

          </div>
        </div>
         <#include "/mobile/includes/footer.ftl" />

      </div>
    </div>

    

</body>
  </html>
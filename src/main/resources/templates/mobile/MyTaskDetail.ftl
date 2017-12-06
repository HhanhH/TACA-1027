<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="../../../../../static/mobile/css/amazeui.min.css">
    <link rel="stylesheet" href="../../../../../static/mobile/css/wap.css">
    <link rel="stylesheet" href="../../../../../static/mobile/css/my.css">
    <script src="../../../../../static/mobile/js/submitCheck.js"></script>
    <title>活动内容页</title>
</head>
<body style="background:#ececec">
<div class="pet_mian" >
    <div class="pet_head">
  <header data-am-widget="header"
          class="am-header am-header-default pet_head_block">
      <div class="am-header-left am-header-nav ">
          <a href="${base}/mobile/mytask/list" class="iconfont pet_head_jt_ico">&#xe601;</a>
      </div>

<div class="pet_news_list_tag_name">任务详情</div>
      <div class="am-header-right am-header-nav">
          <a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
      </div>
  </header>
</div>

<div class="pet_content">
<div class="pet_content_block pet_hd_con">
<div class="pet_hd_con_head">

</div>
  <article data-am-widget="paragraph" class="am-paragraph am-paragraph-default pet_content_article" data-am-paragraph="{ tableScrollable: true, pureview: true }">
  <h1 class="pet_article_title">${detail.taskName}</h1>
  <div class="pet_article_user_time pet_hd_con_time"><i class="iconfont">&#xe617;</i>截至时间：${detail.endTime} 00:00:00</div>
  <div class="pet_article_user_time pet_hd_con_map"><i class="iconfont">&#xe615;</i>与你一同参加：${detail.personNum} 人</div>
  <div class="pet_hd_con_gp">
    
    <!-- <button class="pet_hd_con_gp_list_xl_m">取消任务</button> -->
  </div>
  <div class="pet_hd_con_gp_list_nr">
      <div class="pet_hd_con_gp_list_nr_tag">本次任务星级</div>
      <p style="color:blue"><#list detail.starList as list>★</#list></p>
    <div class="pet_hd_con_gp_list_nr_tag">本次任务内容</div>
    <p>${detail.content}</p>
    <#if detail.status=='FINISHED'>
    <div class="pet_hd_con_gp_list_nr_tag">实际获得星点</div>
    <p>${detail.actStarNumber}星点</p>
    <#elseif detail.status=='EXPIRED'>
    <div class="pet_hd_con_gp_list_nr_tag">已过期</div>
    <#else>
    <div class="pet_hd_con_gp_list_nr_tag">预期获得星点</div>
    <p>${detail.starNumber}星点</p>
    </#if>
    <#if detail.status =='PROCEEDING'>
 
   	<div class="pet_hd_con_gp_list_nr_tag">本次任务反馈方式</div>
   		<p>${detail.feedBackWay}</p>
 		<div class="pet_hd_con_gp_list_nr_tag">提交任务反馈</div>
   	 <br></br>
   	   <form id="updateFile" action="${base}/mobile/mytask/update/${userName}/${detail.id}" method="post" enctype="multipart/form-data" >
        <textarea style="width: 80%;height: 100px;" id="text" name="text"></textarea><br><br>
        <div>
         <input id="taskName" name="taskId"  multiple="multiple" type="hidden" value="${detail.taskId}"></input>

        <input type="file" style="position:absolute;" multiple="multiple" name="file">
        </div>
           	 <br></br>
       <div>
          <button class="pet_hd_con_gp_list_xl_m" type="submit" id="submitBack"    onclick="return check(this.form);">提交反馈</button>
       </div>
        </form>
        <#elseif  detail.status =='EXPIRED'>
        <#else>
       	  	<div class="pet_hd_con_gp_list_nr_tag">我的反馈</div>
      	   <#if detail.fileAddress??>
     			<p><a href="${base}/mobile/mytask/download?fileAddress=${detail.fileAddress}" style="color:blue">反馈文件下载</a></p>
    	   </#if>
    	  <#if detail.receiveBook??>
    	  <p>${detail.receiveBook}</p>
     	 </#if>
   </#if>
 </div>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-bd" id="content">
     
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">确定</span>
    </div>
  </div>
</div>
 <#include "/mobile/includes/footer.ftl" />
</div>
</div>
</div>
    <script src="../../../../../static/mobile/js/jquery.min.js"></script>
    <script src="../../../../../static/mobile/js/amazeui.min.js"></script>
<script>
$(function(){
    auto_resize();
    $(window).resize(function() {
        auto_resize();
    });
    $('.am-list-thumb img').load(function(){
        auto_resize();
    });
    $('.pet_article_like li:last-child').css('border','none');
        function auto_resize(){
        $('.pet_list_one_nr').height($('.pet_list_one_img').height());
                // alert($('.pet_list_one_nr').height());
    }
        $('.pet_article_user').on('click',function(){
            if($('.pet_article_user_info_tab').hasClass('pet_article_user_info_tab_show')){
                $('.pet_article_user_info_tab').removeClass('pet_article_user_info_tab_show').addClass('pet_article_user_info_tab_cloes');
            }else{
                $('.pet_article_user_info_tab').removeClass('pet_article_user_info_tab_cloes').addClass('pet_article_user_info_tab_show');
            }
        });

        $('.pet_head_gd_ico').on('click',function(){
            $('.pet_more_list').addClass('pet_more_list_show');
       });
        $('.pet_more_close').on('click',function(){
            $('.pet_more_list').removeClass('pet_more_list_show');
        });
});


</script>



</body>
<style>
 .fileinput-button input{
            position:absolute;
            right: 0px;
            top:0px;
            opacity: 0;
            -ms-filter: 'alpha(opacity=0)';
            font-size: 200px;
        }
        </style>
</html>
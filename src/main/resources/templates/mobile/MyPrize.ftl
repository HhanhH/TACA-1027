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
  <title>活动列表页</title>
</head>
<body style="background:#ececec">
  <div class="pet_mian" >
    <div class="pet_head">
      <header data-am-widget="header"
          class="am-header am-header-default pet_head_block">
        <div class="am-header-left am-header-nav ">
          <a onclick="history.go(-1)" class="iconfont pet_head_jt_ico">&#xe601;</a>
        </div>
        <div class="pet_news_list_tag_name">我的兑换记录</div>
        <div class="am-header-right am-header-nav">
          <a href="${base}/mobile/goods/list" class="iconfont pet_head_gd_ico"><small>激励商城</small></a>
        </div>
      </header>
    </div>


    <div class="pet_content pet_content_list pet_hd">
      <div class="pet_article_like">
        <div class="pet_content_main pet_article_like_delete">
          <div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
            <div class="am-list-news-bd">
            <#if transList ?? && (transList?size>0)>
        <#list transList as list><hr>
              <ul class="am-list">
                <!--缩略图在标题右边-->
                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_hd_list">
                   <a href="${base}/mobile/goods/${list.goodsId?default(0)?c}" class="pet_topci_block">
                    <div class="pet_hd_block_title">兑换奖品：${list.name}</div>
                    <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>兑换时间：${list.createTime?date}</div>
                      <#if list.status=='FAIL'>
                      <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>消耗星点：0</div>
                      <#else>
                     <div class="pet_hd_block_map"><i class="iconfont">&#xe632;</i>消耗星点：${list.starNumber}</div>
                   </#if>
                   <#if list.status=='FINISHED'> <div class="pet_hd_block_tag">兑换状态<span class="hd_tag_jh">审核通过</span></div>
                   <#elseif list.status=='FAIL'><div class="pet_hd_block_tag">兑换状态<span class="hd_tag_jh">审核拒绝</span></div>
                    <div class="pet_hd_block_map">拒绝原因：${list.message}</div>
                    <#else><div class="pet_hd_block_tag">兑换状态<span class="hd_tag_jh">审核中</span></div> 
                 </#if>
                  </a>
                </li>
                </ul>
            </#list>
            <#else>
            <div>还没有兑换记录，赶快去兑换心怡的激励吧~~</div>
            </#if>
              </div>
            </div>
          </div>
        </div>
   
         <#include "/mobile/includes/footer.ftl" />
      </div>
    </div>
    <script src="../../../static/mobile/js/jquery.min.js"></script>
    <script src="../../../static/mobile/js/amazeui.min.js"></script>
    <script>
$(function(){

    // 动态计算新闻列表文字样式
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
  </html>
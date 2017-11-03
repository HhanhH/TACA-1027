<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <link rel="stylesheet" href="../../../../static/mobile/css/amazeui.min.css">
  <link rel="stylesheet" href="../../../../static/mobile/css/wap.css">
  <link rel="stylesheet" href="../../../../static/mobile/css/my.css">
  <title>活动列表页</title>
</head>
<body style="background:#ececec">
  <div class="pet_mian" >
    <div class="pet_head">
      <header data-am-widget="header"
          class="am-header am-header-default pet_head_block">
        <div class="am-header-left am-header-nav ">
          <a href="index.html" class="iconfont pet_head_jt_ico">&#xe601;</a>
        </div>
        <div class="pet_news_list_tag_name">风云榜</div>
        <div class="am-header-right am-header-nav">
          <a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
        </div>
      </header>
    </div>


    <div class="pet_content pet_content_list pet_hd">

      <div class="pet_article_like">

      <!--下拉菜单-->

          <button class="btn btn-default dropdown-toggle rank" type="button" id="month" data-toggle="dropdown"><a  href="${base}/mobile/rank/detail/month">月度排行榜</a></button>
          <button class="btn btn-default dropdown-toggle rank" type="button" id="months" data-toggle="dropdown"><a href="${base}/mobile/rank/detail/month/months">季度排行榜</a></button>

      <!--下拉菜单结束-->
        <div class="pet_content_main pet_article_like_delete">
          <div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">

            <div class="am-list-news-bd">
            <#list userinfos as list><hr>
              <ul class="am-list">
                   <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_hd_list">
                  <a href="###" class="pet_hd_block">
                    <div class="pet_hd_block_title">Rank ON.${list_index+1}</div>
                    <div class="pet_hd_block_map">昵称：${list.userName}</div>
                    <div class="pet_hd_block_tag">总星点<span class="hd_tag_jh">${list.historyStar}星点</span> </div>
                      <div class="pet_hd_block_map"><a href="RankingDetail.html">获奖感言</a></div>
                  </a>
                </li>
                </ul>
        </#list>
              </div>

            </div>

          </div>

        </div>

        <div class="pet_article_footer_info">Copyright(c)2015 PetShow All Rights Reserved</div>
      </div>
    </div>


    <script src="../../../../static/mobile/js/jquery.min.js"></script>
    <script src="../../../../static/mobile/js/amazeui.min.js"></script>
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
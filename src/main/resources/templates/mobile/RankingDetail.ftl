<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="../css/amazeui.min.css">
    <link rel="stylesheet" href="../css/wap.css">
    <title>获奖感言</title>
</head>
<body style="background:#ececec">
<div class="pet_mian" >
    <div class="pet_head">
      <header data-am-widget="header"
          class="am-header am-header-default pet_head_block">
        <div class="am-header-left am-header-nav ">
          <a href="Ranking.html" class="iconfont pet_head_jt_ico">&#xe601;</a>
        </div>
        <div class="pet_news_list_tag_name">获奖感言</div>
        <div class="am-header-right am-header-nav">
          <a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
        </div>
      </header>
    </div>




<div class="pet_content">
<div class="pet_content_block">
  <article data-am-widget="paragraph" class="am-paragraph am-paragraph-default pet_content_article" data-am-paragraph="{ tableScrollable: true, pureview: true }">
  <h1 class="pet_article_title">你认识萌萌的小熊猫吗？</h1>
  <div class="pet_article_user_time">发表于：2015-09-25</div>
      <img src="img/a2.jpg"><p class=paragraph-default-p>南极洲又称<a href="###">第七大陆</a>，是地球上最后一个被发现、唯一没有土著人居住的大陆。</p><p>南极大陆为通常所说的南大洋（太平洋、印度洋和大西洋的南部水域）所包围，它与南美洲最近的距离为965公里，距新西兰2000公里、距澳大利亚2500公里、距南非3800公里、距中国北京的距离约有12000公里。南极大陆的总面积为1390万平方公里，相当于中国和印巴次大陆面积的总和，居世界各洲第五位。</p><p><blockquote><p>有一天我们也要去南极走走！！</p></blockquote></p><img src="img/a3.jpg" /><p>整个南极大陆被一个巨大的冰盖所覆盖，平均海拔为2350米。南极洲是由冈瓦纳大陆分离解体而成，是世界上最高的大陆。南极横断山脉将南极大陆分成东西两部分。这两部分在地理和地质上差别很大。</p><img src="img/a2.jpg" /><p>东南极洲是一块很古老的大陆，据科学家推算,已有几亿年的历史。它的中心位于难接近点，从任何海边到难接近点的距离都很远。东南极洲平均海拔高度2500米，最大高度4800 米。在东南极洲有南极大陆最大的活火山，即位于罗斯岛上的埃里伯斯火山，海拔高度3795米，有四个喷火口</p>

  </article>
      



  </div>
</div>
<div class="pet_article_like">

<div class="pet_article_footer_info">Copyright(c)TAKA项目组</div>
</div>
</div>
<script src="../js/jquery.min.js"></script>
<script src="../js/amazeui.min.js"></script>
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
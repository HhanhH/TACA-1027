<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link rel="stylesheet" href="../../static/mobile/css/amazeui.min.css">
    <link rel="stylesheet" href="../../static/mobile/css/wap.css?2">
    <title>首页</title>
</head>
<body>
<div data-am-widget="gotop" class="am-gotop am-gotop-fixed">
    <a href="#top" title="">
        <img class="am-gotop-icon-custom" src="../../static/mobile/img/goTop.png"/>
    </a>
</div>

<div class="pet_mian" id="top">
    <div data-am-widget="slider" class="am-slider am-slider-a1" data-am-slider='{"directionNav":false}'>
        <ul class="am-slides">
            <li>
                <img src="../../static/mobile/img/fl01.png">
                <div class="pet_slider_font">
                    <span class="pet_slider_emoji"> (╭￣3￣)╭♡   </span>
                    <span>卓越职场人：带你走向优秀的你</span>
                </div>
                <div class="pet_slider_shadow"></div>
            </li>
            <li>
                <img src="../../static/mobile/img/fl02.png">
                <div class="pet_slider_font">
                    <span class="pet_slider_emoji"> []~(￣▽￣)~*　</span>
                    <span>卓越职场人：做一个自律的人</span>
                </div>
                <div class="pet_slider_shadow"></div>
            </li>
            <li>
                <img src="../../static/mobile/img/fl03.png">
                <div class="pet_slider_font">
                    <span class="pet_slider_emoji"> (｡・`ω´･)　</span>
                    <span>做好这几点，你也是卓越职场人</span>
                </div>
                <div class="pet_slider_shadow"></div>
            </li>
        </ul>
    </div>
    <div class="pet_circle_nav">
        <ul class="pet_circle_nav_list">
            <li><a href="${base}/mobile/task/hot" class="iconfont pet_nav_xinxianshi">&#xe61e;</a><span>任务大厅</span></li>
            <li><a href="${base}/mobile/goods/list" class="iconfont pet_nav_zhangzhishi ">&#xe607;</a><span>激励商店</span></li>
            <li><a href="${base}/mobile/userinfo/UM" class="iconfont pet_nav_kantuya ">&#xe62c;</a><span>我的账户</span></li>
            <li><a href="${base}/mobile/mytask/list" class="iconfont pet_nav_mengzhuanti ">&#xe622;</a><span>我的任务</span></li>
            <li><a href="${base}/mobile/mygoods/${Session['username']?default('session')}" class="iconfont pet_nav_meirong ">&#xe629;</a><span>我的激励</span></li>
            <li><a href="${base}/mobile/rank/" class="iconfont pet_nav_yiyuan ">&#xe602;</a><span>风云榜单</span></li>
           <#-- <li><a href="" class="iconfont pet_nav_dianpu ">&#xe604;</a><span>讨论</span></li>
            <li><a href="javascript:;" class="iconfont pet_nav_gengduo ">&#xe600;</a><span>更多</span></li>-->
        </ul>
        <div class="pet_more_list">
            <div class="pet_more_list_block">
                <div class="iconfont pet_more_close">×</div>
                <div class="pet_more_list_block">
                    <div class="pet_more_list_block_name">
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <#if (noticeList?size>0) >
    <div class="pet_content_main">
        <div data-am-widget="list_news" class="am-list-news am-list-news-default">
            <div class="am-list-news-bd">
                <ul class="am-list">
                    <!--缩略图在标题右边-->
                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block">
                        <#list noticeList as noticeInfo >
                        <a href="${base}/mobile/notice/${noticeInfo.id}" class="">
                            <div class=" am-u-sm-8 am-list-main pet_list_one_nr">
                                <h3 class="am-list-item-hd pet_list_one_bt">${noticeInfo.title}
                                </h3>
                                <div class="am-list-item-text pet_list_one_text">
                                    ${noticeInfo.content}
                                </div>
                            </div>
                             
                            <div class="am-u-sm-4 am-list-thumb">
                            <#if noticeInfo.iconAddress ??>
                                <img src="${base}/icon/show?iconAddress=${noticeInfo.iconAddress}" class="pet_list_one_img" height="80" width="108" alt=""/>
                            <#else>
                            <img src="../../static/mobile/img/user_icon.png" class="pet_list_one_img" alt="" height="80" width="108"/>
                           
                            </#if>
                             </div>
                            </a>
                           
                        </#list>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    </#if>
    <div class="pet_article_dowload pet_dowload_more_top_off">
      <#include "/mobile/includes/footer.ftl" />
    </div>
</div>

<script src="../../static/mobile/js/jquery.min.js"></script>
<script src="../../static/mobile/js/amazeui.min.js"></script>
<script>
    $(function () {

        // 动态计算新闻列表文字样式
        auto_resize();
        $(window).resize(function () {
            auto_resize();
        });
        $('.am-list-thumb img').load(function () {
            auto_resize();
        });

        $('.am-list > li:last-child').css('border', 'none');
        function auto_resize() {
            $('.pet_list_one_nr').height($('.pet_list_one_img').height());

        }

        $('.pet_nav_gengduo').on('click', function () {
            $('.pet_more_list').addClass('pet_more_list_show');
        });
        $('.pet_more_close').on('click', function () {
            $('.pet_more_list').removeClass('pet_more_list_show');
        });
    });

</script>
</body>
</html>
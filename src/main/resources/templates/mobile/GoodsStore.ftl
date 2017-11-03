<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link rel="stylesheet" href="../../static/mobile/css/amazeui.min.css">
    <link rel="stylesheet" href="../../static/mobile/css/wap.css">
    <link rel="stylesheet" href="../../static/mobile/taca/css/icon.css">
    <title>激励商城</title>
</head>
<body style="background:#ececec">
<div class="pet_mian">
    <div class="pet_head">
        <header data-am-widget="header"
                class="am-header am-header-default pet_head_block">
            <div class="am-header-left am-header-nav ">
                <a href="${base}/mobile/notice/list" class="iconfont pet_head_jt_ico">&#xe601;</a>
            </div>
            <div class="pet_news_list_tag_name">激励商城</div>
            <div class="am-header-right am-header-nav" style="font-size: 10px">
               可用：${userInfo.availableStar?default(0)?c}
            </div>
        </header>
    </div>

    <div class="pet_more_list">
        <div class="pet_more_list_block">
        </div>
    </div>

    <div class="pet_content pet_content_list pet_topci">
        <div class="pet_article_like">
            <div class="pet_content_main pet_article_like_delete">
                <div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
                    <div class="am-list-news-bd">
                        <ul class="am-list">
                            <#list goodsInfoList as goodsInfo>
                            
                                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_topci_list">
                                    <a href="${base}/mobile/goods/${goodsInfo.id?default(0)?c}" class="pet_topci_block">
                                        <#if goodsInfo.starNumber==0>
                                            <div class="hot">
                                                <img src="../../static/mobile/img/爆款.png">
                                            </div>
                                        </#if>
                                        <div class="pet_topci_video"><span>消耗星点：${goodsInfo.starNumber}</span></div>
                                        <div class="pet_topci_shadow_font">${goodsInfo.name}</div>
                                        <div class="pet_topci_shadow" ></div>
                                        <#if goodsInfo.iconAddress ??>
                                        <img src="${base}/icon/show?iconAddress=${goodsInfo.iconAddress}" alt="暂无图片">
                                        <#else>
                                        <img alt="暂无图片" src="../../static/mobile/img/backtp.png">
                                        </#if>
                                    </a>
                                </li>
                                
                            </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    <#include "/mobile/includes/footer.ftl" />
    </div>
</div>
<script src="../../static/mobile/js/jquery.min.js"></script>
<script src="../../static/mobile/js/amazeui.min.js"></script>
</body>
</html>
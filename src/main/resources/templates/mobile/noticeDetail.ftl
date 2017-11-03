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
    <title>公告详情页</title>
</head>
<body style="background:#ececec">
<div class="pet_mian">
    <div class="pet_head">
        <header data-am-widget="header" class="am-header am-header-default pet_head_block">
            <div class="am-header-left am-header-nav ">
                <a href="${base}/mobile/notice/list" class="iconfont pet_head_jt_ico">&#xe601;</a>
            </div>
            <div class="pet_news_list_tag_name">公告详情页</div>
            <div class="am-header-right am-header-nav">
            </div>
        </header>
    </div>

    <div class="pet_content">
        <div class="pet_content_block">
            <article data-am-widget="paragraph" class="am-paragraph am-paragraph-default pet_content_article"
                     data-am-paragraph="{ tableScrollable: true, pureview: true }">
                <h1 class="pet_article_title">${noticeInfo.title}</h1><br>
                <#if noticeInfo.iconAddress??>
                <img src="${base}/icon/show?iconAddress=${noticeInfo.iconAddress}" style="height: 80%;width: 90%;">
                </#if>
                <br>
                <div class="pet_hd_block_tag">&nbsp;&nbsp;&nbsp;&nbsp;${noticeInfo.content}</div>
            </article><br>
            <br>
            <br>
        </div>
    </div>
<#include "/mobile/includes/footer.ftl" />
    <script src="../../static/mobile/js/jquery.min.js"></script>
    <script src="../../static/mobile/js/amazeui.min.js"></script>
    <script src="../../static/mobile/taca/js/GoodsDetail.js"></script>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
    <div class="am-modal-dialog">
        <div class="am-modal-hd"></div>
        <div class="am-modal-bd" id="content">
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn">确定</span>
        </div>
    </div>
</div>
</body>
</html>
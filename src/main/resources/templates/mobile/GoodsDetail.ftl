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
    <title>激励详情页</title>
</head>
<body style="background:#ececec">
<div class="pet_mian">
    <div class="pet_head">
        <header data-am-widget="header" class="am-header am-header-default pet_head_block">
            <div class="am-header-left am-header-nav ">
                <a href="${base}/mobile/goods/list" class="iconfont pet_head_jt_ico">&#xe601;</a>
            </div>
            <div class="pet_news_list_tag_name">激励详情页</div>
            <div class="am-header-right am-header-nav">
                可用星点：${userInfo.availableStar?default(0)?c}
            </div>
        </header>
    </div>

    <div class="pet_content">
        <div class="pet_content_block">
            <article data-am-widget="paragraph" class="am-paragraph am-paragraph-default pet_content_article"
                     data-am-paragraph="{ tableScrollable: true, pureview: true }">
                <h1 class="pet_article_title">${goodsInfo.name}</h1><br>
                    <#if goodsInfo.type=='爆款'>
                        <div class="hotDetail">
                            <img src="../../static/mobile/img/爆款.png">
                        </div>
                    </#if>
                    <#if goodsInfo.iconAddress??>
                <img src="${base}/icon/show?iconAddress=${goodsInfo.iconAddress}">
                <#else>
                <img alt="暂无图片" src="../../static/mobile/img/backtp.png">
                </#if>
                <br>
                <div class="pet_hd_block_title">描述：${goodsInfo.description}</div>
                <div class="pet_hd_block_title">消耗星点：${goodsInfo.starNumber}</div>
                 <div class="pet_hd_block_title">库存：${goodsInfo.availableStock}</div>
            </article>
           <br>
            &nbsp;&nbsp;&nbsp;&nbsp;
             <#if goodsInfo.type=='爆款'>
              <button type="button" class="am-btn am-btn-primary"  onclick="javascript:exchangeGoods(${goodsInfo.id?default(0)?c},${goodsInfo.availableStock},'${Session["username"]?default("session")}')" disabled="true">点击兑换
            </button>
             <#else>
             <button type="button" class="am-btn am-btn-primary"  onclick="javascript:exchangeGoods(${goodsInfo.id?default(0)?c},${goodsInfo.availableStock},'${Session["username"]?default("session")}')">点击兑换
            </button>
            </#if>
            <br>
            <br>
        </div>
    </div>
    <#include "/mobile/includes/footer.ftl" />
    <script src="../../static/mobile/js/jquery.min.js"></script>
    <script src="../../static/mobile/js/amazeui.min.js"></script>
    <script src="../../static/mobile/taca/js/GoodsDetail.js"></script>
</div>
<div class="am-modal am-modal-confirm" tabindex="-1" id="my-alert">
    <div class="am-modal-dialog">
        <div class="am-modal-hd"></div>
        <div class="am-modal-bd" id="content">
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>

<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
    <div class="am-modal-bd" id="content">
           还没有登录，快去登录吧
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>
</body>
</html>
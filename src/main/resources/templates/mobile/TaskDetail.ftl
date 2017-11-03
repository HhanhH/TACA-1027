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
    <title>任务详情页</title>
</head>
<body style="background:#ececec">
<div class="pet_mian">
    <div class="pet_head">
        <header data-am-widget="header" class="am-header am-header-default pet_head_block">
            <div class="am-header-left am-header-nav ">
                <a href="${base}/mobile/task/hot" class="iconfont pet_head_jt_ico">&#xe601;</a>
            </div>
            <div class="pet_news_list_tag_name">任务大厅</div>
        </header>
    </div>

    <div class="pet_more_list">
        <div class="pet_more_list_block">
            <div class="iconfont pet_more_close">×</div>
        </div>
    </div>

    <div class="pet_content pet_content_list pet_hd">
        <div class="pet_article_like">
            <div class="pet_content_main pet_article_like_delete">
                <div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
                    <div class="am-list-news-bd">
                        <ul class="am-list">
                            <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_hd_list">
                                  <div class="pet_hd_block_title"><a>${taskInfo.name}</a></div><br>
                                  <#if taskInfo.iconAddress??>
                                  <img src="${base}/icon/show?iconAddress=${taskInfo.iconAddress}" class="pet_hd_block_title" alt=""/><br><br>
                                  </#if>
                                  <div class="pet_hd_block_tag"><strong>描述：</strong>${taskInfo.content}</div>
                                  <div class="pet_hd_block_tag"><strong>任务类型：</strong>${taskInfo.category}</div>
                                  <div class="pet_hd_block_tag"><strong>反馈方式：</strong>${taskInfo.feedbackWay}</div>
                                  <div class="pet_hd_block_tag"><strong>星级：</strong>${taskInfo.starLevel}星级</div>
                                  <div class="pet_hd_block_tag"><strong>奖励星点：</strong>${taskInfo.starProfit}星点</div>
                                  <div class="pet_hd_block_tag"><strong>时限：</strong>${taskInfo.timeLength}天</div>
                                  <div class="pet_hd_block_tag"><strong>库存：</strong>${taskInfo.availableStock?c}次</div>
                                  <br>
                                  <button type="button" class="am-btn am-btn-primary" onclick="javascript:receiveTaskById(${taskInfo.id},'${Session["username"]?default("session")}',${taskInfo.availableStock});">领取任务
                                  </button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    <#include "/mobile/includes/footer.ftl" />
    </div>
</div>
<div class="am-modal am-modal-confirm" tabindex="-1" id="my-alert">
    <div class="am-modal-dialog">
        <div class="am-modal-hd" ></div>
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


<script src="../../static/mobile/js/jquery.min.js"></script>
<script src="../../static/mobile/js/amazeui.min.js"></script>
<script src="../../static/mobile/taca/js/TaskDetail.js"></script>
</body>
</html>
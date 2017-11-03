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
    <title>我的账户</title>
</head>
<body style="background:#ececec">
<div class="pet_mian">
    <div class="pet_head">
        <header data-am-widget="header"
                class="am-header am-header-default pet_head_block">
            <div class="am-header-left am-header-nav ">
                <a href="${base}/mobile/notice/list" class="iconfont pet_head_jt_ico">&#xe601;</a>
            </div>
            <div class="pet_news_list_tag_name">我的账户</div>
             <div class="am-header-right am-header-nav">
                                  <a href="${base}/mobile/userinfo/changePwd" class="iconfont ">修改密码</a>
            </div>
        </header>
    </div>

    <div class="pet_more_list">
        <div class="pet_more_list_block">
            <div class="pet_more_list_block">
            </div>
        </div>
    </div>

    <div class="pet_content pet_content_list">
        <div class="pet_grzx">

            <div class="pet_grzx_nr">
                <div class="pet_grzx_ico">
                    <form id="uploadForm" enctype="multipart/form-data">
                        <input type="file" id="upLoadImg" style="display: none;" accept="image/*" onchange="javascript:update()">
                        <input type="button" style="display: none;" id="save" onclick="javascript:updateIcon()"></input>
                    </form>
                    <#if userInfo.iconAddress??>
                        <img src="${base}/icon/show?iconAddress=${userInfo.iconAddress}" onclick="javascript:upLoad()">
                    <#else>
                        <img src="../../static/mobile/img/user_icon.png" onclick="javascript:upLoad()">
                    </#if>
                    </div>
                <div class="pet_grzx_name"><span id="nickName" data-am-modal="{target:'#my-prompt'}" onclick="javascript:reName(${userInfo.id?default(0)?c},'${userInfo.nickName}')"><div class="pet_grzx_map">昵称：${userInfo.nickName}</div></span></div>
                <div class="pet_grzx_map">${userInfo.userName}</div>
                <div class="pet_grzx_num">
                    <span>${userInfo.historyStar}<i>累计星点</i></span>
                    <span>${userInfo.availableStar}<i>可用星点</i></span>
                    <span>${userInfo.honorTitle}<i>称号</i></span>
                </div>
            </div>

        </div>
    <#include "/mobile/includes/footer.ftl" />
    </div>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-prompt">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">修改昵称</div>
        <div class="am-modal-bd" id="result" style="color: red"></div>
        <div class="am-modal-bd ">
            <input type="text" class="am-modal-prompt-input" id="nickname" oninput="javascript:isDataOK()">
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" id="sub" data-am-modal-confirm >提交</span>
        </div>
    </div>
</div>
<script src="../../static/mobile/js/jquery.min.js"></script>
<script src="../../static/mobile/js/amazeui.min.js"></script>
<script src="../../static/mobile/taca/js/UserInfo.js"></script>
</body>
</html>
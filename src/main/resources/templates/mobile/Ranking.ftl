<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../css/amazeui.min.css">
<link rel="stylesheet" href="../css/wap.css">
<link rel="stylesheet" href="../css/my.css">
<title>活动列表页</title>
</head>
<body style="background: #ececec">
	<div class="pet_mian">
		<div class="pet_head">
			<header data-am-widget="header"
				class="am-header am-header-default pet_head_block">
				<div class="am-header-left am-header-nav ">
					<a onclick="history.go(-1)" class="iconfont pet_head_jt_ico">&#xe601;</a>
				</div>
				<div class="pet_news_list_tag_name">风云榜</div>
				<div class="am-header-right am-header-nav">
					<a href="${base}/mobile/notice/list;"
						class="iconfont pet_head_gd_ico">&#xe600;</a>
				</div>
			</header>
		</div>


		<div class="pet_content pet_content_list pet_hd">

			<div class="pet_article_like">


				<!--下拉菜单结束-->
				<div class="pet_content_main pet_article_like_delete">
					<div data-am-widget="list_news"
						class="am-list-news am-list-news-default am-no-layout">

						<div class="am-list-news-bd">
							<#list userinfos as list>
							<ul class="am-list">
								<li
									class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_hd_list">
									
							<div class=" am-u-sm-8 am-list-main pet_list_one_nr" style="width: 100%;height:200px">
								 <div class=" am-u-sm-8 am-list-main pet_list_one_nr"style="width: 60%;height:200px;float:left">
									<div class="pet_hd_block_title">Rank NO.${list_index+1}</div>
									<div class="pet_hd_block_map">昵称：${list.nickName}</div>
									<div class="pet_hd_block_map">UM：${list.userName}</div>
									<div class="pet_hd_block_map">英雄榜称号：${list.honorTitle}</div>
									<div class="pet_hd_block_tag">
										累计星点<span class="hd_tag_jh">${list.historyStar}星点</span>
									</div>
								</div>
								<div class="am-u-sm-4 am-list-thumb" style="width:40%;height:200px;float:left;max-height:200px">

									<#if list.iconAddress ??> <img
										src="${base}/icon/show?iconAddress=${list.iconAddress}"
										class="pet_list_one_img" alt=""  width="110px" height="170px;" />
									<#else> <img src="../../static/mobile/img/user_icon.png"
										class="pet_list_one_img" alt="" width="110px" height="170px;"/>
								
								</#if>
								
								</div>
								
							</div>
						</li>
						</ul>
							</#list>
							 
						</div>
					</div>

				</div>

			</div>

		</div>

		<div class="pet_article_footer_info">Copyright(c)2015 PetShow
			All Rights Reserved</div>
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
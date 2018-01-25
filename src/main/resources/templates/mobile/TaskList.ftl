<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <link rel="stylesheet" href="../../static/mobile/css/amazeui.min.css">
  <link rel="stylesheet" href="../../static/mobile/css/wap.css">
  <title>任务列表页</title>
    <style>

    </style>
</head>
<body style="background:#ececec">
  <div class="pet_mian" >
    <div class="pet_head">
      <header data-am-widget="header"
          class="am-header am-header-default pet_head_block">
        <div class="am-header-left am-header-nav ">
          <a href="${base}/mobile/notice/list" class="iconfont pet_head_jt_ico">&#xe601;</a>
        </div>
          <div class="pet_news_list_tag_name">任务大厅</div>
      </header>
    </div>
    <div class="pet_content pet_content_list">
      <div class="pet_article_like">
        <div class="pet_content_main pet_article_like_delete">
          <div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
            <div class="am-list-news-bd">

                   <nav data-am-widget="menu" class="am-menu  am-menu-default">
                      <a href="javascript: void(0)" class="am-menu-toggle">
                           <i class="am-menu-toggle-icon am-icon-bars"></i>
                       </a>
                       <ul class="am-menu-nav am-avg-sm-4">
                           <li class="">
                               <a href="${base}/mobile/task/hot">最热</a>
                           </li>
                           <li class="">
                               <a href="${base}/mobile/task/new">最新</a>
                           </li>
                           <li class="am-parent">
                               <a href="##" class="" >排序</a>
                               <ul class="am-menu-sub am-collapse  am-avg-sm-3 ">
                                   <li class="">
                                       <a href="../../mobile/task/timeDesc" class="" >时间最近</a>
                                   </li>
                                   <li class="">
                                       <a href="../../mobile/task/timeAsc" class="" >时间最远</a>
                                   </li>
                                   <li class="">
                                       <a href="../../mobile/task/starNumberDesc" class="" >星点最高</a>
                                   </li>
                                   <li class="">
                                       <a href="../../mobile/task/starNumberAsc" class="" >星点最低</a>
                                   </li>
                                   <li class="">
                                       <a href="../../mobile/task/timeLengthDesc" class="" >时限最长</a>
                                   </li>
                                   <li class="">
                                       <a href="../../mobile/task/timeLengthAsc" class="" >时限最短</a>
                                   </li>
                               </ul>
                           </li>
                           <li class="am-parent">
                               <a  class="" >筛选</a>
                               <ul class="am-menu-sub am-collapse  am-avg-sm-3 ">
                                   <li class="am-menu-channel" onclick="javascript:typeLiClick()" ><a href="##" class="">类型 &raquo;</a></li>
                                  <a href="javascript: void(0)" class="am-menu-toggle">
                                       <i class="am-menu-toggle-icon "></i>
                                   </a>
                                        <ul class="am-menu-nav am-collapse am-avg-sm-3" id="typeul">
                                            <#if typeList?exists>
                                                <#list typeList as type>
                                                    <li class="">
                                                        <a href="${base}/mobile/task/category?category=${type}">${type}</a>
                                                    </li>
                                                </#list>
                                            </#if>
                                        </ul>
                                   <li class="am-menu-channel" onclick="javascript:starLevelLiClick()"><a href="##" class="">星级 &raquo;</a></li>
                                   <a href="javascript: void(0)" class="am-menu-toggle">
                                       <i class="am-menu-toggle-icon "></i>
                                   </a>
                                       <ul class="am-menu-nav am-collapse am-avg-sm-3 " id="starLevelul">
                                           <#if starLevelList?exists>
                                               <#list starLevelList as starLevel>
                                                   <li class="">
                                                       <a href="${base}/mobile/task/starLevel?starLevel=${starLevel}">${starLevel}</a>
                                                   </li>
                                               </#list>
                                           </#if>
                                       </ul>
                               </ul>
                           </li>
                       </ul>
                   </nav>
                   <ul class="am-list">
                       <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block">
                       <#list taskList as taskInfo>
                       <div class=" am-u-sm-8 am-list-main pet_list_one_nr" style="width:100%">
                           <div class=" am-u-sm-8 am-list-main pet_list_one_nr" style="width:60%">
                               <div class="pet_hd_block_title"><a href="${base}/mobile/task/${taskInfo.id?default(0)?c}">${taskInfo.name}</a></div>
                               <div class="pet_hd_block_tag"><strong>任务类型：</strong>${taskInfo.category}</div>
                               <div class="pet_hd_block_tag"><strong>星级:</strong>${taskInfo.starLevel}</div>
                               <div class="pet_hd_block_tag"><strong>奖励星点：</strong>${taskInfo.starProfit}</div>
                               <div class="pet_hd_block_tag"><strong>时限：</strong>${taskInfo.timeLength}天</div>
                               <div class="pet_hd_block_tag"><strong>库存：</strong>${taskInfo.availableStock}</div>
                           </div>
                           <br>
                           <div class="am-u-sm-4 am-list-thumb"style="width:40%">
                               <a href="${base}/mobile/task/${taskInfo.id?default(0)?c}">
                               <#if taskInfo.iconAddress??>
                               <img src="${base}/icon/show?iconAddress=${taskInfo.iconAddress}" class="pet_list_one_img" alt=""/>
                                 </#if>
                              </a>
                           </div>
                           <br>
                           </div>
                          
                       </#list>

                       </li>
                   </ul>
            </div>
          </div>
        </div>
      </div>
    <#include "/mobile/includes/footer.ftl" />
    </div>
  </div>
    <script>
        function typeLiClick() {
            var ul=document.getElementById("typeul");
            ul.style.display="block";
        }
        function starLevelLiClick() {
            var ul=document.getElementById("starLevelul");
            ul.style.display="block";
        }
        function getListByStarProfit(){
            $.ajax({
                type:'GET',
                url:"getTaskListByStarProfit"
            })
        }

    </script>
    <script src="../../static/mobile/js/jquery.min.js"></script>
    <script src="../../static/mobile/js/amazeui.min.js"></script>
</body>
  </html>
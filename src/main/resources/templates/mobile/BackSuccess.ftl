<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link rel="stylesheet" href="../../../static/mobile/css/amazeui.min.css">
    <link rel="stylesheet" href="../../../static/mobile/css/wap.css">
    <title>任务提交</title>
</head>
<body style="background:#ececec">

	<script type="text/javascript">
		var t = 5;
		function countDown() {
			var time = document.getElementById("time");
			t--;
			time.innerHTML = t + "秒后跳转到我的任务列表";
			if (t <= 0) {
				location.href = "${base}/mobile/mytask/list";
				clearInterval(inter);
			}
			;
		}
		var inter = setInterval("countDown()", 1000);
	</script>

	<div class="pet_mian" style="margin:0 auto;">
    <div class="pet_head">
        <header data-am-widget="header"
                class="am-header am-header-default pet_head_block">
         
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
                
                <div class="pet_grzx_name">恭喜您，提交成功</div>
                <div class="pet_grzx_name">正在审核中......</div>
                <div class="pet_grzx_map">记得继续加油哦</div>
              <div id="time" style="color:blue"></div> 
                <div class="pet_grzx_map"><a href="${base}/mobile/mytask/list">返回我的任务</a></div>
            </div>

        </div>

        <#include "/mobile/includes/footer.ftl" />
    </div>
</div>
<script src="../../../static/mobile/js/jquery.min.js"></script>
<script src="../../../static/mobile/js/amazeui.min.js"></script>
</body>
</html>
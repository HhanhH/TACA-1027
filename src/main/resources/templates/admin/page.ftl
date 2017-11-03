
<div class="am-cf">
	<div class="am-fr">
	
		<ul class="am-pagination tpl-pagination">
		共${page.totalNumber?default("0")}条记录&nbsp;，${page.totalPage?default("0")}页
			<li class=""><a onclick="goPage(${page.currentPage}-1)">上一页</a></li>
			<li class="am-active"><a>${page.currentPage?default("1")}</a></a></li>
			
			<li><a onclick="goPage(${page.currentPage}+1)">下一页</a></li>
		</ul>
	</div>
</div>
function goPage(currentPage){
	$("#currentPage").val(currentPage);
	var responseURL=$("#responseURL").val();
	$("#form").attr("action",responseURL).submit();
}
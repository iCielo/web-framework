<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="base.jsp"%>

<!-- bootstrap-table -->
<script type="text/javascript" src="${CP}/static/js/lib/bootstrap-table/bootstrap-table.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/bootstrap-table/my-bootstrap-table.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>

<script type="text/javascript">
	$(function() {
		$(window).resize(function() {
			$("#dataTable").bootstrapTable('resetWidth');
			$(".panel").css({
				"min-height" : $(window).height() - 22
			});
		});
		$(".panel").css({
			"min-height" : $(window).height() - 22
		});
		$("form select").change(query);
		$("form input").keyup(function(e){
			if(Common.isEnterKey(e)){
				query();
			}
		});
	});

	/* 查询 */
	function query() {
		$("#dataTable").bootstrapTable('refresh');
	}

	/* 查询参数 */
	function getQueryParams(params) {
		$("form input,form select").each(function(i, obj) {
			params[$(obj).prop("name")] = $(obj).val();
		});
		return params;
	}
</script>
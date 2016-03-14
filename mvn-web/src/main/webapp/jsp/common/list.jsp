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
		$("form input").keyup(function(e) {
			if (Common.isEnterKey(e)) {
				query();
			}
		});
		$("button[type=reset]").click(function() {
			if ($("#searchForm > form").size() > 0) {
				$("#searchForm > form")[0].reset();
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

	/* 获取选中的某个字段值，返回数组。 */
	function getSelections(field) {
		if (!field) {
			field = "id";
		}
		var rows = $("#dataTable").bootstrapTable('getSelections');
		if (rows.length == 0) {
			return [];
		}
		var arr = [];
		for (var i = 0; i < rows.length; i++) {
			arr.push(rows[i][field]);
		}
		return arr;
	}
</script>
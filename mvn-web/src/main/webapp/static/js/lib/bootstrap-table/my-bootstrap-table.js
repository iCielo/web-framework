/**
 * bootstrap table 自定义封装
 * 
 * @param $
 * @author cielo
 */
(function($) {

	var myBootstrapTable = {
		bootstrapTable : $("#dataTable"),
		option : {
			toolbar : "#toolbar",
			toolbarAlign : "left",
			clickToSelect : false,
			pagination : "true",
			idField : "id",
			sidePagination : "server",
			showRefresh : true,
			showColumns : true,
			pageList : [ 10, 25, 50, 100 ],
			/**
			 * 修改默认的行单击事件，单击行为单选，单击复选框为多选。需将clickToSelect设置为false，若设置为true则启用默认的行单击事件
			 */
			onClickRow : function(row, $element) {
				if (myBootstrapTable.option.clickToSelect == false) {
					var dataIndex = parseInt($element.attr("data-index"));
					var checked = $element.find(".bs-checkbox :checkbox").prop("checked");
					$dataTable = myBootstrapTable.bootstrapTable;
					$dataTable.bootstrapTable("uncheckAll");
					if (!checked) {
						$dataTable.bootstrapTable("check", dataIndex);
					}
				}
				return false;
			}
		}
	}

	$.fn.myBootstrapTable = function(option) {
		myBootstrapTable.bootstrapTable = $(this);
		option = $.extend(true, {}, myBootstrapTable.option, option);
		return $(this).bootstrapTable(option);
	}

})(jQuery);

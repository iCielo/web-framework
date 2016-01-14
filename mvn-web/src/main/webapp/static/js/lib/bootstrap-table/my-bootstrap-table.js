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
			height : 520,
			clickToSelect : true,
			pagination : "true",
			idField : "id",
			sidePagination : "server",
			method : "post",
			showRefresh : true,
			cache : false,
			/**
			 * 单击行时，改为单选。选择复选框，为多选
			 */
			onClickRow : function(row, $element) {
				var checked = $element.find(".bs-checkbox :checkbox").prop("checked");
				myBootstrapTable.bootstrapTable.bootstrapTable("uncheckAll");
				if (!checked) {
					$element[0].click();
				}
				return false;
			}
		}
	}

	$.fn.myBootstrapTable = function(option) {
		myBootstrapTable.bootstrapTable = $(this);
		option = $.extend(true, {}, myBootstrapTable.option, option);
		return $(this).bootstrapTable(option)
	}

})(jQuery);

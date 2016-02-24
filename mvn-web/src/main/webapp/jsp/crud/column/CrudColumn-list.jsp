<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/list.jsp"%>
<title>${title}</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').myBootstrapTable({
			idField : "id",
			columns : [ {
				checkbox : true,
				align : 'center',
				valign : 'middle'
			}, {
				title : '表名',
				field : 'tableName',
				align : 'center'
			}, {
				title : '列名',
				field : 'columnName',
				align : 'center'
			}, {
				title : '数据类型',
				field : 'columnType',
				align : 'center'
			}, {
				title : '显示名',
				field : 'label',
				align : 'center'
			}, {
				title : '输入提示',
				field : 'placeholder',
				align : 'center'
			}, {
				title : '录入类型',
				field : 'inputType',
				align : 'center'
			}, {
				title : '数据字典',
				field : 'dictType',
				align : 'center'
			}, {
				title : '自定义数据字典',
				field : 'dictList',
				align : 'center'
			}, {
				title : '校验规则',
				field : 'rules',
				align : 'center'
			} ],
			url : "${CP}/crud/column.do?method=loadData",
			queryParams : getQueryParams
		});
		//选择表时，自动隐藏表名列
		if("${param.tableName }"!=""){
			$("#dataTable").bootstrapTable('hideColumn','tableName');
		}
		$("#tableName").change(function(){
			if($("#tableName").val()!=""){
				$("#dataTable").bootstrapTable('hideColumn','tableName');
			}
		});
	});

	//修改
	function updEntity() {
		var rows = $("#dataTable").bootstrapTable('getSelections');
		if (rows.length != 1) {
			MyLayer.msg("请选择要修改的单条记录！");
			return;
		}
		MyLayer.open({
			title : "修改字段",
			content : "${CP}/crud/column.do?method=upd&id=" + rows[0].id,
		});
	}

	//删除
	function delEntity() {
		var rows = $("#dataTable").bootstrapTable('getSelections');
		if (rows.length == 0) {
			MyLayer.msg("请选择要删除的记录！");
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].id);
		}
		MyLayer.confirm("是否真的删除？", function(index) {
			Common.ajax({
				url : "${CP}/crud/column.do?method=delEntity",
				data : {
					ids : ids.join(",")
				},
				success : function(data) {
					query();
				}
			})
		});
	}
	
</script>
</head>
<body>
	<section class="panel">
		<header class="panel-heading"> 表字段 </header>
		<div class="panel-body">
			<div id="searchForm">
				<form class="form-horizontal" onsubmit="return false;">
					<div class="form-group">
						<label class="col-sm-1 col-xs-1 control-label">表名：</label>
						<div class="col-lg-2 col-sm-2">
							<select class="form-control input-sm" id="tableName" name="tableName" data-option-value="${param.tableName }">
								<option value="">--请选择--</option>
								<c:forEach var="item"   items="${tableNameList }" >
								<option value="${item }">${item }</option>
								</c:forEach>
							</select>
						</div>
						<label class="col-sm-1 col-xs-1 control-label">列名：</label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="columnName" name="columnName" placeholder="">
						</div>
					</div>
				</form>
			</div>
			<div id="toolbar">
				<button type="button" class="btn btn-primary" onclick="query()">
					<i class="glyphicon glyphicon-search"></i>&nbsp;搜索&nbsp;
				</button>
				<button type="reset" class="btn btn-primary form-label">
					<i class="glyphicon glyphicon-repeat"></i>&nbsp;清空&nbsp;
				</button>
				<button class="btn btn-primary" onclick="updEntity()">
					<i class="glyphicon glyphicon-edit"></i>&nbsp;修&nbsp;改
				</button>
				<button class="btn btn-danger " onclick="delEntity()">
					<i class="glyphicon glyphicon-remove"></i>&nbsp;删&nbsp;除
				</button>
			</div>
			<table id="dataTable"></table>
		</div>
	</section>
</body>
</html>

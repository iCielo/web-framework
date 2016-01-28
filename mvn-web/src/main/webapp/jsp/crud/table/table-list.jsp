<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/list.jsp"%>
<title>代码工厂</title>
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
				title : '菜单名',
				field : 'menuName',
				align : 'center'
			}, {
				title : '模块名',
				field : 'moduleName',
				align : 'center'
			}, {
				title : '模块代码',
				field : 'moduleCode',
				align : 'center'
			}, {
				title : '控制器映射路径',
				field : 'controllerUrl',
				align : 'center'
			},{
				title : '操作',
				align:'center',
				formatter : function(value, row, index) {
					var html = [];
					html.push('<a href="javascript:;" onclick="editColumns(\''+row.tableName+'\')" title="编辑字段"><i class="fa fa-pencil-square-o fa-lg"></i> ');
					html.push('<a href="javascript:;" onclick="processCode(\''+row.tableName+'\')" title="运行"><i class="fa fa-play-circle-o fa-lg"></i>');
					return html.join("");
				}
			} ],
			url : "${CP}/crud/table.do?method=loadData",
			queryParams : getQueryParams
		});
	});
	
	//修改表字段
	function editColumns(tableName){
		MyLayer.open({
			title : "修改表 "+tableName+" 的字段",
			content : "${CP}/crud/column.do?method=editList",
		});
	}
	
	//运行
	function processCode(tableName){
		Common.ajax({
			url : "${CP}/crud/table.do?method=processCode",
			data : {
				tableName : tableName
			}
		})
	}

	//新增
	function addEntity() {
		MyLayer.open({
			title : "新增代码",
			content : "${CP}/crud/table.do?method=add"
		});
	}

	//修改
	function updEntity() {
		var rows = $("#dataTable").bootstrapTable('getSelections');
		if (rows.length != 1) {
			MyLayer.msg("请选择要修改的单条记录！");
			return;
		}
		MyLayer.open({
			title : "修改代码",
			content : "${CP}/crud/table.do?method=upd&id=" + rows[0].id
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
				url : "${CP}/crud/table.do?method=delEntity",
				data : {
					ids : ids.join(",")
				},
				success : function(data) {
					query();
				}
			})
		});
	}

	/* 查询 */
	function query() {
		$("#dataTable").bootstrapTable('refresh');
	}

	/* 查询参数 */
	function getQueryParams(params) {
		$(".search-are input,.search-are select").each(function(i, obj) {
			params[$(obj).prop("name")] = $(obj).val();
		});
		return params;
	}
</script>
</head>
<body>
	<section class="panel">
		<header class="panel-heading"> 代码工厂</header>
		<div class="panel-body">
			<div id="toolbar">
				<button class="btn btn-primary " onclick="addEntity()">
					<i class="glyphicon glyphicon-plus-sign"></i>&nbsp;新&nbsp;增
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

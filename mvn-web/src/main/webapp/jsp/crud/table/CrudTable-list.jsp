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
				title : '模块代码',
				field : 'moduleCode',
				align : 'center'
			}, {
				title : '模块名',
				field : 'moduleName',
				align : 'center'
			}, {
				title : '菜单名',
				field : 'menuName',
				align : 'center'
			}, {
				title : '表名',
				field : 'tableName',
				align : 'center',
				formatter : function(value, row, index) {
					var html = [];
					html.push('<a href="${CP}/crud/column.do?method=list&tableName='+value+'">'+value+'</a>');
					return html.join("");
				}
			}, {
				title : '控制器映射路径',
				field : 'controllerUrl',
				align : 'center'
			},{
				title : '操作',
				align:'center',
				formatter : function(value, row, index) {
					var html = [];
					html.push('<a href="javascript:;" onclick="updateColumns(\''+row.tableName+'\')" title="更新表字段"><i class="fa fa-refresh fa-lg"></i>');
					html.push('  <a href="javascript:;" onclick="processCode(\''+row.tableName+'\')" title="生成代码"><i class="fa fa-play-circle-o fa-lg"></i>');
					return html.join("");
				}
			} ],
			url : "${CP}/crud/table.do?method=loadData",
			queryParams : getQueryParams
		});
	});
	
	//更新表字段
	function updateColumns(tableName){
		Common.ajax({
			url : "${CP}/crud/table.do?method=updateColumns",
			data : {
				tableName : tableName
			}
		});
	}
	
	//运行
	function processCode(tableName){
		Common.ajax({
			url : "${CP}/crud/table.do?method=processCode",
			data : {
				tableName : tableName
			}
		});
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
	
</script>
</head>
<body>
	<section class="panel">
		<header class="panel-heading"> 代码工厂</header>
		<div class="panel-body">
			<div id="toolbar">
				<button type="button" class="btn btn-primary" onclick="query()">
					<i class="glyphicon glyphicon-search"></i>&nbsp;搜索&nbsp;
				</button>
				<button type="reset" class="btn btn-primary form-label">
					<i class="glyphicon glyphicon-repeat"></i>&nbsp;清空&nbsp;
				</button>
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/list.jsp"%>
<title>首页</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').myBootstrapTable({
			idField : "id",
			columns : [ {
				checkbox : true,
				align : 'center',
				valign : 'middle'
			}, {
				title : '账号',
				field : 'account',
				align : 'center'
			}, {
				title : '姓名',
				field : 'name',
				align : 'center'
			}, {
				title : '性别',
				field : 'sexLabel',
				align : 'center'
			}, {
				title : '联系电话',
				field : 'phone',
				align : 'center'
			}, {
				title : '邮箱',
				field : 'email',
				align : 'center'
			}, {
				title : '状态',
				field : 'status',
				align : 'center',
				formatter : function(value, row, index) {
					if (value == "ON") {
						return "<span title=\"启用\" class=\"fa fa-check-square-o fa-lg\" style=\"color:green;\"></span>";
					} else {
						return "<span title=\"禁用\" class=\"fa fa-square-o fa-lg\"></span>";
					}
				}
			} ],
			url : "${CP}/sys/user.do?method=loadData",
			queryParams : getQueryParams
		});
	});

	//新增
	function addEntity() {
		MyLayer.open({
			title : "新增用户",
			content : '${CP}/sys/user.do?method=addPage'
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
			title : "修改用户",
			content : "${CP}/sys/user.do?method=updPage&id=" + rows[0].id
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
				url : "${CP}/sys/user.do?method=delEntity",
				data : {
					ids : ids.join(",")
				},
				success : function(data) {
					query();
				}
			})
		});
	}
	
	//启用、禁用
	function opStatus(status){
		var rows = $("#dataTable").bootstrapTable('getSelections');
		if (rows.length == 0) {
			if(status=="ON"){
				MyLayer.msg("请选择要启用的记录！");	
			}else{
				MyLayer.msg("请选择要禁用的记录！");
			}
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].id);
		}
		Common.ajax({
			url : "${CP}/sys/user.do?method=opStatus",
			data : {
				ids : ids.join(","),
				status : status
			},
			success : function(data) {
				if (data.msg) {
					MyLayer.alert(data.msg);
				}
				query();
			}
		})
	}
</script>
</head>
<body>
	<section class="panel">
		<header class="panel-heading"> 用户管理 </header>
		<div class="panel-body">
			<div id="searchForm">
				<form class="form-horizontal" onsubmit="return false;">
					<div class="form-group">
						<label class="col-sm-1 col-xs-1 control-label">账号：</label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="account" name="account" placeholder="">
						</div>
						<label class="col-sm-1 col-xs-1 control-label">姓名：</label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="name" name="name" placeholder="">
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
				<button class="btn btn-primary " onclick="addEntity()">
					<i class="glyphicon glyphicon-plus-sign"></i>&nbsp;新&nbsp;增
				</button>
				<button class="btn btn-primary" onclick="updEntity()">
					<i class="glyphicon glyphicon-edit"></i>&nbsp;修&nbsp;改
				</button>
				<button class="btn btn-danger " onclick="delEntity()">
					<i class="glyphicon glyphicon-remove"></i>&nbsp;删&nbsp;除
				</button>
				<button class="btn btn-primary " onclick="opStatus('ON')">
					<i class="glyphicon glyphicon-ok-circle"></i>启用
				</button>
				<button class="btn btn-primary " onclick="opStatus('OFF')">
					<i class="glyphicon glyphicon-ban-circle"></i>禁用
				</button>
			</div>
			<table id="dataTable"></table>
		</div>
	</section>
</body>
</html>
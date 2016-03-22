<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/list.jsp"%>
<title>资源管理</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').myBootstrapTable({
			idField : "id",
			columns : [ 
	           {
					checkbox : true,
					align : 'center',
					valign : 'middle'
				}
													 , {
						title : '资源名称',
						field : 'name',
						align : 'center'
					}
																									 , {
						title : '操作用户',
						field : 'opUserId',
						align : 'center'
					}
																	 , {
						title : '资源链接地址',
						field : 'url',
						align : 'center'
					}
																	 , {
						title : '资源码',
						field : 'code',
						align : 'center'
					}
																	 , {
						title : '父资源代码',
						field : 'parentCode',
						align : 'center'
					}
																			],
			url : "${CP}/sys/resource.do?method=loadData",
			queryParams : getQueryParams
		});
	});

	//新增
	function addEntity() {
		MyLayer.open({
			title : "新增资源管理",
			content : "${CP}/sys/resource.do?method=add"
		});
	}

	//修改
	function updEntity() {
		var ids = getSelections();
		if (ids.length != 1) {
			MyLayer.msg("请选择要修改的单条记录！");
			return;
		}
		MyLayer.open({
			title : "修改资源管理",
			content : "${CP}/sys/resource.do?method=upd&id=" + ids[0]
		});
	}

	//删除
	function delEntity() {
		var ids = getSelections();
		if (ids.length == 0) {
			MyLayer.msg("请选择要删除的记录！");
			return;
		}
		MyLayer.confirm("是否真的删除？", function(index) {
			Common.ajax({
				url : "${CP}/sys/resource.do?method=delEntity",
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
		<header class="panel-heading"> 资源管理 </header>
		<div class="panel-body">
			<div id="searchForm">
				<form class="form-horizontal" onsubmit="return false;">
					<div class="form-group">
						<label class="col-sm-1 col-xs-1 control-label">Name：</label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="name" name="name" placeholder="Jane Doe">
						</div>
						<label class="col-sm-1 col-xs-1 control-label">Name：</label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="name" name="name" placeholder="Jane Doe">
						</div>
						<label class="col-sm-1 col-xs-1 control-label">Name：</label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="name" name="name" placeholder="Jane Doe">
						</div>
						<label class="col-sm-1 col-xs-1 control-label">Name：</label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="name" name="name" placeholder="Jane Doe">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 col-xs-1 control-label">Name：</label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="name" name="name" placeholder="Jane Doe">
						</div>
						<label class="col-sm-1 col-xs-1 control-label">Name：</label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="name" name="name" placeholder="Jane Doe">
						</div>
						<label class="col-sm-1 col-xs-1 control-label">Name：</label>
						<div class="col-lg-2 col-sm-2">
							<select class="form-control input-sm" id="sex" name="sex">
								<option value="">--请选择--</option>
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
						<label class="col-sm-1 col-xs-1 control-label">Name：</label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="name" name="name" placeholder="Jane Doe">
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
			</div>
			<table id="dataTable"></table>
		</div>
	</section>
</body>
</html>

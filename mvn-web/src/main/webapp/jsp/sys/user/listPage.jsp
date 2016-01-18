<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/base.jsp"%>
<title>首页</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').myBootstrapTable({
			url : "${CP}/sys/users"
		});
	});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-sm-12">
				<section class="panel">
					<header class="panel-heading"> Dynamic Table </header>
					<div class="panel-body">
						<div id="toolbar">
							<button class="btn btn-primary ">
								<i class="glyphicon glyphicon-plus-sign"></i>&nbsp;新&nbsp;增
							</button>
							<button class="btn btn-primary">
								<i class="glyphicon glyphicon-edit"></i>&nbsp;修&nbsp;改
							</button>
							<button class="btn btn-primary ">
								<i class="glyphicon glyphicon-ok-circle"></i>启用
							</button>
							<button class="btn btn-primary ">
								<i class="glyphicon glyphicon-ban-circle"></i>禁用
							</button>
							<button class="btn btn-danger ">
								<i class="glyphicon glyphicon-remove"></i>&nbsp;删&nbsp;除
							</button>
						</div>
						<table id="dataTable">
							<thead>
								<tr>
									<th data-checkbox="true"></th>
									<th data-field="id" data-halign="center" data-align="center" data-visible="false"></th>
									<th data-field="account" data-halign="center" data-align="center">账号</th>
									<th data-field="name" data-halign="center" data-align="center">姓名</th>
									<th data-field="sex" data-halign="center" data-align="center">性别</th>
									<th data-field="age" data-halign="center" data-align="center">年龄</th>
									<th data-field="phone" data-halign="center" data-align="center">联系电话</th>
									<th data-field="email" data-halign="center" data-align="center">邮箱</th>
									<th data-field="remark" data-halign="center" data-align="center">备注</th>
									<th data-field="opTime" data-halign="center" data-align="center">操作时间</th>
								</tr>
						</table>
					</div>
				</section>
			</div>
		</div>
	</div>
</body>
</html>
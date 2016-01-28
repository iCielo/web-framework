<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>用户角色 - 新增</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				opUserId : "length(~36);",
				name : "length(~255);",
				id : "required;length(~36);",
				remark : "length(~255);",
			}
		});
		$('#form').on('valid.form', function(e) {
			Common.ajax({
				url : "${CP}/sys/role.do?method=addEntity",
				data : $(this).serialize(),
				success : function(data) {
					Common.closeDialog();
				}
			})
		});
	});
</script>
</head>
<body>
	<section class="panel">
		<div class="panel-body">
			<form class="form-horizontal tasi-form" method="post" id="form">
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">角色名 </label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" type="text" id="name" name="name" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">备注 </label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" type="text" id="remark" name="remark" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">状态 </label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" type="text" id="status" name="status" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-xs-offset-3">
						<button class="btn btn-primary" type="submit">
							<i class="glyphicon glyphicon-ok"></i>&nbsp;确定
						</button>
						<button class="btn btn-primary" type="button" onclick="Common.closeDialog();">
							<i class="glyphicon glyphicon-remove"></i>&nbsp;关闭
						</button>
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
</html>

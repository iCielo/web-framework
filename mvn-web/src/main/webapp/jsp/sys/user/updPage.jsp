<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>首页</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				account : "required;username",
				password : "required;password",
				name : "required;chinese",
				sex : "required;",
				phone : "tel",
				email : "required;email"
			}
		});
		$('#form').on('valid.form', function(e) {
			Common.ajax({
				url : "${CP}/sys/sysUser.do?method=updEntity",
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
				<input type="hidden" id="id" name="id" value="${entity.id }">
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">账号<span class="form-must">*</span></label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入账号" type="text" id="account" name="account" value="${entity.account }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">密码</label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入密码" type="password" id="password" name="password" >
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">姓名</label>
					<div class="col-sm-6 col-xs-6"><c:out value="${entity.name }"></c:out>
						<input class="form-control" placeholder="请输入姓名" type="text" id="name" name="name" value="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">性别</label>
					<div class="col-sm-6 col-xs-6">
						<select class="form-control input-sm" id="sex" name="sex" data-option-value="${entity.sex }">
							<option value="">--请选择--</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">联系电话</label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入联系电话" type="text" id="phone" name="phone" value="${entity.phone }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">邮箱地址</label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入邮箱地址" type="text" id="email" name="email" value="${entity.email }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">是否启用</label>
					<div class="col-sm-6 col-xs-6">
						<input type="checkbox" checked="" data-toggle="switch" id="status" name="status" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-xs-offset-3">
						<button class="btn btn-primary" type="submit">确定</button>
						<button class="btn btn-primary" type="button" onclick="Common.closeDialog();">关闭</button>
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
</html>
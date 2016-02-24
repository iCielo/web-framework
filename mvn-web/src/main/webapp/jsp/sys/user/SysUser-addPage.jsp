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
				account : "required;username;remote(${CP}/sys/user.do?method=isRepeat)",
				password : "required;password",
				name : "required;chinese",
				sex : "required;",
				phone : "phone",
				email : "required;email"
			}
		});
		$('#form').on('valid.form', function(e) {
			Common.ajax({
				url : "${CP}/sys/user.do?method=addEntity",
				data : $(this).serialize(),
				success : function(data) {
					if(parent.ifr_main&&typeof(parent.ifr_main.query)=='function'){
						parent.ifr_main.query();
					}else if(typeof(parent.query)=='function'){
						parent.query();
					}
					MyLayer.close();
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
					<label class="col-sm-3 col-xs-3 control-label">账号<span class="form-must">*</span></label>
					<div class="col-sm-8 col-xs-8">
						<input class="form-control" placeholder="请输入账号" type="text" id="account" name="account">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">密码<span class="form-must">*</span></label>
					<div class="col-sm-8 col-xs-8">
						<input class="form-control" placeholder="请输入密码" type="password" id="password" name="password">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">姓名<span class="form-must">*</span></label>
					<div class="col-sm-8 col-xs-8">
						<input class="form-control" placeholder="请输入姓名" type="text" id="name" name="name">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">性别<span class="form-must">*</span></label>
					<div class="col-sm-8 col-xs-8">
						<dict:select cssClass="form-control input-sm" sort="SEX" id="sex" name="sex" key="${entity.sex }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">联系电话</label>
					<div class="col-sm-8 col-xs-8">
						<input class="form-control" placeholder="请输入联系电话" type="text" id="phone" name="phone">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">邮箱地址<span class="form-must">*</span></label>
					<div class="col-sm-8 col-xs-8">
						<input class="form-control" placeholder="请输入邮箱地址" type="text" id="email" name="email">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">是否启用</label>
					<div class="col-sm-8 col-xs-8">
						<dict:select cssClass="form-control input-sm" sort="STATUS" id="status" name="status" key="${entity.status }"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-xs-offset-3">
						<button class="btn btn-primary" type="submit"><i class="glyphicon glyphicon-ok"></i>&nbsp;确定</button>
						<button class="btn btn-primary" type="button" onclick="MyLayer.close();"><i class="glyphicon glyphicon-remove"></i>&nbsp;关闭</button>
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
</html>
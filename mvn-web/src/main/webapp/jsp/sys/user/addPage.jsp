<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/base.jsp"%>
<title>首页</title>
<script type="text/javascript">
	$(function() {
	});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-sm-12">
				<section class="panel">
					<div class="panel-body">
						<form class="form-horizontal tasi-form" method="get">
							<div class="form-group">
								<label class="col-sm-3 col-sm-3 control-label">账号<span class="form-must">*</span></label>
								<div class="col-sm-9">
									<input class="form-control" placeholder="请输入账号" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 col-sm-3 control-label">密码</label>
								<div class="col-sm-9">
									<input class="form-control" placeholder="请输入密码" type="password">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 col-sm-3 control-label">姓名</label>
								<div class="col-sm-9">
									<input class="form-control" placeholder="请输入姓名" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 col-sm-3 control-label">性别</label>
								<div class="col-sm-9">
									<select class="form-control input-sm m-bot15">
										<option value="">--请选择--</option>
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 col-sm-3 control-label">联系电话</label>
								<div class="col-sm-9">
									<input class="form-control" placeholder="请输入联系电话" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 col-sm-3 control-label">邮箱地址</label>
								<div class="col-sm-9">
									<input class="form-control" placeholder="请输入邮箱地址" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 col-sm-3 control-label">是否启用</label>
								<div class="col-sm-9">
									<input type="checkbox" checked="" data-toggle="switch" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-3 col-lg-11">
									<button class="btn btn-primary" type="submit">确定</button>
									<button class="btn btn-primary" type="submit">关闭</button>
								</div>
							</div>
						</form>
					</div>
				</section>
			</div>
		</div>
	</div>
</body>
</html>
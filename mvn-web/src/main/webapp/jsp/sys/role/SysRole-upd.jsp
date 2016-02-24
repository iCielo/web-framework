<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>用户角色 - 修改</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				name : "required;length(~255);remote(${CP}/sys/role.do?method=isRepeat)",
				status : "required;",
				remark : "length(~255);",
			}
		});
		$('#form').on('valid.form', function(e) {
			Common.ajax({
				url : "${CP}/sys/role.do?method=updEntity",
				data : $(this).serialize(),
				success : function(data) {
					if (parent.ifr_main && typeof (parent.ifr_main.query) == 'function') {
						parent.ifr_main.query();
					} else if (typeof (parent.query) == 'function') {
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
				<input type="hidden" id="id" name="id" value="${entity.id }"/>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label"><span class="form-must">*</span>名称：</label>
					<div class="col-sm-8 col-xs-8">
						<input class="form-control" type="text" id="name" name="name" value="<c:out value="${entity.name}"/>">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label"><span class="form-must">*</span>状态：</label>
					<div class="col-sm-8 col-xs-8">
						<dict:select cssClass="form-control input-sm" sort="STATUS" id="status" name="status" key="${entity.status }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">备注：</label>
					<div class="col-sm-8 col-xs-8">
						<textarea class="form-control" id="remark" name="remark">${entity.remark}</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-xs-offset-3">
						<button class="btn btn-primary" type="submit">
							<i class="glyphicon glyphicon-ok"></i>&nbsp;确定
						</button>
						<button class="btn btn-primary" type="button" onclick="MyLayer.close();">
							<i class="glyphicon glyphicon-remove"></i>&nbsp;关闭
						</button>
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
</html>

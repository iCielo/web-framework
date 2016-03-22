<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>资源管理 - 新增</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
									name : "length(~255);",
																								url : "length(~255);url;",
																		parentCode : "length(~255);",
															}
		});
		$('#form').on('valid.form', function(e) {
			Common.ajax({
				url : "${CP}/sys/resource.do?method=addEntity",
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
																																																																													<div class="form-group">
						<label class="col-sm-3 col-xs-3 control-label"> 资源名称：</label>
						<div class="col-sm-8 col-xs-8">
															<input class="form-control" type="input" id="name" name="name"  value="<c:out value="${entity.name}"/>"/>
																																									</div>
					</div> 
																																	<div class="form-group">
						<label class="col-sm-3 col-xs-3 control-label"> 资源链接地址：</label>
						<div class="col-sm-8 col-xs-8">
															<input class="form-control" placeholder=""  type="input" id="url" name="url"  value="<c:out value="${entity.url}"/>"/>
																																									</div>
					</div> 
																									<div class="form-group">
						<label class="col-sm-3 col-xs-3 control-label"> 父资源代码：</label>
						<div class="col-sm-8 col-xs-8">
															<input class="form-control" placeholder=""  type="input" id="parentCode" name="parentCode"  value="<c:out value="${entity.parentCode}"/>"/>
																																									</div>
					</div> 
																	<div class="form-group">
						<label class="col-sm-3 col-xs-3 control-label"> 类型：</label>
						<div class="col-sm-8 col-xs-8">
																													<select class="form-control input-sm" id="type" name="type" data-option-value="${entity.type}">
									<option value="">--请选择--</option>
								</select>
																											</div>
					</div> 
												<div class="form-group">
					<div class="text-center">
						<button class="btn btn-primary" type="submit"><i class="glyphicon glyphicon-ok"></i>&nbsp;确定</button>
						<button class="btn btn-primary" type="button" onclick="MyLayer.close();"><i class="glyphicon glyphicon-remove"></i>&nbsp;关闭</button>
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
</html>

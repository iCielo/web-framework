<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>${title}-新增</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				tableName : "required;length(~20);",
				menuName : "required;length(~50);",
				moduleName : "required;length(~50);",
				moduleCode : "required;length(~20);",
				entity : "required;length(~255);",
				controllerUrl : "required;length(~255);",
				controller : "required;length(~255);",
				service : "required;length(~255);",
				listUrl : "required;length(~255);",
				listJsp : "required;length(~255);",
				addUrl : "required;length(~255);",
				addJsp : "required;length(~255);",
				updUrl : "required;length(~255);",
				updJsp : "required;length(~255);",
			}
		});
		$('#form').on('valid.form', function(e) {
			Common.ajax({
				url : "${CP}/crud/table.do?method=addEntity",
				data : $(this).serialize(),
				success : function(data) {
					Common.closeDialog();
				}
			})
		});
		
		$("#tableName").keyup(function() {
			var tableName = $(this).val().trim();
			var array = tableName.toLowerCase().split("_");
			if (array.length > 1) {
				var moduleCode = array[0];//模块代码
				var subModule = "";//子模块代码
				var entityName = "";//实体类名
				for (var i = 0; i < array.length; i++) {
					if (i > 0) {
						if (i == 1) {
							subModule += array[i].firstLowerCase();
						} else {
							subModule += array[i].firstUpperCase();
						}
					}
					entityName += array[i].firstUpperCase();
				}

				var controllerUrl = "/" + moduleCode + "/" + subModule + ".do";
				var jsp = "/" + moduleCode + "/" + subModule + "/" + entityName;
				var entity = "/" + moduleCode + "/" + subModule + "/entity/" + entityName + ".java";
				var controller = "/" + moduleCode + "/" + subModule + "/action/" + entityName + "Controller.java";
				var service = "/" + moduleCode + "/" + subModule + "/service/" + entityName + "Service.java";

				$("#controller").val(controller);
				$("#service").val(service);
				$("#entity").val(entity);
				$("#moduleCode").val(moduleCode);
				$("#controllerUrl").val(controllerUrl);
				$("#listUrl").val(controllerUrl + "?method=list");
				$("#listJsp").val(jsp + "-list.jsp");
				$("#addUrl").val(controllerUrl + "?method=add");
				$("#addJsp").val(jsp + "-add.jsp");
				$("#updUrl").val(controllerUrl + "?method=upd");
				$("#updJsp").val(jsp + "-upd.jsp");
			} else {
				$("#controller").val("");
				$("#service").val("");
				$("#entity").val("");
				$("#moduleCode").val("");
				$("#controllerUrl").val("");
				$("#listUrl").val("");
				$("#listJsp").val("");
				$("#addUrl").val("");
				$("#addJsp").val("");
				$("#updUrl").val("");
				$("#updJsp").val("");
			}
		});
	});
</script>
</head>
<body>
	<section class="panel">
		<div class="panel-body">
			<form class="form-horizontal tasi-form" method="post" id="form">
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">数据库表<span class="form-must">*</span></label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" placeholder="如sys_user，其中sys为模块码" type="text" id="tableName" name="tableName">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">菜单名称<span class="form-must">*</span></label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" placeholder="请输入菜单名称" type="text" id="menuName" name="menuName">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">模块名称<span class="form-must">*</span></label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" placeholder="请输入模块名称" type="text" id="moduleName" name="moduleName">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">模块代码<span class="form-must">*</span></label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="moduleCode" name="moduleCode" readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">实体类名<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="entity" name="entity" readonly>
					</div>
					<label class="col-sm-2 col-xs-2 control-label">映射路径<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="controllerUrl" name="controllerUrl" readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">控制器类<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="controller" name="controller" readonly>
					</div>
					<label class="col-sm-2 col-xs-2 control-label">服务层类<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="service" name="service" readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">列表映射<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="listUrl" name="listUrl" readonly>
					</div>
					<label class="col-sm-2 col-xs-2 control-label">列表&nbsp;JSP<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="listJsp" name="listJsp" readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">新增映射<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="addUrl" name="addUrl" readonly>
					</div>
					<label class="col-sm-2 col-xs-2 control-label">新增&nbsp;JSP<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="addJsp" name="addJsp" readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">修改映射<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="updUrl" name="updUrl" readonly>
					</div>
					<label class="col-sm-2 col-xs-2 control-label">修改&nbsp;JSP<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="updJsp" name="updJsp" readonly>
					</div>
				</div>
				<div class="form-group">
					<div class="text-center">
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

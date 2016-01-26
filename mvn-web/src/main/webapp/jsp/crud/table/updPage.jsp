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
				url : "${CP}/crud/crudTable.do?method=updEntity",
				data : $(this).serialize(),
				success : function(data) {
					Common.closeDialog();
				}
			})
		});
		$("#tableName").keyup(
				function() {
					var tableName = $(this).val().trim();
					if (tableName != "") {
						var array = tableName.toLowerCase().split("_");
						var entityName = "";
						if (array.length == 1) {
							array = [ "common", array[0] ];
						}
						for (var i = 1; i < array.length; i++) {
							entityName += array[i].firstUpperCase();
						}
						var controllerUrl = "/" + array[0] + "/" + entityName.firstLowerCase() + ".do";
						var jsp = "/jsp/" + array[0] + "/" + entityName.firstLowerCase() + "/"
								+ entityName.firstLowerCase();
						var entity = "/" + array[0] + "/" + entityName.firstLowerCase() + "/entity/" + entityName
								+ ".java";
						var controller = "/" + array[0] + "/" + entityName.firstLowerCase() + "/action/"
								+ entityName.firstUpperCase() + "Controller.java";
						var service = "/" + array[0] + "/" + entityName.firstLowerCase() + "/service/"
								+ entityName.firstUpperCase() + "Service.java";

						$("#controller").val(controller);
						$("#service").val(service);
						$("#entity").val(entity);
						$("#moduleCode").val(array[0]);
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
						<input class="form-control" placeholder="如Sys_user，其中sys为模块码" type="text" id="tableName" name="tableName" value="${entity.tableName }">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">&nbsp;&nbsp;&nbsp;菜单名<span class="form-must">*</span></label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" placeholder="请输入菜单名" type="text" id="menuName" name="menuName" value="<c:out value="${entity.menuName }"/>">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">&nbsp;&nbsp;&nbsp;模块名<span class="form-must">*</span></label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" placeholder="请输入模块名" type="text" id="moduleName" name="moduleName" value="<c:out value="${entity.moduleName }"/>">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">&nbsp;&nbsp;&nbsp;模块码<span class="form-must">*</span></label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="moduleCode" name="moduleCode" readonly value="${entity.moduleCode }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">实体类名<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="entity" name="entity" readonly value="${entity.entity }">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">映射路径<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="controllerUrl" name="controllerUrl" readonly value="${entity.controllerUrl }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">&nbsp;&nbsp;&nbsp;控制器<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="controller" name="controller" readonly value="${entity.controller }">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">&nbsp;&nbsp;&nbsp;服务层<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="service" name="service" readonly value="${entity.service }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">列表映射<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="listUrl" name="listUrl" readonly value="${entity.listUrl }">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">&nbsp;列表JSP<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="listJsp" name="listJsp" readonly value="${entity.listJsp }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">新增映射<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="addUrl" name="addUrl" readonly value="${entity.addUrl }">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">&nbsp;新增JSP<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="addJsp" name="addJsp" readonly value="${entity.addJsp }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">修改映射<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="updUrl" name="updUrl" readonly value="${entity.updUrl }">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">&nbsp;修改JSP<span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="updJsp" name="updJsp" readonly value="${entity.updJsp }">
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

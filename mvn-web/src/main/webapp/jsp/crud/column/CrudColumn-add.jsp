<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>${title}- 新增</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				id : "required;length(~36);",
				tableName : "required;length(~50);",
				columnName : "required;length(~50);",
				columnType : "required;length(~50);",
				label : "required;length(~50);",
				placeholder : "length(~100);",
				inputType : "required;length(~50);",
				dictType : "length(~50);",
				dictList : "length(~255);",
				opUserId : "length(~36);",
			}
		});
		$('#form').on('valid.form', function(e) {
			Common.ajax({
				url : "${CP}/crud/column.do?method=addEntity",
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
					<label class="col-sm-3 col-xs-3 control-label">主键ID <span class="form-must">*</span>
					</label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入主键ID" type="text" id="id" name="id">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">表名 <span class="form-must">*</span>
					</label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入表名" type="text" id="tableName" name="tableName">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">列名 <span class="form-must">*</span>
					</label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入列名" type="text" id="columnName" name="columnName">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">数据类型 <span class="form-must">*</span>
					</label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入数据类型" type="text" id="columnType" name="columnType">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">显示名 <span class="form-must">*</span>
					</label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入显示名" type="text" id="label" name="label">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">输入提示 </label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入输入提示" type="text" id="placeholder" name="placeholder">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">数据录入类型 INPUT：输入框，RADIO：单选，SELECT：下拉框，CHECK：复选框 <span
						class="form-must">*</span>
					</label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入数据录入类型 INPUT：输入框，RADIO：单选，SELECT：下拉框，CHECK：复选框" type="text"
							id="inputType" name="inputType">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">数据字典类型 </label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入数据字典类型" type="text" id="dictType" name="dictType">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">自定义数据字典 </label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入自定义数据字典" type="text" id="dictList" name="dictList">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">是否可空 </label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入是否可空" type="text" id="nullable" name="nullable">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">字符长度 </label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入字符长度" type="text" id="length" name="length">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">校验规则 
					</label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入校验规则" type="text" id="rules" name="rules">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">操作用户 </label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入操作用户" type="text" id="opUserId" name="opUserId">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">操作时间 </label>
					<div class="col-sm-6 col-xs-6">
						<input class="form-control" placeholder="请输入操作时间" type="text" id="opTime" name="opTime">
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
